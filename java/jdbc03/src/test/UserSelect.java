package test;

import com.UserBiz;

import frame.Biz;
import vo.User;

public class UserSelect {

	public static void main(String[] args) {
		
		
		Biz<String,User> biz = new UserBiz();
		
		try {
			biz.get("id55");
			System.out.println("Select");
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
