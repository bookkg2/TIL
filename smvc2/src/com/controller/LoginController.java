package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	@RequestMapping("/login.mc")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView(); /* ModelAndView :�ʿ��� argument -> �����Ϳ� ȭ�� */
		mv.addObject("center","login");
		mv.addObject("navi",Navi.login);
		mv.setViewName("main");
		return mv;
	}
}
