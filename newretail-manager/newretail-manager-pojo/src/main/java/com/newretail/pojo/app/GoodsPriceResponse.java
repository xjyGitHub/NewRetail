package com.newretail.pojo.app;

public class GoodsPriceResponse {
	private String goodsId;

	private String id;

	private double originalPrice;

	private double price;

	private String propertyChildIds;

	private int stores;

	public void setGoodsId(String goodsId){
	this.goodsId = goodsId;
	}
	public String getGoodsId(){
	return this.goodsId;
	}
	public void setId(String id){
	this.id = id;
	}
	public String getId(){
	return this.id;
	}
	public void setOriginalPrice(double originalPrice){
	this.originalPrice = originalPrice;
	}
	public double getOriginalPrice(){
	return this.originalPrice;
	}
	public void setPrice(int price){
	this.price = price;
	}
	public double getPrice(){
	return this.price;
	}
	public void setPropertyChildIds(String propertyChildIds){
	this.propertyChildIds = propertyChildIds;
	}
	public String getPropertyChildIds(){
	return this.propertyChildIds;
	}
	public void setStores(int stores){
	this.stores = stores;
	}
	public int getStores(){
	return this.stores;
	}
}
