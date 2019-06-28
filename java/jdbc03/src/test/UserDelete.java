package test;

import com.UserBiz;

import frame.Biz;
import vo.User;

public class UserDelete {

	public static void main(String[] args) {
        Biz<String,User> biz = new UserBiz();
		
		try {
			biz.remove("id06");
			System.out.println("Delete");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
