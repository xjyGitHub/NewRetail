package com.newretail.common.utils;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailUtils {
	
	public static boolean sendVildateCodeEmail(String toAddress,String code,String username) {
		 	SimpleEmail simpleEmail = new SimpleEmail();
	        simpleEmail.setHostName("smtp.ym.163.com");
	        simpleEmail.setAuthentication("admin@campuspp.com", "sysen.cn");
	        simpleEmail.setSmtpPort(25);
	        try {
				simpleEmail.setFrom("admin@campuspp.com", "系统管理员", "UTF-8");
			} catch (EmailException e3) {
				e3.printStackTrace();
			}
	        try {
				simpleEmail.addTo("1282029858@qq.com", "亲爱的："+username);
			} catch (EmailException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
	        simpleEmail.setSubject("轻松点用户信息验证");
	        try {
				simpleEmail.setMsg("欢迎注册本轻松点，您本次的注册验证码为"+code+"，该验证码5分钟内有效【未来轻松点科技】");
			} catch (EmailException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        try {
				simpleEmail.send();
			} catch (EmailException e) {
				e.printStackTrace();
			}
		
		return false;
	}; 

}
