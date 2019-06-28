package db3;

public class App {

	public static void main(String[] args) {
		@SuppressWarnings("rawtypes")//난 Generic을 안 쓰겠다. 
		DB<User, String>  db= new UserDB();
		
		User user= new User("id01", "james","pwd01");
		db.insert(user);
		
		DB<Product, Integer> db2 = new ProductDB();
		db2.insert(new Product(100,"T",10000));
		Product p = db2.select(200);
		System.out.println(p);
	}

}
