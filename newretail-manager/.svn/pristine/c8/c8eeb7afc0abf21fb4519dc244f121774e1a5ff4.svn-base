package com.newretail.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newretail.common.utils.JqGridResult;
import com.newretail.mapper.DeliverInfoTableMapper;
import com.newretail.mapper.custom.DeliverModelMapper;
import com.newretail.pojo.DeliverInfoTable;
import com.newretail.pojo.custom.DeliverInfoAddTable;
import com.newretail.service.DeliverManagerService;

@Service("deliverManagerService")
public class DeliverManagerServiceImpl implements DeliverManagerService{

	@Autowired
	private DeliverModelMapper deliverModelMapper;
	
	//测试
	public JqGridResult<Map<String,Object>> test(Map<String,Object> param){
		JqGridResult<Map<String,Object>> result = new JqGridResult();
		List<Map<String, Object>> lists = deliverModelMapper.test(param);
		result.setData(lists);
		return result;
	}
	
	//点击配送情况，显示当日总配送情况
	@Override
	public List<Map<String,String>> getAllDeliverListToday(String toDay) {
		System.out.println("执行···");
		return deliverModelMapper.getAllDeliverListToday(toDay);
	}
	
	//选择状态，按状态+时间查询
	@Override
	public JqGridResult<Map<String,Object>> getDeliverListByStatus(Map<String,Object> param) {
	//	DeliverInfoTable deliverInfoTable = deliverInfoTableMapper.selectByPrimaryKey(deliverStatus);
		System.out.println("执行商家按状态+时间查询···");
		JqGridResult<Map<String,Object>> result = new JqGridResult();
		List<Map<String, Object>> lists = deliverModelMapper.getDeliverListByStatus(param);
		result.setData(lists);
		return result;
	}

	//管理员按照条件查询
	@Override
	public JqGridResult<Map<String,Object>> getDeliverListByCondition(Map<String,Object> param) {
		System.out.println("执行管理员按照条件查询···");
		JqGridResult<Map<String,Object>> result = new JqGridResult();
		List<Map<String, Object>> lists = deliverModelMapper.getDeliverListByCondition(param);
		result.setData(lists);
		return result;
	}
	
	

	
	
}
