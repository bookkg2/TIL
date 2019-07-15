package mini.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
