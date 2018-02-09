package com.newretail.service;

import java.util.List;
import java.util.Map;

import com.newretail.common.utils.JqGridResult;
import com.newretail.common.utils.NewRetailResult;
import com.newretail.pojo.custom.OrderFindRequest;

public interface IOrderManageService {
	
	/**
	 * 获取符合条件的所有订单信息
	 * */
	JqGridResult getOrderList(OrderFindRequest orderFind);
	
	/**
	 * 获取指定订单的所有商品信息
	 * */
	NewRetailResult getGoodsByOrderCode(String orderCode);
	
	/**
	 *更改订单状态
	 * */
	NewRetailResult updateOrderStatus(String orderCode,String status);
}
