package com.wang;

import org.mybatis.spring.annotation.MapperScan;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
 
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
 
 
@SpringBootApplication
@EnableAsync
@MapperScan("com.wang.dao")
@EnableScheduling
public class Application {

	public static void main(String[] args) {
		
		
		
		
		
		SpringApplication.run(Application.class, args);
		
		
		
	}
	 
	
	 

}