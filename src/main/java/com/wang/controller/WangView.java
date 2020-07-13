package com.wang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 全局url
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/wang")
public class WangView {
	private final String url="http://dreamwang.com.cn";
	//private final String url="http://localhost";
	@RequestMapping("/Wang-Service-Web")
	public String WangServiceWebViewMethod() {
		//redirect:主页
		return "redirect:"+url+":8085/Wang-Service-Web/index";
	}
	@RequestMapping("/Wang-Service-Web/ranking")
	public String WangServiceWebRaNKingViewMethod() {
		//redirect:主页
		return "redirect:"+url+":8085/Wang-Service-Web/ranking";
	}
	
	@RequestMapping("/Wang-Service-User")
	public String WangServiceUserViewMethod() {
		//redirect:个人中心
		return "redirect:"+url+":8084/Wang-Service-User/RegisterUser";
	}
	
	
	@RequestMapping("/Wang-Service-Management")
	public String WangServiceManagementViewMethod() {
		//redirect:发布快乐源泉
		return "redirect:"+url+":8091/Wang-Service-Management/management";
	}
	
	
	@RequestMapping("/Wang-Book")
	public String WangBookViewMethod() {
		//redirect:活动
		return "redirect:"+url+":9001/Wang-Book/index";
	}
	
	@RequestMapping("/Wang-Service-EmailLogin/register")
	public String WangEmailLoginViewMethod() {
		//redirect:邮箱注册
		return "redirect:"+url+":8088/Wang-Service-EmailLogin/Emailregister";
	}
	
	
	@RequestMapping("/Wang-Service-EmailLogin/login")
	public String WangServiceEmailLoginViewMethod() {
		//redirect:邮箱登录
		return "redirect:"+url+":8088/Wang-Service-EmailLogin/Emaillogin";
	}
	
	
	@RequestMapping("/Wang-Service-PhoneLogin/register")
	public String WangServicePhoneLoginViewMethod() {
		//redirect:短信注册
		return "redirect:"+url+":8087/Wang-Service-PhoneLogin/phoenRegister";
	}
	
	@RequestMapping("/Wang-Service-PhoneLogin/login")
	public String WangServicePhoneLoginLoginViewMethod() {
		//redirect:短信登录
		return "redirect:"+url+":8087/Wang-Service-PhoneLogin/phoneLogin";
	}
}
