package com.newretail.service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.newretail.mapper.GoodsTableMapper;
import com.newretail.pojo.GoodsTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.newretail.common.utils.AliyunOssUtils;
import com.newretail.common.utils.DateUtil;
import com.newretail.common.utils.JqGridResult;
import com.newretail.common.utils.NewRetailResult;
import com.newretail.common.utils.TextUtils;
import com.newretail.mapper.custom.GoodsCustomMapper;
import com.newretail.mapper.custom.InterfaceMapper;
import com.newretail.pojo.custom.AppResponseResultList;
import com.newretail.pojo.custom.AppResponseResult;
import com.newretail.pojo.custom.GoodsDetail;
import com.newretail.pojo.custom.GoodsListData;
import com.newretail.pojo.custom.GoodsTableCustom;
import com.newretail.pojo.custom.MerchantInfo;
import com.newretail.pojo.custom.goods.BasicInfo;
import com.newretail.pojo.custom.goods.Category;
import com.newretail.pojo.custom.goods.Details;
import com.newretail.pojo.custom.goods.GoodsDetailData;
import com.newretail.pojo.custom.goods.Logistics;
import com.newretail.pojo.custom.goods.Pics;
import com.newretail.service.IInterfaceService;

@Service("interfaceService")
public class InterfaceServiceImpl implements IInterfaceService {
	@Autowired
	private InterfaceMapper interfaceMapper;

	@Autowired
	private GoodsCustomMapper goodsCustomMapper;

	@Autowired
	private GoodsTableMapper goodsTableMapper;

	@Override
	public JqGridResult<MerchantInfo> getMerchantList(Map<String, Object> param) {
		JqGridResult<MerchantInfo> result = new JqGridResult<>();
		int page = (int) param.get("currentPage");// 第几页
		int rows = (int) param.get("limitCount");// 一页显示的数量
		PageHelper.startPage(page, rows);

		List<MerchantInfo> dataList = interfaceMapper.getMerchantList(param);

		PageInfo<MerchantInfo> pageInfo = new PageInfo<>(dataList);// 把结果放在分页里面
		// 设置返回的参数
		result.setCurrentPage(page);
		result.setLimitCount(rows);
		result.setCurrentCount(pageInfo.getPageNum());
		result.setTotalCount((int) pageInfo.getTotal());// 总数量
		result.setTotalPage(pageInfo.getPages());// 总页数
		result.setData(pageInfo.getList());// 查询的所有数据
		return result;
	}

	@Override
	public JqGridResult<GoodsTableCustom> getMerchantGoodsList(Map<String, Object> param) {
		JqGridResult<GoodsTableCustom> result = new JqGridResult<>();
		int page = (int) param.get("currentPage");// 第几页
		int rows = (int) param.get("limitCount");// 一页显示的数量
		PageHelper.startPage(page, rows);

		List<GoodsTableCustom> dataList = interfaceMapper.getMerchantGoodsList(param);

		PageInfo<GoodsTableCustom> pageInfo = new PageInfo<>(dataList);// 把结果放在分页里面
		// 设置返回的参数
		result.setCurrentPage(page);
		result.setLimitCount(rows);
		result.setCurrentCount(pageInfo.getPageNum());
		result.setTotalCount((int) pageInfo.getTotal());// 总数量
		result.setTotalPage(pageInfo.getPages());// 总页数
		result.setData(pageInfo.getList());// 查询的所有数据
		return result;
	}

	@Override
	public JqGridResult<Map<String, Object>> getGoodsTypeList(Map<String, Object> param) {
		JqGridResult<Map<String, Object>> result = new JqGridResult<>();
		List<Map<String, Object>> dataList = interfaceMapper.getGoodsTypeList(param);
		for (int i = 0; i < dataList.size(); i++) {
			dataList.get(i).put("goodsTypeId", i);
		}
		result.setData(dataList);
		return result;
	}

	@Override
	public JqGridResult<Map<String, Object>> getEvaluateList(Map<String, Object> param) {
		System.out.println("param:" + param);
		JqGridResult<Map<String, Object>> result = new JqGridResult<>();
		int page = (int) param.get("currentPage");// 第几页
		int rows = (int) param.get("limitCount");// 一页显示的数量
		PageHelper.startPage(page, rows);
		List<Map<String, Object>> dataList = interfaceMapper.getEvaluateList(param);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(dataList);// 把结果放在分页里面
		// 设置返回的参数
		result.setCurrentPage(page);
		result.setLimitCount(rows);
		result.setCurrentCount(pageInfo.getPageNum());
		result.setTotalCount((int) pageInfo.getTotal());// 总数量
		result.setTotalPage(pageInfo.getPages());// 总页数
		result.setData(pageInfo.getList());// 查询的所有数据
		// result.setData(dataList);
		return result;
	}

	@Override
	public AppResponseResultList<GoodsListData> getGoodsList(Map<String, Object> param) {
		GoodsTableCustom goodsCustom = new GoodsTableCustom();
		// 获取第几页数据，不传该参数默认为1
		int page = (int) param.get("page");
		if (TextUtils.isEmpty(page)) {
			page = 1;
		}
		// 每页获取多少条数据，不传该参数默认为50
		int pageSize = (int) param.get("pageSize");
		if (TextUtils.isEmpty(pageSize)) {
			pageSize = 50;
		}
		if (param.get("categoryId") != null) {
			// 商品分类ID,必出传
			int categoryId = (int) param.get("categoryId");

			if (!TextUtils.isEmpty(categoryId)) {
				goodsCustom.setGoodsCatId(categoryId);
			}
		}

		if (param.get("goodsNameLike") != null) {
			// 模糊查询
			String goodsNameLike = param.get("goodsNameLike").toString();
			goodsCustom.setGoodsName(goodsNameLike);
		}
		if (param.get("orderBy") != null) {
			// 判断方式：desc或者asc
			String orderBy = param.get("orderBy").toString();
			if (!TextUtils.isEmpty(orderBy)) {
				goodsCustom.setOrderBy(orderBy);
			}
		}

		if (param.get("userId") != null) {
			String userId = param.get("userId").toString();
			goodsCustom.setUserId(userId);
		}
		if (param.get("goodsId") != null) {
			String object = param.get("goodsId").toString();
			if (!TextUtils.isEmpty(object)) {
				goodsCustom.setGoodsId(object);
			}
		}

		List<GoodsTableCustom> findGoodsByCustom = null;
		// 设置重n,到ml列
		PageHelper.startPage(page, pageSize);

		findGoodsByCustom = goodsCustomMapper.findGoodsByCustomOrderByGoodsCustom(goodsCustom);
		// 把结果放在分页里面
		PageInfo<GoodsTableCustom> pageInfo = new PageInfo<>(findGoodsByCustom);
		List<GoodsTableCustom> list = pageInfo.getList();
		 AliyunOssUtils aliyunOssUtils = new AliyunOssUtils();
		for (int i = 0; i < list.size(); i++) {
			String goodsPhoto = list.get(i).getGoodsPhoto();
			if (goodsPhoto != null && goodsPhoto.length() > 0) {
				// 授权，让客户端可以访问
				String imageUrl = aliyunOssUtils.getImageSignUrl(goodsPhoto);
				list.get(i).setGoodsPhoto(imageUrl);
			}
		}
		aliyunOssUtils.destory();
		List<GoodsListData> goodsListDatas = new ArrayList<GoodsListData>();
		for (GoodsTableCustom goodsTable : list) {
			GoodsListData goodsListData = new GoodsListData();
			goodsListData.setCategoryId(goodsTable.getGoodsCatId());
			goodsListData.setPic(goodsTable.getGoodsPhoto());
			goodsListData.setName(goodsTable.getGoodsName());
			goodsListData.setId(goodsTable.getGoodsId());
			goodsListData.setMinPrice(Double.parseDouble(goodsTable.getGoodsPrice()));
			goodsListData.setRecommendStatusStr("普通");
			goodsListData.setPaixu(0);
			goodsListData.setNumberOrders(95);
			goodsListData.setStatusStr("上架");
			goodsListData.setStores(goodsTable.getStock());
			goodsListData.setViews(999);
			goodsListData.setCharacteristic(goodsTable.getGoodsName()+"值得拥有");
			try {
				goodsListData.setDateAdd(DateUtil.convertStringToDate(goodsTable.getCreateTime()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			goodsListDatas.add(goodsListData);
		}

		AppResponseResultList<GoodsListData> appResponseResultObj = new AppResponseResultList<GoodsListData>();
		appResponseResultObj.setCode(0);
		appResponseResultObj.setMsg("succeed");
		appResponseResultObj.setData(goodsListDatas);
		return appResponseResultObj;
	}

	@SuppressWarnings("unchecked")
	@Override
	public AppResponseResult<GoodsDetailData> getGoodsDetailData(String goodsId) {
		GoodsTableCustom goodsCustom = new GoodsTableCustom();
		goodsCustom.setGoodsId(goodsId);
		List<GoodsTableCustom> goodsDetailDatas = goodsCustomMapper.findGoodsDetailByGoodsCustom(goodsCustom);
		GoodsTable goodsItem = goodsTableMapper.selectByPrimaryKey(goodsId);
		Logistics logistics = new Logistics();
		//0 人民币
		logistics.setFeeType(0);
		//按件数
		logistics.setFeeTypeStr("按件数");
		Details details = new Details();
		details.setAddAmount(1);
		details.setAddNumber(1);
		details.setFirstAmount(1);
		details.setFirstNumber(1);
		details.setType(2);
		List mDetails = new ArrayList<Details>();
		mDetails.add(details);
		logistics.setDetails(mDetails);
		//不是免费
		logistics.setIsFree(false);
		
		Category category = new Category();
		category.setDateAdd(DateUtil.getDateNow("yyyy-MM-dd HH:mm:ss"));
		GoodsTableCustom goodsTableCustomItem= goodsDetailDatas.get(0);
		AliyunOssUtils aliyunOssUtils = new AliyunOssUtils();
		String pic = aliyunOssUtils.getImageSignUrl(goodsTableCustomItem.getGoodsPhoto());
		aliyunOssUtils.destory();
		category.setIcon(pic);
		category.setId("暂未去取数据");
		category.setUse(true);
		category.setKey(goodsTableCustomItem.getGoodsName());
		category.setName(goodsTableCustomItem.getGoodsName());
		category.setType("category Test");
		category.setUserId(goodsTableCustomItem.getUserId());
		
		Pics pics = new Pics();
		pics.setGoodsId(goodsTableCustomItem.getGoodsId());
		pics.setPic(pic);
		pics.setId(1);
		ArrayList<Pics> list = new ArrayList<Pics>();
		list.add(pics);
		BasicInfo baseinfo = new BasicInfo();
		baseinfo.setCategoryId(goodsTableCustomItem.getGoodsCatId());
		baseinfo.setCharacteristic("这里显示商品分类");
		baseinfo.setId(goodsId);
		baseinfo.setLogisticsId(1);
		baseinfo.setMinPrice(Double.parseDouble(goodsTableCustomItem.getGoodsPrice()));
		baseinfo.setName(goodsTableCustomItem.getGoodsName());
		baseinfo.setNumberFav(0);
		baseinfo.setNumberGoodReputation(0);
		baseinfo.setOriginalPrice(Double.parseDouble(goodsTableCustomItem.getGoodsPrice()));
		baseinfo.setPaixu(0);
		baseinfo.setPic(pic);
		baseinfo.setDateAdd(DateUtil.getDateNow("yyyy-MM-dd HH:mm:ss"));
		baseinfo.setRecommendStatus(99);
		baseinfo.setRecommendStatusStr("普通");
		baseinfo.setShopId(goodsItem.getMerchantId());
		baseinfo.setStatus(Integer.parseInt(goodsItem.getGoodsStatus()));
		baseinfo.setStatusStr("上架");
		baseinfo.setStores(goodsTableCustomItem.getStock()==null?0:goodsTableCustomItem.getStock());
		baseinfo.setViews(99);
		try {
			baseinfo.setUserId(goodsTableCustomItem.getUserId());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//
		AppResponseResult<GoodsDetailData> appResponseResultObj = new AppResponseResult<GoodsDetailData>();
//		
 	    appResponseResultObj.setCode(0);
		appResponseResultObj.setMsg("succeed");
		GoodsDetailData goodsDetailData = new GoodsDetailData();
		goodsDetailData.setLogistics(logistics);
		goodsDetailData.setCategory(category);
		goodsDetailData.setPics(list);
		goodsDetailData.setContent("<p>这是个测试</p>");
		goodsDetailData.setBasicInfo(baseinfo);
		
 	   	appResponseResultObj.setData(goodsDetailData);
 	    return appResponseResultObj;
	}

	@Override
	public NewRetailResult getGoodsDetail(String goodsId) {
		GoodsTableCustom goodsCustom = new GoodsTableCustom();
		goodsCustom.setGoodsId(goodsId);
		List<GoodsTableCustom> goodsDetailDatas = goodsCustomMapper.findGoodsDetailByGoodsCustom(goodsCustom);
		
		GoodsTableCustom goodsTableCustom = goodsDetailDatas.get(0);
		AliyunOssUtils aliyunOssUtils = new AliyunOssUtils();
		String image = aliyunOssUtils.getImageSignUrl(goodsTableCustom.getGoodsPhoto(),320,150);
		aliyunOssUtils.destory();
 	    GoodsDetail goodsDetail = new GoodsDetail();
 	    
 	    goodsDetail.setDetail("快来买，真心不错");
 	    goodsDetail.setId(goodsId);
 	    goodsDetail.setImage(image);
 	    goodsDetail.setParameter("1件");
 	    goodsDetail.setPrice((goodsTableCustom.getGoodsPrice()==null?0.0:Double.parseDouble(goodsTableCustom.getGoodsPrice())));
 	    goodsDetail.setService("送货上门");
 	    goodsDetail.setStock((goodsTableCustom.getStock()==null?0:goodsTableCustom.getStock())+"");
 	    goodsDetail.setTitle(goodsTableCustom.getGoodsName());
		return NewRetailResult.build(200, "succeed", goodsDetail);
	}

	@Override
	public GoodsTableCustom getGoodsCustomById(String goodsId) {
		GoodsTableCustom goodsCustom = new GoodsTableCustom();
		goodsCustom.setGoodsId(goodsId);
		return goodsCustomMapper.findGoodsDetailByGoodsCustom(goodsCustom).get(0);
	}

}
