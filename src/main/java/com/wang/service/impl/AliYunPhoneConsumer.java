package com.wang.service.impl;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;

//import org.springframework.jms.annotation.JmsListener;

//import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.wang.exception.MyExpection;
/**
 * 监听者执行短信发送
 * @author Administrator
 *
 */
@Component
public class AliYunPhoneConsumer {
	
	
	  //这个是电话的队列
		//配置好对应的队列名字
		@JmsListener(destination="aliyunphone")
		@SendTo("soque")
		public void ResceveMessage(String message) throws MyExpection, ServerException, ClientException {
			String[] phonestr=message.split(",");//0 is phone , 1 is code
			String phone=phonestr[0];//第一个参数是电话
			String code=phonestr[1];//第二个是验证码
			
			
			//下面是阿里云的短信业务
			 DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", " ", "   ");
		        IAcsClient client = new DefaultAcsClient(profile);

		        CommonRequest request = new CommonRequest();
		        request.setMethod(MethodType.POST);
		        request.setDomain("dysmsapi.aliyuncs.com");
		        request.setVersion("2017-05-25");
		        request.setAction("SendSms");
		        request.putQueryParameter("RegionId", "cn-hangzhou");
		        request.putQueryParameter("PhoneNumbers", phone);
		        request.putQueryParameter("SignName", "dreamwang");
		        request.putQueryParameter("TemplateCode", "   ");
		        request.putQueryParameter("TemplateParam", "{\"product\":\""+code+"\"}");
		        try {
		            CommonResponse response = client.getCommonResponse(request);
		            System.out.println(response.getData());
		        } catch (Exception e) {
		        	 
		        	throw new MyExpection("网络发生故障！！！！！");
		             
		        }
			
		}
}
