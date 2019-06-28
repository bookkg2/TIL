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
				User u1 = new User(id , name , pwd);//User 객체에서 받아옴
				try {
					biz.register(u1);//Biz에서 등록하라고 던져줌 
					System.out.println("Insert Completed");
				} catch (Exception e) {
					
					System.out.println("Insert Error");
					System.out.println(e.getMessage());
					
				}
				
				break;
			case "g" :
				Biz<String, User> biz1 = new UserBiz();
				ArrayList<User> list = null; // 받을 거만 할거니 그냥 NUll
				try {
					list = biz1.get();//받을 준비!!
				    for(User u : list) {
				    	System.out.println(u);// 출력
				    }
				} catch (Exception e) {
					System.out.println(e.getMessage());// 예외 예시 : 현재 시스템 서버 오류 등등
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
