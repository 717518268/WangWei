package com.wang.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wang.pojo.Register;
import com.wang.pojo.RootUser;
import com.wang.service.RegisterService;

@Controller
@RequestMapping("/Wang-Book")
public class RegisterProjectsController {
	
	@Autowired
	private RegisterService registerService;
	
	private final String DefaultValue="------";
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
	@RequestMapping("/RegisterProjects")
	public String GetRegisterProjectsView(HttpSession request) {
		RootUser rootUser=(RootUser) request.getAttribute("rootuser");
		 
		if(rootUser==null) {
			return "lockscreen";
		}
		return "RegisterProjects";
	}
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

	@RequestMapping("/RegisterProjects2")
	public String GetRegisterProjectsView2(HttpSession request) {
		RootUser rootUser=(RootUser) request.getAttribute("rootuser");
		 
		if(rootUser==null) {
			return "lockscreen";
		}
		return "RegisterProjects2";
	}

	/**
	 *                                         ,s555SB@@&                          
	 *                                      :9H####@@@@@Xi                        
	 *                                     1@@@@@@@@@@@@@@8                       
	 *                                   ,8@@@@@@@@@B@@@@@@8                      
	 *                                  :B@@@@X3hi8Bs;B@@@@@Ah,                   
	 *             ,8i                  r@@@B:     1S ,M@@@@@@#8;                 
	 *            1AB35.i:               X@@8 .   SGhr ,A@@@@@@@@S                
	 *            1@h31MX8                18Hhh3i .i3r ,A@@@@@@@@@5               
	 *            ;@&i,58r5                 rGSS:     :B@@@@@@@@@@A               
	 *             1#i  . 9i                 hX.  .: .5@@@@@@@@@@@1               
	 *              sG1,  ,G53s.              9#Xi;hS5 3B@@@@@@@B1                
	 *               .h8h.,A@@@MXSs,           #@H1:    3ssSSX@1                  
	 *               s ,@@@@@@@@@@@@Xhi,       r#@@X1s9M8    .GA981               
	 *               ,. rS8H#@@@@@@@@@@#HG51;.  .h31i;9@r    .8@@@@BS;i;          
	 *                .19AXXXAB@@@@@@@@@@@@@@#MHXG893hrX#XGGXM@@@@@@@@@@MS        
	 *                s@@MM@@@hsX#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&,      
	 *              :GB@#3G@@Brs ,1GM@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@B,     
	 *            .hM@@@#@@#MX 51  r;iSGAM@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@8     
	 *          :3B@@@@@@@@@@@&9@h :Gs   .;sSXH@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@:    
	 *      s&HA#@@@@@@@@@@@@@@M89A;.8S.       ,r3@@@@@@@@@@@@@@@@@@@@@@@@@@@r    
	 *   ,13B@@@@@@@@@@@@@@@@@@@5 5B3 ;.         ;@@@@@@@@@@@@@@@@@@@@@@@@@@@i    
	 *  5#@@#&@@@@@@@@@@@@@@@@@@9  .39:          ;@@@@@@@@@@@@@@@@@@@@@@@@@@@;    
	 *  9@@@X:MM@@@@@@@@@@@@@@@#;    ;31\.         H@@@@@@@@@@@@@@@@@@@@@@@@@@:    
	 *   SH#@B9.rM@@@@@@@@@@@@@B       :.         3@@@@@@@@@@@@@@@@@@@@@@@@@@5    
	 *     ,:.   9@@@@@@@@@@@#HB5                 .M@@@@@@@@@@@@@@@@@@@@@@@@@B    
	 *           ,ssirhSM@&1;i19911i,.             s@@@@@@@@@@@@@@@@@@@@@@@@@@S   
	 *              ,,,rHAri1h1rh&@#353Sh:          8@@@@@@@@@@@@@@@@@@@@@@@@@#:  
	 *            .A3hH@#5S553&@@#h   i:i9S          #@@@@@@@@@@@@@@@@@@@@@@@@@A.
	 *
	 *
	 *    又看源码，看你妹妹呀！
	 */
	@RequestMapping("/getRegisters/UpdatePraises")
	@ResponseBody
	public List<Register>Get(){
		
		return GetListRegisterBooK();
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
	@RequestMapping("/getRegisters/FindId")
	@ResponseBody
	public Register GetRegisterRequest(Integer id) {
		 
	 
		
		return GetRegister(id);
	}
	
	public Register GetRegister(Integer id) {
		System.out.println("2");
		Register register=registerService.selectByPrimaryKey(id);
		if(register!=null) {
			 
			return register;
		}else {
			
			System.out.println("3");
			return null;
		}
		
		 
	}
	
	
	public List<Register>GetListRegisterBooK(){
		List<Register>list=registerService.selectRegisterListRanking();
		ArrayList<Register>registerlist=new ArrayList<>();
		for (Register register : list) {
			if(register!=null) {
				register.setEmail(DefaultValue);
				register.setPassword(DefaultValue);
				register.setPhone(DefaultValue);
				//过滤掉字段
				registerlist.add(register);
			}
			
		}
		//排序
		registerlist.sort((a,b)->b.getPraisecount().compareTo(a.getPraisecount()));
		return  registerlist;
	}
	
	
	/**
	 * 返回1时 成功
	 * 返回-1 输入的数字不符合
	 * @param id
	 * @param count
	 * @return
	 */
	@RequestMapping("/updateRegister/PraisesByID")
	@ResponseBody
	public Integer updatePraisesController(Integer id,Integer praisecount){
		if(praisecount!=null) {
			Register register=registerService.selectByPrimaryKey(id);
			if(register!=null) {
				Integer PraisesNumber=register.getPraisecount();
				PraisesNumber=PraisesNumber+praisecount;
				register.setPraisecount(PraisesNumber);
				int indexupdate=registerService.updateRegisterpPraiseCount(register);
				if(indexupdate>0) {
					return 1;
				}
			}else {
				return -2;//发生未知错误
			}
			 
		}
		
		 
			 
		 
		return -1;
	}
	
	
	
}
