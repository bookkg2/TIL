package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ProductController {
	
	
	
	@RequestMapping("/productadd.mc")
	public ModelAndView padd() {
		ModelAndView mv = new ModelAndView(); /* ModelAndView :�ʿ��� argument -> �����Ϳ� ȭ�� */
		mv.setViewName("product/add");
		return mv;
	}
	@RequestMapping("/productlist.mc")
	public ModelAndView plist() {
		ModelAndView mv = new ModelAndView(); /* ModelAndView :�ʿ��� argument -> �����Ϳ� ȭ�� */
		mv.setViewName("product/list");
		return mv;
	}
}
