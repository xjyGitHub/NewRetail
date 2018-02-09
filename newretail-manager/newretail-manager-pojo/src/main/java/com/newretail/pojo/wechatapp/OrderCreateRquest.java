package com.newretail.pojo.wechatapp;

import java.util.List;

/**
 * 
 * ClassName: OrderCreateRquest <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason: TODO  <br/>  
 * date: 2017年12月25日 下午8:22:49 <br/>  
 *  
 * @author Yongjie  
 * @version   
 * @since JDK 1.8
 */
public class OrderCreateRquest {
	/**地址ID*/
	private String addressId;
	/**登录接口返回的登录凭证*/
	private String token;
	/**收货地址省份编码*/
	private int provinceId;
	/**收货地址城市编码*/
	private int cityId;
	/**收货地址区县编码*/
	private int districtld;
	/**收货地址详细地址*/
	private String address;
	/**收货地址联系人信息*/
	private String linkMan;
	/**收货地址联系人手机号码*/
	private String mobile;
	/**收货地址邮政编码*/
	private String code;
	/**下单备注信息*/
	private String remark;
	/**使用的优惠券编号*/
	private String couponId;
	/**true 不实际下单，而是返回价格计算*/
	private boolean calculate;
	/**身份证号码【国际件使用】*/
	private String idcard;
	/**购买的商品、规格尺寸、数量信息的数组，如：[{"goodsId":11,"number":2,"propertyChildIds":"","logisticsType":0}, {"goodsId":8,"number":3,"propertyChildIds":"2:9","logisticsType":0, "inviter_id":邀请用户ID}]*/
	private List<GoodsJsonStr> goodsJsonStr;
	/**1 为货到付款，其他数字为先支付*/
	private String payOnDelivery;
	/**订单ID在修改的时候有用*/
	private String orderId;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public int getDistrictld() {
		return districtld;
	}

	public void setDistrictld(int districtld) {
		this.districtld = districtld;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLinkMan() {
		return linkMan;
	}

	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCouponId() {
		return couponId;
	}

	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}

	public boolean isCalculate() {
		return calculate;
	}

	public void setCalculate(boolean calculate) {
		this.calculate = calculate;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public List<GoodsJsonStr> getGoodsJsonStr() {
		return goodsJsonStr;
	}

	public void setGoodsJsonStr(List<GoodsJsonStr> goodsJsonStr) {
		this.goodsJsonStr = goodsJsonStr;
	}

	public String getPayOnDelivery() {
		return payOnDelivery;
	}

	public void setPayOnDelivery(String payOnDelivery) {
		this.payOnDelivery = payOnDelivery;
	}
}
