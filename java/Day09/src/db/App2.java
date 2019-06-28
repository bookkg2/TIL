package db;

public class App2 {

	public static void main(String[] args) {
//		Biz biz = null;
		Product product = new Product("id03" , "pants", 10000);
		
		Biz biz = new ProductBiz("192.168.111.100");
		biz.register(product);

	}

}
