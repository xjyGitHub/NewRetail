package com.newretail.pojo.wechatapp;

/**
 * 
 * @author Yongjie
 *
 */
public class OrderListItem {
	 	/**数量*/
	    private Double price;
	    /**配送数量*/
	    private Double priceLogistics;
	    /**真实数量*/
	    private Double priceReal;
	    /**更新日期*/
	    private String dateAdd;
	    /**商品数量*/
	    private int goodsNumber;
	    /**id*/
	    private String id;
	    /**订单编号*/
	    private String orderNumber;
	    /**备注*/
	    private String remark;
	    /**状态*/
	    private int status;
	    /**状态字符串*/
	    private String statusStr;
	    /**类型*/
	    private String type;
	    /**唯一ID*/
	    private int uid;
	    /**用户ID*/
	    private String userId;

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getPriceLogistics() {
		return priceLogistics;
	}

	public void setPriceLogistics(Double priceLogistics) {
		this.priceLogistics = priceLogistics;
	}

	public Double getPriceReal() {
		return priceReal;
	}

	public void setPriceReal(Double priceReal) {
		this.priceReal = priceReal;
	}

	public String getDateAdd() {
		return dateAdd;
	}

	public void setDateAdd(String dateAdd) {
		this.dateAdd = dateAdd;
	}

	public int getGoodsNumber() {
		return goodsNumber;
	}

	public void setGoodsNumber(int goodsNumber) {
		this.goodsNumber = goodsNumber;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getStatusStr() {
		return statusStr;
	}

	public void setStatusStr(String statusStr) {
		this.statusStr = statusStr;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
