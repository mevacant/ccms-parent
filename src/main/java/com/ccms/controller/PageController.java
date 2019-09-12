package com.ccms.controller;

import com.ccms.entity.EcVoucherAddress;
import com.ccms.entity.EcsuserUserAddrs;
import com.ccms.entity.SysDictData;
import com.ccms.mapper.EcPageTempletePropertyMapper;
import com.ccms.mapper.EcVoucherAddressMapper;
import com.ccms.mapper.EcsuserUserAddrsMapper;
import com.ccms.mapper.SysDictDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.*;

@Controller
@RequestMapping("/pages/")
@Slf4j
public class PageController {
    @Resource
    private EcPageTempletePropertyMapper ecPageTempletePropertyMapper;
    @Resource
    private EcsuserUserAddrsMapper ecsuserUserAddrsMapper;
    @Resource
    private EcVoucherAddressMapper ecVoucherAddressMapper;
    @Resource
    private SysDictDataMapper sysDictDataMapper;

    @RequestMapping(value = "/test")
    public String test(ModelMap model) {
        log.info("进入页面");
        Map map = new LinkedHashMap<>();
        for (int i = 0; i < 5; i++) {
            map.put("key" + i, "value" + i);
        }
        model.addAttribute("list", Arrays.asList("string1", "string2", "string3", "string4", "string5", "string6"));
        model.addAttribute("map", map);
        model.addAttribute("name", "   htTps://wWw.zHyD.mE   ");
        model.addAttribute("htmlText", "<span style=\"color: red;font-size: 16px;\">html内容</span>");
        model.addAttribute("num", 123.012);
        model.addAttribute("null", null);
        model.addAttribute("dateObj", new Date());  
        model.addAttribute("bol", true);
        return "/test/index";
    }

    @RequestMapping(value = "/testRedirect")
    public String testRedirect(ModelMap model) {
        model.addAttribute("name", "jack");
        return "redirect:/test/index.html";
    }


    @RequestMapping(value = "/index")
    public String index(ModelMap model) {
//        List<EcPageTempleteProperty> list = ecPageTempletePropertyMapper.selelctEnablePageTempletePropertyList();
//        for(EcPageTempleteProperty p : list){
//            model.addAttribute(p.getName(),p.getValue());
//        }


        return "/voucher/index";
    }

    @RequestMapping(value = "/addrForm")
    public String addrForm(ModelMap model, String code) {

        EcsuserUserAddrs addr = new EcsuserUserAddrs();
        addr = ecsuserUserAddrsMapper.selectAddrByCode(code);

        model.addAttribute("code",code);
        model.addAttribute("addrObj",addr);
        return "/voucher/addr_form";
    }

    @RequestMapping(value = "/queryGift")
    public String queryGift(ModelMap model, String code) {

        return "/voucher/query";
    }

    @RequestMapping(value = "/showAddr")
    public String showAddr(ModelMap model, String code) {
        EcsuserUserAddrs addr = ecsuserUserAddrsMapper.selectAddrByCode(code);

        if(addr != null){
            Example vaExample = new Example(EcVoucherAddress.class);
            vaExample.createCriteria().andEqualTo("addrId", addr.getAddrId());
            EcVoucherAddress va = ecVoucherAddressMapper.selectOneByExample(vaExample);

            if(va != null && StringUtils.isNotEmpty(va.getLogicNo())){
                Example dictExample = new Example(SysDictData.class);
                dictExample.createCriteria()
                        .andEqualTo("dictType", "logic_type")
                        .andEqualTo("dictValue", va.getLogicType());
                SysDictData dict = sysDictDataMapper.selectOneByExample(dictExample);
                if(dict != null){

                    model.addAttribute("logicType",dict.getDictLabel());
                    model.addAttribute("logicNo",va.getLogicNo());

                }

            }

        }


        model.addAttribute("code",code);
        model.addAttribute("addrObj",addr);
        return "/voucher/show_addr";
    }



}
