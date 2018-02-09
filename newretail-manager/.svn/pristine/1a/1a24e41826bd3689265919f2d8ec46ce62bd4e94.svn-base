package com.newretail.controller.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.newretail.common.utils.AliyunSmsUtils;
@Controller
@RequestMapping("/sms")
public class SmsController {
	/**
	 * 获取验证码
	 * @param obj json格式的数据：{"phoneNumber":"151xxxx0001"}
	 * @param req 
	 * @return
	 */
	@RequestMapping("sendSms")
	public @ResponseBody Map<String,Object>  getSmsVerificationCode(@RequestBody Map<String,Object> obj,HttpSession session) {
		//随机数验证码
		String random = Integer.toString((int)((Math.random()*9+1)*100000));
		Map<String,Object> status = new HashMap();
		String number = obj.get("phoneNumber").toString();
		try {

			//把验证码保存在Session中
			//---------------------------------------------------------------
				session.setMaxInactiveInterval(60*5);
			    session.setAttribute(number, random);
			    session.setAttribute("newretaill", "newretail");
				SendSmsResponse response = AliyunSmsUtils.sendSms(number, random);
	        //----------------------------------------------------------------
			if(response.getCode().equals("OK")) {
		        status.put("code", 200);
		        status.put("vcode", random);
		        status.put("msg","请求验证码成功");
	        }else {
		        status.put("code", 0);
		        status.put("vcode", -1);
		        status.put("msg","请求验证码失败");
	        }
		} catch (ClientException e) {
				status.put("code", 0);
	        	status.put("vcode", -1);
	        	status.put("msg","请求验证码失败，抛出异常:"+e.getErrMsg());
				e.printStackTrace();
		}
		return status;
	}
	
	/**
	 * 
	 * @param obj 请求参数Json形式,eg:{"phone":"15113993846","code":"123456"}
	 * @param sessionn
	 * @return 返回参数 eg:{"status":0,"msg":"succeed"}
	 */
	@RequestMapping("vildate")
	public @ResponseBody Map<String,Object> VlidateCodeCheck(@RequestBody Map<String,Object> obj,HttpSession session){
		String phone = obj.get("phone").toString();
		String code = obj.get("code").toString();
		Map<String,Object> rep = new HashMap<String,Object>();
		if(phone!=null&&phone.length()==11) {
				if(session==null) {
					rep.put("status", 0);
					rep.put("msg", "请重新获取验证码,Session为空");
					return rep;
				}
				String mCode = session.getAttribute(phone).toString();
				if(code.equals(mCode)) {
					rep.put("status", 200);
					rep.put("msg", "验证码成功"+mCode);
				}else {
					rep.put("status", 0);
					rep.put("msg", "输入的验证码不正确");
				}
		}else {
			rep.put("status", 0);
			rep.put("msg", "请输入验证码");
		}
		return rep;
		
	}
}
