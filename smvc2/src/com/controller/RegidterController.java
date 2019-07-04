package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegidterController {
	@RequestMapping("register.mc")
	public ModelAndView register() {
		ModelAndView mv = new ModelAndView(); /* ModelAndView :�ʿ��� argument -> �����Ϳ� ȭ�� */
		mv.addObject("center","register");
		mv.addObject("navi",Navi.register);
		mv.setViewName("main");
		return mv;
	}
		
	
}
