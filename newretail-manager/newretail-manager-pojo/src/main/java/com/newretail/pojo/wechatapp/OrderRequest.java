package com.newretail.pojo.wechatapp;
/**
 * 
 * ClassName: OrderRequest <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason: TODO  <br/>  
 * date: 2017年12月25日 下午8:23:52 <br/>  
 *   订单查询请求参数
 * @author Yongjie  
 * @version   
 * @since JDK 1.8
 */
public class OrderRequest {
	
	private String token;
	private int page;
	//每页获取多少条数据，不传该参数默认获取50条数据
	private int pageSize;
	//订单状态：-1 已关闭 0 待支付 1 已支付待发货 2 已发货待确认 3 收货待评价 4 已评价
	private int status;
	//订单编号，如：OD1703281618955938
	private String orderNumber;
	//评价状态：0 差评 1 中评 2 好评
	private int goodsReputation;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public int getGoodsReputation() {
		return goodsReputation;
	}
	public void setGoodsReputation(int goodsReputation) {
		this.goodsReputation = goodsReputation;
	}
	
	@Override
	public String toString() {
		return "OrderRequest [token=" + token + ", page=" + page + ", pageSize=" + pageSize + ", status=" + status
				+ ", orderNumber=" + orderNumber + ", goodsReputation=" + goodsReputation + "]";
	}
	
	public OrderRequest() {
		super();
	}
	/**
	 * 
	 * @param token
	 * @param page
	 * @param pageSize
	 * @param status
	 * @param orderNumber
	 * @param goodsReputation
	 */
	public OrderRequest(String token, int page, int pageSize, int status, String orderNumber, int goodsReputation) {
		super();
		this.token = token;
		this.page = page;
		this.pageSize = pageSize;
		this.status = status;
		this.orderNumber = orderNumber;
		this.goodsReputation = goodsReputation;
	}
	
	
}
