package com.wang.service;

import java.util.concurrent.Future;

public interface AliYunPhoneMessageService {
	
	/**
	 * 将短信接口注册到服务中心
	 * @param phone
	 * @param code
	 */
	public void sendAliyunMessage(String phone,String code);
	
}
