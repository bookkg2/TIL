package db2;

public class DBuser extends DB {
	
	
	public DBuser(String ip) {
		super(ip);
	}

	@Override
	public void insert(Object obj) {
		connection();
		User user = (User)(obj);//obj ���� Ÿ�� ĳ����
		System.out.println(user.getId() + "Inserted");
		close();

	}

	@Override
	public Object select(Object obj) {//�޾ƿ� user ������ object ������ ���� 
		
		User user = null;
		String str = (String)obj;
		connection();
		
		user = new User("id02", "tom", "pwd02");
		close();
		return user;
	}

}
