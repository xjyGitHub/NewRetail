package com.newretail.common.utils;

public class StsData {
	private String AccessKeyId;

	private String AccessKeySecret;

	private String SecurityToken;

	private String Expiration;

	public void setAccessKeyId(String AccessKeyId){
	this.AccessKeyId = AccessKeyId;
	}
	public String getAccessKeyId(){
	return this.AccessKeyId;
	}
	public void setAccessKeySecret(String AccessKeySecret){
	this.AccessKeySecret = AccessKeySecret;
	}
	public String getAccessKeySecret(){
	return this.AccessKeySecret;
	}
	public void setSecurityToken(String SecurityToken){
	this.SecurityToken = SecurityToken;
	}
	public String getSecurityToken(){
	return this.SecurityToken;
	}
	public void setExpiration(String Expiration){
	this.Expiration = Expiration;
	}
	public String getExpiration(){
	return this.Expiration;
	}
}
