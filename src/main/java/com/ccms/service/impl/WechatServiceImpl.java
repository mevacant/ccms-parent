package com.ccms.service.impl;

import com.ccms.constant.Constant;
import com.ccms.service.HttpRequestService;
import com.ccms.service.WechatService;
import com.ccms.util.DateUtil;
import com.ccms.util.RedisTemplateUtil;
import com.ccms.util.StringUtils;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

@Service
public class WechatServiceImpl implements WechatService {
    private final static Logger logger = LoggerFactory.getLogger(WechatServiceImpl.class);

    @Autowired
    private HttpRequestService httpRequestService;

    @Value("${wx.appid}")
    private String appid;

    @Value("${wx.appsecret}")
    private String appsecret;

    // redis过期时间（单位为秒，设置为1个半小时）
    private int overduetime = 5400;

    @Override
    public Map<String, Object> getAccessData(String url) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        Map<String, String> tokenMap = new HashMap<String, String>();

        logger.info("Wechat url={}", url);
        try {
            // token
            getToken(tokenMap);
            String token = MapUtils.getString(tokenMap, "token");
            String ticket = MapUtils.getString(tokenMap, "ticket");

            // 随机字符串
            String nonceStr = StringUtils.getRandomString(16);
            // 获取当前时间戳
            String timestampStr = String.valueOf(System.currentTimeMillis());
            // 将时间戳转为秒（单位：s）
            String timestamp = timestampStr.substring(0, timestampStr.length() - 3);
            // 获取认证签名
            String signature = getSignature(ticket, nonceStr, timestamp, url);

            // 返回数据
            resMap.put("appId", appid);
            resMap.put("nonceStr", nonceStr);
            resMap.put("timestamp", timestamp);
            resMap.put("signature", signature);

            logger.info("url=" + url);
            logger.info("token=" + token);
            logger.info("resMap=" + resMap);
        }
        catch (Exception e) {
            logger.info("Exception!" + e);
        }

        return resMap;
    }

    /**
     * 获取token Map
     * @param tokenMap
     */
    private void getToken(Map<String, String> tokenMap){
        if(RedisTemplateUtil.exists("activity_wx_share_token_map")){

            tokenMap.putAll((Map<String, String>)RedisTemplateUtil.hGetAll("activity_wx_share_token_map"));
            logger.info("getToken from RedisUtil token = "+tokenMap.get("token")+"  ticket=" +tokenMap.get("ticket") );
            return;
        }

        String tokenParams = "?grant_type=client_credential&appid=" + appid + "&secret=" + appsecret;

        Map<String, Object> resultMap = httpRequestService.sendGet(Constant.URL_WX_GETTOKEN+tokenParams);

        logger.info("Wechat tokenMap={}", resultMap);

        String token = MapUtils.getString(resultMap, "access_token");

        String ticketParams = "?type=jsapi&access_token=" + token;

        Map<String, Object> ticketMap = httpRequestService.sendGet(Constant.URL_WX_GETTICKET+ticketParams);
        logger.info("Wechat ticketMap={}", ticketMap);

        String ticket = MapUtils.getString(ticketMap, "ticket");

        tokenMap.put("ticket", ticket);
        tokenMap.put("token", token);

        RedisTemplateUtil.hSetAll("activity_wx_share_token_map", tokenMap );
        RedisTemplateUtil.expire("activity_wx_share_token_map",overduetime);

    }

    private String getSignature(String ticket, String noncestr, String timestamp, String url) {
        StringBuilder sb = new StringBuilder();

        sb.append("jsapi_ticket=");
        sb.append(ticket);
        sb.append("&noncestr=");
        sb.append(noncestr);
        sb.append("&timestamp=");
        sb.append(timestamp);
        sb.append("&url=");
        sb.append(url);

        String str = sb.toString();

        MessageDigest md = null;
        String tmpStr = null;

        try {
            md = MessageDigest.getInstance("SHA-1");
            byte[] digest = md.digest(str.getBytes());

            tmpStr = byteToStr(digest);
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return tmpStr;
    }


    private String byteToStr(byte[] byteArray) {
        String strDigest = "";
        for (int i = 0; i < byteArray.length; i++) {
            strDigest += byteToHexStr(byteArray[i]);
        }
        return strDigest;
    }


    private String byteToHexStr(byte mByte) {
        char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        char[] tempArr = new char[2];
        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
        tempArr[1] = Digit[mByte & 0X0F];

        String s = new String(tempArr);

        return s;
    }

}
