package db3;

public class ProductDB extends DB<Product, Integer> {

	@Override
	public void insert(Product obj) {
		System.out.println(obj.id + " " + obj.getName() + " " + obj.getPrice() + " " + "Insert");
		
	}

	@Override
	public Product select(Integer obj) {
		Product p = null;
		System.out.println("Search : " + obj);// DB �������� ���� �°��� Key(id) ������
		p = new Product(200, "Pants",10000);
		return p;
	}

}
