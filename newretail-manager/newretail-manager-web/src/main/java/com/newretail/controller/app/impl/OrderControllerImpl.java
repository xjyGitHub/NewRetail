package com.newretail.controller.app.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newretail.controller.app.OrderController;
import com.newretail.pojo.UserTable;
import com.newretail.pojo.app.GoodsMapItem;
import com.newretail.pojo.app.LogisticsMapItem;
import com.newretail.pojo.app.OrderCreateRquest;
import com.newretail.pojo.app.OrderListItem;
import com.newretail.pojo.app.OrderRequest;
import com.newretail.pojo.app.OrderResponse;
import com.newretail.pojo.app.OrderStatistics;
import com.newretail.pojo.app.RefundResponse;
import com.newretail.pojo.app.ReputationsRoot;
import com.newretail.pojo.custom.AppResponseResult;
import com.newretail.service.InterfaceOrderService;
import com.newretail.service.UserService;

@Controller
@RequestMapping("/interface")
public class OrderControllerImpl implements OrderController {
	@Autowired
	private UserService userService;

	@Autowired
	private InterfaceOrderService interfaceOrderService;

	/**
	 * 获取所有订单
	 * @param orderRequest
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "order/list", method = RequestMethod.POST)
	@ResponseBody
	public AppResponseResult queryAllOrderList(@RequestBody OrderRequest orderRequest) throws Exception {

		UserTable userByToken = userService.getUserByToken(orderRequest.getToken());
		String userId = userByToken.getId();
		try {
			if (orderRequest.getPage() == 0) {
				orderRequest.setPage(1);
			}
			if (orderRequest.getPageSize() == 0) {
				orderRequest.setPageSize(50);
			}
			AppResponseResult<OrderResponse> body = interfaceOrderService.getUserOrderListByUserId(orderRequest,userId);
			return body;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return AppResponseResult.fail(orderRequest.getToken());
	}

	@Override
	public AppResponseResult queryAllOrderList(@RequestParam String token, @RequestParam int page, @RequestParam int pageSize, @RequestParam int status, @RequestParam String orderNumber,
			int goodReputation) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "order/statistics", method = RequestMethod.POST)
	@ResponseBody
	@Override
	public AppResponseResult<OrderStatistics> queryOrderStatistics(@RequestParam String token) {
		try {
			AppResponseResult appResponseResult = interfaceOrderService.orderStatistics(token);
			return appResponseResult;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return AppResponseResult.fail();
	}

	/**
	 * TODO.
	 * 
	 * @see com.newretail.controller.app.OrderController#createOrderByOrderCreateRequest(com.newretail.pojo.app.OrderCreateRquest)
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "order/create", method = RequestMethod.POST)
	@ResponseBody
	@Override
	public AppResponseResult createOrderByOrderCreateRequest(@RequestBody OrderCreateRquest orderCreateRquest) {
		try {
			return interfaceOrderService.orderCreate(orderCreateRquest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return AppResponseResult.fail("订单创建失败，请重新操作");
	}

	/**
	 * TODO.
	 * 
	 * @see com.newretail.controller.app.OrderController#confirmOrderDelivery(java.lang.String,
	 *      java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "order/delivery", method = RequestMethod.POST)
	@ResponseBody
	@Override
	public AppResponseResult confirmOrderDelivery(@RequestParam String token, @RequestParam String orderId) {
		try {
			AppResponseResult appResponseResult = interfaceOrderService.confirmOrderDelivery(token, orderId);
			return appResponseResult;
		} catch (Exception e) {
			return AppResponseResult.fail(e.getMessage());
		}
	}

	/**
	 * TODO.
	 * 
	 * @see com.newretail.controller.app.OrderController#closeOrderByTokenAndOrderId(java.lang.String,
	 *      java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "order/close", method = RequestMethod.POST)
	@ResponseBody
	@Override
	public AppResponseResult closeOrderByTokenAndOrderId(@RequestParam String token, @RequestParam String orderId) {
		AppResponseResult appResponseResult = null;
		try {
			appResponseResult = interfaceOrderService.closeOrderByOrderId(token, orderId);
			return appResponseResult;
		} catch (Exception e) {
			return AppResponseResult.fail(e.getMessage());
		}
	}

	/**
	 * TODO.
	 * 订单评论
	 * @see com.newretail.controller.app.OrderController#orderReputation(com.newretail.pojo.app.ReputationsRoot)
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "order/reputation", method = RequestMethod.POST)
	@ResponseBody
	@Override
	public AppResponseResult orderReputation(ReputationsRoot reputationsRoot) {
		try {
			AppResponseResult appResponseResult = interfaceOrderService.orderReputation(reputationsRoot);
			return  appResponseResult;
		} catch (Exception e) {
			return AppResponseResult.fail(e.getMessage());
		}
	}

	/**
	 * TODO.
	 * 查询退款
	 * @see com.newretail.controller.app.OrderController#queryRefund(java.lang.String,
	 *      java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "order/refund", method = RequestMethod.POST)
	@ResponseBody
	@Override
	public AppResponseResult<List<RefundResponse>> queryRefund(@RequestParam String token, @RequestParam String orderId) {
		AppResponseResult appResponseResult = null;
		try {
			appResponseResult = interfaceOrderService.orderRefund(token, orderId);
			return appResponseResult;
		} catch (Exception e) {
			return AppResponseResult.fail();
		}
	}

	/**
	 * TODO.
	 * 订单支付
	 * @see com.newretail.controller.app.OrderController#orderPay(java.lang.String,
	 *      java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "order/pay", method = RequestMethod.POST)
	@ResponseBody
	@Override
	public AppResponseResult orderPay(@RequestParam String token, @RequestParam String orderId) {
		AppResponseResult appResponseResult = null;
		try {
			appResponseResult = interfaceOrderService.orderPay(token, orderId);
			return appResponseResult;
		} catch (Exception e) {
			return AppResponseResult.fail();
		}
	}

	/**
	 * 查询订单明细
	 * @param token 用户登陆凭证
	 * @param id 订单编号
	 * @return
	 */
	@RequestMapping(value = "order/detail", method = RequestMethod.POST)
	@ResponseBody
	@Override
	public AppResponseResult querOrderDetail(@RequestParam String token, @RequestParam String id) {
		Logger logger = Logger.getLogger(OrderControllerImpl.class);
		logger.error(token+"--"+id);
		try {
			AppResponseResult appResponseResult = interfaceOrderService.querOrderDetail(token, id);
			return appResponseResult;
		} catch (Exception e) {
			return AppResponseResult.fail(e.getMessage());
		}
	}
}
