package mini.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



import mini.frame.Biz;



import mini.vo.Customer;

@Controller
public class MainController {
	@Resource(name="cbiz")
	Biz<String,Customer> biz;
	
	@RequestMapping("/main.mc")
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		return mv;
	}
	
	@RequestMapping("/loginimpl.mc")
	public ModelAndView loginimpl(ModelAndView mv,
			HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		String CUSTOMER_ID= request.getParameter("CUSTOMER_ID");
		String CUSTOMER_PWD= request.getParameter("CUSTOMER_PWD");
		
		try {
			Customer dbuser = biz.get(CUSTOMER_ID);
			if(CUSTOMER_PWD.equals(dbuser.getCUSTOMER_PWD())) {
				session.setAttribute("loginuser", dbuser);
				mv.addObject("center","center");
				
				
			}else {
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				
				out.println("<script>alert('비밀번호가 틀렸습니다.'); location.href='login.mc'</script>");
				out.flush();
			}
		} catch (Exception e) {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out;
			try {
				out = response.getWriter();
				out.println("<script>alert('아이디가 틀렸습니다.'); location.href='login.mc'</script>");
				out.flush();
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
			
			
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
	
	@RequestMapping("/customerupdate.mc")
	public ModelAndView cupdate(ModelAndView mv,
			String CUSTOMER_ID) {
		Customer customer =null;
		try {
			customer = biz.get(CUSTOMER_ID);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.addObject("customerupdate",customer);
		mv.addObject("center","cupdate");
		mv.setViewName("main");
		
		return mv;
		
	}

	@RequestMapping("/customerupdateimpl.mc")
	public ModelAndView uupdcustomerupdateimplate(HttpServletRequest request,Customer customer,String CUSTOMER_ID,HttpServletResponse response) {
		ModelAndView mv= new ModelAndView();
		System.out.println(customer);
		try {
			biz.modify(customer);
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out;
			
				out = response.getWriter();
				out.println("<script>alert('수정되었습니다.'); location.href='main.mc'</script>");
				out.flush();
				
				mv.addObject("center","cupdate");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mv.setViewName("main");
		return mv;
	
	}
	
	
	
	
}
