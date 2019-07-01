package com.user;

import com.frame.Biz;
import com.frame.Dao;
import com.vo.User;

public class InsertText {

	public static void main(String[] args) {
		User us = new User("id81","3333","일만수");
		Biz<String,User> biz= new UserBiz();
		
		try {
			biz.register(us);
			System.out.println("ok");
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
