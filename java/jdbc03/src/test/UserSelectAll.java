package test;

import com.UserBiz;
import com.UserDao;

import frame.Biz;
import frame.Dao;
import vo.User;

public class UserSelectAll {

	public static void main(String[] args) {
     Biz<String,User> biz = new UserBiz();
		
		try {
			biz.get();
			System.out.println("Select");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
