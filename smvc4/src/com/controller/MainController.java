package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Biz;
import com.vo.Product;
import com.vo.User;



@Controller
public class MainController {
	@Resource(name="ubiz")
	Biz<String,User> biz;
	
	@Resource(name="pbiz")
	Biz<Integer,Product> pbiz;
	
	
	@RequestMapping("/main.mc")
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView("main"); /* ModelAndView :필요한 argument -> 데이터와 화면 */
		mv.setViewName("main");
		return mv;
	}
	
	@RequestMapping("/login.mc")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView(); /* ModelAndView :필요한 argument -> 데이터와 화면 */
		mv.addObject("center","login");
		mv.addObject("navi",Navi.login);
		mv.setViewName("main");
		return mv;
	}
	
	@RequestMapping("/loginimpl.mc")
	public ModelAndView loginimpl(ModelAndView mv,
			HttpServletRequest request,
			HttpSession session) {
		String id= request.getParameter("id");
		String pwd= request.getParameter("pwd");
		
		try {
			User dbuser = biz.get(id);
			if(pwd.equals(dbuser.getPwd())) {
				session.setAttribute("loginuser", dbuser);
				mv.addObject("center","loginok");
			}else {
				mv.addObject("center","loginfail");
			}
		} catch (Exception e) {
			mv.addObject("center","loginfail");
			e.printStackTrace();
		}
		
		
		mv.setViewName("main");
		return mv;
		
	}
	
	@RequestMapping("/logout.mc")
	public ModelAndView logout(ModelAndView mv,
			HttpSession session) {
		if(session != null) {
			session.invalidate();
		}
		
		mv.setViewName("main");
		return mv;
		
	}
	
	@RequestMapping("/aboutus.mc")
	public ModelAndView aboutus() {
		ModelAndView mv = new ModelAndView(); /* ModelAndView :필요한 argument -> 데이터와 화면 */
		mv.addObject("center","aboutus");
		mv.addObject("navi",Navi.aboutus);
		mv.setViewName("main");
		return mv;
	}
	@RequestMapping("register.mc")
	public ModelAndView register() {
		ModelAndView mv = new ModelAndView(); /* ModelAndView :필요한 argument -> 데이터와 화면 */
		mv.addObject("center","register");
		mv.addObject("navi",Navi.register);
		mv.setViewName("main");
		return mv;
	}
		
	
	@RequestMapping("/pdata.mc")
	@ResponseBody
	public void pdata(HttpServletResponse rep) {
		ArrayList<Product> plist = null;
		
		try {
			plist = pbiz.get();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		JSONArray ja = new JSONArray();
		for(Product p : plist) {
			JSONObject jo = new JSONObject();
			jo.put("name", p.getName());
			jo.put("y", p.getPrice());
			ja.add(jo);
		}
		PrintWriter out = null;
		try {
			rep.setCharacterEncoding("EUC-KR");
			rep.setContentType("text/json;charset=UTF-8");
			out = rep.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print(ja.toJSONString());
		
	}
	

	
}
