package com.ccms.service.impl;

import com.ccms.constant.Errors;
import com.ccms.entity.EcVoucherDetail;
import com.ccms.entity.EcVoucherLog;
import com.ccms.entity.EcVoucherMain;
import com.ccms.entity.EcVoucherUse;
import com.ccms.enums.VoucherEnum;
import com.ccms.exception.BizException;
import com.ccms.mapper.EcVoucherDetailMapper;
import com.ccms.mapper.EcVoucherLogMapper;
import com.ccms.mapper.EcVoucherMainMapper;
import com.ccms.mapper.EcVoucherUseMapper;
import com.ccms.service.VoucherService;
import com.ccms.util.DateUtil;
import com.ccms.util.Md5Util;
import com.ccms.util.RedisTemplateUtil;
import com.ccms.vo.AppRspObject;
import com.ccms.vo.ErrorVo;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.redis.util.RedisLockRegistry;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class VoucherServiceImpl implements VoucherService {
    Logger logger = LoggerFactory.getLogger(VoucherService.class);

    private static final String PACKAGE_CODE_MAP = "package_code_map";
    private static final String USE_CODE_LOCK = "use_code_lock:";
    public static final String[] ERRORS_ARR = new String[]{
        "无效兑换码",
        "兑换码已过期",
        "兑换码输入为空",
        "兑换码已被冻结，暂无法兑换",
        "兑换码已兑换，请填写收货地址",
        "兑换码已被兑换完毕",
        "本次活动每人可兑换次数有限",
        "兑换时间未到",
        "兑换码已经兑换"
    };


    @Resource
    private EcVoucherDetailMapper ecVoucherDetailMapper;
    @Resource
    private EcVoucherMainMapper ecVoucherMainMapper;
    @Resource
    private EcVoucherUseMapper ecVoucherUseMapper;
    @Resource
    private EcVoucherLogMapper ecVoucherLogMapper;

    @Autowired
    private RedisLockRegistry redisLockRegistry;



    /**
     *
     a.	兑换码校验不符合生成规则
     b.	兑换码在数据库中找不到
     c.	兑换码已作废（删除）
     d.	兑换码已过期
     e.	兑换码输入为空
     f.	兑换码被冻结（后台冻结兑换码）
     g.	兑换码已被兑换（1:1的兑换码）
     h.	已超过兑换码允许兑换总人数（1：N的兑换码）
     i.	已超过每批次每人允许兑换张数
     j.	用户之前已成功兑换（1：N兑换码）

     0	abc - "我们翻遍了服务器，也没找到您输入的兑换码～"
     1	d - "兑换码已过期，相忘于江湖～"
     2	e - "兑换码输入为空，请谨慎调戏服务器"
     3	f - "兑换码已被冻结，暂无法兑换"
     4	g - "兑换码已经被兑换完毕了哟～"
     5	h - "兑换码已被兑换完毕，下次请赶早～"
     6	ij - "本次活动没人可兑换次数有限"

     validResult校验结果(
     4001.券码为空
     4002.券码校验不满足后台生成规则
     4003.券码在数据库中找不到
     4004.券码已过期
     4005.券码已冻结（不能领取/兑换）
     4006.券码已作废（删除）
     4007.券码已被领取/兑换
     4008.已超过每批次每人允许领取/兑换张数
     4009.已超过券码包实际兑换人数
     4010.兑换成功
     4011.其它)
     * @param code
     * @return
     * @throws Exception
     */
    public AppRspObject checkCodeValid(String code) {
        //变量
        AppRspObject appRspObject = AppRspObject.createSuccRsp(null);

        for (;;) {
            //检查是否为空
            if (StringUtils.isEmpty(code)) {
//                errorMsg = ERRORS_ARR[2];
//                validResult = 1;
                appRspObject = AppRspObject.createFailRsp(Errors.ERROR_VOUCHER_EMPTY, ERRORS_ARR[2]);
                break;
            }

            //在redis中找到对应的13位券码
            code = getCodeFromMap(code);

            //检查是否13位
            if (13 != code.length()) {
//                errorMsg = ERRORS_ARR[0];
//                validResult = 2;
                appRspObject = AppRspObject.createFailRsp(Errors.ERROR_VOUCHER_INVALID, ERRORS_ARR[0]);
                break;
            }

            //大小写转换
            code = code.toUpperCase();

            //检验位
            if (!isEncodeNumberValid(code)) {
//                errorMsg = ERRORS_ARR[0];
//                validResult = 2;
                appRspObject = AppRspObject.createFailRsp(Errors.ERROR_VOUCHER_INVALID, ERRORS_ARR[0]);
                break;
            }

            break;

        }

        return appRspObject;
    }

    /**
     * 检查状态 此方法需要纳入分布式锁
     * @param code
     * @param userId
     * @return
     */
    public AppRspObject checkCodeStatus(String code, Long userId, EcVoucherMain vm, EcVoucherDetail vcd) {
        //变量
        AppRspObject appRspObject = AppRspObject.createSuccRsp(null);

        for (;;){
            if (vcd == null) {
                appRspObject = AppRspObject.createFailRsp(Errors.ERROR_VOUCHER_NOT_FOUND, ERRORS_ARR[0]);
                break;
            }

            //查询批次
            if (vm == null) {
                appRspObject = AppRspObject.createFailRsp(Errors.ERROR_VOUCHER_NOT_FOUND, ERRORS_ARR[0]);
                break;
            }


            //redisTemplateUtil.incr(PACKAGE_CURRENT_COUNT_KEY + "_" + vm.getBatchId());
            //log.info("使用次数++，用户：{}", userNo);
//            voucherType = vm.getVoucherType();

            //检查是否冻结
            if (VoucherEnum.BATCH_STATUS_FROZEN.getValue().equals(vm.getBatchStatus())) {
                //冻结
                appRspObject = AppRspObject.createFailRsp(Errors.ERROR_VOUCHER_FROZEN, ERRORS_ARR[3]);
                break;
            } else if (VoucherEnum.BATCH_STATUS_OVERDUE.getValue().equals(vm.getBatchStatus())
                    || isBatchOverEndTime(vm)) {
                // 过期
                appRspObject = AppRspObject.createFailRsp(Errors.ERROR_VOUCHER_OVERDUE, ERRORS_ARR[1]);
                break;
            } else if (isBatchNotBegin(vm)) {
                // 过期
                appRspObject = AppRspObject.createFailRsp(Errors.ERROR_VOUCHER_OVERDUE, ERRORS_ARR[7]);
                break;
            } else if (VoucherEnum.BATCH_STATUS_CANCEL.getValue().equals(vm.getBatchStatus())
                    || VoucherEnum.CODE_STATUS_CANCEL.getValue().equals(vcd.getStatus())) {
                //，作废
                appRspObject = AppRspObject.createFailRsp(Errors.ERROR_VOUCHER_CANCEL, ERRORS_ARR[0]);
                break;
            }

            //1对1
            //检查兑换次数
            if (VoucherEnum.VOUCHER_TYPE_ONE_TO_ONE.getValue().equals(vm.getVoucherType())) {//1对1
                //检查VOUCHER_USE表是否有数据
//                Example voucherUseExample = new Example(EcVoucherUse.class);
//                voucherUseExample.createCriteria().andEqualTo("code", code);
//                List list = ecVoucherUseMapper.selectByExample(voucherUseExample);//selectAllByCode(code);
                if (VoucherEnum.CODE_STATUS_USED.getValue().equals(vcd.getStatus())) {
                    appRspObject = AppRspObject.createFailRsp(Errors.ERROR_VOUCHER_USED, ERRORS_ARR[4]);
                    break;
                }else if(VoucherEnum.CODE_STATUS_USED_ADDR.getValue().equals(vcd.getStatus())){
                    appRspObject = AppRspObject.createFailRsp(Errors.ERROR_VOUCHER_USED_ADDR, ERRORS_ARR[8]);
                    break;
                }
            } else {
                //1对多
                //检查VOUCHER_MAIN表兑换次数
                if (vm != null) {
                    Long maxTimes = vm.getPackageAllowcount() == null ? 0l : vm.getPackageAllowcount();
                    //String packageCurrentCount = RedisAdapter2.get(PACKAGE_CURRENT_COUNT_KEY + "_" + ecVoucherMain.getBatchId());
//                    if (StringUtils.isNotEmpty(packageCurrentCount)) {
//                        usedTimes = Long.valueOf(packageCurrentCount);
//                    } else {
                    int usedTimes = vm.getPackageUsecount() == null ? 0 : vm.getPackageUsecount();
//                    }

                    if (usedTimes >= maxTimes) {
                        //兑换次数已大于等于兑换次数
                        appRspObject = AppRspObject.createFailRsp(Errors.ERROR_VOUCHER_PACKAGE_MAX, ERRORS_ARR[5]);
                        break;
                    }
                }
            }

            //是否已达每人每批次领取上限
            if (isOverUseTimesEachBatch(userId, vm)) {
                appRspObject = AppRspObject.createFailRsp(Errors.ERROR_VOUCHER_EACH_MAX, ERRORS_ARR[6]);
                break;
            }

            break;

        }

        return appRspObject;

    }

    /**
     * 福利发放 更新券码状态 需要加锁
     * @param code
     * @param userId
     * @param vm
     * @param vcd
     * @return
     */
    @Transactional(rollbackFor=Exception.class)
    public AppRspObject sendWelfare(String code, Long userId, EcVoucherMain vm, EcVoucherDetail vcd) throws BizException {
        AppRspObject appRspObject = AppRspObject.createSuccRsp(null);
        List welfareList = new ArrayList<>();
        if(vm != null){
            //查询用户
            /*
            SysuserAccount user = comSysuserAccountMapper.selectByPrimaryKey(userId.intValue());
            String mobile = "";
            if(user != null)
                mobile = user.getMobile();
            */

            //插入券码使用信息
            EcVoucherUse voucherUse = new EcVoucherUse();
//            voucherUse.setMobile(mobile);
            voucherUse.setUserId(userId);
            voucherUse.setYear(vm.getYear());
            voucherUse.setMainId(vm.getId());
            voucherUse.setVoucherType(vm.getVoucherType());
            voucherUse.setCode(code);
            voucherUse.setUseTime(new Date());


            //发放福利
            //1.仙果
            logger.info("券码兑换，发放体验金voucherMain.Id:{},exchangeVal:{},userId:{}",vm.getId(),vm.getExchangeVal(), userId);
            if(VoucherEnum.EXCHANGE_TYPE_XIANGUO.getValue().equals(vm.getCodeType())){
                //throw new RuntimeException("shibai");
                // 发放xianguo
                sendCashpoint(userId, new BigDecimal(vm.getExchangeVal()), code);
            }

            //大于0福利发放成功更新相关表
            //RedisAdapter2.incr(PACKAGE_CURRENT_COUNT_KEY + "_" + vm.getBatchId());
            //更新user表
            ecVoucherUseMapper.insert(voucherUse);


            //更新detail表 mian表
            //如果是1对1券码更新VOUCHER_CODE_DETAIL表状态
            //如果是1对多券码更新VOUCHER_MAIN使用次数
            String voucherType = vm.getVoucherType();
            if(VoucherEnum.VOUCHER_TYPE_ONE_TO_ONE.getValue().equals(voucherType)){ //1对1
                vcd.setStatus(VoucherEnum.CODE_STATUS_USED.getValue());
                ecVoucherDetailMapper.updateByPrimaryKeySelective(vcd);
            }else{ //1对多
                vm.setPackageUsecount(vm.getPackageUsecount()+1);
                ecVoucherMainMapper.updateByPrimaryKeySelective(vm);
            }
        }
        return appRspObject;
    }

    /**
     * 获取锁的key,一对一使用code加锁，一对多使用batchid加锁
     *
     */
    public String getLockKey(String code){
        String key = USE_CODE_LOCK;

        Map<String, Object> map = ecVoucherDetailMapper.selectSimpleColumnByCode(code);
        String voucherType = MapUtils.getString(map,"voucherType");
        String batchId = MapUtils.getString(map,"batchId");

        if(VoucherEnum.VOUCHER_TYPE_ONE_TO_ONE.getValue().equals(voucherType)){
            key += code;
        }else{
            key += batchId;
        }

        return key;
    }



    /**
     * 有些券码使用中文字符 不是13为 需要在redis中找出对应的13位券码
     * @param code
     */
    private String getCodeFromMap(String code){
        Map<String, String> map = getCodeMap();
        if(map != null && !map.isEmpty()){
            String value = map.get(code);
            if(StringUtils.isNotEmpty(value))
                code = value;
        }

        return code;
    }


    /**
     * 获取券码并缓存在redis中
     */
    private Map<String, String> getCodeMap(){
        String key = PACKAGE_CODE_MAP;

        Map<String, String> packCodeMap = RedisTemplateUtil.hGetAll(key);
        if(packCodeMap == null || packCodeMap.isEmpty()){
            logger.info("---redis中券码映射map为空，从数据库读取---");
            Example vmExample = new Example(EcVoucherMain.class);
            vmExample.createCriteria()
                    .andIsNotNull("packageName")
                    .andIsNotNull("packageCode");
            List<EcVoucherMain> list = ecVoucherMainMapper.selectByExample(vmExample);
            if(list != null & list.size() >0){
                for(EcVoucherMain v : list){
                    packCodeMap.put(v.getPackageName(), v.getPackageCode());
                }
                RedisTemplateUtil.hSetAll(key, packCodeMap);
            }
        }

        return packCodeMap;
    }

    private String encodeTop11(String code){
        String prefix = "@!%21a";
        String endfix = "*@!22b";
        String top11 = code.substring(0, 11);
        String toBeEncode = prefix + top11 + endfix;

        return Md5Util.upperMD5_32(toBeEncode);
    }

    public static void main (String[] args) {
        String s = "1234567890256";

        String prefix = "@!%21a";
        String endfix = "*@!22b";
        String top11 = s.substring(0, 11);
        String toBeEncode = prefix + top11 + endfix;



        System.out.println(Md5Util.upperMD5_32(toBeEncode));
    }


    /**
     * 检验前11位加密结果区前2位 是否等于 券码最后2位
     */
    private boolean isEncodeNumberValid(String code){
        boolean result = false;

        String md5String = encodeTop11(code);
        String a = md5String.substring(0, 2);
        String b = code.substring(code.length()-2, code.length());

        if(StringUtils.equalsIgnoreCase(a, b))
            result = true;


        return result;
    }


    /**
     * 已过期
     * @param vm
     * @return
     * @throws Exception
     */
    private boolean isBatchOverEndTime(EcVoucherMain vm){
        boolean result = false;

        try {
            String nowStr = DateTime.now().toString("yyyyMMdd");

            if(vm != null){
                if(vm.getEndTime() != null){
                    String endTimeStr = new DateTime(vm.getEndTime()).toString("yyyyMMdd");
                    //当前时间大于结束
                    if(DateUtil.compareDate(nowStr, endTimeStr) > 0){
                        result = true;
                    }
                }
            }
        }catch (Exception e){
            logger.error("判断券码是否过期异常，vm.endTime:{},错误:{}",vm.getEndTime(),e);
        }

        return result;
    }

    /**
     * 未开始
     * @param vm
     * @return
     * @throws Exception
     */
    private boolean isBatchNotBegin(EcVoucherMain vm){
        boolean result = false;



        try {
            String nowStr = DateTime.now().toString("yyyyMMdd");

            if(vm != null){
                if(vm.getBeginTime() != null){
                    String beginTimeStr = new DateTime(vm.getBeginTime()).toString("yyyyMMdd");
                    //当前时间小于开始时间
                    if(DateUtil.compareDate(nowStr, beginTimeStr) < 0){
                        result = true;
                    }
                }
            }
        }catch (Exception e){
            logger.error("判断券码是否未开始异常，vm.BeginTime:{},错误:{}",vm.getBeginTime(),e);
        }
        return result;
    }


    /**
     * 每批次个人可兑换数是否超限
     *
     * 此方法需要加锁
     */
    private boolean isOverUseTimesEachBatch(Long userId, EcVoucherMain vm){
        boolean result = false;

        Integer maxTimes = vm.getEachAllowcount();
        if(maxTimes != null && maxTimes >0){
            Example voucherUseExample = new Example(EcVoucherUse.class);
            voucherUseExample.createCriteria()
                    .andEqualTo("userId", userId)
                    .andEqualTo("year", vm.getYear())
                    .andEqualTo("mainId", vm.getId());
            List list = ecVoucherUseMapper.selectByExample(voucherUseExample);
                    //.selectAllByUserNoAndYearAndBatchId(userNo, vm.getYear(), vm.getBatchId());

            if(list != null & list.size() >0){
                Long userUseTimes = new Long(list.size());

                if(userUseTimes >= maxTimes){ //大于等于上限 返回已超限
                    return true;
                }

            }
        }

        return result;
    }


    /**
     * 使用券码
     * 1.检查code正确性（无锁）2.检查券码状态（有锁）3.券码发放 券码状态更新(有锁)
     * @param code
     * @param userId
     * @return
     */
    /*
    @Override
    public AppRspObject useCode(String code, Long userId) {
        AppRspObject result = null;
        String batchId = null;
        for(;;){
            result = checkCodeValid(code);
            if(Errors.RESPONSE_ERROR.equals(result.getSuccess())){
               break;
            }


            String lockKey = getLockKey(code);
            Lock lock = redisLockRegistry.obtain(lockKey);

            try {
                if(lock.tryLock(5L, TimeUnit.SECONDS)){
                    //查询
                    Example vcdExample = new Example(EcVoucherDetail.class);
                    vcdExample.createCriteria().andEqualTo("code", code);
                    EcVoucherDetail vcd = ecVoucherDetailMapper.selectOneByExample(vcdExample);//.selectByCode(code);
                    if(vcd != null){
                        batchId = vcd.getBatchId();
                    }else {
                        result = AppRspObject.createFailRsp(Errors.ERROR_VOUCHER_NOT_FOUND, ERRORS_ARR[0]);
                        break;
                    }

                    Example vmExample = new Example(EcVoucherDetail.class);
                    vmExample.createCriteria()
                            .andEqualTo("year", vcd.getYear())
                            .andEqualTo("batchId",vcd.getBatchId());
                    EcVoucherMain vm = ecVoucherMainMapper.selectOneByExample(vmExample);

                    if(vm == null){
                        result = AppRspObject.createFailRsp(Errors.ERROR_VOUCHER_NOT_FOUND, ERRORS_ARR[0]);
                        break;
                    }

                    //检查券状态 使用量
                    result = checkCodeStatus(code,userId,vm,vcd);
                    if(Errors.RESPONSE_ERROR.equals(result.getSuccess())){
                        break;
                    }else{
                        result = sendWelfare(code,userId,vm,vcd);
                        break;
                    }
                }
            } catch (InterruptedException ie){
                logger.error("并发锁获取失败，lockKey:{},userId:{}",lockKey,userId);
                return AppRspObject.createFailRsp(Errors.ERROR_VOUCHER_EXCHANGE_FAIL, "网络拥堵，请重试");
            } catch (Exception e){
                logger.error("使用券码失败，code:{},userId:{},错误:{}",code,userId,e);
                return AppRspObject.createFailRsp(Errors.ERROR_VOUCHER_EXCHANGE_FAIL, "兑换失败，请重试");
            } finally {
                lock.unlock();
                saveLogByCodeDetail(batchId, code, userId, result.getError());
            }

            break;
        }

        return result;
    }
    */


    public int saveLogByCodeDetail(Long mainId, String code, Long userId, ErrorVo errorVo){
        EcVoucherLog vvl = new EcVoucherLog();
        vvl.setMainId(mainId);
        vvl.setCode(code);
        vvl.setUserId(userId);
        if (errorVo != null){
            vvl.setCheckResult(errorVo.getCode());
            vvl.setErrorMsg(errorVo.getMessage());
        }
        vvl.setCreateDate(DateTime.now().toDate());
        vvl.setUpdateDate(DateTime.now().toDate());

        return ecVoucherLogMapper.insertSelective(vvl);

    }

    @Transactional(rollbackFor = Exception.class)
    public void sendCashpoint(Long userId, BigDecimal point, String code) throws BizException {
        /*
        String behavior = "卡券【"+code+"】兑换赠送仙果"+point+"个";

        SysuserUserCashpointlog userCashpointlog = new SysuserUserCashpointlog();
        userCashpointlog.setUserId(userId.intValue());
        userCashpointlog.setModifiedTime(DateUtil.getCurrentSecondTime());
        userCashpointlog.setBehaviorType("obtain");
        userCashpointlog.setPoint(point);
        userCashpointlog.setRemark("购买产品返赠送仙果");
        userCashpointlog.setTid(null);
        userCashpointlog.setOid(null);
        userCashpointlog.setBehavior(behavior);


        comSysuserUserCashpointlogMapper.insertSelective(userCashpointlog);


        int updatePointCount = comSysuserUserMapper.updateAddCashpoint(userId.intValue(), point);

        if(updatePointCount <= 0){
            logger.error("券码兑换,更新仙果数失败code:{},userId:{},错误:{}",code, userId);
            throw new BizException(Errors.ERROR_VOUCHER_EXCHANGE_FAIL, "兑换失败,请重试");
        }

        */

    }

}
