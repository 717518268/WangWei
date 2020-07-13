package com.wang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Wang-Book")
public class ExpetionView {
	
	@RequestMapping("/400")
	public String a400view() {
		return "400";
		
	}
	
}
