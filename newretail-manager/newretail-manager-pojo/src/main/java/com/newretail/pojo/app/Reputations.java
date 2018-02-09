package com.newretail.pojo.app;

/**
 * ClassName:Reputations <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2017年12月25日 下午8:42:54 <br/>
 * 
 * @author Yongjie
 * @version 1.0
 * @since JDK 1.8
 * @see
 */
public class Reputations {
	/** 订单归属的商品列表数据的id字段 */
	private String id;
	/** 0 差评 1 中评 2 好评 */
	private int reputation;
	/** 评价备注，限200字符 */
	private String remark;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getReputation() {
		return reputation;
	}

	public void setReputation(int reputation) {
		this.reputation = reputation;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
