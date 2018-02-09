package com.newretail.pojo.custom;

import java.util.Date;

/**
 * 订单查询请求参数
 * Created with YongjieWu.
 * Description:
 * User: Yongjie
 * Date: 2017-12-29
 * Time: 10:11
 */
public class OrderFindRequest {
        private Date orderTime;
        private String orderCode;
        private Integer orderStatus;
        private Integer deliverStatus;
        private Integer deliverType;
        private Integer page;
        private Integer pageSize;
        private String merchantId;

    public OrderFindRequest(Date orderTime, String orderCode, Integer orderStatus, Integer deliverStatus, Integer deliverType, Integer page, Integer pageSize, String merchantId) {
        this.orderTime = orderTime;
        this.orderCode = orderCode;
        this.orderStatus = orderStatus;
        this.deliverStatus = deliverStatus;
        this.deliverType = deliverType;
        this.page = page;
        this.pageSize = pageSize;
        this.merchantId = merchantId;
    }

    public OrderFindRequest() {
        super();
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getDeliverStatus() {
        return deliverStatus;
    }

    public void setDeliverStatus(Integer deliverStatus) {
        this.deliverStatus = deliverStatus;
    }

    public Integer getDeliverType() {
        return deliverType;
    }

    public void setDeliverType(Integer deliverType) {
        this.deliverType = deliverType;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
