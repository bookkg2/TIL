package db3;

public class UserDB extends DB<User, String> {

	@Override
	public void insert(User obj) {
		System.out.println(obj.getId()+" " + obj.getName() + " " + "Inserted");
	}

	@Override
	public User select(String obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
