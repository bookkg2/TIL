package test;

import vo.User;

import com.UserBiz;

import frame.Biz;

public class UserInsert {

	public static void main(String[] args) {
		User u = new User("id67","pwd67","�̸���");//rollback ���ؼ� �ȵ�
		Biz<String, User> biz= new UserBiz();
		
		try {
			biz.register(u);
			System.out.println("OK");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
