package test;

import com.UserDao;

import frame.Dao;
import vo.User;

public class UserInsert {

	public static void main(String[] args) {
		Dao<String, User> dao = new UserDao();
		User user = new User("id55", "pwd55", "��ȿ��");
		User use2 = new User("id57", "pwd52", "��d��");
//		dao.insert(user);
		try {
			
			dao.insert(use2);
			System.out.println("User Inserted");
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
