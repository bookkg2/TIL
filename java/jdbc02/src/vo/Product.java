package vo;

import java.sql.Date;

public class Product {//product 정보를 담는 객체 생성
	int id;
	String name;
	double price;
	Date regdate;
	public Product() {
		
	}
	
	public Product(int id, String name, double price, Date regdate) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.regdate = regdate;
	}

	public Product(int id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", regdate=" + regdate + "]";
	}

	

	
	
	
			

}
