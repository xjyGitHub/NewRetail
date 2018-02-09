package com.newretail.controller.wechatapp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestParam;

import com.newretail.pojo.custom.AddressResponse;
import com.newretail.pojo.custom.AppResponseResult;
import com.newretail.pojo.custom.AppResponseResultList;
/**
 * 地址管理
 * @author Yongjie
 *
 */
public interface AddressController {
	/**
	 * 根据Token获取城市列表
	 * 
	 * @param req
	 * @return
	 */
	AppResponseResultList<AddressResponse> getAllShippingAddress(@RequestParam("token") String token) ;
	
	/**
	 * 根据Token默认地址
	 * @param req
	 * @return
	 */
	AppResponseResult<AddressResponse> getAllShippingDefaultAddress(HttpServletRequest req);
	
	/**
	 *  获取详细收货地址
	 * @param token
	 * @param id 地址ID
	 * @return
	 */
	AppResponseResult<AddressResponse> getAllShippingDetailAddress(@RequestParam String token,@RequestParam String id) ;
	
	/**
	 * 添加收货地址
	 * @param req
	 * @return
	 */
	AppResponseResult<String> addShippingAddress(HttpServletRequest req);
	
	/**
	 * 删除收货地址
	 * @param token 
	 * @param id 地址ID
	 * @return
	 */
	AppResponseResult<String> delShippingAddress(@RequestParam("token") String token,@RequestParam("id") String id);
	
	/**
	 * 修改地址
	 * @param token
	 * @param id 地址ID
	 * @param isDefault 是否默认
	 * @return
	 */
	AppResponseResult<String> updateShippingAddress(@RequestParam("token") String token,@RequestParam("id") String id,@RequestParam Boolean isDefault);
	
	

}
