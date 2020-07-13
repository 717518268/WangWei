package com.wang.scheduled;

import java.util.ArrayList;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

 
import com.wang.config.GetDate;
import com.wang.pojo.Number;
import com.wang.service.NumberService;
import com.wang.service.RedisTempService;
@Component
@Configuration
public class ScheduledUtil {
	@Autowired
	private RedisTempService redisTempService;
	@Autowired
	private  NumberService numberService;
	//reids的key
	private static final String HTTPCOUNT="httpcount";
	private static final Integer DefaultValue=0; 
	@Scheduled(cron="*/180 * * * * *")
    public void scheduledTask1(){
      //  System.out.println("定时任务1111"+new Date());
        Integer value=(Integer) redisTempService.getString(HTTPCOUNT);
        if(value!=null) {
        	//  System.out.println("定时取"+value);
              
              List<Number>list= numberService.selectAllNumberList();
              if(list!=null) {
            	  Number number= list.get(list.size()-1>0?list.size()-1:1);//在列表内去最后的一个
                  System.out.println(number);
                  number.setCount(number.getCount()+value);//总数+缓存数
                 int index= numberService.updateNumberCount(number);//更新语句
                 redisTempService.deleteKey(HTTPCOUNT);//更新访问量之后删除reids的key
              }
              
        } 
       
    }
	 //秒 分 时 天 月 年
	//每天中午12点添加新的，访问量
	@Scheduled(cron="0 0 12 * * ?")
    public void scheduledTask2(){
       // System.out.println("定时任务2222"+new Date());
        Number number=new Number();
        number.setCount(DefaultValue);//默认值为零
        number.setData(GetDate.getdate());//获取时间
        int indexnumber=numberService.insertNumber(number);
        
    }
	
	 //秒 分 时 天 月 年
	//每15天
	@Scheduled(cron="0 0 12 13 * ?")
	//@Scheduled(cron="*/10 * * * * *")
   public void scheduledTask3(){
		System.out.println("定时任务1111"+new Date());
		List<Number>list=numberService.selectAllNumberList();
		if(list.size()>14) {
			System.out.println("打印"+list.size());
			ArrayList<Integer>array=new ArrayList<Integer>(); 
			for (int i = 0; i <list.size(); i++) {
				if(i<12) {
					numberService.deleteNumberId(list.get(i).getId());
					 
				}
				 
			}
			 
			 
		}else {
			System.out.println("未达到条件");
		}
      
   }
	/**
	 * 0 0 10,14,16 * * ? 每天上午10点，下午2点，4点
       0 0/30 9-17 * * ?   朝九晚五工作时间内每半小时
       0 0 12 ? * WED 表示每个星期三中午12点
       "0 0 12 * * ?" 每天中午12点触发
       "0 15 10 ? * *" 每天上午10:15触发
       "0 15 10 * * ?" 每天上午10:15触发
       "0 15 10 * * ? *" 每天上午10:15触发
       "0 15 10 * * ? 2005" 2005年的每天上午10:15触发
       "0 * 14 * * ?" 在每天下午2点到下午2:59期间的每1分钟触发
       "0 0/5 14 * * ?" 在每天下午2点到下午2:55期间的每5分钟触发
       "0 0/5 14,18 * * ?" 在每天下午2点到2:55期间和下午6点到6:55期间的每5分钟触发
       "0 0-5 14 * * ?" 在每天下午2点到下午2:05期间的每1分钟触发
       "0 10,44 14 ? 3 WED" 每年三月的星期三的下午2:10和2:44触发
       "0 15 10 ? * MON-FRI" 周一至周五的上午10:15触发
       "0 15 10 15 * ?" 每月15日上午10:15触发
       "0 15 10 L * ?" 每月最后一日的上午10:15触发
       "0 15 10 ? * 6L" 每月的最后一个星期五上午10:15触发
       "0 15 10 ? * 6L 2002-2005" 2002年至2005年的每月的最后一个星期五上午10:15触发
       "0 15 10 ? * 6#3" 每月的第三个星期五上午10:15触发
	 */
}
