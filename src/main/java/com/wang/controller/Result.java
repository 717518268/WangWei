package com.wang.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wang.config.Contant;
import com.wang.pojo.Gift;
import com.wang.pojo.OrderTable;
import com.wang.pojo.User;
import com.wang.service.OrderTableService;
import com.wang.service.UserService;

@Controller
@RequestMapping("/Wang-Book")
public class Result {
	@Autowired
	private OrderTableService orderTableService;
	@Autowired
	private UserService userService;
	/**
	 **************************************************************
	 *                                                            *
	 *   .=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-.       *
	 *    |                     ______                     |      *
	 *    |                  .-"      "-.                  |      *
	 *    |                 /            \                 |      *
	 *    |     _          |              |          _     |      *
	 *    |    ( \         |,  .-.  .-.  ,|         / )    |      *
	 *    |     > "=._     | )(__/  \__)( |     _.=" <     |      *
	 *    |    (_/"=._"=._ |/     /\     \| _.="_.="\_)    |      *
	 *    |           "=._"(_     ^^     _)"_.="           |      *
	 *    |               "=\__|IIIIII|__/="               |      *
	 *    |              _.="| \IIIIII/ |"=._              |      *
	 *    |    _     _.="_.="\          /"=._"=._     _    |      *
	 *    |   ( \_.="_.="     `--------`     "=._"=._/ )   |      *
	 *    |    > _.="                            "=._ <    |      *
	 *    |   (_/                                    \_)   |      *
	 *    |                                                |      *
	 *    '-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-='      *
	 *                                                            *
	 *           LASCIATE OGNI SPERANZA, VOI CH'ENTRATE           *
	 **************************************************************
	 */

	/**
	 * 视图请求
	 * @return
	 */
	@RequestMapping("/result")
	public String getview2() {
		
		 
		return "result";
	}
	
	@RequestMapping("/getResultAll")
	@ResponseBody
	public List<OrderTable>getlistortableRequse(){
		
		List<OrderTable>list=orderTableService.selectAllOrderTablList();
		if(list!=null) {
			
		
		ArrayList<Integer>array=new ArrayList<Integer>();
		for (OrderTable orderTable : list) {
			 
			array.add(orderTable.getGid());
		}
		ArrayList<OrderTable>arrayreuslt=new ArrayList<OrderTable>();
		for (int i = 0; i < list.size(); i++) {
			
			OrderTable orderTable=orderTableService.selectOrderTablOneUser(array.get(i));
			//看完这行代码，不信你不鼓掌
			orderTable.getUser().setPhone(Contant.splitVAluePhone(orderTable.getUser().getPhone()));
			/*  转码 转成星号 */
			orderTable.setUser(orderTable.getUser());
					 
			arrayreuslt.add(orderTable);
		}
		
	 
		
		return arrayreuslt;
		}
		
		
		return null;
	}
	/**
	 *_______________#########_______________________
	 *______________############_____________________
	 *______________#############____________________
	 *_____________##__###########___________________
	 *____________###__######_#####__________________
	 *____________###_#######___####_________________
	 *___________###__##########_####________________
	 *__________####__###########_####_______________
	 *________#####___###########__#####_____________
	 *_______######___###_########___#####___________
	 *_______#####___###___########___######_________
	 *______######___###__###########___######_______
	 *_____######___####_##############__######______
	 *____#######__#####################_#######_____
	 *____#######__##############################____
	 *___#######__######_#################_#######___
	 *___#######__######_######_#########___######___
	 *___#######____##__######___######_____######___
	 *___#######________######____#####_____#####____
	 *____######________#####_____#####_____####_____
	 *_____#####________####______#####_____###______
	 *______#####______;###________###______#________
	 *________##_______####________####______________
	 */
	/**
	 * 根据电话查询
	 * @param phone
	 * @return
	 */
	@RequestMapping("/sendPhoneByUser")
	@ResponseBody
	public OrderTable sendPhoneByUser(String phone) {
		//System.out.println("获取到的电话"+phone);
		boolean phonefalg=Contant.isphone(phone);
		System.out.println("格式："+phonefalg);
		if(phonefalg) {
			User user= userService.selectFindPhone(phone);
			System.out.println("电话获取到的对象"+user);
			if(user!=null) {
				Integer gid=user.getGid();
				System.out.println("gid是："+gid);
				OrderTable orderTable=orderTableService.selectOrderTablOneUser(gid);
				System.out.println("遍历对象："+orderTable);
				if(orderTable!=null) {
				//	 System.out.println("111111111");
					return orderTable;
				}else {
				//	System.out.println("查无结果");
					return null;//查无结果
				}
			}else {
				//用户不存在；
			//	System.out.println("用户不存在");
				return null;
			}
		}else {
			//电话不合法；
		//	System.out.println("电话不合法");
			return null;
		}
	}
	
	
}
