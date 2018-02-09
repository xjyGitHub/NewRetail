package com.newretail.controller.wechatapp.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.newretail.common.utils.AliyunOssUtils;
import com.newretail.common.utils.DateUtil;
import com.newretail.mapper.GoodsTableMapper;
import com.newretail.pojo.GoodsTable;
import com.newretail.pojo.GoodsTableExample;
import com.newretail.pojo.wechatapp.BannerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newretail.common.utils.JqGridResult;
import com.newretail.common.utils.TextUtils;
import com.newretail.controller.wechatapp.GoodsController;
import com.newretail.mapper.custom.GoodsCustomMapper;
import com.newretail.pojo.GoodsCatTable;
import com.newretail.pojo.wechatapp.GoodsPriceResponse;
import com.newretail.pojo.custom.AppResponseResult;
import com.newretail.pojo.custom.AppResponseResultList;
import com.newretail.pojo.custom.GoodsCatResponse;
import com.newretail.pojo.custom.GoodsListData;
import com.newretail.pojo.custom.GoodsTableCustom;
import com.newretail.pojo.custom.MerchantInfo;
import com.newretail.pojo.custom.goods.GoodsDetailData;
import com.newretail.service.AddressService;
import com.newretail.service.CityService;
import com.newretail.service.GoodsCatService;
import com.newretail.service.IInterfaceService;
import com.newretail.service.IOrderManageService;
import com.newretail.service.UserService;

@Controller
@RequestMapping("/interface")
public class GoodsControllerImpl implements GoodsController{
	@Autowired
	private IInterfaceService interfaceService;

	@Autowired
	private GoodsCustomMapper goodsCustomMapper;

	@Autowired
	private GoodsCatService goodsCatService;

	@Autowired
	private AddressService addressSerice;

	@Autowired
	private UserService userService;

	@Autowired
	private CityService cityService;
	
	@Autowired
	private IOrderManageService orderManagerService;

	@Autowired
	private GoodsTableMapper goodsMappper;

	@Value("${SSO_BASE_URL}")
	public String SSO_BASE_URL;

	@Value("${SSO_USER_TOKEN}")
	public String SSO_USER_TOKEN;

	@Value("${SSO_PAGE_LOGIN}")
	public String SSO_PAGE_LOGIN;

	@Value("${SSO_USER_LOGIN}")
	public String SSO_USER_LOGIN;
	
	@RequestMapping("/merchantList")
	@Override
	public JqGridResult<MerchantInfo> getMerchantList(HttpServletRequest req, HttpServletResponse res) {
		Map<String, Object> param = new HashMap<>();
		param.put("shopId", req.getParameter("shopId"));
		param.put("shopName", req.getParameter("shopName"));
		param.put("currentPage", Integer.parseInt(req.getParameter("currentPage")));
		param.put("limitCount", Integer.parseInt(req.getParameter("limitCount")));
		param.put("latitude", req.getParameter("latitude"));
		param.put("longitude", req.getParameter("longitude"));
		return interfaceService.getMerchantList(param);
	}
	
	@RequestMapping("/merchantGoodsList")
	@Override
	public JqGridResult<GoodsTableCustom> getMerchantGoodsList(HttpServletRequest req, HttpServletResponse res) {
		Map<String, Object> param = new HashMap<>();
		param.put("shopId", req.getParameter("shopId"));
		param.put("goodsId", req.getParameter("goodsId"));
		param.put("goodsType", req.getParameter("goodsType"));
		param.put("goodsName", req.getParameter("goodsName"));
		param.put("currentPage", Integer.parseInt(req.getParameter("currentPage")));
		param.put("limitCount", Integer.parseInt(req.getParameter("limitCount")));
		return interfaceService.getMerchantGoodsList(param);
	}
	
	@RequestMapping("/goodsTypeList")
	@Override
	public JqGridResult<Map<String, Object>> getGoodsTypeList(HttpServletRequest req, HttpServletResponse res) {
		Map<String, Object> param = new HashMap<>();
		param.put("shopId", req.getParameter("shopId"));
		return interfaceService.getGoodsTypeList(param);
	}
	
	@RequestMapping("/evaluateList")
	@Override
	public JqGridResult<Map<String, Object>> getEvaluateList(HttpServletRequest req, HttpServletResponse res) {
		Map<String, Object> param = new HashMap<>();
		param.put("shopId", req.getParameter("shopId"));
		param.put("currentPage", Integer.parseInt(req.getParameter("currentPage")));
		param.put("limitCount", Integer.parseInt(req.getParameter("limitCount")));
		return interfaceService.getEvaluateList(param);
	}

	@RequestMapping("goods/category/all")
	@ResponseBody
	@Override
	public GoodsCatResponse<GoodsCatTable> getGoodsCategoryAll() {
		List<GoodsCatTable> findAllGoodsCatTable = goodsCatService.findAllGoodsCatTable();
		GoodsCatResponse<GoodsCatTable> goodsCatResponse = new GoodsCatResponse<GoodsCatTable>();
		goodsCatResponse.setCode(200);
		goodsCatResponse.setData(findAllGoodsCatTable);
		goodsCatResponse.setMsg("succeed");
		return goodsCatResponse;
	}

	@RequestMapping("shop/goods/detail")
	@ResponseBody
	@Override
	public AppResponseResult<GoodsDetailData> getGoodsListDetail(String goodsId) {

		return interfaceService.getGoodsDetailData(goodsId);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("shop/goods/price")
	@ResponseBody
	@Override
	public AppResponseResult<GoodsDetailData> getGoodsPrice(String goodsId, String propertyChildIds) {
		GoodsTableCustom goodsCustomById = interfaceService.getGoodsCustomById(goodsId);
		GoodsPriceResponse goodsPriceResponse = new GoodsPriceResponse();
		goodsPriceResponse.setGoodsId(goodsId);
		goodsPriceResponse.setId(goodsId);
		goodsPriceResponse.setOriginalPrice(Double.parseDouble(goodsCustomById.getGoodsPrice()));
		goodsPriceResponse.setStores(goodsCustomById.getStock());
		//商品规格
		goodsPriceResponse.setPropertyChildIds("1:1,");
		return new AppResponseResult(0,goodsPriceResponse,"succeed");
	}

	@RequestMapping("shop/goods/reputation")
	@ResponseBody
	@Override
	public AppResponseResult getGoodsReputation() {
		return new AppResponseResult(200,null,"succeed");
	}
	@RequestMapping("shop/goods/price/freight")
	@ResponseBody
	@Override
	public AppResponseResult<Map<String, Integer>> getGoodsRepublation() {
		Map<String,Integer> mp  = new HashMap<String,Integer>();
		mp.put("firstNumber", 9);
		mp.put("addAmount", 12);
		mp.put("firstAmount", 10);
		mp.put("addNumber", 1);
		return new AppResponseResult<Map<String,Integer>>(200,mp,"succeed");
	}
	
	@RequestMapping("goods/list")
	@ResponseBody
	@Override
	public AppResponseResultList<GoodsListData> getGoodsListByPo(HttpServletRequest req) {
		Map<String, Object> param = new HashMap<String, Object>();
		if (!TextUtils.isEmpty(req.getParameter("page"))) {
			Integer page = Integer.parseInt(req.getParameter("page"));
			param.put("page", page);
		} else {
			param.put("page", 1);
		}
		if (!TextUtils.isEmpty(req.getParameter("pageSize"))) {
			Integer pageSize = Integer.parseInt(req.getParameter("pageSize"));
			param.put("pageSize", pageSize);
		} else {
			param.put("pageSize", 20);
		}
		if (!TextUtils.isEmpty(req.getParameter("categoryId"))) {
			Integer categoryId = Integer.parseInt(req.getParameter("categoryId"));
			param.put("categoryId", categoryId);
		} else {
			param.put("categoryId", -1);
		}
		if (!TextUtils.isEmpty(req.getParameter("shopId"))) {
			Integer shopId = Integer.parseInt(req.getParameter("shopId"));
			param.put("shopId", shopId);
		}
		if (!TextUtils.isEmpty(req.getParameter("goodsNameLike"))) {
			String goodsNameLike = req.getParameter("nameLike");
			param.put("goodsNameLike", goodsNameLike);
		}
		if (!TextUtils.isEmpty(req.getParameter("userId"))) {
			Integer userId = Integer.parseInt(req.getParameter("userId"));
			param.put("userId", userId);
		}
		if (!TextUtils.isEmpty(req.getParameter("goodsId"))) {
			Integer goodsId = Integer.parseInt(req.getParameter("goodsId"));
			param.put("goodsId", goodsId);
		}
		if (!TextUtils.isEmpty(req.getParameter("orderBy"))) {
			String orderBy = req.getParameter("orderBy");
			param.put("orderBy", orderBy);
		}
		return interfaceService.getGoodsList(param);
	}

	/**
	 *
	 * @return
	 */
	@RequestMapping("banner/list")
	@ResponseBody
	@Override
	public AppResponseResult getGoodsBanner() {
		GoodsTableExample goodsTableExample = new GoodsTableExample();
		GoodsTableExample.Criteria criteria = goodsTableExample.createCriteria();
		criteria.andCreateTimeIsNotNull();
		PageHelper.startPage(1,3);
		List<GoodsTable> goodsTables = goodsMappper.selectByExample(goodsTableExample);
		PageInfo<GoodsTable> info = new PageInfo<GoodsTable>(goodsTables);
		info.setOrderBy("createTime");
		List<GoodsTable> list = info.getList();
		AliyunOssUtils aliyunOssUtils = new AliyunOssUtils();
		List<BannerResponse> bannerResponses = new ArrayList<>();
		for(GoodsTable goods:list){
			BannerResponse bannerResponse = new BannerResponse();
			bannerResponse.setBusinessId(goods.getGoodsId());
			bannerResponse.setDateAdd(DateUtil.getDate(goods.getCreateTime()));
			bannerResponse.setDateUpdate(DateUtil.getDate(goods.getCreateTime()));
			bannerResponse.setId(goods.getGoodsId());
			bannerResponse.setLinkUrl("https://www.campuspp.com");
			bannerResponse.setPaixu(1);
			String imageSignUrl = aliyunOssUtils.getImageSignUrl(goods.getGoodsPhoto());
			bannerResponse.setPicUrl(imageSignUrl);
			int  status = Integer.parseInt(goods.getGoodsStatus()==null?"0":goods.getGoodsStatus()) ;
			bannerResponse.setStatus(status);
			bannerResponse.setStatusStr(status==0?"默认":status==1?"审核":status==2?"上架":status==3?"下架":"审核失败");
			bannerResponse.setTitle(goods.getGoodsName());
			bannerResponse.setType(goods.getGoodsType());
			bannerResponses.add(bannerResponse);
		}
		aliyunOssUtils.destory();
		if(bannerResponses.size()>0){
			return new AppResponseResult(200,bannerResponses,"succeed");
		}
		return AppResponseResult.fail();
	}

}
