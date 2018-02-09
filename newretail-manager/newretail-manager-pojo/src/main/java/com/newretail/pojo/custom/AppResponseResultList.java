package com.newretail.pojo.custom;
import java.util.List;

/**
 * 返回给App端的实体类，返回数据类型为数组类型的
 * 移动端包括微信小程序，移动APP
 * @author Yongjie
 * code = 200 代码请求成功,100代表失败
 * @param <T>
 */
public class AppResponseResultList<T> {

   private int code;
   private List<T> data;
   private String msg;
   public void setCode(int code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }

   public void setData(List<T> data) {
        this.data = data;
    }
    public List<T> getData() {
        return data;
    }

   public void setMsg(String msg) {
        this.msg = msg;
    }
    public String getMsg() {
        return msg;
    }
    /**
     * 
     * @param code  默认200代表成功,100代表失败
     * @param data
     * @param msg
     */
	public AppResponseResultList(int code, List<T> data, String msg) {
		super();
		this.code = code;
		this.data = data;
		this.msg = msg;
	}
	public AppResponseResultList() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 请求成功
	 * @return 
	 */
	public static AppResponseResultList succeed() {
		return new AppResponseResultList(0,null,"succeed");
	}
	
	/**
	 *  自定义返回code级msg
	 * @param code
	 * @param msg
	 * @return
	 */
	public static AppResponseResultList build(int code,String msg) {
		return new AppResponseResultList(code,null,msg);
	}
	
	/**
	 * 请求失败
	 * @return 
	 */
	public static AppResponseResultList fail() {
		return new AppResponseResultList(100,null,"failed");
	}
    
}
