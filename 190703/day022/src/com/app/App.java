package com.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.frame.Biz;
import com.product.Product;
import com.user.User;

public class App {

	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("myspring.xml");// XML에서 자동적으로 모든 객체 생성

		System.out.println("Spring Started");

		Biz<String, User> biz = (Biz<String, User>) factory.getBean("ubiz");
		User user = null;
		
		try {
			user = biz.select("id01");
			System.out.println(user);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
//		User user = new User("id01", "pwd01", "이말자");
//		try {
//			biz.insert(user);
//			System.out.println("Inserted Ok From app.");
//		} catch (Exception e) {
//
//			e.printStackTrace();
//		}

		factory.close();

		/*
		 * Biz<String,Product> biz = (Biz<String,Product>)factory.getBean("pb");
		 * 
		 * Product product = new Product("id05","NF",8000);
		 * 
		 * try { biz.insert(product); System.out.println("Insert ok"); } catch
		 * (Exception e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 * factory.close();
		 */

	}

}
