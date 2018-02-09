package com.newretail.pojo.app;

import java.util.Date;
import java.util.List;

/**
 * Created with YongjieWu.
 * Description: 商家客户端返回实体
 * User: Yongjie
 * Date: 2018-01-05
 * Time: 16:09
 */
public class OrderItem {
        private String orderId;
        private String createTime;
        /**是否紧急*/
        private int isUrgent;
        private int status;
        private String linkMan;
        private String address;
        private String addressId;
        private String receiverPhone;
        private List<OrderGoodsItem> goods;
        private double income;
        private int deliverStatus;
        private String deliverStatusStr;
        private String deliverName;
        private String deliverPhone;
        private int goodsNumber;
        private String updateTime;

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public int getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(int goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getIsUrgent() {
        return isUrgent;
    }

    public void setIsUrgent(int isUrgent) {
        this.isUrgent = isUrgent;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getLinkMan() {
        return linkMan;
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public List<OrderGoodsItem> getGoods() {
        return goods;
    }

    public void setGoods(List<OrderGoodsItem> goods) {
        this.goods = goods;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public int getDeliverStatus() {
        return deliverStatus;
    }

    public void setDeliverStatus(int deliverStatus) {
        this.deliverStatus = deliverStatus;
    }

    public String getDeliverStatusStr() {
        return deliverStatusStr;
    }

    public void setDeliverStatusStr(String deliverStatusStr) {
        this.deliverStatusStr = deliverStatusStr;
    }

    public String getDeliverName() {
        return deliverName;
    }

    public void setDeliverName(String deliverName) {
        this.deliverName = deliverName;
    }

    public String getDeliverPhone() {
        return deliverPhone;
    }

    public void setDeliverPhone(String deliverPhone) {
        this.deliverPhone = deliverPhone;
    }
}
