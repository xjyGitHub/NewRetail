package com.newretail.controller.app;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newretail.pojo.app.OrderCreateRquest;
import com.newretail.pojo.app.OrderStatistics;
import com.newretail.pojo.app.RefundResponse;
import com.newretail.pojo.app.ReputationsRoot;
import com.newretail.pojo.custom.AppResponseResult;

/**
 * 
 * ClassName: OrderController <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason: TODO  <br/>  
 * date: 2017年12月25日 下午8:25:06 <br/>  
 *  订单相关接口
 * @author Yongjie  
 * @version   
 * @since JDK 1.8
 */
public interface OrderController {
	/**
	 * 
	 * queryAllOrderList <br/>   
	 * 获取所有订单
	 * @author Yongjie  
	 * @param token 用户Token，登录接口返回的登录凭证
	 * @param page 	获取第几页的数据，不传该参数默认为1
	 * @param pageSize 每页获取多少条数据，不传该参数默认获取50条数据
	 * @param status 订单状态，-1 已关闭 0 待支付 1 已支付待发货 2 已发货待确认 3 确认收货待评价 4 已评价
	 * @param orderNumber 订单编号，如：OD1703281618955938
	 * @param goodReputation  评价状态：0 差评 1 中评 2 好评
	 * @return
	 * @since JDK 1.8
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="getuser",method=RequestMethod.POST)
	@ResponseBody
	public AppResponseResult queryAllOrderList(
			@RequestParam String token,
			@RequestParam int page,
			@RequestParam int pageSize,
			@RequestParam int status,
			@RequestParam String orderNumber,
			@RequestParam int goodReputation);
	/**
	 * 
	 * queryOrderStatistics <br/>   
	 *  返回用户订单统计
	 * @author Yongjie  
	 * @param token
	 * @return  
	 * @since JDK 1.8
	 */
	public AppResponseResult<OrderStatistics> queryOrderStatistics(@RequestParam String token);
	
	/**
	 * 创建订单
	 * createOrderByOrderCreateRequest <br/>   
	 *  
	 * @author Yongjie  
	 * @param orderCreateRquest 
	 * @return  
	 * @since JDK 1.8
	 */
	public AppResponseResult createOrderByOrderCreateRequest(@RequestBody OrderCreateRquest orderCreateRquest);
	/**
	 * 确认收货
	 * confirmOrderDelivery <br/>   
	 *  
	 * @author Yongjie  
	 * @param token
	 * @param orderId
	 * @return  
	 * @since JDK 1.8
	 */
	public AppResponseResult confirmOrderDelivery(@RequestParam String token,@RequestParam String orderId);
	
	/**
	 * 关闭订单接口
	 * closeOrderByTokenAndOrderId <br/>   
	 *  
	 * @author Yongjie  
	 * @param token
	 * @param orderId
	 * @return  
	 * @since JDK 1.8
	 */
	public AppResponseResult closeOrderByTokenAndOrderId(@RequestParam String token,@RequestParam String orderId);

	/**
	 * 评论
	 * orderReputation <br/>   
	 *  
	 * @author Yongjie  
	 * @param reputationsRoot
	 * @return  
	 * @since JDK 1.8
	 */
	public AppResponseResult orderReputation(@RequestBody ReputationsRoot reputationsRoot);

	/**
	 * 查询退款记录
	 * @param token
	 * @param orderId
	 * @return
	 */
	public AppResponseResult<List<RefundResponse>> queryRefund(@RequestParam String token,@RequestParam String orderId);

	/**
	 * 
	 * orderPay <br/>   
	 *  支付
	 * @author Yongjie  
	 * @param token
	 * @param orderId
	 * @return  
	 * @since JDK 1.8
	 */
	public AppResponseResult orderPay(@RequestParam String token,@RequestParam String orderId);

	/**
	 * 查询订单明细
	 * @param token 用户登陆凭证
	 * @param id 订单编号
	 * @return
	 */
	public AppResponseResult querOrderDetail(@RequestParam String token,@RequestParam String id);

}
