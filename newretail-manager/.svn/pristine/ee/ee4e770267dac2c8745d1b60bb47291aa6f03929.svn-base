package com.newretail.controller.web;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newretail.common.utils.*;
import com.newretail.pojo.custom.OrderFindRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newretail.pojo.UserTable;
import com.newretail.service.IOrderManageService;
import com.newretail.service.UserService;

/**
 * 订单管理类
 */
@Controller
@RequestMapping("/order")
public class OrderManageController {
	
	@Autowired
	private IOrderManageService orderManageService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/toIndex")	
	public String toIndex(HttpServletRequest req){
		String token = CookieUtils.getCookieValue(req, "NEWRETAIL_LOGIN");
		UserTable userByToken = null;
		try {
			userByToken = userService.getUserByToken(token);
		} catch (Exception e1) {
			e1.printStackTrace();
		}		
		req.setAttribute("userIdentify", userByToken.getIdentify());
		return "forward:/order";//转发页面，重定向用redirect,forward:
	}

	/**
	 * 获取订单列表
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping("/getOrderList")
	@ResponseBody
	public JqGridResult getOrderList(HttpServletRequest req,HttpServletResponse res){
		//获取用户登陆凭证
		String token = CookieUtils.getCookieValue(req, "NEWRETAIL_LOGIN");
		UserTable userByToken = null;
		String merchantId = "";
		try {
			userByToken = userService.getUserByToken(token);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		Map<String,Object> params = new HashMap<>();
		if(userByToken.getIdentify().equals("2")){
			params.put("merchantId", userByToken.getId());
		}


		int pageSize = Integer.parseInt(req.getParameter("rows"));//这个是每页要显示的行数
		int page = Integer.parseInt(req.getParameter("page"));//显示的第几页
		OrderFindRequest orderRequest = new OrderFindRequest();
		orderRequest.setPage(page);
		orderRequest.setPageSize(pageSize);
		if(!TextUtils.isEmpty(req.getParameter("orderTime"))){
			orderRequest.setOrderTime(DateUtil.getDate(req.getParameter("orderTime")));
		}else{
			orderRequest.setOrderTime(DateUtil.getNowDate());
		} if(!TextUtils.isEmpty(req.getParameter("orderCode"))){
			orderRequest.setOrderCode(req.getParameter("orderCode"));
		}else{
			orderRequest.setOrderCode(req.getParameter(""));
		}
		if(!TextUtils.isEmpty(req.getParameter("orderStatus"))){
			orderRequest.setOrderStatus(Integer.parseInt(req.getParameter("orderStatus")));
		}
		if(!TextUtils.isEmpty(req.getParameter("deliverStatus"))){
			orderRequest.setDeliverStatus(Integer.parseInt(req.getParameter("deliverStatus")));
		}
		if(!TextUtils.isEmpty(req.getParameter("deliverType"))){
			orderRequest.setDeliverStatus(Integer.parseInt(req.getParameter("deliverType")));
		}
		orderRequest.setMerchantId(userByToken.getId());
		return orderManageService.getOrderList(orderRequest);
	}
	
	@RequestMapping("/getGoodsList")
	@ResponseBody
	public NewRetailResult getGoodsList(HttpServletRequest req,HttpServletResponse res){
		
		String orderCode = req.getParameter("orderCode");
		if(StringUtils.isEmpty(orderCode)){
			return new NewRetailResult(NewRetailResult.RESULT_FAILED, "订单号不能为空", null);
		}	
		return orderManageService.getGoodsByOrderCode(orderCode);
	}
	
	@RequestMapping("/updateOrderStatus")
	@ResponseBody
	public NewRetailResult updateOrderStatus(HttpServletRequest req,HttpServletResponse res){
		String orderCode = req.getParameter("orderCode");
		if(StringUtils.isEmpty(orderCode)){
			return new NewRetailResult(NewRetailResult.RESULT_FAILED, "订单号不能为空", null);
		}	
		return orderManageService.updateOrderStatus(orderCode, "1");
	}
	

}
