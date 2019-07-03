package com.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.frame.Biz;
import com.vo.User;

public class App {

	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("myspring.xml"); 
		
		Biz<String,User> biz = (Biz<String,User>) factory.getBean("ubiz"); 
		User user =new User("id02","pw02","�̸���");
		try {
			biz.register(user);
			System.out.println(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		factory.close();
	}

}
