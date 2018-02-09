/**  
 * Project Name:newretail-manager-pojo  
 * File Name:ReputationsRoot.java  
 * Package Name:com.newretail.pojo.wechatapp
 * Date:2017年12月25日下午8:45:36  
 * Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved.  
 *  
*/  
/**  
 * Project Name:newretail-manager-pojo  
 * File Name:ReputationsRoot.java  
 * Package Name:com.newretail.pojo.wechatapp
 * Date:2017年12月25日下午8:45:36  
 * Copyright (c) 2017, https://www.campuspp.com All Rights Reserved.  
 *  
 */  
  
package com.newretail.pojo.wechatapp;

import java.util.List;

/**  
 * ClassName:ReputationsRoot <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2017年12月25日 下午8:45:36 <br/>  
 * @author   Yongjie  
 * @version    
 * @since    JDK 1.8  
 * @see        
 */
public class ReputationsRoot {
	/**用戶登錄凭证*/
	private String token;
	/**订单ID*/
	private String orderId;
	/**评论*/
	private List<Reputations> reputations;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public List<Reputations> getReputations() {
		return reputations;
	}
	public void setReputations(List<Reputations> reputations) {
		this.reputations = reputations;
	}
	
}
  
