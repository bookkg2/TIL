package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegidterController {
	@RequestMapping("register.mc")
	public ModelAndView register() {
		ModelAndView mv = new ModelAndView(); /* ModelAndView :필요한 argument -> 데이터와 화면 */
		mv.addObject("center","register");
		mv.addObject("navi",Navi.register);
		mv.setViewName("main");
		return mv;
	}
		
	
}
