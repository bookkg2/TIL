package com.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.pro.Biz;

public class App {

	public static void main(String[] args) {
     AbstractApplicationContext factory = new GenericXmlApplicationContext("mydb.xml");//XML���� �ڵ������� ��� ��ü ����
		
		System.out.println("Spring Started");
		
		Biz biz = (Biz)factory.getBean("ubiz");
		biz.register();
		
		
		Biz biz2 = (Biz)factory.getBean("obiz");
		biz2.register();
		

	}

}