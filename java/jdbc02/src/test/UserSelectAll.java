package test;

import com.UserDao;

import frame.Dao;
import vo.User;

public class UserSelectAll {

	public static void main(String[] args) {
		Dao<String, User> dao = new UserDao();
		
		
		
		try {
			dao.select();
			System.out.println("SelectAll...");
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
