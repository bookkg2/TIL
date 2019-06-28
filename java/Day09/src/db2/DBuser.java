package db2;

public class DBuser extends DB {
	
	
	public DBuser(String ip) {
		super(ip);
	}

	@Override
	public void insert(Object obj) {
		connection();
		User user = (User)(obj);//obj 값을 타입 캐스팅
		System.out.println(user.getId() + "Inserted");
		close();

	}

	@Override
	public Object select(Object obj) {//받아온 user 정보를 object 리턴은 가능 
		
		User user = null;
		String str = (String)obj;
		connection();
		
		user = new User("id02", "tom", "pwd02");
		close();
		return user;
	}

}
