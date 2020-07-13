package com.wang.controller;

 
import java.util.List;

 
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
 
import com.wang.pojo.Gift;
import com.wang.pojo.Number;
import com.wang.pojo.PhoneCount;
import com.wang.pojo.RootUser;
import com.wang.pojo.User;
import com.wang.service.GiftService;
import com.wang.service.NumberService;
import com.wang.service.PhoneCountService;
import com.wang.service.RedisTempService;
import com.wang.service.RootUserService;
import com.wang.service.UserService;

@Controller
@RequestMapping("/Wang-Book")
public class TimeLine {
	@Autowired
	private NumberService numberService;
	@Autowired
	private PhoneCountService phoneCountService;
	@Autowired
	private UserService userService;//用户
	@Autowired
	private RootUserService rootUserService;
	@Autowired
	private RedisTempService redisTempService;
	@Autowired
	private GiftService giftService;
	private static final String Start="start"; 
	private String  url;
	/**
	 *                  ___====-_  _-====___
	 *            _--^^^#####//      \\#####^^^--_
	 *         _-^##########// (    ) \\##########^-_
	 *        -############//  |\^^/|  \\############-
	 *      _/############//   (@::@)   \\############\_
	 *     /#############((     \\//     ))#############\
	 *    -###############\\    (oo)    //###############-
	 *   -#################\\  / VV \  //#################-
	 *  -###################\\/      \//###################-
	 * _#/|##########/\######(   /\   )######/\##########|\#_
	 * |/ |#/\#/\#/\/  \#/\##\  |  |  /##/\#/  \/\#/\#/\#| \|
	 * `  |/  V  V  `   V  \#\| |  | |/#/  V   '  V  V  \|  '
	 *    `   `  `      `   / | |  | | \   '      '  '   '
	 *                     (  | |  | |  )
	 *                    __\ | |  | | /__
	 *                   (vvv(VVV)(VVV)vvv)                
	 *                        神兽保佑
	 *                       代码无BUG!
	 */
	@RequestMapping("/timeline")
	public String TimeLineView(HttpSession request) {
		RootUser rootUser=(RootUser) request.getAttribute("rootuser");
		 
		if(rootUser==null) {
			return "lockscreen";
		}
		redisTempService.setString("rootus", rootUser);
		return "timeline";
	}
	@RequestMapping("/TphoneCountList")
	@ResponseBody
	public List<PhoneCount>getphoneCountServiceList(){
		return getServiceList();
	}
	@RequestMapping("/TphoneCountContent")
	@ResponseBody
	public Integer getPhoneNumber() {
		return getServiceList().size();
		
	}
	
	public List<PhoneCount>getServiceList(){
		
		List<PhoneCount> phoentlist=(List<PhoneCount>) redisTempService.getString("getServiceList100");
		if(phoentlist==null) {
			phoentlist= phoneCountService.selectAllPhoneCountList();
			redisTempService.setString("getServiceList100", phoentlist, 1600);
			return phoentlist;
		}
		return  phoentlist;
	}
	
	
	@RequestMapping("/TUserList")
	@ResponseBody
	public List<User>RequestGetUserList(){
		return GetUserList();
	}
	/***
	 * 获取用户数量
	 * @return
	 */
	@RequestMapping("/TUserContext")
	@ResponseBody
	public Integer RequestGetUserContent(){
		return GetUserList().size();
	}
	public List<User>GetUserList(){
		 List<User> redislist=(List<User>) redisTempService.getString("GetUserList110");
		if(redislist==null) {
			redislist=userService.selectByAllUser();
			redisTempService.setString("GetUserList110", redislist, 1600);
			return redislist;
		}
		return redislist ;
	}
	
	/**
	 * 记录电话表
	 * @return
	 */
	@RequestMapping("/TNumberList")
	@ResponseBody
	public List<Number>RequestNumberList(){
		return getNumberList();
	}
	
	@RequestMapping("/TNumberCount")
	@ResponseBody
	public Integer RequestNumberCount(){
		return getNumberList().size();
	}
	
	public List<Number>getNumberList(){
		List<Number>numberlist=(List<Number>) redisTempService.getString("numberlist100");
		if(numberlist==null) {
			numberlist=numberService.selectAllNumberList();
			redisTempService.setString("numberlist100", numberlist, 1600);
			return numberlist;
		}
		return  numberlist;
	}
	
	/**
	 * 修改活动状态
	 * @param value
	 * @param request
	 * @return
	 */
	@RequestMapping("/updateRootUserStart")
	@ResponseBody
	public Object updateStyer(@Param("value") String value,HttpSession request) {
		//System.out.println("value="+value);
	//	RootUser rootUser=(RootUser) request.getAttribute("rootuser");
		
		String key=Index.RedisSatutsKey;
		redisTempService.setString(key, value);
		try {
			RootUser rootUser=new RootUser();
			rootUser.setId(1);
			rootUser.setAtckass(value);
			
			int updateMessgaeStat=rootUserService.updateMessagent(rootUser);
			
			//rootUser=null;
			System.out.println("rootUser="+rootUser);
			return updateMessgaeStat>0?value:value;
		} catch (Exception e) {
			 
		}
		 
		
		
		return value;
	}
	
	@RequestMapping("/selectValueroot")
	@ResponseBody
	public String SelectRoot( HttpSession request) {
		RootUser rootUser=(RootUser) request.getAttribute("rootuser");
	//	System.out.println("查询状态"+rootUser);
		if(rootUser!=null) {
			String phone=rootUser.getUsername();
			RootUser rootuser= rootUserService.selectByRootUser(phone);
			 
			return rootuser.getAtckass();
		}
		//System.out.println("查询状态失败");
		return "ERROR";
		
	}
	@RequestMapping("/getmessgeCountN")
	@ResponseBody
	public Object getMessageCount(HttpSession request) {
		RootUser rootUser=(RootUser) request.getAttribute("rootuser");
		//	System.out.println("查询状态"+rootUser);
			if(rootUser!=null) {
				String phone=rootUser.getUsername();
				RootUser rootuser= rootUserService.selectByRootUser(phone);
				
				 
				return rootuser.getMessagecount();
			}
			return 0;
	}
	
	@RequestMapping("/UpdatemessgeCountN")
	@ResponseBody
	public Object UpdatetMessageCounts(HttpSession request,Integer count) {
		if(count==null) {
			return -1;
		}
		RootUser rootUser=(RootUser) request.getAttribute("rootuser");
		//	System.out.println("查询状态"+rootUser);
			if(rootUser!=null) {
				String phone=rootUser.getUsername();
				RootUser rootuser= rootUserService.selectByRootUser(phone);
				rootuser.setMessagecount(count);
				rootUserService.uMessagentCount(rootuser);//修改短信
				return rootuser.getMessagecount();
			}
			return 0;
	}
	
	
	/**
	 * 根据id删除 
	 * @param index
	 * @return
	 */
	 @RequestMapping("/deleteGitfById")
	 @ResponseBody
    public Integer getGiftListByDelete(Integer index){
		 System.out.println("============"+index);
		 int removeid=giftService.deleteByGiftGId(index);
		 System.out.println("removeid="+removeid);
		 if(removeid>0) {
			  redisTempService.deleteKey("getGiftList");//将redis的键删除
			  redisTempService.deleteKey("count");
			 return  1;
		 }
		return null;
    }
	 /**
	  * 	修改数量
	  * @param index
	  * @param count
	  * @return
	  */
	 @RequestMapping("/updateCountForRootUser")
	 @ResponseBody
	 public Integer updateCountForRootUser(Integer index,Integer count) {
		 if(index!=null&&count!=null) {
			Gift gitf=giftService.selectByGiftGId(index);
			if(gitf!=null) {
				 
				gitf.setCount(count);
				 
				int updatevalue=giftService.updateGiftCount(gitf);
				if(updatevalue>0) {
					try {
						redisTempService.deleteKey("getGiftList");//将redis的键删除
						  redisTempService.deleteKey("count");
					} catch (Exception e) {
						// TODO: handle exception
					}finally {
						return gitf.getCount();
					}
					 
					 
				}
			}
			
		 }else {
			 return -1;
		 }
		return 0;
		 
		 
	 }
    
 
	
}
