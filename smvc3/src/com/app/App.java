package com.app;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.frame.Biz;
import com.frame.Search;
import com.vo.Product;
import com.vo.User;

public class App {

	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("myspring.xml"); 
		Date date = new Date();
		
		Biz<String,User> biz = (Biz<String,User>) factory.getBean("ubiz");
//		Search<String,User> biz = (Search<String,User>) factory.getBean("ubiz");
		
//		try {
//			biz.remove(1);
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//		}
//		Product pro = new Product("TV3",9000,"ss3.jpg");
//		
//		try {
//			biz.register(pro);
//			System.out.println("Inserted ..");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		User user = new User();
//		
//		
//			 user=new User("id71","pw52","사랑한다고요");
//			 try {
//					biz.register(user);
//					System.out.println("Inserted ...");
//				} 
//		
//		
//		catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		
//		ArrayList<User> list = new ArrayList<>();
//		try {
//			list = biz.search("");
//			for(User u:list) {
//				System.out.println(u);
//			}
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		ArrayList<User> list = new ArrayList<>();
		try {
			list = biz.get();
			for(User u:list) {
				System.out.println(u);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		factory.close();
	}

}
