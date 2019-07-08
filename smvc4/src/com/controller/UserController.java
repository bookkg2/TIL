package com.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Biz;
import com.vo.User;


@Controller
public class UserController {
	
	@Resource(name="ubiz")
	Biz<String,User> biz;
	
	@RequestMapping("/useradd.mc")
	public ModelAndView uadd() {
		ModelAndView mv = new ModelAndView(); /* ModelAndView :필요한 argument -> 데이터와 화면 */
		mv.addObject("center","user/add");
		mv.addObject("navi",Navi.useradd);
		mv.setViewName("main");
		return mv;
	}
	
	@RequestMapping("/useraddimpl.mc")
	public ModelAndView useraddimpl(ModelAndView mv, User user) {
		try {
			biz.register(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.setViewName("main");
		return mv;
	}
	
	
	@RequestMapping("/userlist.mc")
	public ModelAndView ulist() {
		ModelAndView mv = new ModelAndView(); /* ModelAndView :필요한 argument -> 데이터와 화면 */
		ArrayList<User> dbuser = new ArrayList<>();
		try {
			dbuser = biz.get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.addObject("userlist",dbuser);
		mv.addObject("center","user/list");
		mv.addObject("navi	",Navi.userlist);
		mv.setViewName("main");
		return mv;
	}
	
	@RequestMapping("/userdetail.mc")
	public ModelAndView udetail(ModelAndView mv,String id) {
		
		User user =null;
		try {
			user = biz.get(id);
			mv.addObject("userdetail",user);
			mv.addObject("center","detail");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		mv.setViewName("main");
		return mv;
		
	}
	
	@RequestMapping("/userdelete.mc")
	public String udelete(ModelAndView mv,String id) {
		try {
			biz.remove(id);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return "redirect:userlist.mc";
	}
	
	@RequestMapping("/userupdate.mc")
	public ModelAndView uupdate(ModelAndView mv) {
		mv.addObject("center","update");
		mv.setViewName("main");
		
		return mv;
	
	}
	
	@RequestMapping("/userupdateimpl.mc")
	public String uupdate(User user,String id) {
		try {
			biz.modify(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:userdetail.mc?id=" + user.getId();
	
	}

}
