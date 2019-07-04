package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserController {
	
	
	
	@RequestMapping("/useradd.mc")
	public ModelAndView uadd() {
		ModelAndView mv = new ModelAndView(); /* ModelAndView :필요한 argument -> 데이터와 화면 */
		mv.addObject("center","user/add");
		mv.addObject("navi",Navi.useradd);
		mv.setViewName("main");
		return mv;
	}
	
	@RequestMapping("/userlist.mc")
	public ModelAndView ulist() {
		ModelAndView mv = new ModelAndView(); /* ModelAndView :필요한 argument -> 데이터와 화면 */
		mv.addObject("center","user/list");
		mv.addObject("navi",Navi.userlist);
		mv.setViewName("main");
		return mv;
	}

}
