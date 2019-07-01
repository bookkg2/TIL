package com.user;

import com.frame.Biz;
import com.vo.User;

public class DeleteText {

	public static void main(String[] args) {
		
		Biz biz= new UserBiz();
		String k = "id81";
		try {
			biz.remove(k);
			System.out.println("ok");
		}catch(Exception e) {
			e.printStackTrace();
		}
		

	}

}
