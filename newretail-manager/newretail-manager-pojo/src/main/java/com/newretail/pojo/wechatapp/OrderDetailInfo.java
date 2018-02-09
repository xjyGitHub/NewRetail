package com.newretail.pojo.wechatapp;

/**
 * 订单明细，显示的订单信息
 * Created with YongjieWu.
 * Description:
 * User: Yongjie
 * Date: 2017-12-26
 * Time: 16:22
 */
public class OrderDetailInfo {
    /**数量*/
    private double price;
    /**运输数量*/
    private double priceLogistics;
    /**真实数量*/
    private double priceReal;
    /**添加日期*/
    private String dateAdd;
    /**修改时间*/
    private String dateUpdate;
    /**商品评论，*/
    private int goodReputation;
    /**商品评论详情*/
    private String goodReputationRemark;
    /**商品评论对应的字符串*/
    private String goodReputationStr;
    /**商品编码*/
    private int goodsNumber;
    /**主键*/
    private String id;
    /**订单编号*/
    private String orderNumber;
    /**订单备注*/
    private String remark;
    /**状态码*/
    private int status;
    /**状态码对应的状态*/
    private String statusStr;
    /**类型*/
    private String type;
    /**唯一ID*/
    private String uid;
    /**用户ID*/
    private String userId;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPriceLogistics() {
        return priceLogistics;
    }

    public void setPriceLogistics(double priceLogistics) {
        this.priceLogistics = priceLogistics;
    }

    public double getPriceReal() {
        return priceReal;
    }

    public void setPriceReal(double priceReal) {
        this.priceReal = priceReal;
    }

    public String getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(String dateAdd) {
        this.dateAdd = dateAdd;
    }

    public String getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(String dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public int getGoodReputation() {
        return goodReputation;
    }

    public void setGoodReputation(int goodReputation) {
        this.goodReputation = goodReputation;
    }

    public String getGoodReputationRemark() {
        return goodReputationRemark;
    }

    public void setGoodReputationRemark(String goodReputationRemark) {
        this.goodReputationRemark = goodReputationRemark;
    }

    public String getGoodReputationStr() {
        return goodReputationStr;
    }

    public void setGoodReputationStr(String goodReputationStr) {
        this.goodReputationStr = goodReputationStr;
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

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
