package com.newretail.common.utils;

import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

/**
 * Created with YongjieWu.
 * Description:
 * User: Yongjie
 * Date: 2018-01-05
 * Time: 17:46
 */
public class Base64Utils {
    /**
     * 解码
     * @param string
     * @return
     */
    public static String decode(final String string) {
        try {
            return new String(Base64.decodeBase64(string.getBytes("UTF-8")), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 二进制数据编码为BASE64字符串
     * @param string
     * @return
     */
    public static String encode(final String string) {
        try {
            return new String(Base64.encodeBase64(string.getBytes("UTF-8")),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

}
