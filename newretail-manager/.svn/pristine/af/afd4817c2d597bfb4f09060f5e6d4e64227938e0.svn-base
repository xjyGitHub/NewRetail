package com.newretail.pojo.custom;

import java.util.List;

/**
 * 返回给App端的通用实体类，数据类型为Object类型
 * 包括微信小程序、移动App等
 * @author Yongjie
 *	code = 200 代码请求成功,100代表失败
 * @param <T> Object
 */
public class AppResponseResult<T> {
	
	private int code;
	   private T data;
	   private String msg;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "WeChatResponseObj [code=" + code + ", data=" + data + ", msg=" + msg + "]";
	}
	/**
	 * 
	 * @param code 参数 200 成功 ,100 失败
	 * @param data 数据
	 * @param msg 消息
	 */
	public AppResponseResult(int code, T data, String msg) {
		super();
		this.code = code;
		this.data = data;
		this.msg = msg;
	}
	public AppResponseResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * 请求成功
	 * @return 
	 */
	public static AppResponseResult succeed() {
		return new AppResponseResult(200,null,"succeed");
	}
	
	/**
	 *  自定义返回code级msg
	 * @param code
	 * @param msg
	 * @return
	 */
	public static AppResponseResult build(int code,String msg) {
		return new AppResponseResult(code,null,msg);
	}
	
	/**
	 * 请求失败
	 * @return 
	 */
	public static AppResponseResult fail() {
		return new AppResponseResult(100,null,"failed");
	}
	/**
	 * 请求失败
	 * @return 
	 */
	public static AppResponseResult fail(String msg) {
		return new AppResponseResult(100,null,msg);
	}
}
