package mini.vo;

public class OrderDetail {
	public int ord_id;
	public int pro_id;
	String or_no;
	public int pro_qt;
	public double pro_price;
	public String ord_status;
	
	public OrderDetail() {
		
	}

	public OrderDetail(int ord_id, int pro_id, String or_no, int pro_qt, double pro_price, String ord_status) {
		this.ord_id = ord_id;
		this.pro_id = pro_id;
		this.or_no = or_no;
		this.pro_qt = pro_qt;
		this.pro_price = pro_price;
		this.ord_status = ord_status;
	}

	public int getOrd_id() {
		return ord_id;
	}

	public void setOrd_id(int ord_id) {
		this.ord_id = ord_id;
	}

	public int getPro_id() {
		return pro_id;
	}

	public void setPro_id(int pro_id) {
		this.pro_id = pro_id;
	}

	public String getOr_no() {
		return or_no;
	}

	public void setOr_no(String or_no) {
		this.or_no = or_no;
	}

	public int getPro_qt() {
		return pro_qt;
	}

	public void setPro_qt(int pro_qt) {
		this.pro_qt = pro_qt;
	}

	public double getPro_price() {
		return pro_price;
	}

	public void setPro_price(double pro_price) {
		this.pro_price = pro_price;
	}

	public String getOrd_status() {
		return ord_status;
	}

	public void setOrd_status(String ord_status) {
		this.ord_status = ord_status;
	}

	@Override
	public String toString() {
		return "OrderDetail [ord_id=" + ord_id + ", pro_id=" + pro_id + ", or_no=" + or_no + ", pro_qt=" + pro_qt
				+ ", pro_price=" + pro_price + ", ord_status=" + ord_status + "]";
	}
	
	
	
	
	
}
