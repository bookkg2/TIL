package db2;

public class App {

	public static void main(String[] args) {
		String id = "id02 ";
		String name = "tom";
		String pwd = "pow02";
		
		DB db = new DBuser("192.100.100.1");
		
		
		User user = new User(id, name, pwd);
		db.insert(user);
		
		User dbuser = null;
		dbuser = (User)db.select("id02");//�ڵ�󿡴� Object �Ǿ� ������ Ÿ�� ĳ��Ʈ 
		System.out.println(dbuser);

	}

}
