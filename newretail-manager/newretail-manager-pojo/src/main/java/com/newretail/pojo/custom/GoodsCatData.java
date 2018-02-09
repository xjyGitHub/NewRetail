package com.newretail.pojo.custom;

import java.util.Date;
/**
 * 返回商品分类
 * @author Yongjie
 *
 */
public class GoodsCatData {
	private int goodsId;
	private String goodsName;
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	@Override
	public String toString() {
		return "GoodsCatData [goodsId=" + goodsId + ", goodsName=" + goodsName + "]";
	}
	
}
