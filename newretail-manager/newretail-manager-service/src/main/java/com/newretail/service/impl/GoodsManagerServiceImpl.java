package com.newretail.service.impl;

import java.util.List;
import java.util.Map;

import com.newretail.common.utils.TextUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.newretail.common.utils.AliyunOssUtils;
import com.newretail.common.utils.IdGenerator;
import com.newretail.common.utils.JqGridResult;
import com.newretail.mapper.GoodsSalesMapper;
import com.newretail.mapper.GoodsTableMapper;
import com.newretail.mapper.custom.GoodsCustomMapper;
import com.newretail.pojo.GoodsSales;
import com.newretail.pojo.GoodsTable;
import com.newretail.pojo.GoodsTableExample;
import com.newretail.pojo.GoodsTableExample.Criteria;
import com.newretail.pojo.custom.GoodsTableCustom;
import com.newretail.service.GoodsManagerService;

/**
 * 商品管理
 * @author Yongjie
 *
 */
@Service("goodsManagerService")
public class GoodsManagerServiceImpl implements GoodsManagerService {
	@Autowired
	private GoodsTableMapper goodsTableMapper;
	
	@Autowired
	private GoodsCustomMapper goodsCustomMapper;
	
	@Autowired
	private GoodsSalesMapper goodsSalesMapper;
	
	Logger log = Logger.getLogger(GoodsManagerServiceImpl.class);
	@Override
	public int addGoodsByGoods(GoodsTable goods) throws Exception {
		log.error("------------addGoodsByGoods-----------"+goods.toString());
		String goodsId = IdGenerator.getId();
		       goods.setGoodsId(goodsId);
		int insertSelective = goodsTableMapper.insertSelective(goods);
		if(goodsId!=null) {
			GoodsSales goodsSales = new GoodsSales();
			goodsSales.setGoodsId(goodsId);
			goodsSales.setSales(0);
			goodsSales.setId(IdGenerator.getId());
			int insertSelective2 = goodsSalesMapper.insertSelective(goodsSales);
			if(insertSelective2<0){
				throw  new Exception("修改货物销量失败");
			}
		}
		return insertSelective;
	}

	@Override
	public int deleteGoodsById(String id) throws Exception {
		return goodsTableMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateGoodsById(GoodsTable goods) throws Exception {
		return goodsTableMapper.updateByPrimaryKeySelective(goods);
	}

	@Override
	public List<GoodsTable> findGoodsByGoods(GoodsTable goods) throws Exception {
		GoodsTableExample goodsTableExample = new GoodsTableExample();
		Criteria goodsCriteria = goodsTableExample.createCriteria();
		if(goods.getGoodsId()!=null) {
			goodsCriteria.andGoodsIdEqualTo(goods.getGoodsId());
		}
		if(goods.getUserId()!=null) {
			goodsCriteria.andUserIdEqualTo(goods.getUserId());
		}
		if(goods.getAuditorId()!=null) {
			goodsCriteria.andAuditorIdEqualTo(goods.getAuditorId());
		}
		return goodsTableMapper.selectByExample(goodsTableExample);
	}

	@Override
	public GoodsTable findGoodsById(String id) throws Exception {
		return goodsTableMapper.selectByPrimaryKey(id);
	}

	@Override
	public JqGridResult<GoodsTableCustom> findGoodsByGoods(GoodsTable goods, Map<String, Integer> pages) throws Exception {
		 String userId = goods.getUserId();
		 GoodsTableCustom goodsCustom = new GoodsTableCustom();
		 List<GoodsTableCustom> findGoodsByCustom = null;
		 //设置重n,到ml列
		 PageHelper.startPage(pages.get("page"), pages.get("rows"));
	
		 if(!TextUtils.isEmpty(userId)) {
			 goodsCustom.setUserId(userId);
		 }
		 if(!TextUtils.isEmpty(goods.getGoodsName())) {//模糊查询
			 goodsCustom.setGoodsName(goods.getGoodsName());
		 }
		 log.error("=================status==================="+pages.get("status"));
		 log.error("=================goodsCustom==================="+goodsCustom.toString());
		 //排序
		 if(pages.get("status")==1) {//销量
			 findGoodsByCustom = goodsCustomMapper.findGoodsByCustomOrderBySales(goodsCustom);
		 }else if(pages.get("status")==2) { //按时间排序
			 findGoodsByCustom = goodsCustomMapper.findGoodsByCustomOrderByLastTime(goodsCustom);
		 }else {
			 findGoodsByCustom =  goodsCustomMapper.findGoodsByCustom(goods.getUserId());
		 }
		 
		 //把结果放在分页里面
		 PageInfo<GoodsTableCustom>  pageInfo = new PageInfo<>(findGoodsByCustom);
		 //把分页后的结果放在jqGridResult中
		 JqGridResult<GoodsTableCustom> jqGridResult = new JqGridResult<GoodsTableCustom>();
		 
		 jqGridResult.setData(findGoodsByCustom);
		 int rows=	pages.get("rows");
		 int sums = pageInfo.getPageSize();
		 jqGridResult.setTotalCount(sums);	
		 jqGridResult.setTotalPage(sums%rows==0?sums/rows:(sums/rows+1));
		
		 List<GoodsTableCustom> list = pageInfo.getList();
		 AliyunOssUtils aliyunOssUtils = new AliyunOssUtils();
		 for(int i=0;i<list.size();i++) {
			 if(list.get(i).getGoodsStatus().equals("0")) {
				 list.get(i).setGoodsStatus("已创建");
			 }else if(list.get(i).getGoodsStatus().equals("1")) {
				 list.get(i).setGoodsStatus("审核中");
			 }else if(list.get(i).getGoodsStatus().equals("2")) {
				 list.get(i).setGoodsStatus("已上架");
			 }else if(list.get(i).getGoodsStatus().equals("3")) {
				 list.get(i).setGoodsStatus("已下架");
			 }else if(list.get(i).getGoodsStatus().equals("4")) {
				 list.get(i).setGoodsStatus("审核失败");
			 }
			 list.get(i).setId((i+1)+"");
			 
			 String goodsPhoto = list.get(i).getGoodsPhoto();
			 
			 if(goodsPhoto!=null&&goodsPhoto.length()>0) {
				 //授权，让客户端可以访问
				 String imageUrl = aliyunOssUtils.getImageSignUrl(goodsPhoto);
				 list.get(i).setGoodsPhoto(imageUrl);
			 }
			 
			 
		 }
		 jqGridResult.setData(list);
		 aliyunOssUtils.destory();
		return jqGridResult;
	}

	@Override
	public JqGridResult<GoodsTableCustom> findGoodsByAdminGoods(GoodsTableCustom custom, Map<String, Integer> pages) throws Exception {

		//重新封装数据
		GoodsTableCustom goodsCustom = new GoodsTableCustom();

		List<GoodsTableCustom> findGoodsByCustom = null;

		//设置重n,到ml列,分页设置
		PageHelper.startPage(pages.get("page"), pages.get("rows"));

		String userId = custom.getUserId();
		//用户ID
		if(!TextUtils.isEmpty(userId)) {
			goodsCustom.setUserId(userId);
		}
		//商品ID
		if(!TextUtils.isEmpty(custom.getGoodsId())) {
			goodsCustom.setGoodsId(custom.getGoodsId());
		}
		//商品状态
		if(!TextUtils.isEmpty(custom.getGoodsStatus())) {
			goodsCustom.setGoodsStatus(custom.getGoodsStatus());
		}
		//详细地址
		if(!TextUtils.isEmpty(custom.getDeliverAddress())) {
			goodsCustom.setDeliverAddress(custom.getDeliverAddress());
		}
		//区域地址
		if(!TextUtils.isEmpty(custom.getAreaCode())) {
			goodsCustom.setAreaCode(custom.getAreaCode());
		}
		if(!TextUtils.isEmpty(custom.getProvince())){
			goodsCustom.setProvince(custom.getProvince());
		}
		if(!TextUtils.isEmpty(custom.getCity())){
			goodsCustom.setCity(custom.getCity());
		}

		if(!TextUtils.isEmpty(custom.getDistrict())){
			goodsCustom.setDistrict(custom.getDistrict());
		}

		//查询
		findGoodsByCustom = goodsCustomMapper.findGoodsByCustomOrderByAdmin(goodsCustom);

		//把结果放在分页里面
		PageInfo<GoodsTableCustom>  pageInfo = new PageInfo<>(findGoodsByCustom);
		//把分页后的结果放在jqGridResult中
		JqGridResult<GoodsTableCustom> jqGridResult = new JqGridResult<GoodsTableCustom>();

		int rows=	pages.get("rows");
		int sums = pageInfo.getPageSize();
		jqGridResult.setTotalCount(sums);
		jqGridResult.setTotalPage(sums%rows==0?sums/rows:(sums/rows+1));

		List<GoodsTableCustom> ls = pageInfo.getList();
		for(int i=0;i<ls.size();i++) {
			if(ls.get(i).getGoodsStatus().equals("1")) {
				ls.get(i).setGoodsStatus("审核中");
			}else if(ls.get(i).getGoodsStatus().equals("2")) {
				ls.get(i).setGoodsStatus("已上架");
			}else if(ls.get(i).getGoodsStatus().equals("3")) {
				ls.get(i).setGoodsStatus("已下架");
			}else if(ls.get(i).getGoodsStatus().equals("4")) {
				ls.get(i).setGoodsStatus("审核失败");
			}
			ls.get(i).setId((i+1)+"");
		}
		//回显数据
		jqGridResult.setData(ls);
		return jqGridResult;
	}


}
