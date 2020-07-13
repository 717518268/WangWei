package com.wang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/Wang-Book")
public class SuccessController{
	
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

	 
	 @RequestMapping("/success")
	 public String SuccessView2() {
		 
		 return "success";
	 }
}
