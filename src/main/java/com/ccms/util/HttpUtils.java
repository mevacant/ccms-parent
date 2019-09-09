package com.ccms.util;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Map;

@Slf4j
public class HttpUtils {

  
    /**    
     * POST请求，Map形式数据    
     * @param url 请求地址    
     * @param param 请求数据
     */  
    public static String sendPost(String url, Map<String, String> param) {
        StringBuffer buffer = new StringBuffer();  
        if (param != null && !param.isEmpty()) {  
            for (Map.Entry<String, String> entry : param.entrySet()) {  
                buffer.append(entry.getKey()).append("=").append(  
                        URLEncoder.encode(entry.getValue())).append("&");
            }  
        }  
        buffer.deleteCharAt(buffer.length() - 1);  
  
        PrintWriter out = null;  
        BufferedReader in = null;  
        String result = "";  
        try {  
            URL realUrl = new URL(url);  
            // 打开和URL之间的连接    
            URLConnection conn = realUrl.openConnection();  
            // 设置通用的请求属性    
            conn.setRequestProperty("accept", "*/*");  
            conn.setRequestProperty("connection", "Keep-Alive");  
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行    
            conn.setDoOutput(true);  
            conn.setDoInput(true);  
            // 获取URLConnection对象对应的输出流    
            out = new PrintWriter(conn.getOutputStream());  
            // 发送请求参数    
            out.print(buffer);  
            // flush输出流的缓冲    
            out.flush();
            result = getResponseResult(in,conn);
        } catch (Exception e) {
            log.error("-----发送 POST 请求出现异常！{}",e);
            e.printStackTrace();  
        }  
        // 使用finally块来关闭输出流、输入流    
        finally {  
            try {  
                if (out != null) {  
                    out.close();  
                }  
                if (in != null) {  
                    in.close();  
                }  
            } catch (IOException ex) {  
                ex.printStackTrace();  
            }  
        }  
        return result;  
    }

    /**
     * 发送get请求
     * @param url
     * @param params
     * @return
     */
    public static String sendGet(String url,Map<String,String> params) {
        if(params != null && params.size()>0){
            StringBuilder urlSb = new StringBuilder();
            urlSb.append("?");
            for(Map.Entry<String,String> entry : params.entrySet()){
                urlSb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
            url += urlSb.deleteCharAt(urlSb.length()-1).toString();
        }

        String result = "";
        BufferedReader in = null;
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            result = getResponseResult(in,connection);
        } catch (Exception e) {
            log.error("---发送GET请求出现异常！{}",e);
            e.printStackTrace();
        }finally { // 使用finally块来关闭输入流
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

    private static String getResponseResult(BufferedReader in, URLConnection connection) throws IOException {
        // 定义 BufferedReader输入流来读取URL的响应
        in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
        String line;
        StringBuilder inSb = new StringBuilder();
        while ((line = in.readLine()) != null) {
            inSb.append(line);
        }
        return inSb.toString();
    }

}
