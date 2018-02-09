package com.newretail.pojo.app;

/**
 * 订单统计
 * @author Yongjie
 *
 */
public class OrderStatistics {
	/**未支付订单数*/
	private int count_id_no_pay;
	/**待发货订单数*/
	private int count_id_no_transfer;
	/**待确认收货订单数*/
	private int count_id_no_confirm;
	/**交易完成订单数*/
	private int count_id_success;
	/**关闭的订单数*/
	private int count_id_close;
	/**待评价订单数*/
	private int count_id_no_reputation;
	public int getCount_id_no_pay() {
		return count_id_no_pay;
	}
	public void setCount_id_no_pay(int count_id_no_pay) {
		this.count_id_no_pay = count_id_no_pay;
	}
	public int getCount_id_no_transfer() {
		return count_id_no_transfer;
	}
	public void setCount_id_no_transfer(int count_id_no_transfer) {
		this.count_id_no_transfer = count_id_no_transfer;
	}
	public int getCount_id_no_confirm() {
		return count_id_no_confirm;
	}
	public void setCount_id_no_confirm(int count_id_no_confirm) {
		this.count_id_no_confirm = count_id_no_confirm;
	}
	public int getCount_id_success() {
		return count_id_success;
	}
	public void setCount_id_success(int count_id_success) {
		this.count_id_success = count_id_success;
	}
	public int getCount_id_close() {
		return count_id_close;
	}
	public void setCount_id_close(int count_id_close) {
		this.count_id_close = count_id_close;
	}
	public int getCount_id_no_reputation() {
		return count_id_no_reputation;
	}
	public void setCount_id_no_reputation(int count_id_no_reputation) {
		this.count_id_no_reputation = count_id_no_reputation;
	}
	public OrderStatistics(int count_id_no_pay, int count_id_no_transfer, int count_id_no_confirm, int count_id_success,
			int count_id_close, int count_id_no_reputation) {
		super();
		this.count_id_no_pay = count_id_no_pay;
		this.count_id_no_transfer = count_id_no_transfer;
		this.count_id_no_confirm = count_id_no_confirm;
		this.count_id_success = count_id_success;
		this.count_id_close = count_id_close;
		this.count_id_no_reputation = count_id_no_reputation;
	}
	public OrderStatistics() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
