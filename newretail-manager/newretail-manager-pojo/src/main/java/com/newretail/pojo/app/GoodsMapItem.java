package com.newretail.pojo.app;
/**
 * 
 * @author Yongjie
 *
 */
public class GoodsMapItem {
		/**数量*/
		private double price;
		/**商品ID*/
	    private String goodsId;
	    /**商品名称*/
	    private String goodsName;
	    /**ID*/
	    private String id;
	    /**商品编号*/
	    private int number;
	    /**订单编号*/
	    private String orderId;
	    /**图片*/
	    private String pic;
	    /**参数*/
	    private String property;
	    
		public String getPic() {
			return pic;
		}
		public void setPic(String pic) {
			this.pic = pic;
		}
		public String getProperty() {
			return property;
		}
		public void setProperty(String property) {
			this.property = property;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public String getGoodsId() {
			return goodsId;
		}
		public void setGoodsId(String goodsId) {
			this.goodsId = goodsId;
		}
		public String getGoodsName() {
			return goodsName;
		}
		public void setGoodsName(String goodsName) {
			this.goodsName = goodsName;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public int getNumber() {
			return number;
		}
		public void setNumber(int number) {
			this.number = number;
		}
		public String getOrderId() {
			return orderId;
		}
		public void setOrderId(String orderId) {
			this.orderId = orderId;
		}
		
}
