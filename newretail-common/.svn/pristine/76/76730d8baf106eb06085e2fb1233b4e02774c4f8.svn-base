package com.newretail.common.utils;


import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 加解密工具
 * @author Yongjie
 *
 */
public class EncrypationUtils {
	/**
	 * md5加密
	 * @param express 明文
	 * @return 返回加密后的密文
	 */
	public static String md5Hex(String express) {
		return DigestUtils.md5Hex(express);
	}
	/**
	 * SHA1加密
	 * @param express 明文
	 * @return 返回加密后的密文
	 */
	public static String shaHex(String express) {
		return DigestUtils.sha1Hex(express);
	}
	
	/**
	 * Base64编码
	 * @param express 明文
	 * @return 返回加密后的密文
	 */
	public static String base64Hex(String express) {
		return Base64.encodeToString(express.getBytes(),Base64.DEFAULT);
	}
	/**
	 * Base64解码
	 * @param base64Str 传入加密过的Base64字符串
	 * @return
	 */
	public static String base64Decrypt(String base64Str) {
		return new String(Base64.decode(base64Str,Base64.DEFAULT));
	}
	
	/***
     *  利用Apache的工具类实现SHA-256加密
     * @param str 加密后的报文
     * @return
     */
    public static String getSHA256Str(String str){
        MessageDigest messageDigest;
        String encdeStr = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hash = messageDigest.digest(str.getBytes("UTF-8"));
            encdeStr = Hex.encodeHexString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encdeStr;
    }
}
