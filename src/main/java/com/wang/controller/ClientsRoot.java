package com.wang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/Wang-Book")
public class ClientsRoot {
	
	/**
	 * 修改领取状态
	 * @return
	 */
	@RequestMapping("/ClientsView")
	 
	public String ClientsViewMethord() {
		//
		
		return "clients";
	}
	
}
