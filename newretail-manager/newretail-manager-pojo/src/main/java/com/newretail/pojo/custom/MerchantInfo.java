
package com.newretail.pojo.custom;

import java.util.List;

public class MerchantInfo {

	private String id;
	private String shopId;
	private String shopName;
	private String picUrl;
	private String shopAddress;
	private String longitude;
	private String latitude;
	private int distance;
	private int sendPrice;
	private int orderLeadTime;
	private String phone;
	private List<String> openingHours;
	private double rating;
	private int ratingCount;
	private int recentOrderNum;
	private String businessLicenseUrl;
	private String businessLicenseId;
	private int piecewiseAgentFee;
	private List<MerchantActivities> activities;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopName() {
		return shopName;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}

	public String getShopAddress() {
		return shopAddress;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getDistance() {
		return distance;
	}

	public void setSendPrice(int sendPrice) {
		this.sendPrice = sendPrice;
	}

	public int getSendPrice() {
		return sendPrice;
	}

	public void setOrderLeadTime(int orderLeadTime) {
		this.orderLeadTime = orderLeadTime;
	}

	public int getOrderLeadTime() {
		return orderLeadTime;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return phone;
	}

	public void setOpeningHours(List<String> openingHours) {
		this.openingHours = openingHours;
	}

	public List<String> getOpeningHours() {
		return openingHours;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public double getRating() {
		return rating;
	}

	public void setRatingCount(int ratingCount) {
		this.ratingCount = ratingCount;
	}

	public int getRatingCount() {
		return ratingCount;
	}

	public void setRecentOrderNum(int recentOrderNum) {
		this.recentOrderNum = recentOrderNum;
	}

	public int getRecentOrderNum() {
		return recentOrderNum;
	}

	public void setBusinessLicenseUrl(String businessLicenseUrl) {
		this.businessLicenseUrl = businessLicenseUrl;
	}

	public String getBusinessLicenseUrl() {
		return businessLicenseUrl;
	}

	public void setBusinessLicenseId(String businessLicenseId) {
		this.businessLicenseId = businessLicenseId;
	}

	public String getBusinessLicenseId() {
		return businessLicenseId;
	}

	public int getPiecewiseAgentFee() {
		return piecewiseAgentFee;
	}

	public void setPiecewiseAgentFee(int piecewiseAgentFee) {
		this.piecewiseAgentFee = piecewiseAgentFee;
	}

	public void setActivities(List<MerchantActivities> activities) {
		this.activities = activities;
	}

	public List<MerchantActivities> getActivities() {
		return activities;
	}

	@Override
	public String toString() {
		return "MerchantInfo [id=" + id + ", shopId=" + shopId + ", shopName=" + shopName + ", picUrl=" + picUrl
				+ ", shopAddress=" + shopAddress + ", longitude=" + longitude + ", latitude=" + latitude + ", distance="
				+ distance + ", sendPrice=" + sendPrice + ", orderLeadTime=" + orderLeadTime + ", phone=" + phone
				+ ", openingHours=" + openingHours + ", rating=" + rating + ", ratingCount=" + ratingCount
				+ ", recentOrderNum=" + recentOrderNum + ", businessLicenseUrl=" + businessLicenseUrl
				+ ", businessLicenseId=" + businessLicenseId + ", piecewiseAgentFee=" + piecewiseAgentFee
				+ ", activities=" + activities + "]";
	}

}