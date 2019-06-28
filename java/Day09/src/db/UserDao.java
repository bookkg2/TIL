package db;

public class UserDao extends Dao {
	public UserDao() {
		
	}
	public UserDao(String ip) {
		super(ip);
	}
	@Override
	public void insert(Object obj) {//User ��ü�� �־� �ָ�� .
		connection();
		User user = (User)obj;
		System.out.println(user.getId() + " " + user.getName() + " " + user.getPwd()+ "Inserted...");
		close();

	}

	@Override
	public Object select(Object obj) {
		User user = null;
		String str = (String)obj;
		//DB���� SELECT�ؼ� �����͸� ������ �´�.
		connection();
		user = new User("id01" , "Tom" , "pwd01");
		close();
		return user;
	}

	@Override
	public void delete(Object obj) {
	
		String str = (String)obj;
		connection();
		System.out.println(str+ "Deleted.....");
		close();
		

	}

}
