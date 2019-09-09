package com.ccms.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Util {

    /**
     * 小写32位md5加密
     * @param sourceStr
     * @return
     */
    public static String lowerMD5_32(String sourceStr) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(sourceStr.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer();
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString();
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
        return result;
    }

    /**
     * 大写32位md5加密
     * @param sourceStr
     * @return
     */
    public static String upperMD5_32(String sourceStr){
        return lowerMD5_32(sourceStr).toUpperCase();
    }

}
