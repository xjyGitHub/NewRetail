package com.newretail.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.newretail.common.utils.DateUtil;
import com.newretail.common.utils.TextUtils;
import com.newretail.mapper.DeliverInfoTableMapper;
import com.newretail.mapper.OrderLogisticsTableMapper;
import com.newretail.mapper.OrderTableMapper;
import com.newretail.pojo.*;
import com.newretail.pojo.custom.OrderCustom;
import com.newretail.pojo.custom.OrderFindRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.newretail.common.utils.JqGridResult;
import com.newretail.common.utils.NewRetailResult;
import com.newretail.mapper.custom.OrderModelMapper;
import com.newretail.service.IOrderManageService;

@Service("orderManageService")
public class OrderManageServiceImpl implements IOrderManageService {
	@Autowired
	private OrderModelMapper orderModelMapper;
	@Autowired
	private OrderTableMapper orderTableMapper;
	@Autowired
	private DeliverInfoTableMapper DeliverInfoTableMapper;
	@Autowired
	private OrderLogisticsTableMapper orderLogisticsTableMapper;
	@Override
	public JqGridResult<OrderCustom> getOrderList(OrderFindRequest orderFind) {
		int page = orderFind.getPage()==null?1:orderFind.getPage();
		int pageSize = orderFind.getPageSize()==null?20:orderFind.getPageSize();
		//商家ID
		String merchantId = orderFind.getMerchantId();
		PageHelper.startPage(page, pageSize);
		OrderTableExample orderTableExample = new OrderTableExample();
		OrderTableExample.Criteria criteria = orderTableExample.createCriteria();
		OrderTable orderTable = new OrderTable();
		criteria.andMerchantIdEqualTo(merchantId);
//		//订单号
//		if(!TextUtils.isEmpty(orderFind.getOrderCode())){
//			criteria.andOrderIdEqualTo(orderFind.getOrderCode());
//		//订单状态
//		}else if(!TextUtils.isEmpty(orderFind.getOrderStatus())){
//		//配送状态
//			criteria.andStatusEqualTo(orderFind.getOrderStatus());
//		}else if(!TextUtils.isEmpty(orderFind.getDeliverStatus())){
//			//criteria.sh
//        //配送类型
//		}else if(!TextUtils.isEmpty(orderFind.getDeliverType())){
//			criteria.andShippingTypeEqualTo(orderFind.getDeliverType());
//		}
		//查询订单信息
		List<OrderTable> orderTablesList = orderTableMapper.selectByExample(orderTableExample);

		PageInfo<OrderTable>  pageInfo = new PageInfo<OrderTable>(orderTablesList);//把结果放在分页里面
		List<OrderTable> orderTables = pageInfo.getList();
		List<OrderCustom> orderCustoms = new ArrayList<>();
		for(OrderTable orderItem:orderTables){
			OrderCustom orderCustom = new OrderCustom();
			String orderId1 = orderItem.getOrderId();
			//配送地址信息
			OrderLogisticsTable orderLogisticsTable = orderLogisticsTableMapper.selectByPrimaryKey(orderId1);
			//
			DeliverInfoTableExample deliverInfoTableExample = new DeliverInfoTableExample();
			DeliverInfoTableExample.Criteria infoTableExampleCriteria = deliverInfoTableExample.createCriteria();
			infoTableExampleCriteria.andOrderIdEqualTo(orderId1);
			//根据订单查询
			List<DeliverInfoTable> deliverInfoTables = DeliverInfoTableMapper.selectByExample(deliverInfoTableExample);
			if(deliverInfoTables!=null&&deliverInfoTables.size()>1){
				DeliverInfoTable deliverInfoTable = deliverInfoTables.get(0);
				orderCustom.setOrderId(orderId1);
				orderCustom.setDeliverAddress(orderLogisticsTable.getReceiverAddress());
				orderCustom.setDeliverId(orderLogisticsTable.getOrderId());
				orderCustom.setDeliverStatus(orderItem.getShippingType());

				/**订单ID*/
				orderCustom.setOrderId(orderItem.getOrderId());
				/**商家ID*/
				orderCustom.setMerchantId(orderItem.getMerchantId());
				/**订单编号*/
				orderCustom.setOrderCode(orderItem.getOrderId());
				/**订单时间*/
				orderCustom.setOrderTime(DateUtil.getStringDate(orderItem.getCreateTime()));
				/**支付状态*/
				orderCustom.setPayStatus(orderItem.getPaymentType());
				/**配送状态*/
				orderCustom.setDeliverStatus(Integer.parseInt(deliverInfoTable.getDeliverStatus()));
				/**配送类型*/
				orderCustom.setDeliverType(1);
				/**订单状态*/
				orderCustom.setOrderStatus(orderItem.getStatus());
				/***配送员ID*/
				orderCustom.setDeliverId(deliverInfoTable.getId());
				/**订单价格*/
				orderCustom.setOrderAmount(Double.parseDouble(orderItem.getPayment()));
				/**收货人ID*/
				orderCustom.setReceiverId(orderLogisticsTable.getOrderId());
				/**配送地址*/
				orderCustom.setDeliverAddress(orderLogisticsTable.getReceiverAddress());
				/**收货人电话*/
				orderCustom.setReceiverPhone(orderLogisticsTable.getReceiverMobile());
				/**收货人姓名*/
				orderCustom.setReceiverName(orderLogisticsTable.getReceiverName());
			}else{
				orderCustom.setOrderId(orderId1);
				orderCustom.setDeliverAddress(orderLogisticsTable.getReceiverAddress());
				orderCustom.setDeliverId(orderLogisticsTable.getOrderId());
				orderCustom.setDeliverStatus(orderItem.getShippingType());
				/**订单ID*/
				orderCustom.setOrderId(orderItem.getOrderId());
				/**商家ID*/
				orderCustom.setMerchantId(orderItem.getMerchantId());
				/**订单编号*/
				orderCustom.setOrderCode(orderItem.getOrderId());
				/**订单时间*/
				orderCustom.setOrderTime(DateUtil.getStringDate(orderItem.getCreateTime()));
				/**支付状态*/
				orderCustom.setPayStatus(orderItem.getPaymentType());
				/**配送状态*/
				orderCustom.setDeliverStatus(0);
				/**配送类型*/
				orderCustom.setDeliverType(0);
				/**订单状态*/
				orderCustom.setOrderStatus(orderItem.getStatus());
				/***配送员ID*/
				orderCustom.setDeliverId("");
				/**订单价格*/
				orderCustom.setOrderAmount(Double.parseDouble(orderItem.getPayment()));
				/**收货人ID*/
				orderCustom.setReceiverId(orderLogisticsTable.getOrderId());
				/**配送地址*/
				orderCustom.setDeliverAddress(orderLogisticsTable.getReceiverAddress());
				/**收货人电话*/
				orderCustom.setReceiverPhone(orderLogisticsTable.getReceiverMobile());
				/**收货人姓名*/
				orderCustom.setReceiverName(orderLogisticsTable.getReceiverName());
			}
			orderCustoms.add(orderCustom);
		}

		 JqGridResult<OrderCustom> result = new JqGridResult();
		 //设置返回的参数
		 result.setTotalCount((int)pageInfo.getTotal());//总数量
		 result.setTotalPage(pageInfo.getPages());//总页数
		 result.setData(orderCustoms);//查询的所有数据
		 return result;
	}

	@Override
	public NewRetailResult getGoodsByOrderCode(String orderCode) {
		
		List<Map<String,Object>> result = orderModelMapper.getGoodsByOrderCode(orderCode);
		if(result.size()==0){
			return new NewRetailResult(NewRetailResult.RESULT_FAILED,"查无数据",null);
		}		
		return new NewRetailResult(NewRetailResult.RESULT_SUCCESS, "", result);
	}
	
	@Override
	public NewRetailResult updateOrderStatus(String orderCode,String status) {
		
		int result = orderModelMapper.updateOrderStatus(orderCode,status);
		if(result==0){
			return new NewRetailResult(NewRetailResult.RESULT_FAILED,"更新失败",null);
		}		
		return new NewRetailResult(NewRetailResult.RESULT_SUCCESS, "更新成功", null);
	}

}
