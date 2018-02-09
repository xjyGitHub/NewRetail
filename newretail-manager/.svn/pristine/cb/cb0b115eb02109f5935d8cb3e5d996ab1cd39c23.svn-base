package com.newretail.controller.web;

import com.newretail.common.utils.*;
import com.newretail.mapper.custom.GoodsCustomMapper;
import com.newretail.pojo.AddressTable;
import com.newretail.pojo.GoodsTable;
import com.newretail.pojo.UserTable;
import com.newretail.pojo.custom.GoodsTableCustom;
import com.newretail.service.GoodsManagerService;
import com.newretail.service.UserAuthenticationService;
import com.newretail.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/goods")
public class GoodsManagerController {

	@Autowired
	private GoodsManagerService goodsManagerService;

	@Autowired
	private UserAuthenticationService userAuthenticationService;

	@Autowired
	private UserService userService;

	@Autowired
	private GoodsCustomMapper goodsCustomMapper;




	/**
	 * 添加商品 addGoodsByGoods:(这里用一句话描述这个方法的作用). <br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author Yongjie
	 * @param goods
	 * @param request
	 * @return
	 * @since JDK 1.8
	 */
	@RequestMapping("add")
	@ResponseBody
	public NewRetailResult addGoodsByGoods(@RequestBody GoodsTable goods, HttpServletRequest request) {
		GoodsTable goodsTable = new GoodsTable();
		String token = CookieUtils.getCookieValue(request, "NEWRETAIL_LOGIN");
		UserTable userByToken = null;
		List<AddressTable> addressList = null;
		try {
			userByToken = userService.getUserByToken(token);
		} catch (Exception e1) {
			return NewRetailResult.build(0, "登录可能失效", ExceptionUtil.getStackTrace(e1));
		}
		String goodsStatus = "1";
		boolean isAuthentication;
		try {
			isAuthentication = userAuthenticationService.findUserIsAuthentication(userByToken.getId());
			if (isAuthentication == false) {
				return NewRetailResult.build(0, "您尚未认证，请联系管理员");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			return NewRetailResult.build(0, "认证异常", ExceptionUtil.getStackTrace(e1));
		}
		if (!TextUtils.isEmpty(userByToken.getId())) {
			goodsTable.setUserId(userByToken.getId());
		} else {
			return NewRetailResult.build(0, "可能登录失效，请刷新页面重试！");
		}

		if (!TextUtils.isEmpty(goods.getGoodsName())) {
			goodsTable.setGoodsName(goods.getGoodsName());
		} else {
			return NewRetailResult.build(0, "商品名不能为空");
		}

		if (!TextUtils.isEmpty(goods.getGoodsPhoto())) {
			goodsTable.setGoodsPhoto(goods.getGoodsPhoto());
		} else {
			return NewRetailResult.build(0, "请选择商品图片");
		}

		if (!TextUtils.isEmpty(goods.getGoodsPrice())) {
			goodsTable.setGoodsPrice(goods.getGoodsPrice());
		} else {
			return NewRetailResult.build(0, "请设置商品价格");
		}
		if (!TextUtils.isEmpty(goods.getDiscount())) {
			goodsTable.setDiscount(goods.getDiscount());
		} else {
			return NewRetailResult.build(0, "折扣为空");
		}

		if (!TextUtils.isEmpty(goods.getGoodsType())) {
			goodsTable.setGoodsType(goods.getGoodsType());
		} else {
			return NewRetailResult.build(0, "商品类型不能为空");
		}
		//查询当前用户的默认地址
		AddressTable AddressTable = new AddressTable();
		AddressTable.setUserId(userByToken.getId());
		try {
			addressList = userService.findUserAddress(AddressTable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//设置商品所属区域
		if(addressList!=null&&addressList.size()>0){
			AddressTable addressTable = addressList.get(0);
			String city = addressTable.getCityStr();
			String district = addressTable.getDistrictStr();
			if(!district.contentEquals("-")){
				goodsTable.setAreaCode(district);
			}else{
				goodsTable.setAreaCode(city);
			}
		}
		String createTime = DateUtil.getNowDateTime("yyyy-MM-dd HH:mm:ss");

		if (goods.getStock() != null){
			goodsTable.setStock(goods.getStock());
		}else{
			return NewRetailResult.build(0, "库存不能为空");
		}


		goodsTable.setCreateTime(createTime);
		goodsTable.setUpdateTime(createTime);

		if (!TextUtils.isEmpty(goodsStatus)){

			goodsTable.setGoodsStatus(goodsStatus);
		}else{

			return NewRetailResult.build(0, "货物状态");
		}
		try {
			int status = goodsManagerService.addGoodsByGoods(goodsTable);
			if (status > 0) {
				return NewRetailResult.ok();
			} else {
				return NewRetailResult.build(0, "添加失败");
			}
		} catch (Exception e) {
			return NewRetailResult.build(0, ExceptionUtil.getStackTrace(e));
		}
	}

	/**
	 * 查询数据 getGoodsList:(这里用一句话描述这个方法的作用). <br/>
	 *
	 * @author Yongjie
	 * @param req
	 * @param response
	 * @return
	 * @since JDK 1.8
	 */
	@RequestMapping("getGoodsList")
	@ResponseBody
	public JqGridResult<GoodsTableCustom> getGoodsList(HttpServletRequest req, HttpServletResponse response) {
		Logger log = Logger.getLogger(GoodsManagerController.class);
		String token = CookieUtils.getCookieValue(req, "NEWRETAIL_LOGIN");
		UserTable userByToken = null;
		try {
			userByToken = userService.getUserByToken(token);
		} catch (Exception e1) {
			e1.printStackTrace();

		}
		String goodsName = req.getParameter("goodsName");
		String searchCat = req.getParameter("searchSelect");
		// 这个是每页要显示的行数
		int rows = Integer.parseInt(req.getParameter("rows"));
		// 显示的第几页
		int page = Integer.parseInt(req.getParameter("page"));

		// 设置分页及排序参数
		Map<String, Integer> pages = new HashMap<String, Integer>(2);
		pages.put("rows", rows);
		pages.put("page", page);
		log.error("------------searchCat------------" + searchCat);
		// 设置排序方式
		if (searchCat == null) {
			// 默认不排序
			pages.put("status", 0);
			// 按销量排序
		} else if ("1".equals(searchCat)) {
			pages.put("status", 1);
			// 按时间排序
		} else if ("2".equals(searchCat)) {
			pages.put("status", 2);
		} else {
			pages.put("status", 0);
		}
		// 设置查询条件
		GoodsTable goodsTable = new GoodsTable();
		if (!TextUtils.isEmpty(userByToken.getId())) {
			goodsTable.setUserId(userByToken.getId());
		} else {
			return null;
		}
		if (!TextUtils.isEmpty(goodsName)) {
			goodsTable.setGoodsName(goodsName);
		}

		try {
			return goodsManagerService.findGoodsByGoods(goodsTable, pages);
		} catch (Exception e) {

			e.printStackTrace();

		}
		return null;

	}

	/**
	 * 查询数据 getGoodsList:(这里用一句话描述这个方法的作用). <br/>
	 *
	 * @author Yongjie
	 * @param req
	 * @param response
	 * @return
	 * @since JDK 1.8
	 */
	@RequestMapping("getGoodsAdminList")
	@ResponseBody
	public JqGridResult<GoodsTableCustom> getGoodsListByAdmin(HttpServletRequest req, HttpServletResponse response) {
		int rows = 0;
		int page = 10;
		//商户账户
		String userAccount  = req.getParameter("userAccount");
		//审核状态
		String goodsStatus   = req.getParameter("goods_status");
		//具体地址
		String detailAddress  = req.getParameter("detailAddress");
		//商品ID
		String goodsId   = req.getParameter("goodsId");
		//地址搜索
		String province  = req.getParameter("province");
		//地址搜索
		String city  = req.getParameter("city");
		//地址搜索
		String district  = req.getParameter("district");

		//重新封装数据
		GoodsTableCustom goodsCustom = new GoodsTableCustom();

		Map<String,Integer> pages = new HashMap<>(2);
		rows = Integer.parseInt(req.getParameter("rows"));// 这个是每页要显示的行数
		page = Integer.parseInt(req.getParameter("page"));// 显示的第几页
		if(!TextUtils.isEmpty(province)){
			goodsCustom.setProvince(province);
		}
		if(!TextUtils.isEmpty(city)){
			goodsCustom.setCity(city);
		}

		if(!TextUtils.isEmpty(district)){
			goodsCustom.setDistrict(district);
		}
		//用户ID
		if(!TextUtils.isEmpty(userAccount)) {
			goodsCustom.setUserId(userAccount);
		}
		//商品ID
		if(!TextUtils.isEmpty(goodsId)) {
			goodsCustom.setGoodsId(goodsId);
		}
		//商品状态
		if(!TextUtils.isEmpty(goodsStatus)&& !"0".equals(goodsStatus)) {
			goodsCustom.setGoodsStatus(goodsStatus);
		}
		//详细地址
		if(!TextUtils.isEmpty(detailAddress)) {
			goodsCustom.setDeliverAddress(detailAddress);
		}

		//分页设置
		if(rows!=0){
			pages.put("rows",rows);
		}else{
			pages.put("rows",0);
		}
		if(rows!=0){
			pages.put("page",page);
		}else{
			pages.put("page",10);
		}
		try {
			return goodsManagerService.findGoodsByAdminGoods(goodsCustom, pages);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping("update")
	public @ResponseBody NewRetailResult updateGoodsByItem(HttpServletRequest req) {
		String goodsId = req.getParameter("goodsId");
		String goodsName = req.getParameter("goodsName");
		String goodsPrice = req.getParameter("goodsPrice");
		String goodsType = req.getParameter("goodsType");
		String discount = req.getParameter("discount");
		Integer stock = Integer.parseInt(req.getParameter("stock"));
		String updateTime = req.getParameter("updateTime");
		GoodsTable goodsTable = new GoodsTable();
		goodsTable.setGoodsId(goodsId);
		goodsTable.setGoodsName(goodsName);
		goodsTable.setGoodsPrice(goodsPrice);
		goodsTable.setGoodsType(goodsType);
		goodsTable.setDiscount(discount);
		goodsTable.setStock(stock);
		goodsTable.setUpdateTime(updateTime);
		try {
			int updateGoodsById = goodsManagerService.updateGoodsById(goodsTable);
			if (updateGoodsById > 0){

				return NewRetailResult.build(200, "修改成功", goodsTable);
			}else{

				return NewRetailResult.build(0, "更新失败请重试");
			}
		} catch (Exception e) {
			return NewRetailResult.build(0, "更新失败", ExceptionUtil.getStackTrace(e));

		}

	};

	@RequestMapping("del")
	@ResponseBody
	public NewRetailResult delGoodsByGoodsIds(HttpServletRequest req) {
		String[] goodsIds = req.getParameter("goodsIds").split(",");
		try {
			for (int i = 0; i < goodsIds.length; i++) {
				if (!TextUtils.isEmpty(goodsIds[i])){
					goodsManagerService.deleteGoodsById(goodsIds[i]);
				}
			}
			return NewRetailResult.build(200, "刪除成功", goodsIds);
		} catch (NumberFormatException e) {
			return NewRetailResult.build(0, "删除失败",ExceptionUtil.getStackTrace(e));
		} catch (Exception e) {
			return NewRetailResult.build(0, "删除失败",ExceptionUtil.getStackTrace(e));
		}
	
	}
	@RequestMapping("authenticate")
	@ResponseBody
	public NewRetailResult updateGoodsByGoodsIds(HttpServletRequest req) {
		String[] goodsIds = req.getParameter("goodsIds").split(",");
		String status = req.getParameter("status");
		try {
			for (int i = 0; i < goodsIds.length; i++) {
				if (!TextUtils.isEmpty(goodsIds[i])) {
					if("1".equals(status)){
						GoodsTable goodsTable = new GoodsTable();
						goodsTable.setGoodsStatus("2");
						goodsTable.setGoodsId(goodsIds[i]);
						goodsManagerService.updateGoodsById(goodsTable);
					}else if("0".equals(status)){
						GoodsTable goodsTable = new GoodsTable();
						goodsTable.setGoodsStatus("4");
						goodsTable.setGoodsId(goodsIds[i]);
						goodsManagerService.updateGoodsById(goodsTable);
					}else{
						return NewRetailResult.build(0, "系统出错", status);
					}
				}
			}
			return NewRetailResult.build(200, "处理成功", goodsIds);
		} catch (NumberFormatException e) {
			return NewRetailResult.build(0, "处理成功",ExceptionUtil.getStackTrace(e));
		} catch (Exception e) {
			return NewRetailResult.build(0, "处理成功",ExceptionUtil.getStackTrace(e));
		}

	}

	/**
	 * 上架操作
	 * @param req
	 * @return
	 */
	@RequestMapping("putOnAndDown")
	@ResponseBody
	public NewRetailResult updateGoodsByGoodsId(HttpServletRequest req) {
		String[] goodsIds = req.getParameter("goodsIds").split(",");
		String status = req.getParameter("status");
		try {
			for (int i = 0; i < goodsIds.length; i++) {
				if (!TextUtils.isEmpty(goodsIds[i])) {
					if("1".equals(status)){
						GoodsTable goodsTable = new GoodsTable();
						goodsTable.setGoodsStatus("1");
						goodsTable.setGoodsId(goodsIds[i]);
						goodsManagerService.updateGoodsById(goodsTable);
					}else if("3".equals(status)){
						GoodsTable goodsTable = new GoodsTable();
						goodsTable.setGoodsStatus("3");
						goodsTable.setGoodsId(goodsIds[i]);
						goodsManagerService.updateGoodsById(goodsTable);
					}else{
						return NewRetailResult.build(0, "系统出错", status);
					}
				}
			}
			return NewRetailResult.build(200, "提交审核成功", goodsIds);
		} catch (NumberFormatException e) {
			return NewRetailResult.build(0, "提交审核失败",ExceptionUtil.getStackTrace(e));
		} catch (Exception e) {
			return NewRetailResult.build(0, "提交审核失败",ExceptionUtil.getStackTrace(e));
		}

	}

}
