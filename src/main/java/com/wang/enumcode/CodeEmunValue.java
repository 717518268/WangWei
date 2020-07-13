package com.wang.enumcode;

import java.io.Serializable;

public enum CodeEmunValue implements Serializable{
	 
	SUCCESS  (1,"成功"),
	OVER_ACTIVLE(0,"抽奖次数用完了"),
	OPERATION_BUSY(-1,"手机号匹配不成功"),
	NAME_ERROE(-2,"汉字匹配不正确"),
	HAVE_PHONE_ERRPR (-3,"用户手机已经注册了"),
	PHONE_CODE_ERROR(-4,"重复提交"),
	OVER_TIME(-5,"为超时返回值--操作繁忙"),
	STOP(-6,"活动被管理员停止了"),
	MESSAGE_INSUFFICLIENT(-7,"短信不足"),
	NO_HAVE_PHONE_CODE(-8,"用户还没获取获取验证码"),
	CODE_MATTHE(-9,"验证码格式不对"),
	CODE_ERROE(-10,"验证码不正确");
	
 
	private Integer code;
	private String message;
	CodeEmunValue(Integer code,String message){
		this.code=code;
		this.setMessage(message);
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
