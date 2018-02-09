package com.newretail.mapper.custom;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.newretail.common.utils.JqGridResult;
import com.newretail.pojo.DeliverInfoTable;
import com.newretail.pojo.custom.DeliverInfoAddTable;

public interface DeliverModelMapper {
	
	//测试
	public List<Map<String,Object>> test(Map<String,Object> param);

	/**
	 * 点击配送情况，查询当日订单(按时间倒序排列)
	 */
	List<Map<String,String>> getAllDeliverListToday(@Param(value="queryTime")String toDay);
	
	/**
	 * 商家按配送状态+时间查询
	 */
	List<Map<String,Object>> getDeliverListByStatus(Map<String,Object> param);
	 
	/**
	 * 管理员按照条件查询
	 */
	List<Map<String,Object>> getDeliverListByCondition(Map<String,Object> param);
}
