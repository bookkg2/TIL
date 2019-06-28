package test;

import com.UserDao;

import frame.Dao;
import vo.User;

public class Userdelete {

	public static void main(String[] args) {
		Dao<String, User> dao = new UserDao();
		
		
		
			try {
				dao.delete("id56");
				System.out.println("User Delete");
			}catch(Exception e) {
				e.printStackTrace();
			}
		

	}

}
