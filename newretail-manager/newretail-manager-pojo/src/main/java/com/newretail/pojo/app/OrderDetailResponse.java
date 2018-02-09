package com.newretail.pojo.app;

import java.util.List;

/**
 * 返回订单明细
 * Created with YongjieWu.
 * Description:
 * User: Yongjie
 * Date: 2017-12-26
 * Time: 17:13
 */
public class OrderDetailResponse {
    private OrderDetailInfo orderInfo;
    private List<OrderDetailGoods> goods;
    private List<LogisticsMapItem> logistics;

    public OrderDetailInfo getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(OrderDetailInfo orderInfo) {
        this.orderInfo = orderInfo;
    }

    public List<OrderDetailGoods> getGoods() {
        return goods;
    }

    public void setGoods(List<OrderDetailGoods> goods) {
        this.goods = goods;
    }

    public List<LogisticsMapItem> getLogistics() {
        return logistics;
    }

    public void setLogistics(List<LogisticsMapItem> logistics) {
        this.logistics = logistics;
    }
}
