package com.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.frame.Biz;
import com.user.User;

public class App {

	public static void main(String[] args) {
     AbstractApplicationContext factory = new GenericXmlApplicationContext("myspring.xml");//XML에서 자동적으로 모든 객체 생성
		
		System.out.println("Spring Started");
		
		Biz<String,User> biz = (Biz<String,User>)factory.getBean("ubiz");
		
		User user = new User("id01","pwd01","이말자");
		try {
			biz.insert(user);
			System.out.println("Inserted Ok From app.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		factory.close();

	}

}
