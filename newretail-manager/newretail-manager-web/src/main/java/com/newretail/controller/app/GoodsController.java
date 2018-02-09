package com.newretail.controller.app;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newretail.common.utils.JqGridResult;
import com.newretail.pojo.GoodsCatTable;
import com.newretail.pojo.custom.AddressResponse;
import com.newretail.pojo.custom.AppResponseResult;
import com.newretail.pojo.custom.AppResponseResultList;
import com.newretail.pojo.custom.GoodsCatResponse;
import com.newretail.pojo.custom.GoodsListData;
import com.newretail.pojo.custom.GoodsTableCustom;
import com.newretail.pojo.custom.MerchantInfo;
import com.newretail.pojo.custom.goods.GoodsDetailData;

/**
 * 移动应用商品相关接口
 * @author Yongjie
 *
 */
public interface GoodsController {
	/**
	 * 获取商家列表
	 * @param req
	 * @param res
	 * @return
	 */
	public JqGridResult<MerchantInfo> getMerchantList(HttpServletRequest req, HttpServletResponse res);
	
	/**
	 * 获取指定商家的商品信息
	 * @param req
	 * @param res
	 * @return
	 */
	public JqGridResult<GoodsTableCustom> getMerchantGoodsList(HttpServletRequest req, HttpServletResponse res);
	
	/**
	 * 
	 * @param req
	 * @param res
	 * @return
	 */
	public JqGridResult<Map<String, Object>> getGoodsTypeList(HttpServletRequest req, HttpServletResponse res);
	/**
	 * 获取指定商家的用户评价
	 * @param req
	 * @param res
	 * @return
	 */
	public JqGridResult<Map<String, Object>> getEvaluateList(HttpServletRequest req, HttpServletResponse res);
	
	/**
	 * 获取商品所有分类
	 * @return 所有分类
	 */
	public GoodsCatResponse<GoodsCatTable> getGoodsCategoryAll();
	
	/**
	 * 获取商品列表详情
	 * @param goodsId 商品ID
	 * @return
	 */
	public AppResponseResult<GoodsDetailData> getGoodsListDetail(@RequestParam("goodsId") String goodsId);
	
	/**
	 * 选择规格和尺寸获取商品价格
	 * @param goodsId 商品ID
	 * @param propertyChildIds eg:选择的规格尺寸信息：如：4:15,2:10,1:4 。多个规格请用英文的逗号分割
	 * @return
	 */
	public AppResponseResult<GoodsDetailData> getGoodsPrice(@RequestParam("goodsId") String goodsId,@RequestParam("propertyChildIds") String propertyChildIds);
	
	/**
	 * 获取指定商家的用户评价
	 * @return
	 */
	public AppResponseResult getGoodsReputation();
	
	/**
	 * 获取物流信息
	 * @return
	 */
	public AppResponseResult<Map<String,Integer>> getGoodsRepublation();
	
	/**
	 * 获取指定商家的用户评价
	 * @param req
	 * @return
	 */
	public AppResponseResultList<GoodsListData> getGoodsListByPo(HttpServletRequest req);

	/**
	 * 获取轮播图片
	 * @return
	 */
	public AppResponseResult getGoodsBanner();
	
}
