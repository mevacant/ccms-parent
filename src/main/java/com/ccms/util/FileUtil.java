package com.ccms.util;

import org.apache.commons.lang3.StringUtils;

/**
 * @author YH
 * @create 2019-07-09
 */
public class FileUtil {

    /**
     * 获取图片文件的完整URL地址
     *
     * @param imageUrl
     * @param size
     * @return URL
     */
    public static String modifier(String imageUrl, String size) {
        if (StringUtils.isEmpty(imageUrl)) {
            return "";
        }

        if (imageUrl.length() < 4 || (!StringUtils.equals(imageUrl.substring(0, 4), "http"))) {
            imageUrl = "http://jyx.ytuow.com" + imageUrl;
        }
        String type = "";
        int len = imageUrl.lastIndexOf(".");
        if (len != -1) {
            type = imageUrl.substring(len + 1);
        }
        if (StringUtils.isNotEmpty(size)) {
            return getSizeImageUrl(imageUrl, size, type);
        }

        return imageUrl;
    }

    private static String getSizeImageUrl(String imageUrl, String size, String type) {
        int len = imageUrl.lastIndexOf("_");
        if (len != -1) {
            imageUrl = imageUrl.substring(0, len);
        }
        StringBuilder sb = new StringBuilder(imageUrl);
        return sb.append('_').append(size.toLowerCase()).append(".").append(type).toString();
    }


    /*
     * Java文件操作 获取文件扩展名
     *
     *  Created on: 2011-8-2
     *      Author: blueeagle
     */
    public static String getExtensionName(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot > -1) && (dot < (filename.length() - 1))) {
                return filename.substring(dot + 1);
            }
        }
        return filename;
    }

    /*
     * Java文件操作 获取不带扩展名的文件名
     *
     *  Created on: 2011-8-2
     *      Author: blueeagle
     */
    public static String getFileNameNoEx(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot > -1) && (dot < (filename.length()))) {
                return filename.substring(0, dot);
            }
        }
        return filename;

    }

}
