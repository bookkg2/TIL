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
		dbuser = (User)db.select("id02");//코드상에는 Object 되어 있으니 타입 캐스트 
		System.out.println(dbuser);

	}

}
