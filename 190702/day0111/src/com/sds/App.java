package com.sds;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class App {

	public static void main(String[] args) {//IOC ���
		AbstractApplicationContext factory = new GenericXmlApplicationContext("myspring.xml");//XML���� �ڵ������� ��� ��ü ����
		
		System.out.println("Spring Started");
		
		/*STV tv = (STV)factory.getBean("stv");//��� 1) stv��� �̸��� ��û (String XML��), tv(�������̽�) �ּ��� ->stv �ּ���
		tv.turnOn();*/
		
		/*TV tv = (TV)factory.getBean("stv");//��� 2) tv(�������̽�) �ּ��� ->stv �ּ���
		tv.turnOn();*/
		
		/*
		 * TV tv = (TV)factory.getBean("ltv"); tv.up();
		 * 
		 * TV tv2 = (TV)factory.getBean("ltv"); tv2.turnOn();
		 * 
		 * if(tv == tv2) {//���۷��� Ȯ�ο� System.out.println("ok"); }
		 */
		
		TV tv = (TV)factory.getBean("stv"); // contructor Ȱ��
		tv.up();
		System.out.println(tv);
		
		TV tv2 = (TV)factory.getBean("ltv"); // 
		tv2.up();
		System.out.println(tv2);
	}

}