package com.newretail.pojo.app;

import java.util.List;
import java.util.Map;

/**
 * 返回给APP端
 * @author Yongjie
 *
 */
public class OrderResponse {
	
		private List<OrderListItem> orderList;
		
		private Map<String,List<GoodsMapItem>> goodsMap;
		
		private Map<String,List<LogisticsMapItem>> logisticsMap;

		public List<OrderListItem> getOrderList() {
			return orderList;
		}

		public void setOrderList(List<OrderListItem> orderList) {
			this.orderList = orderList;
		}

		public Map<String, List<GoodsMapItem>> getGoodsMap() {
			return goodsMap;
		}

		public void setGoodsMap(Map<String, List<GoodsMapItem>> goodsMap) {
			this.goodsMap = goodsMap;
		}

		public Map<String, List<LogisticsMapItem>> getLogisticsMap() {
			return logisticsMap;
		}

		public void setLogisticsMap(Map<String, List<LogisticsMapItem>> logisticsMap) {
			this.logisticsMap = logisticsMap;
		}

}
