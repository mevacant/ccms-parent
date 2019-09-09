package com.ccms.controller;

import com.ccms.entity.EcPageTempleteProperty;
import com.ccms.mapper.EcPageTempletePropertyMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.*;

@Controller
@RequestMapping("/pages/")
@Slf4j
public class PageController {
    @Resource
    private EcPageTempletePropertyMapper ecPageTempletePropertyMapper;

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



}
