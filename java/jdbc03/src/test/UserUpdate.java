package test;

import com.UserBiz;

import frame.Biz;
import vo.User;

public class UserUpdate {

	public static void main(String[] args) {
		User user = new User( "id55", "2222","김재영");
		Biz<String,User> biz = new UserBiz();
		try {
			biz.modify(user);
			System.out.println("수정완료 ");
		}catch(Exception e) {
			e.getStackTrace();
		}
	}

}
