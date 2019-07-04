package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MainController {
	
	@RequestMapping("/main.mc")
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView("main"); /* ModelAndView :�ʿ��� argument -> �����Ϳ� ȭ�� */
		mv.setViewName("main");
		return mv;
	}
	
	
}
