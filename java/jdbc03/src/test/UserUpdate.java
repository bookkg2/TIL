package test;

import com.UserBiz;

import frame.Biz;
import vo.User;

public class UserUpdate {

	public static void main(String[] args) {
		User user = new User( "id55", "2222","���翵");
		Biz<String,User> biz = new UserBiz();
		try {
			biz.modify(user);
			System.out.println("�����Ϸ� ");
		}catch(Exception e) {
			e.getStackTrace();
		}
	}

}
