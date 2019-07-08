package com.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Biz;
import com.vo.Product;


@Controller
public class ProductController {
	
	@Resource(name="pbiz")
	Biz<Integer,Product> biz;
	
	
	@RequestMapping("/productadd.mc")
	public ModelAndView padd() {
		ModelAndView mv = new ModelAndView(); /* ModelAndView :필요한 argument -> 데이터와 화면 */
		mv.addObject("center","product/add");
		mv.addObject("navi",Navi.productadd);
		mv.setViewName("main");
		return mv;
	}
	@RequestMapping("/productlist.mc")
	public ModelAndView plist() {
		ModelAndView mv = new ModelAndView(); /* ModelAndView :필요한 argument -> 데이터와 화면 */
		ArrayList<Product> list = null;
		try {
			list = biz.get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		mv.addObject("plist",list);
		mv.addObject("center","product/list");
		mv.addObject("navi",Navi.productlist);
				mv.setViewName("main");
		return mv;
	}
	@RequestMapping("/productaddimpl.mc")
	public ModelAndView paddimpl(ModelAndView mv, Product product) {
		
		String imgname = product.getMf().getOriginalFilename();
		product.setImgname(imgname);
		
		try {
			biz.register(product);
			Util.savrFile(product.getMf());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.setViewName("main");
		return mv;
		
	}
}
