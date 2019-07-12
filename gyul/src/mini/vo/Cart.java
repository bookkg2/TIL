package mini.vo;

public class Cart {
	
	public int cart_id;
	public String cus_id;
	public int pro_no;
	public int cart_qt;
	public double cart_price;
	
	public Cart() {
		
	}

	public Cart(int cart_id, String cus_id, int pro_no, int cart_qt, double cart_price) {
		
		this.cart_id = cart_id;
		this.cus_id = cus_id;
		this.pro_no = pro_no;
		this.cart_qt = cart_qt;
		this.cart_price = cart_price;
	}

	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	public String getCus_id() {
		return cus_id;
	}

	public void setCus_id(String cus_id) {
		this.cus_id = cus_id;
	}

	public int getPro_no() {
		return pro_no;
	}

	public void setPro_no(int pro_no) {
		this.pro_no = pro_no;
	}

	public int getCart_qt() {
		return cart_qt;
	}

	public void setCart_qt(int cart_qt) {
		this.cart_qt = cart_qt;
	}

	public double getCart_price() {
		return cart_price;
	}

	public void setCart_price(double cart_price) {
		this.cart_price = cart_price;
	}

	@Override
	public String toString() {
		return "Cart [cart_id=" + cart_id + ", cus_id=" + cus_id + ", pro_no=" + pro_no + ", cart_qt=" + cart_qt
				+ ", cart_price=" + cart_price + "]";
	}
	
}
