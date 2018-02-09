package com.newretail.common.utils;

import java.net.URL;
import java.util.Date;

import org.apache.log4j.Logger;

import com.aliyun.oss.HttpMethod;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.GeneratePresignedUrlRequest;

/**
 * 阿里云OSS对象存储，工具 需要访问图片是调用，通过获取STS授权方式后去获取授权后的 URL，URL有过期时间。
 * 
 * @author Yongjie
 *
 */
public class AliyunOssUtils {
	// private static AliyunOssUtils instance = null;

	private static String bucketName = "newretail-app";
	private String endpoint = "http://oss-cn-shenzhen.aliyuncs.com";
	private OSSClient client = null;
	private String accessKeyId = "LTAIiqu8ll61HBex";
	private String accessKeySecret ="JSXMOImI677xBiUwClcHMd65zn7a2w";
	private String securityToken;
	static Logger logger = Logger.getLogger(AliyunOssUtils.class);

	public AliyunOssUtils() {
//		String json = HttpClientUtil.doGet("http://39.108.94.35:10081");
//		StsData stsData = GsonUtils.parseJson(json, StsData.class);
//		this.accessKeyId = stsData.getAccessKeyId();
//		this.accessKeySecret = stsData.getAccessKeySecret();
//		this.securityToken = stsData.getSecurityToken();
//		client = new OSSClient(endpoint, accessKeyId, accessKeySecret, securityToken);
		client = new OSSClient(endpoint, accessKeyId, accessKeySecret);
	}

	public void init() {
//		client = new OSSClient(endpoint, accessKeyId, accessKeySecret, securityToken);
		client = new OSSClient(endpoint, accessKeyId, accessKeySecret);
	}

	/**
	 * 销毁
	 */
	public void destory() {
		client.shutdown();
	}

	/**
	 * 获取签名后的路径
	 * 
	 * @param oldUrl
	 * @return
	 */
	public String getImageUrl(String oldUrl) {
		// 设置URL过期时间为2小时
		Date expiration = new Date(new Date().getTime() + 3600 * 1000);
		URL url = client.generatePresignedUrl(bucketName, oldUrl.substring(1, oldUrl.length()), expiration);
		return url.toString();
	}

	public  String getImageSignUrl(String oldUrl) {
		// 设置URL过期时间为2小时
		Date expiration = new Date(new Date().getTime() + 3600 * 1000);
		URL url = client.generatePresignedUrl(bucketName, oldUrl.substring(1, oldUrl.length()), expiration);
		return url.toString();
	}
	
	public  String getImageSignUrl(String oldUrl,int w,int h) {
		String style = "image/resize,w_"+String.valueOf(w)+",h_"+String.valueOf(h)+",limit_0";
		// 设置URL过期时间为2小时
		Date expiration = new Date(new Date().getTime() + 3600 * 1000);
		GeneratePresignedUrlRequest req = new GeneratePresignedUrlRequest(bucketName, oldUrl.substring(1, oldUrl.length()), HttpMethod.GET);
	    req.setExpiration(expiration);
	    req.setProcess(style);
		URL url = client.generatePresignedUrl(req);
		return url.toString();
	}
}
