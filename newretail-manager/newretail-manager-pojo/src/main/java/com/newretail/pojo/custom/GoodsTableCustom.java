/**
 * Project Name:newretail-manager-pojo
 * File Name:GoodsTableCustom.java
 * Package Name:com.newretail.pojo.custom
 * Date:2017年10月18日下午11:54:01
 * Copyright (c) 2017, campuspp.com All Rights Reserved.
 *
*/

package com.newretail.pojo.custom;

import java.util.List;

/**
 * ClassName:GoodsTableCustom <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2017年10月18日 下午11:54:01 <br/>
 * 
 * @author Yongjie
 * @version
 * @since JDK 1.8
 * @see
 */
public class GoodsTableCustom { 
	private String id;

	private String goodsId;

	private String goodsName;

	private String goodsPhoto;

	private String goodsPrice;

	private String discount;

	private String goodsType;

	private String createTime;

	private String updateTime;

	private Integer stock;

	private String goodsStatus;

	private String userId;

	private String auditorId;

	private String sales;

	private String areaCode;

	private String deliverAddress;

	private String goodsSalePrice;

	private String packingFree;

	private List<GoodsSize> goodsSize;
	
	private int goodsCatId;
	/**省份*/
	private String province;
	/**城市*/
	private String city;
	/**区域*/
	private String district;

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	/**
	 * 排序方式
	 */
	private String orderBy;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsPhoto() {
		return goodsPhoto;
	}
	public void setGoodsPhoto(String goodsPhoto) {
		this.goodsPhoto = goodsPhoto;
	}
	public String getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(String goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public String getGoodsStatus() {
		return goodsStatus;
	}
	public void setGoodsStatus(String goodsStatus) {
		this.goodsStatus = goodsStatus;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAuditorId() {
		return auditorId;
	}
	public void setAuditorId(String auditorId) {
		this.auditorId = auditorId;
	}
	public String getSales() {
		return sales;
	}
	public void setSales(String sales) {
		this.sales = sales;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getDeliverAddress() {
		return deliverAddress;
	}
	public void setDeliverAddress(String deliverAddress) {
		this.deliverAddress = deliverAddress;
	}
	public String getGoodsSalePrice() {
		return goodsSalePrice;
	}
	public void setGoodsSalePrice(String goodsSalePrice) {
		this.goodsSalePrice = goodsSalePrice;
	}
	public String getPackingFree() {
		return packingFree;
	}
	public void setPackingFree(String packingFree) {
		this.packingFree = packingFree;
	}
	public List<GoodsSize> getGoodsSize() {
		return goodsSize;
	}
	public void setGoodsSize(List<GoodsSize> goodsSize) {
		this.goodsSize = goodsSize;
	}
	public int getGoodsCatId() {
		return goodsCatId;
	}
	public void setGoodsCatId(int goodsCatId) {
		this.goodsCatId = goodsCatId;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	
}
