package com.ccms.service.impl;


import com.ccms.service.HttpRequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Service
public class HttpRequestServiceImpl implements HttpRequestService {
    
    private final static Logger logger = LoggerFactory.getLogger(HttpRequestServiceImpl.class);

    /**
     * 向指定URL发送GET方法的请求
     * 
     * @param2 url
     *            发送请求的URL
     * @param2 param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    @Override
    public HashMap sendGet(String url) {
    	logger.info("into sendGet method ");
        return restTemplate.getForObject(url, HashMap.class);
    }

    @Autowired
    private RestTemplate restTemplate;

}
