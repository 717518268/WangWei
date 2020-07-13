package com.wang.service.impl;





import javax.jms.Destination;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;

//import javax.jms.Destination;




//import org.apache.activemq.command.ActiveMQQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.wang.service.AliYunPhoneMessageService;

@Component
public class AliYunPhoneMessageServiceImpl implements AliYunPhoneMessageService{
	
	@Autowired
	private AliYunPhoneProducer aliYunPhoneProducer;
///	@Async
	@Override
	public  void sendAliyunMessage(String phone, String code) {
		StringBuffer message=new StringBuffer();
		message.append(phone+",");
		message.append(code+",");
		
		Destination des= new ActiveMQQueue("aliyunphone");//设置队列名称
		
		
		//发送过去
		aliYunPhoneProducer.sendMessage(des, message.toString());
		/**     activemq**/
		//下面是阿里云的短信业务
		 
		
		 
		
	}

}
