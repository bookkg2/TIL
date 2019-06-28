package com.sds.app;

import java.util.ArrayList;
import java.util.Scanner;

import com.sds.component.UserBiz;
import com.sds.frame.Biz;
import com.sds.vo.User;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Biz<String, User> biz = new UserBiz();
		
		out:
		while(true) {
			System.out.println("MENU :r,g,q..");
			String cmd = sc.next();
			switch(cmd) {
			case "r" :
				System.out.println("Input User Info");
				String id = sc.next();
				String pwd = sc.next();
				String name = sc.next();
				User u1 = new User(id , name , pwd);//User ��ü���� �޾ƿ�
				try {
					biz.register(u1);//Biz���� ����϶�� ������ 
					System.out.println("Insert Completed");
				} catch (Exception e) {
					
					System.out.println("Insert Error");
					System.out.println(e.getMessage());
					
				}
				
				break;
			case "g" :
				Biz<String, User> biz1 = new UserBiz();
				ArrayList<User> list = null; // ���� �Ÿ� �ҰŴ� �׳� NUll
				try {
					list = biz1.get();//���� �غ�!!
				    for(User u : list) {
				    	System.out.println(u);// ���
				    }
				} catch (Exception e) {
					System.out.println(e.getMessage());// ���� ���� : ���� �ý��� ���� ���� ���
				}
				
				
				break;
			case "q" : 
				System.out.println("Bye..");
				break out;
			}
		}
		sc.close();

	}

}
