package com.newretail.service;

import java.util.Map;

import com.newretail.common.utils.JqGridResult;
import com.newretail.common.utils.NewRetailResult;
import com.newretail.pojo.custom.GoodsCatResponse;
import com.newretail.pojo.custom.GoodsListData;
import com.newretail.pojo.custom.GoodsTableCustom;
import com.newretail.pojo.custom.MerchantInfo;
import com.newretail.pojo.custom.AppResponseResultList;
import com.newretail.pojo.custom.AppResponseResult;
import com.newretail.pojo.custom.goods.GoodsDetailData;
/**
 * 微信小程序接口
 * @author Yongjie
 *
 */
public interface IInterfaceService {

	JqGridResult<MerchantInfo> getMerchantList(Map<String,Object>param);
	
	JqGridResult<GoodsTableCustom> getMerchantGoodsList(Map<String,Object>param);
	/**
	 * 获取商品类型
	 * @param param
	 * @return
	 */
	JqGridResult<Map<String,Object>> getGoodsTypeList(Map<String,Object>param);
	
	JqGridResult<Map<String,Object>> getEvaluateList(Map<String,Object>param);
	/**
	 * 获取商品列表
	 * @return
	 */
	AppResponseResultList<GoodsListData> getGoodsList(Map<String,Object>param);
	
	/**
	 * 获取商品详情
	 * @return
	 */
	AppResponseResult<GoodsDetailData>  getGoodsDetailData(String goodsId);
	
	/**
	 * 获取商品详情
	 * @return
	 */
	NewRetailResult getGoodsDetail(String goodsId);
	
	/**
	 * 获取商品列表
	 * @param goodsId
	 * @return
	 */
	GoodsTableCustom getGoodsCustomById(String goodsId);
	
	
	
	
}
