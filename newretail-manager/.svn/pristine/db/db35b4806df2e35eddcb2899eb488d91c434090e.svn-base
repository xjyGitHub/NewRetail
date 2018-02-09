package com.newretail.service;

import java.util.List;
import java.util.Map;

import com.newretail.common.utils.JqGridResult;
import com.newretail.pojo.DeliverInfoTable;
import com.newretail.pojo.custom.DeliverInfoAddTable;

public interface DeliverManagerService {
	
	/**
	 * 测试
	 * @param param
	 * @return
	 */
	public JqGridResult<Map<String, Object>> test(Map<String,Object> param);
	
	/**
	 * 点击配送情况，查询当日订单(按时间倒序排列)
	 */
	List<Map<String,String>> getAllDeliverListToday(String toDay);
	
	/**
	 * 商家按配送状态+时间查询
	 */
	JqGridResult<Map<String,Object>> getDeliverListByStatus(Map<String,Object> params);
	 
	/**
	 * 管理员按照条件查询
	 */
	JqGridResult<Map<String,Object>> getDeliverListByCondition(Map<String,Object> params);
}
