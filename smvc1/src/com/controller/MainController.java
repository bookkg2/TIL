package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MainController {
	
	@RequestMapping("/main.mc")
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView("main"); /* ModelAndView :필요한 argument -> 데이터와 화면 */
		mv.setViewName("main");
		return mv;
	}
	
	
}
