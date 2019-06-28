package ws;

import java.util.ArrayList;

public class UserDB extends DB<User, String> {
	

	@Override
	public void insert(User obj) {
		System.out.println(obj.getId() + " " + obj.getName() + " " + obj.getPwd() + " " + "Inserted");
		
	}

	@Override
	public User select(String obj) {
		
		return 0;
	}

	@Override
	public User selectAll(User obj) {
		
		return null;
	}

	@Override
	public User update(User obj) {
		
		return null;
	}

	@Override
	public void delete(String obj) {
	
		
	}

}
