package com.newretail.common.utils;

import java.io.IOException;

/**
 * @ClassName: OSSConfig
 * @Description: OSS配置类
 * @author AggerChen
 * @date 2016年11月4日 下午3:58:36
 */
class OSSConfig{
    private  String endpoint;  		//连接区域地址
    private  String accessKeyId;  	//连接keyId
    private  String accessKeySecret;    //连接秘钥
    private  String bucketName;  	//需要存储的bucketName
    private  String picLocation;  	//图片保存路径
	
    public OSSConfig() {
    	try {
			this.endpoint = SystemConfig.getConfigResource("endpoint");
			this.bucketName = SystemConfig.getConfigResource("bucketName");
			this.picLocation = SystemConfig.getConfigResource("picLocation");
			this.accessKeyId = SystemConfig.getConfigResource("accessKeyId");
			this.accessKeySecret = SystemConfig.getConfigResource("accessKeySecret");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    /**
     * 
     * @param isPublic
     */
    public OSSConfig(boolean isPublic) {
    	if(isPublic==true) {
    		try {
    			this.endpoint = SystemConfig.getConfigResourcePublic("endpoint");
    			this.bucketName = SystemConfig.getConfigResourcePublic("bucketName");
    			this.picLocation = SystemConfig.getConfigResourcePublic("picLocation");
    			this.accessKeyId = SystemConfig.getConfigResourcePublic("accessKeyId");
    			this.accessKeySecret = SystemConfig.getConfigResourcePublic("accessKeySecret");
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    	}else {
    		try {
    			this.endpoint = SystemConfig.getConfigResource("endpoint");
    			this.bucketName = SystemConfig.getConfigResource("bucketName");
    			this.picLocation = SystemConfig.getConfigResource("picLocation");
    			this.accessKeyId = SystemConfig.getConfigResource("accessKeyId");
    			this.accessKeySecret = SystemConfig.getConfigResource("accessKeySecret");
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    	}
    	
	}

	public String getEndpoint() {
		return endpoint;
	}
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
	public String getAccessKeyId() {
		return accessKeyId;
	}
	public void setAccessKeyId(String accessKeyId) {
		this.accessKeyId = accessKeyId;
	}
	public String getAccessKeySecret() {
		return accessKeySecret;
	}
	public void setAccessKeySecret(String accessKeySecret) {
		this.accessKeySecret = accessKeySecret;
	}
	public String getBucketName() {
		return bucketName;
	}
	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}
	public String getPicLocation() {
		return picLocation;
	}
	public void setPicLocation(String picLocation) {
		this.picLocation = picLocation;
	}
}