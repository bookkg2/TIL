package mini.controller;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import mini.frame.Biz;
import mini.vo.Customer;

@Controller
public class RegisterController {
	@Resource(name="cbiz")
	Biz<String,Customer> biz;

	@RequestMapping("/customerregister.mc")
	public ModelAndView cus_register(Customer customer) {
		ModelAndView mv = new ModelAndView();
		try {
			biz.register(customer);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.addObject("center","login");
		mv.setViewName("main");
		return mv;
	}
	
	@RequestMapping("/checkId.mc")
	@ResponseBody
	public ModelAndView checkId(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		String CUSTOMER_ID1 = request.getParameter("CUSTOMER_ID");
		String result="";
		try {
			Customer dbuser = biz.get(CUSTOMER_ID1);

			if(dbuser != null) {
				result = "1";
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.write(result);
				out.close();
			}else {
				result = "0";
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.write(result);
				out.close();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.addObject("center","register");
		mv.setViewName("main");
		return mv;
	}
}
