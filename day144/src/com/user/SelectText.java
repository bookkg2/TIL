package com.user;

import com.frame.Biz;
import com.vo.User;

public class SelectText {

	public static void main(String[] args) {
		Biz<String,User> biz = new UserBiz();
		
		try {
			biz.get();
			System.out.println("ok");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
