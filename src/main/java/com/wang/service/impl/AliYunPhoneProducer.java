package com.wang.service.impl;

import javax.jms.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class AliYunPhoneProducer {
	

	@Autowired
	private JmsMessagingTemplate jmsTemplate;
	//发送消息
	public void sendMessage(Destination des,String message) {
		
		jmsTemplate.convertAndSend(des,message);
		
		
	}
	
	
}
