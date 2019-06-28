package test;

import com.UserDao;

import frame.Dao;
import vo.User;

public class UserSlect {

	public static void main(String[] args) {
		Dao<String, User> dao = new UserDao();
		
		
		
		try {
			dao.select("id55");
			System.out.println(" select");
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
