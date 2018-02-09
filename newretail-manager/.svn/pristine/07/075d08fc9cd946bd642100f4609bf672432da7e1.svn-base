package com.newretail.controller.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转controller
 * <p>Title: PageController</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.com</p> 
 * @author	入云龙
 * @date	2015年9月2日上午11:11:41
 * @version 1.0
 */
@Controller
@RequestMapping("/")
public class PageController2 {

	
	@RequestMapping("getIndex")
	public String showpage() {
		System.out.println("11111111111111111");
		return "index";
	}
	
	@RequestMapping("getUserManagerPage")
	public String showUseManager(HttpServletRequest request) {
		String page=request.getParameter("page");
		return "pages/"+page;
	}
	
	@RequestMapping("getDeliveryManagerPage")
	public String showDeliveryManager(HttpServletRequest request) {
		String page=request.getParameter("page");
		return "pages/"+page;
	}
}
