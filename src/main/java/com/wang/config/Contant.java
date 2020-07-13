package com.wang.config;

public class Contant {
	//手机号
	 public static final String REGEX_MOBILE = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
	 
	 public static final String REGISTER_NUMBER="[0-9]{6}";
	 /**
	  * 匹配中文
	  * @param name
	  * @return
	  */
	 public static boolean ChineseNameTest(String name) {
		 if(name==null) {
			 return false;
		 }
		 if (!name.matches("[\u4e00-\u9fa5]{2,4}")) {
		 System.out.println("只能输入2到4个汉字");
		 return false;
		 }else {
			 return true;
		 }
		 
		 }
	 /**
	  * 匹配手机号码
	  * @param phone
	  * @return
	  */
	 public static boolean isphone(String phone) {
		 boolean falgphone;
			if(phone==null) {
				falgphone= false;
			}else {
				if(phone.matches(REGEX_MOBILE)){
					falgphone= true;
				}else{
					falgphone= false;
				}
				 
			}
			 return falgphone;
			 
		}
	 
	 
	 public static boolean isphoneCode(String code) {
		 if(code==null) {
			 return false;
		 }
		 if(code.matches(REGISTER_NUMBER)) {
			 System.out.println("符合"+code);
			 return true;
		 }else {
			 System.out.println("不符合"+code);
			 return false;
		 }
	 }
	 
	 /**
	  * 将字符串转成星号
	  * @param value
	  * @return
	  */
	 public static String splitVAluePhone(String value) {
		 
		String str= value.substring(3, value.length()-4);
		String str1="********";
		 str=str1;
		 String str2= value.substring(0,3);
		 String str3= value.substring(value.length()-4, value.length());
		 str2+=str+str3;
		  
		 return str2;
	 }
	
}
