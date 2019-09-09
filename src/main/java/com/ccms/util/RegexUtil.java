package com.ccms.util;

import java.util.regex.Pattern;

public class RegexUtil {

    /**
     * 身份证号校验
     * @param idCardNo
     * @return
     */
    public static boolean validateIdCardNo(String idCardNo){
        String pattern = "\\d{15}(\\d{2}[0-9xX])?";
        return Pattern.matches(pattern,idCardNo);
    }

    /**
     * 银行卡号校验
     * @param bankCardNo
     * @return
     */
    public static boolean validateBankCardNo(String bankCardNo){
        String pattern = "/^(\\d{16}|\\d{19}|\\d{17})$/";
        return Pattern.matches(pattern,bankCardNo);
    }

    /**
     * 开户行校验
     * @param openBank
     * @return
     */
    public static boolean validateOpenBank(String openBank){
        String pattern = "/^[\\x{4e00}-\\x{9fa5}]+$/u";
        return Pattern.matches(pattern,openBank);
    }
    /**
     * 邮箱校验
     * @param email
     * @return
     */
    public static boolean validateEmail(String email){
        String pattern = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        return Pattern.matches(pattern,email);
    }

    /**
     * 手机号校验
     * @param mobile
     * @return
     */
    public static boolean validateMobile(String mobile){
        String pattern = "^[1][3,4,5,6,7,8,9][0-9]{9}$";
        return Pattern.matches(pattern,mobile);
    }

    /**
     * 登陆账号校验 登录名仅支持英文字母，数字，中文，"_"和"-"'
     * @param account
     * @return
     */
    public static boolean validateAccount(String account){
        String pattern = "^[a-zA-Z0-9_\u4e00-\u9fa5]+$";
        return Pattern.matches(pattern,account);
    }
}
