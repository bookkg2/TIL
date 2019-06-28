package com.sds.test;

import java.util.ArrayList;

import com.sds.component.UserBiz;
import com.sds.frame.Biz;
import com.sds.vo.User;

public class UserSelectAll {

	public static void main(String[] args) {
		Biz<String, User> biz = new UserBiz();
		ArrayList<User> list = null; // 받을 거만 할거니 그냥 NUll
		try {
			list = biz.get();
		    for(User u : list) {
		    	System.out.println(u);
		    }
		} catch (Exception e) {
			System.out.println(e.getMessage());// 예외 예시 : 현재 시스템 서버 오류 등등
		}

	}

}
