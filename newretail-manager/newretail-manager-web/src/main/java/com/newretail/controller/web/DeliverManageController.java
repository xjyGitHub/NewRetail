package com.newretail.controller.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newretail.common.utils.JqGridResult;
import com.newretail.common.utils.NewRetailResult;
import com.newretail.pojo.DeliverInfoTable;
import com.newretail.pojo.custom.DeliverInfoAddTable;
import com.newretail.service.DeliverManagerService;

@Controller
@RequestMapping("/deliver")
public class DeliverManageController {
	
	@Resource
	private DeliverManagerService deliverManagerService;
	
	/**
	 * 点击配送情况，跳转界面
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping("/toIndex")
	public String toIndex(HttpServletRequest req,HttpServletResponse res){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String toDay = sdf.format(date);
		List<Map<String,String>> list = deliverManagerService.getAllDeliverListToday(toDay);
		System.out.println("查询···");
		System.out.println(list);
		req.setAttribute("list", list);
		return "adminDelivery";	//管理员
	//	return "delivery";		//商家
	}
	
	/**
	 * 测试
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping("/test")
	@ResponseBody
	public JqGridResult test(HttpServletRequest req,HttpServletResponse res){
		Map<String,Object> params = new HashMap<>();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String queryTime = sdf.format(date);
		System.out.println("test查询···");
		JqGridResult result =  new JqGridResult();
		int rows = Integer.parseInt(req.getParameter("rows"));//这个是每页要显示的行数
		int page = Integer.parseInt(req.getParameter("page"));//显示的第几页
		params.put("rows", rows);
		params.put("startIndex", rows*(page-1));
		params.put("queryTime", queryTime);
		System.out.println(params+"***********"+rows+"***********"+page);
		result = deliverManagerService.test(params);;
		return result;
	}
	/**
	 * 商家按状态+时间查询
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping("/queryDeliverDetail")
	@ResponseBody
	public JqGridResult queryDeliverDetail(HttpServletRequest req,HttpServletResponse res){
		Map<String,Object> params = new HashMap<>();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String toDay = sdf.format(date);
		String deliverStatus = req.getParameter("deliverStatus");
		String queryTime = req.getParameter("queryTime");
		if("".equals(queryTime)){
			queryTime = toDay;
		}
		JqGridResult result =  new JqGridResult();
		int rows = Integer.parseInt(req.getParameter("rows"));//这个是每页要显示的行数
		int page = Integer.parseInt(req.getParameter("page"));//显示的第几页
		params.put("rows", rows);
		params.put("startIndex", rows*(page-1));
		params.put("deliverStatus", deliverStatus);
		params.put("queryTime", queryTime);
		result = deliverManagerService.getDeliverListByStatus(params);
		System.out.println(result);
		return result;
	}
	
	/**
	 * 管理员查看配送情况
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping("/queryDeliverByCondition")
	@ResponseBody
	public JqGridResult queryDeliverByCondition(HttpServletRequest req,HttpServletResponse res){
		Map<String,Object> params = new HashMap<>();
		//店铺号 shop_id
		String shopId = req.getParameter("shopId");
		String deliverStatus = req.getParameter("deliverStatus");
		String orderId = req.getParameter("orderId");
		String startTime = req.getParameter("startTime");
		String endTime = req.getParameter("endTime");
		
		JqGridResult result =  new JqGridResult();
		int rows = Integer.parseInt(req.getParameter("rows"));//这个是每页要显示的行数
		int page = Integer.parseInt(req.getParameter("page"));//显示的第几页
		params.put("rows", rows);
		params.put("startIndex", rows*(page-1));
		params.put("shopId", shopId);
		params.put("deliverStatus", deliverStatus);
		params.put("orderId", orderId);
		params.put("startTime", startTime);
		params.put("endTime", endTime);
		result = deliverManagerService.getDeliverListByCondition(params);
		return result;
	}
	
}
