package com.newretail.service;

import com.newretail.pojo.OrderTable;
import com.newretail.pojo.wechatapp.OrderCreateRquest;
import com.newretail.pojo.wechatapp.OrderRequest;
import com.newretail.pojo.wechatapp.OrderResponse;
import com.newretail.pojo.wechatapp.ReputationsRoot;
import com.newretail.pojo.custom.AppResponseResult;
import com.newretail.pojo.custom.GoodsTableCustom;

/**
 * 订单相关接口
 * @author Yongjie
 *
 */
public interface InterfaceOrderService {
	/**
	 * 通过订单ID查询订单
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	public OrderTable getOrderListByOrderId(String orderId)  throws Exception;

	/**
	 *  查询订单信息
	 * @param orderId
	 * @param userId
	 * @return
	 */
	public AppResponseResult<OrderResponse> getOrderList(String orderId,String userId);

	/**
	 * 查询用户订单
	 * @param orderRequest  订单请求参数
	 * @param userId 用户ID
	 * @return
	 * @throws Exception 查询失败时抛出异常信息
	 */
	public AppResponseResult<OrderResponse> getUserOrderListByUserId(OrderRequest orderRequest,String userId) throws Exception;

	/**
	 * 通过商品ID查询商品信息
	 * @param goodsId
	 * @return
	 * @throws Exception
	 */
	public GoodsTableCustom getGoodsCustomById(String goodsId)  throws Exception;

	/**
	 * 关闭订单
	 * @param token
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	public AppResponseResult closeOrderByOrderId(String token,String orderId)  throws Exception;

	/**
	 *
	 * @param token
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	public AppResponseResult confirmOrderDelivery(String token,String orderId) throws Exception;

	/**
	 * 订单评论接口
	 * @param reputationsRoot
	 * @return
	 * @throws Exception
	 */
	public AppResponseResult orderReputation(ReputationsRoot reputationsRoot)  throws Exception;

	/**
	 * 订单统计接口
	 * @param token
	 * @return
	 * @throws Exception
	 */
	public AppResponseResult orderStatistics(String token)  throws Exception;

	/**
	 * 退款接口
	 * @param token
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	public AppResponseResult orderRefund(String token,String orderId)  throws Exception;

	/**
	 * 订单支付接口
	 * @param token
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	public AppResponseResult orderPay(String token,String orderId)  throws Exception;

	/**
	 * 查询订单明细
	 * @param token
	 * @param id
	 * @return
	 */
	public AppResponseResult  querOrderDetail(String token, String id) throws Exception;

	/**
	 * 创建订单
	 * @param orderCreateRquest 订单信息
	 * @return
	 * @throws Exception
	 */
	public AppResponseResult  orderCreate(OrderCreateRquest orderCreateRquest) throws Exception;


}
