package set;

import java.util.ArrayList;

public class ListTest2 {

	public static void main(String[] args) {
		ArrayList<User> list = new ArrayList<>();//배열과 다른점 사이즈를 안정해도됨! , Type casting을 안해도됨 !
		
		list.add(new User("id01", "James","pwd01"));
		list.add(new User("id02", "James","pwd02"));
		list.add(new User("id03", "James","pwd03"));
		list.add(new User("id04", "James","pwd04"));
		list.add(new User("id05", "James","pwd05"));
		
		System.out.println(list.size());
		list.remove(3);//삭제 가능
		
		for(User u : list) {
			System.out.println(u);
		}

	}

}
