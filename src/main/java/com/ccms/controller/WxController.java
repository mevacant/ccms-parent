package com.ccms.controller;

import com.alibaba.fastjson.JSON;
import com.ccms.service.WechatService;
import com.ccms.vo.AppRspObject;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/wx/")
@Slf4j
public class WxController {

    private final static Logger logger = LoggerFactory.getLogger(WxController.class);

    @Autowired
    public WechatService wechatService;

    @PostMapping("/getAccess")
    public AppRspObject getAccess(@RequestParam Map<String, String> paramsMap) {
        logger.debug("Enter method getSignature().");
        AppRspObject result = null;
        Map<String, Object> resMap = wechatService.getAccessData(paramsMap.get("url"));
        result = AppRspObject.createSuccRsp(resMap);
        logger.debug("Leave method getSignature().");
        return result;
    }



}
