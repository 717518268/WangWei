package com.wang.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.apache.juli.logging.Log;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wang.config.Contant;
import com.wang.config.GetCode;
import com.wang.config.GetDate;
import com.wang.enumcode.CodeEmunValue;
import com.wang.exception.MyExpection;
import com.wang.pojo.Advertising;
import com.wang.pojo.Gift;
import com.wang.pojo.OrderTable;
import com.wang.pojo.PhoneCount;
import com.wang.pojo.RootUser;
import com.wang.pojo.User;
import com.wang.service.AdvertisingServie;
import com.wang.service.AliYunPhoneMessageService;
import com.wang.service.GiftService;
import com.wang.service.OrderTableService;
import com.wang.service.PhoneCountService;
import com.wang.service.RedisTempService;
import com.wang.service.RootUserService;
import com.wang.service.UserService;
@Controller
@RequestMapping("/Wang-Book")
public class Index {
	@Autowired
	private GiftService giftService;
	/**
	 * 注入redis对象
	 */
	@Autowired
	private RedisTempService redisTempService;
	@Autowired
	private UserService userService;
	//阿里云实现
	@Autowired
	private AliYunPhoneMessageService aliYunPhoneMessageService;
	
	@Autowired
	private OrderTableService orderTableService;
	@Autowired
	private PhoneCountService phoneCountService;
	@Autowired
	private AdvertisingServie advertisingServie;
	//做定时一万秒
	private Integer GIFTTIME_10000=10000;
	
	private final Integer COUNT=1;  
	//默认值
	private final static Integer INDEX=1;
	@Autowired
	private RootUserService rootUserService;
	//登录
	private final static String USERROOT="15218327912";
	
	public final static String RedisSatutsKey="stauts";
	
	//线程本地
	private ThreadLocal<Integer>returnValue=new ThreadLocal<Integer>();
	
	private Logger log=Logger.getLogger(Index.class);
	
	/**
	 *  
	 *　　　　１１１　　　　　　　　　　　　　　　　　　　　　　　　　１　　　　　　　　　　　
	 *　　　　１１１　１１１１１１１１１１１１　　　　　　　　　　　１１１　　　　　　　　　　
	 *　　　　１１　　１１１１１１１１１１１１　　　　　　　　　　１１１１１　　　　　　　　　
	 *　　　　１１　　１１１　　　　　　　１１　　　　　　　　　１１１１１１１　　　　　　　　
	 *　　１１１１　１　１１１１１１１１１１１　　　　　　　　　１１１　１１１１　　　　　　　
	 *　　１１１１１１　１１１１１１１１１１１　　　　　　　１１１１　　　１１１１１　　　　　
	 *　　１１１１１１　１１　　　　　　　　　　　　　　　１１１１　　　　　１１１１１１　　　
	 *　　　　１１　　　１１１１１１１１　１１　　　　１１１１１１１１１１１１１１１１１１　　
	 *　　　　１１　　　１１１１１１１１１１１　　　１１１１１１１１１１１１１１１１１１１　　
	 *　　　　１１１１１１１１１　１１　　１１　　　　１１　　　　　　１１　　　　　　　　　　
	 *　　１１１１１１１１１１１１１１１１１１　　　　　　　　　　　　１１　　　　　　　　　　
	 *　　１１１１　　１１１１１１１１１１１１　　　　　　１１１１１１１１１１１１１１　　　　
	 *　　１１１１　　１１　　　　１１　　　　　　　　　　１１１１１１１１１１１１１１　　　　
	 *　　　　１１　　１１　１１　１１　　１１１　　　　　　１１　　　１１　　１１１　　　　　
	 *　　　　１１　　１１　１１　１１　　１１　　　　　　　１１１　　１１　　１１１　　　　　
	 *　　　　１１　１１１　１１　１１　　１１　　　　　　　　１１１　１１　１１１　　　　　　
	 *　　１１１１　１１１　１１１１１１１１１　　　　　１１　１１１　１１　１１１１１１１　　
	 *　　　１１１１１１　　１１１１１１１１１１　　　　１１１１１１１１１１１１１１１１１　　
	 *　　　１１　１１１　　　　　　　　　１１１　　　　１１１１１１１１１１１１１１１１１　　
	 */

	 
	/**
	 * 视图请求 
	 * @return
	 */
	@SuppressWarnings("static-access")
	@RequestMapping("/index")
	public String getview1() {
		 
		/**
		 * 页面请求时进行redis读写
		 */
		Integer value=(Integer) redisTempService.getString("httpcount");
		if(value==null) {
			value=0;
		}
		redisTempService.setString("httpcount",value+INDEX);
		 
		 
		
		return "index";
	}
	
	 
	
	/**
	 * 获取业务状态
	 * @return
	 */
	public String getSatuss() {
		String stauts=(String) redisTempService.getString(RedisSatutsKey);
		if(stauts==null) {
			RootUser rootuser=rootUserService.selectByRootUser(USERROOT);
			stauts=rootuser.getAtckass();
			 
			redisTempService.setString(RedisSatutsKey,  stauts);
			 
		}
		
		return stauts;
	}
	
	
	
	/**
	 *  加载数据
	 * @return
	 */
	@RequestMapping("/getGiftList")
	@ResponseBody
	public List<Gift> getGiftList(){
		List<Gift>gitflist=(List<Gift>) redisTempService.getString("getGiftList");
		if(gitflist==null) {
			gitflist=giftService.selectAllGiftList();
			redisTempService.setString("getGiftList", gitflist, 1600);
			 
		}
	 
		 
		return gitflist;
	}
	
	/**
	 *             ,%%%%%%%%,
	 *           ,%%/\%%%%/\%%
	 *          ,%%%\c "" J/%%%
	 * %.       %%%%/ o  o \%%%
	 * `%%.     %%%%    _  |%%%
	 *  `%%     `%%%%(__Y__)%%'
	 *  //       ;%%%%`\-/%%%'
	 * ((       /  `%%%%%%%'
	 *  \\    .'          |
	 *   \\  /       \  | |
	 *    \\/         ) | |
	 *     \         /_ | |__
	 *     (___________))))))) 渣瓦攻城湿
	 *
	 *        _       _
	 * __   _(_)_   _(_) __ _ _ __
	 * \ \ / / \ \ / / |/ _` |'_ \
	 *  \ V /| |\ V /| | (_| | | | |
	 *   \_/ |_| \_/ |_|\__,_|_| |_|
	 */
 
	/**
	 * 获取抽奖次数
	 * 从所有的count字段中的和
	 * @return
	 */
	@SuppressWarnings("all")
	@RequestMapping("/getCount")
	@ResponseBody
	public Integer getCountINGet() {
		Integer account=getCountAll();
		return account;
	}
	public Integer getCountAll() {
		Integer account=(Integer) redisTempService.getString("count");//取缓存的count
		List<Gift>list=redisTempService.getList("getGiftList", 0, -1);//取list模式集合
		int count = 0;
		if(list==null) {
			if(account==null) {//再判断缓存值中的account为空的情况下
			//	System.out.println("走数据库");
				list=giftService.selectAllGiftList();//去数据库查
				redisTempService.setList("getGiftList", list, GIFTTIME_10000);//拿到集合放进缓存
				for (Gift gift : list) {//累加
					count+=gift.getCount();
					//for切不可做增删改操作
				} 
				//把累加后的数量值存到redis里键为count
				redisTempService.setString("count", count, GIFTTIME_10000);
				return count;//然后返回
			}else {
			//	System.out.println("走缓存..");
				return account;//当account的缓存值不为空，直接返回这个值
			}	
		}else {
			if(account==null) {//再判断缓存值中的account为空的情况下
			//	System.out.println("走数据库");
				list=giftService.selectAllGiftList();//去数据库查
				redisTempService.setList("getGiftList", list, GIFTTIME_10000);//拿到集合放进缓存
				for (Gift gift : list) {//累加
					count+=gift.getCount();
				
				} 
				//把累加后的数量值存到redis里键为count
				redisTempService.setString("count", count, GIFTTIME_10000);
				return count;//然后返回
			}else {
				 
				return account;//当account的缓存值不为空，直接返回这个值
			}
		}
	}
	
	/**
	 * 发送手机验证码
	 * 返回值 -7短信操作数量不足
	 * 返回值 -6活动被管理员停止了
	 * 返回值 -5操作繁忙
	 * 返回值 -4 重复提交
	 * 返回值 -3用户手机已经注册了
	 * 返回值 -2汉字匹配不正确
	 * 返回值 -1手机号匹配不成功
	 * 返回值  0 抽奖次数用完了
	 * 返回值  1 成功返回
	 * @param phone
	 * @param name
	 * @return
	 * @throws MyExpection 
	 */
	@RequestMapping("/getPhoneCode")
	@ResponseBody
	public Integer getphoneCodeMethod(String phone,String name) throws MyExpection {
		 
		 
		
		String stauts=getSatuss();
		if(stauts.equals("stop")) {
			returnValue.set(CodeEmunValue.STOP.getCode());
			log.info(CodeEmunValue.STOP.getCode()+"=====>"+CodeEmunValue.STOP.getMessage());
			return returnValue.get();
		}
		
		Integer account=getCountAll();
		if(account==0) {
			returnValue.set(CodeEmunValue.OVER_ACTIVLE.getCode());
			log.info(CodeEmunValue.OVER_ACTIVLE.getCode()+"=====>"+CodeEmunValue.OVER_ACTIVLE.getMessage());
			return returnValue.get();//抽奖次数用完了
		}
		String novaluephone=(String) redisTempService.getString(phone);//防止用户重复点击获取验证码
		if(novaluephone!=null) {
			returnValue.set(CodeEmunValue.PHONE_CODE_ERROR.getCode());
			log.info(CodeEmunValue.PHONE_CODE_ERROR.getCode()+"=====>"+CodeEmunValue.PHONE_CODE_ERROR.getMessage());
			return returnValue.get();//操作繁忙
		}
		boolean phonefalg=Contant.isphone(phone);
		boolean namefalg=Contant.ChineseNameTest(name);
		if(phonefalg) {//true 表示这个手机号匹配成功
			if(namefalg) {//汉字正确
				User user=userService.selectFindPhone(phone);
				if(user==null) {//这个手机号尚未注册
					//可执行业务
					String code=GetCode.getMsgCode();
					 
					
					boolean phonevalue=phone.matches(Contant.REGEX_MOBILE);
					if(phonevalue==false){
						//手机号匹配不成功
						returnValue.set(CodeEmunValue.OPERATION_BUSY.getCode());
						log.info(CodeEmunValue.OPERATION_BUSY.getCode()+"=====>"+CodeEmunValue.OPERATION_BUSY.getMessage());
						//throw new MyExpection(CodeEmunValue.OPERATION_BUSY.getMessage());
						return returnValue.get();
					}
					 
					 
					/**
					 * 查短信可一用数start
					 */
					RootUser rootuser= rootUserService.selectByRootUser(USERROOT);
					if(rootuser!=null) {
						if(rootuser.getMessagecount()==0) {//等于
							returnValue.set(CodeEmunValue.MESSAGE_INSUFFICLIENT.getCode());
							log.info(CodeEmunValue.MESSAGE_INSUFFICLIENT.getCode()+"=====>"+CodeEmunValue.MESSAGE_INSUFFICLIENT.getMessage());
							return returnValue.get();//短信不足
						}
					}
					/**
					 * 查短信可一用数end
					 */
					
					
						PhoneCount phoneCount= phoneCountService.selectByPhoneCountPhoneValue(phone);
						if(phoneCount!=null) {
							if(phoneCount.getCount()<4) {//当手机号记录次数不超过4次时
								 
								//加一
								phoneCount.setCount((phoneCount.getCount()+1));
								Integer updatePhoneValue=phoneCountService.updatePhoneCount(phoneCount);//修改处理
								//System.out.println("修改处理："+updatePhoneValue);
								if(updatePhoneValue>0) {
									//System.out.println("记录次数增加"+phoneCount.getCount());
									redisTempService.setString(phone, code, 90);//设置定时90秒
									aliYunPhoneMessageService.sendAliyunMessage(phone, code);
									int mecount=rootuser.getMessagecount()-1;
									rootuser.setMessagecount(mecount);//短信次数减一
									int inc=rootUserService.uMessagentCount(rootuser);
									//System.out.println("inc="+inc+"&"+rootuser.getMessagecount());
									returnValue.set(CodeEmunValue.SUCCESS.getCode());
									log.info(CodeEmunValue.SUCCESS.getCode()+"=====>"+CodeEmunValue.SUCCESS.getMessage());
									return returnValue.get();//返回正确
								}
								 
							}else {//做手机超时处理
								//System.out.println("超时返回值....");
								returnValue.set(CodeEmunValue.OVER_TIME.getCode());
								log.info(CodeEmunValue.OVER_TIME.getCode()+"=====>"+CodeEmunValue.OVER_TIME.getMessage());
								return returnValue.get();//-5为超时返回值
							}
							///	
						}else {//第一次往当前手机号写进记录表
						 
						//	System.out.println("第一次往当前手机号写进记录表"+phoneCount);
							PhoneCount phoneCount2=new PhoneCount();
							phoneCount2.setPhone(phone);
							phoneCount2.setCount(COUNT);//第一次插入记录表，记录次数为1
							 
							int phoneIndex=phoneCountService.insertPhoneCount(phoneCount2);
							//System.out.println("结果："+phoneIndex);
							redisTempService.setString(phone, code, 90);//设置定时90
							if(phoneIndex>0) {//插入成功时才发送
								
								
								aliYunPhoneMessageService.sendAliyunMessage(phone, code);
								int mecount=rootuser.getMessagecount()-1;
								rootuser.setMessagecount(mecount);//短信次数减一
								int inc=rootUserService.uMessagentCount(rootuser);
								 
								returnValue.set(CodeEmunValue.SUCCESS.getCode());
								log.info(CodeEmunValue.SUCCESS.getCode()+"=====>"+CodeEmunValue.SUCCESS.getMessage());
								return returnValue.get();//返回正确
							}
							 
						}
						 
						/**
						 * 写进记录表里
						 */
						
						/**
						 * 发送验证码
						 */
				
				}else {
					returnValue.set(CodeEmunValue.HAVE_PHONE_ERRPR.getCode());
					log.info(CodeEmunValue.HAVE_PHONE_ERRPR.getCode()+"=====>"+CodeEmunValue.HAVE_PHONE_ERRPR.getMessage());
					return returnValue.get();//用户手机已经注册了
				}
			}else {//汉字匹配不正确
				returnValue.set(CodeEmunValue.NAME_ERROE.getCode());
				log.info(CodeEmunValue.NAME_ERROE.getCode()+"=====>"+CodeEmunValue.NAME_ERROE.getMessage());
				return returnValue.get();
			}
			 
		}else {//手机号匹配不成功
			returnValue.set(CodeEmunValue.OPERATION_BUSY.getCode());
			log.info(CodeEmunValue.OPERATION_BUSY.getCode()+"=====>"+CodeEmunValue.OPERATION_BUSY.getMessage());
			return returnValue.get();
		}
		
		return returnValue.get();
		 
	}
	
	
	/**
	 * 返回值 -1 手机号匹配不成功
	 * 返回值 -2 汉字匹配不正确
	 * 返回值 -3 用户手机已经注册了
	 * 返回值 -8 用户还没获取获取验证码
	 * 返回值 -9 验证码格式不对
	 * 返回值 -10 验证码不正确
	 * 返回值 1 成功
	 * @param phone
	 * @param name
	 * @param phoneCode
	 * @return
	 */
	@RequestMapping("/getAllContent")
	@ResponseBody
	public Object chenckEnd(String phone,String name,String phoneCode) {
		 
		Integer account=getCountAll();
		returnValue.set(account);
		if(returnValue.get()==0) {
			returnValue.set(CodeEmunValue.OVER_ACTIVLE.getCode());
			log.info(CodeEmunValue.OVER_ACTIVLE.getCode()+"=====>"+CodeEmunValue.OVER_ACTIVLE.getMessage());
			return returnValue.get();//抽奖次数用完了
		}
		 
		String novaluephone=(String) redisTempService.getString(phone);//用户还没获取获取验证码
		if(novaluephone==null) {
			returnValue.set(CodeEmunValue.PHONE_CODE_ERROR.getCode());
			log.info(CodeEmunValue.PHONE_CODE_ERROR.getCode()+"=====>"+CodeEmunValue.PHONE_CODE_ERROR.getMessage());
			return returnValue.get();
		} 
		System.out.println("取到redis验证码了"+novaluephone);
		boolean phonefag=Contant.isphone(phoneCode);
		if(!phonefag) {
			returnValue.set(CodeEmunValue.CODE_MATTHE.getCode());
			log.info(CodeEmunValue.CODE_MATTHE.getCode()+"=====>"+CodeEmunValue.CODE_MATTHE.getMessage());
			return returnValue.get();//验证码格式不对-9
		}
		
		boolean phonefalg=Contant.isphone(phone);
		boolean namefalg=Contant.ChineseNameTest(name);
		
		 
		if(phonefalg) {//true 表示这个手机号匹配成功
			if(namefalg) {//汉字正确
				User user1=userService.selectFindPhone(phone);
				if(user1==null) {//这个手机号尚未注册
					//可执行业务
					System.out.println("输入的验证码:"+phoneCode+"\t短信的验证码是："+novaluephone);
					if(phoneCode.equals(novaluephone)) {
						//执行操作
						List<Gift>list=giftService.selectAllGiftList();
						ArrayList<Gift>array=new ArrayList<>();
						for (Gift gift : list) {
							if(gift.getCount()>0) {//根据count大于零的时候就往集合里放数据
								array.add(gift);//过滤掉数量为零的礼物
							}
						} 
						int index=new Random().nextInt(array.size());
						//获取集合里随机的值
						Gift gift= array.get(index);
						 
						 User user=Set_User(name, novaluephone, gift.getGid());
					//	System.out.println("========2======value:"+content);
						//生成OrderTable
						OrderTable orderTable= Set_Controller_OrderTable(gift);//
						User user2=userService.selectFindPhone(phone);
						//因为取不到uid，所以再调用一次根据电话号码查询
						orderTable.setUid(user2.getUid());//把uid设置进去
						int inse=orderTableService.insertOrderTabl(orderTable);
						OrderTable orderTable2=orderTableService.selectByOrderUId(user2.getUid());
						//再查一次
						 
						gift.setCount(gift.getCount()-1);//库存减一
						int value2=giftService.updateGiftCount(gift);
						int value3=giftService.updateGiftGid(gift);
						//修改gid
						User user3=new User();
						user3.setUid(user2.getUid());
						user3.setGid(orderTable2.getGid());//获取自增的gid
						int value4=userService.updateByGid(user3);
						
						redisTempService.deleteKey("count");
						redisTempService.deleteKey("getGiftList");
						//执行结束
						returnValue.set(CodeEmunValue.SUCCESS.getCode());
						log.info(CodeEmunValue.SUCCESS.getCode()+"=====>"+CodeEmunValue.SUCCESS.getMessage());
						return returnValue.get();
					}else {
						returnValue.set(CodeEmunValue.CODE_ERROE.getCode());
						log.info(CodeEmunValue.CODE_ERROE.getCode()+"=====>"+CodeEmunValue.CODE_ERROE.getMessage());
						return returnValue.get();//验证码不正确-10
					}
					 
					 
				}else {//用户手机已经注册了
					returnValue.set(CodeEmunValue.HAVE_PHONE_ERRPR.getCode());
					log.info(CodeEmunValue.HAVE_PHONE_ERRPR.getCode()+"=====>"+CodeEmunValue.HAVE_PHONE_ERRPR.getMessage());
					return returnValue.get(); 
				}
			}else {//汉字匹配不正确
				returnValue.set(CodeEmunValue.NAME_ERROE.getCode());
				log.info(CodeEmunValue.NAME_ERROE.getCode()+"=====>"+CodeEmunValue.NAME_ERROE.getMessage());
				return returnValue.get();
			}
			 
		}else {//手机号匹配不成功
			returnValue.set(CodeEmunValue.OPERATION_BUSY.getCode());
			log.info(CodeEmunValue.OPERATION_BUSY.getCode()+"=====>"+CodeEmunValue.OPERATION_BUSY.getMessage());
			return returnValue.get();
		}
		
	}
	
	
	/**
	 * 广告随机一条
	 * @return
	 */
	//advertisingServie
	@RequestMapping("/getAdvertising")
	@ResponseBody
	public Advertising getAdvertising(){
		 
		 
		List<Advertising>Advertisinglist=advertisingServie.selectAdvertisingList();
		if(Advertisinglist!=null){
			 
			 
			 int index=new Random().nextInt((Advertisinglist.size()));
		 
			 
				return Advertisinglist.get(index);
			 
		}
		 int index=new Random().nextInt((Advertisinglist.size()));
			 
	 
	return Advertisinglist.get(index);
	}
	
	
	/**
	 * 
	 * @param gift
	 * @return
	 */
	public OrderTable Set_Controller_OrderTable(Gift gift){
		OrderTable orderTable=new OrderTable();
		orderTable.setContentname(gift.getContentname());
		orderTable.setTitle(gift.getTitle());
		orderTable.setImage(gift.getImage());
		orderTable.setTime(GetDate.getdate());//重新设置时间
		orderTable.setCount(gift.getCount());//先将值赋进
		return orderTable;
	}
	 
	public User Set_User(String name,String phone,Integer gid){
		 User user=new User();
			user.setName(name);
			user.setPhone(phone);
			user.setGid(gid);
			int content=userService.insertUser(user);//插入用户表
			 
			return content>0?user:null;
	}
	
}
