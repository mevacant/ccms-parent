package com.ccms.controller;

import com.ccms.annotation.RequestLimit;
import com.ccms.constant.Errors;
import com.ccms.entity.EcVoucherAddress;
import com.ccms.entity.EcVoucherDetail;
import com.ccms.entity.EcVoucherMain;
import com.ccms.entity.EcsuserUserAddrs;
import com.ccms.enums.VoucherEnum;
import com.ccms.mapper.EcVoucherAddressMapper;
import com.ccms.mapper.EcVoucherDetailMapper;
import com.ccms.mapper.EcVoucherMainMapper;
import com.ccms.mapper.EcsuserUserAddrsMapper;
import com.ccms.service.VoucherService;
import com.ccms.service.impl.VoucherServiceImpl;
import com.ccms.vo.AppRspObject;
import com.ccms.vo.EcsuserUserAddrsVo;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.redis.util.RedisLockRegistry;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

@RestController
@RequestMapping("/voucher")
public class VoucherController {

    private Logger logger = LoggerFactory.getLogger(VoucherController.class);

    @Autowired
    private VoucherService voucherService;
    @Resource
    private EcVoucherDetailMapper ecVoucherCodeDetailMapper;
    @Resource
    private EcVoucherMainMapper ecVoucherMainMapper;
    @Resource
    private EcVoucherAddressMapper ecVoucherAddressMapper;
    @Resource
    private EcsuserUserAddrsMapper ecsuserUserAddrsMapper;

    @Autowired
    private RedisLockRegistry redisLockRegistry;

    /**
     * 券码兑换
     * @return
     */
//    @RequestLimit(count=3,time=60000)
    @PostMapping("/useCode")
    public AppRspObject useCode(@RequestParam String code, @RequestParam Long userId){

        AppRspObject result = null;
        Long mainId = null;
        for(;;){
            result = voucherService.checkCodeValid(code);
            if(Errors.RESPONSE_ERROR.equals(result.getSuccess())){
                break;
            }


            String lockKey = voucherService.getLockKey(code);
            Lock lock = redisLockRegistry.obtain(lockKey);

            try {
                if(lock.tryLock(5L, TimeUnit.SECONDS)){
                    //查询
                    Example vcdExample = new Example(EcVoucherDetail.class);
                    vcdExample.createCriteria().andEqualTo("code", code);
                    EcVoucherDetail vcd = ecVoucherCodeDetailMapper.selectOneByExample(vcdExample);//.selectByCode(code);
                    if(vcd != null){
                        mainId = vcd.getMainId();
                    }else {
                        result = AppRspObject.createFailRsp(Errors.ERROR_VOUCHER_NOT_FOUND, VoucherServiceImpl.ERRORS_ARR[0]);
                        break;
                    }

//                    Example vmExample = new Example(EcVoucherDetail.class);
//                    vmExample.createCriteria()
//                            .andEqualTo("year", vcd.getYear())
//                            .andEqualTo("batchId",vcd.getBatchId());
                    EcVoucherMain vm = ecVoucherMainMapper.selectByPrimaryKey(mainId);

                    if(vm == null){
                        result = AppRspObject.createFailRsp(Errors.ERROR_VOUCHER_NOT_FOUND, VoucherServiceImpl.ERRORS_ARR[0]);
                        break;
                    }

                    //检查券状态 使用量
                    result = voucherService.checkCodeStatus(code,userId,vm,vcd);
                    if(Errors.RESPONSE_ERROR.equals(result.getSuccess())){
                        break;
                    }else{
                        result = voucherService.sendWelfare(code,userId,vm,vcd);
                        break;
                    }
                }
            } catch (InterruptedException ie){
                logger.error("并发锁获取失败，lockKey:{},userId:{}",lockKey,userId);
                result = AppRspObject.createFailRsp(Errors.ERROR_VOUCHER_EXCHANGE_FAIL, "网络拥堵，请重试");
                break;
            } catch (Exception e){
                logger.error("使用券码失败，code:{},userId:{},错误:{}",code,userId,e);
                result =  AppRspObject.createFailRsp(Errors.ERROR_VOUCHER_EXCHANGE_FAIL, "兑换失败，请重试");
                break;
            } finally {
                lock.unlock();

            }

            break;
        }

        voucherService.saveLogByCodeDetail(mainId, code, userId, result.getError());
        return result;

    }

    @PostMapping("/saveAddress")
    public AppRspObject saveAddress(@RequestBody EcsuserUserAddrsVo addrObj){
        AppRspObject result = null;
         String code = addrObj.getCode();
        for(;;) {
            result = voucherService.checkCodeValid(code);
            if (Errors.RESPONSE_ERROR.equals(result.getSuccess())) {
                break;
            }

            //查询
            Example vcdExample = new Example(EcVoucherDetail.class);
            vcdExample.createCriteria().andEqualTo("code", code);
            EcVoucherDetail vcd = ecVoucherCodeDetailMapper.selectOneByExample(vcdExample);


            if(vcd != null) {

                //存在地址&&没有物流号   就修改否则新增
                EcsuserUserAddrs oldAddress = ecsuserUserAddrsMapper.selectAddrByCode(code);
                if(null == oldAddress){
                    ecsuserUserAddrsMapper.insert(addrObj);
                    //saveaddr
                    EcVoucherAddress va = new EcVoucherAddress();
                    va.setAddrId(Long.valueOf(addrObj.getAddrId()));
                    va.setVoucherCode(vcd.getVoucherCode());
                    va.setCreateDate(DateTime.now().toDate());
                    va.setUpdateDate(DateTime.now().toDate());
                    ecVoucherAddressMapper.insert(va);

                    //status = CODE_STATUS_USED
                    vcd.setStatus(VoucherEnum.CODE_STATUS_USED_ADDR.getValue());
                    ecVoucherCodeDetailMapper.updateByPrimaryKeySelective(vcd);

                    result = AppRspObject.createSuccRsp(null);
                }else{
                    Example vaExample = new Example(EcVoucherAddress.class);
                    vaExample.createCriteria().andEqualTo("voucherCode", vcd.getVoucherCode());
                    EcVoucherAddress va = ecVoucherAddressMapper.selectOneByExample(vaExample);
                    if(va != null && StringUtils.isNotEmpty(va.getLogicNo())){
                        result = AppRspObject.createFailRsp(Errors.ERROR_VOUCHER_CANNOT_CHANGE_ADDR, "已发货，无法修改地址");
                    }else {
                        addrObj.setAddrId(oldAddress.getAddrId());
                        ecsuserUserAddrsMapper.updateByPrimaryKey(addrObj);
                    }

                }
            }else{
                result = AppRspObject.createFailRsp(Errors.ERROR_VOUCHER_NOT_FOUND, VoucherServiceImpl.ERRORS_ARR[0]);
            }
            break;
        }

        return result;
    }

    @PostMapping("/queryCode")
    public AppRspObject queryCode(@RequestParam String code){
        AppRspObject result = null;
        for(;;) {
            result = voucherService.checkCodeValid(code);
            if (Errors.RESPONSE_ERROR.equals(result.getSuccess())) {
                break;
            }

            //查询
            Long mainId = null;
            Example vcdExample = new Example(EcVoucherDetail.class);
            vcdExample.createCriteria().andEqualTo("code", code);
            EcVoucherDetail vcd = ecVoucherCodeDetailMapper.selectOneByExample(vcdExample);//.selectByCode(code);
            if(vcd != null){
                mainId = vcd.getMainId();
            }else {
                result = AppRspObject.createFailRsp(Errors.ERROR_VOUCHER_NOT_FOUND, VoucherServiceImpl.ERRORS_ARR[0]);
                break;
            }

            EcVoucherMain vm = ecVoucherMainMapper.selectByPrimaryKey(mainId);

            if(vm == null){
                result = AppRspObject.createFailRsp(Errors.ERROR_VOUCHER_NOT_FOUND, VoucherServiceImpl.ERRORS_ARR[0]);
                break;
            }

            //检查券状态 使用量
            result = voucherService.checkCodeStatus(code,0L,vm,vcd);
            if(Errors.RESPONSE_ERROR.equals(result.getSuccess())){
                if(Errors.ERROR_VOUCHER_USED_ADDR.equals(result.getError().getCode())){
                    //已填写地址，显示地址
                    EcsuserUserAddrs addr = ecsuserUserAddrsMapper.selectAddrByCode(vcd.getVoucherCode());
                    result.setData(addr);
                }
                break;
            }else{
                //引导去领取
                result = AppRspObject.createSuccRsp(null);
                break;
            }
        }

        return result;
    }
}
