package com.newretail.service.app;

import com.newretail.pojo.OrderTable;
import com.newretail.pojo.app.OrderItem;
import com.newretail.pojo.custom.AppResponseResult;
import com.newretail.pojo.custom.GoodsTableCustom;
import com.newretail.pojo.wechatapp.OrderCreateRquest;
import com.newretail.pojo.wechatapp.OrderRequest;
import com.newretail.pojo.wechatapp.OrderResponse;
import com.newretail.pojo.wechatapp.ReputationsRoot;

import java.util.List;

/**
 * 订单相关接口
 * @author Yongjie
 *
 */
public interface InterfaceOrderManagerService {
	/**
	 * @param token 用户登陆凭证
	 * @param page 从第几条开始
	 * @param pageSize 到多少条
	 * @param status 状态
	 * @return
	 * @throws Exception 抛出异常信息
	 */
	public AppResponseResult<List<OrderItem>> getOrderMerchantList(String token, int page, int pageSize, int status, String merchantId) throws Exception;

	/**
	 *修改订单
	 * @param token
	 * @param orderId 订单ID
	 * @return
	 * @throws Exception
	 */
	public AppResponseResult orderConfirmByMerchant(String token,String orderId,int status) throws Exception;
}
