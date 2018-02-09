package com.newretail.pojo.app;

/**
 * Created with YongjieWu.
 * Description: 订单商品返回实体
 * User: Yongjie
 * Date: 2018-01-05
 * Time: 16:08
 */
public class OrderGoodsItem {
        private String goodsName;
        private int goodsNumber;
        private double price;
        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
        }
        public String getGoodsName() {
            return goodsName;
        }

        public void setGoodsNumber(int goodsNumber) {
            this.goodsNumber = goodsNumber;
        }
        public int getGoodsNumber() {
            return goodsNumber;
        }

        public void setPrice(double price) {
            this.price = price;
        }
        public double getPrice() {
            return price;
        }
}
