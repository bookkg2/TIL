package db;

public class App {

	public static void main(String[] args) {
		User user = new User("id01", "james", "pwd01");
//		Biz biz = new Instance("UserBiz");// Instance : biz�� �ִ� Userbiz�� ����ϰڽ��ϴ�. ������ ���� API�� ��� ���� ,.
		Biz biz = new UserBiz("192.168.111.100");
		biz.register(user);//�ڹ��� ����� ! ,register �� �߻��Լ��� �����ϱ� ���� !!
		biz.remove("id01");
		
		User dbuser = null;
		dbuser = (User)biz.get("id01");//object�� ���� �ü� ������ 
		System.out.println(dbuser);

	}

}
