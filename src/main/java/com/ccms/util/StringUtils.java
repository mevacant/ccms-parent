package com.ccms.util;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 * 
 * @author GuoqiangMen
 *
 */
public class StringUtils
{

    /**
     * 判断字符串为空
     * 
     * @param str
     * @return
     */
    public static boolean isEmpty(String str)
    {
        if (str == null || str.length() == 0)
        {
            return true;
        }

        return false;
    }

    /**
     * 判断字符串为不空
     * 
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str)
    {
        if (!isEmpty(str))
        {
            return true;
        }

        return false;
    }

    /**
     * 随机生成字符串
     * 
     * @param length
     *            字符串长度
     * @return
     */
    public static String getRandomString(int length)
    {
        String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++)
        {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }

        return sb.toString();
    }

    /**
     * 获取客户端IP地址
     * 
     * @param request
     * @return
     */
    public static String getIp(HttpServletRequest request)
    {
        String ip = request.getHeader("X-Forwarded-For");
        if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip))
        {
            // 多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = ip.indexOf(",");
            if (index != -1)
            {
                return ip.substring(0, index);
            }
            else
            {
                return ip;
            }
        }
        ip = request.getHeader("X-Real-IP");
        if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip))
        {
            return ip;
        }
        return request.getRemoteAddr();
    }

    /**
     * 随机数字，范围min -- max <功能详细描述>
     * 
     * @author JunHuang
     * @param min
     * @param max
     * @return
     * @since 2016年2月4日 下午3:50:20
     */
    public static int randomInt(int min, int max)
    {
        Random random = new Random();
        return random.nextInt(max) % (max - min + 1) + min;
    }

    /**
     * 首字母大写
     * 
     * @param str
     * @return
     */
    public static String toFirstLetterUpperCase(String str)
    {
        if (str == null || str.length() < 2)
        {
            return str;
        }
        String firstLetter = str.substring(0, 1).toUpperCase();
        return firstLetter + str.substring(1, str.length());
    }
    
    /**
     * 替换模版参数
     * 
     * @param str
     * @return
     */
    public static String templateReplace(String template, String... args)
    {
        if (args == null || args.length == 0){
            return null;
        }
        String ret = template ;
        for (String str : args){
            ret = ret.replaceFirst("\\{[^\\{\\}]*\\}", String.valueOf(str));
        }
        
        return ret;
    }

    /**
     * 正则表达式匹配{}里的字符串
     * @param str //要验证的字符串
     * @return
     */
    public static List<String> getRegExStr(String str) {
        List<String> regExStrs = new ArrayList<String>();
        String regEx = "\\{.*?\\}"; //匹配的正则表达式
        // 编译正则表达式
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(str);
        while(matcher.find()){
            String param = matcher.group().replaceAll("^.*\\{", "").replaceAll("}.*", ""); 
            regExStrs.add(param);
        }
        return regExStrs;
    }
    
    /**
     * 正则表达式匹配{}里的字符串
     * @param str //要验证的字符串
     * @return
     */
    public static double getRandom(double min, double max) {
        return Math.random() * (max - min) + min;
    }

}
