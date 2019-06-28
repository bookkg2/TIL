package db;

public class ProductDao extends Dao {
	
	
	public ProductDao() {
		
	}
	public ProductDao(String ip) {
		super(ip);
	}
	
	@Override
	public void insert(Object obj) {
		connection();
		Product product = (Product)obj;
		System.out.println(product.getId() + " " + product.getName() + " " + product.getPrice() + " " + "Inserted...");
		close();

	}

	@Override
	public Object select(Object obj) {
		Product product = null;
		String str = (String)obj;
		//DB에서 SELECT해서 데이터를 가지고 온다.
		connection();
		product = new Product("id01" , "pants" , 10000);
		close();
		return product;
	}

	@Override
	public void delete(Object obj) {
		String str = (String)obj;
		connection();
		System.out.println(str+ "Deleted.....");
		close();
		

	}

}
