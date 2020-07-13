package com.wang.controller;

import java.io.File;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.wang.config.GetDate;
import com.wang.pojo.Gift;
import com.wang.pojo.RootUser;
import com.wang.service.GiftService;

@Controller
@RequestMapping("/Wang-Book")
public class RootUserController {
	private String  url;
	@Autowired
	private GiftService giftService;
	/**
	 *
	 *
	 *                                                    __----~~~~~~~~~~~------___
	 *                                   .  .   ~~//====......          __--~ ~~
	 *                   -.            \_|//     |||\\  ~~~~~~::::... /~
	 *                ___-==_       _-~o~  \/    |||  \\            _/~~-
	 *        __---~~~.==~||\=_    -_--~/_-~|-   |\\   \\        _/~
	 *    _-~~     .=~    |  \\-_    '-~7  /-   /  ||    \      /
	 *  .~       .~       |   \\ -_    /  /-   /   ||      \   /
	 * /  ____  /         |     \\ ~-_/  /|- _/   .||       \ /
	 * |~~    ~~|--~~~~--_ \     ~==-/   | \~--===~~        .\
	 *          '         ~-|      /|    |-~\~~       __--~~
	 *                      |-~~-_/ |    |   ~\_   _-~            /\
	 *                           /  \     \__   \/~                \__
	 *                       _--~ _/ | .-~~____--~-/                  ~~==.
	 *                      ((->/~   '.|||' -_|    ~~-/ ,              . _||
	 *                                 -_     ~\      ~~---l__i__i__i--~~_/
	 *                                 _-~-__   ~)  \--______________--~~
	 *                               //.-~~~-~_--~- |-------~~~~~~~~
	 *                                      //.-~~~--\
	 *                               神兽保佑
	 *                              代码无BUG!
	 */

	 
	@RequestMapping("/rootuserView")
	public String getRootUserView(HttpSession request) {
		RootUser rootUser=(RootUser) request.getAttribute("rootuser");
		 
		if(rootUser==null) {
			return "lockscreen";
		}
		return "rootUser";
	}
	/**
	 *
	 *
	 *                                                    __----~~~~~~~~~~~------___
	 *                                   .  .   ~~//====......          __--~ ~~
	 *                   -.            \_|//     |||\\  ~~~~~~::::... /~
	 *                ___-==_       _-~o~  \/    |||  \\            _/~~-
	 *        __---~~~.==~||\=_    -_--~/_-~|-   |\\   \\        _/~
	 *    _-~~     .=~    |  \\-_    '-~7  /-   /  ||    \      /
	 *  .~       .~       |   \\ -_    /  /-   /   ||      \   /
	 * /  ____  /         |     \\ ~-_/  /|- _/   .||       \ /
	 * |~~    ~~|--~~~~--_ \     ~==-/   | \~--===~~        .\
	 *          '         ~-|      /|    |-~\~~       __--~~
	 *                      |-~~-_/ |    |   ~\_   _-~            /\
	 *                           /  \     \__   \/~                \__
	 *                       _--~ _/ | .-~~____--~-/                  ~~==.
	 *                      ((->/~   '.|||' -_|    ~~-/ ,              . _||
	 *                                 -_     ~\      ~~---l__i__i__i--~~_/
	 *                                 _-~-__   ~)  \--______________--~~
	 *                               //.-~~~-~_--~- |-------~~~~~~~~
	 *                                      //.-~~~--\
	 *                               神兽保佑
	 *                              代码无BUG!
	 */

	 
	 @RequestMapping(value="/uploadFile",produces="application/json;charset=UTF-8")
	   // @ResponseBody
	    public String uploadFile(@RequestParam("title")String title,
	    		@RequestParam("contentname")String contentname,
	    		@RequestParam("fileName") MultipartFile file,
	    		@RequestParam("count")Integer count,
	    		HttpServletRequest request) {
	 
	      // System.out.println("title="+title);
	     //  System.out.println("contentname="+contentname);
	      // System.out.println("count="+count);
	       
	        //判断文件是否为空
	        if (file.isEmpty()) {
	            return "上传文件不可为空";
	        }
	 
	 
	        // 获取文件名
	        String fileName = file.getOriginalFilename();
//	        System.out.print("上传的文件名为: "+fileName+"\n");
	 
	        fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + fileName;
	        System.out.print("（加个时间戳，尽量避免文件名称重复）保存的文件名为: "+fileName+"\n");
	 
	 
	        //加个时间戳，尽量避免文件名称重复
	      //  String path = "image/" +fileName;
	        String path = request.getSession().getServletContext().getRealPath("image/");
	        //String path = "E:/fileUpload/" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + fileName;
	        //文件绝对路径
	        path+=fileName;
	        System.out.print("保存文件绝对路径"+path+"\n");
	 
	        //创建文件路径
	        File dest = new File(path);
	 
	        //判断文件是否已经存在
	        if (dest.exists()) {
	            return "文件已经存在";
	        }
	 
	        //判断文件父目录是否存在
	        if (!dest.getParentFile().exists()) {
	            dest.getParentFile().mkdir();
	        }
	 
	        try {
	            //上传文件
	            file.transferTo(dest); //保存文件
	            System.out.print("保存文件路径"+path+"\n");
	            //url="http://你自己的域名/项目名/images/"+fileName;//正式项目
	            url="http://localhost:9001/image/"+fileName;//本地运行项目
	            System.out.println("fileName="+fileName);
	            System.out.println("path="+path);
	            System.out.println("url="+url);
	            Gift gift=new Gift();
	            gift.setTitle(title);
	            gift.setContentname(contentname);
	            gift.setImage(url);
	            gift.setCount(count);
	            gift.setTime(GetDate.getdate2noyear());
	            System.out.println(gift);
	           int inserIndex= giftService.insertGift(gift);
	           // int jieguo= giftService.insertGift(fileName,path,url);
	         //   System.out.print("插入结果"+jieguo+"\n");
	            System.out.print("保存的完整url===="+url+"\n");
	 
	        } catch (IOException e) {
	        	
	            return "500";
	        }
	        
	 
	        return "redirect:success";
	    }
	
	 
}
