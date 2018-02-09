package com.newretail.mapper.custom;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface OrderModelMapper {
	
	List<Map<String, Object>> getOrderList(Map<String, Object> param);
	
	List<Map<String, Object>> getGoodsByOrderCode(String orderCode);	
	
	int updateOrderStatus(@Param("orderCode")String orderCode,@Param("status")String status);
}
