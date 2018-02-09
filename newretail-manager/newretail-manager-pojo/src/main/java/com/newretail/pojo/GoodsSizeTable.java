package com.newretail.pojo;

public class GoodsSizeTable {
    private String id;

    private Integer goodsId;

    private String goodsSizeName;

    private String goodsSizePrice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsSizeName() {
        return goodsSizeName;
    }

    public void setGoodsSizeName(String goodsSizeName) {
        this.goodsSizeName = goodsSizeName == null ? null : goodsSizeName.trim();
    }

    public String getGoodsSizePrice() {
        return goodsSizePrice;
    }

    public void setGoodsSizePrice(String goodsSizePrice) {
        this.goodsSizePrice = goodsSizePrice == null ? null : goodsSizePrice.trim();
    }
}