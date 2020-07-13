package com.wang.controller;


import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wang.pojo.RootUser;
import com.wang.service.RootUserService;

@Controller
@RequestMapping("/Wang-Book")
public class LockScreen {
	@Autowired
	private RootUserService rootUserService;
	/**
	 * 					看 你妹啊
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
	 * 页面请求
	 * @return
	 */
	@RequestMapping("/lockscreen")
	public String LockScreenView() {
		
		return "lockscreen";
	}
	
	/**
	 * 表单请求
	 * @param username
	 * @param request
	 * @return
	 */
	@RequestMapping("/SendLocktimeline")
	 
	public String Href(String username,HttpSession request) {
		System.out.println("username="+username);
		if(username!=null) {
			String phone=username;
			RootUser rootuser= rootUserService.selectByRootUser(phone);
			if(rootuser!=null) {
				request.setAttribute("rootuser", rootuser);//填充到域中
				return "redirect:timeline";
			}
		}
		
		return "lockscreen";
	}
	
	@CrossOrigin
	@RequestMapping("/getValueDemo")
	@ResponseBody
	public Object getVAluedemo(String name) {
		System.out.println("hello进入请求域"+name);
		return "1223Value";
	}
	
	/**                              _
	 *  _._ _..._ .-',     _.._(`))
	 * '-. `     '  /-._.-'    ',/
	 *    )         \            '.
	 *   / _    _    |             \
	 *  |  a    a    /              |
	 *  \   .-.                     ;
	 *   '-('' ).-'       ,'       ;
	 *      '-;           |      .'
	 *         \           \    /
	 *         | 7  .__  _.-\   \
	 *         | |  |  ``/  /`  /
	 *        /,_|  |   /,_/   /
	 *           /,_/      '`-'
	 */

	@RequestMapping("/getValueDemo2")
	@ResponseBody
	public Object getVAluedemo2() {
		System.out.println("hello进入请求域");
		return "1223Value";
	}
}
