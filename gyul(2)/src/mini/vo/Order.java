package mini.vo;

import java.util.Date;

public class Order {
  
  String or_no;
  String cus_id;
  Date or_date;
  double or_price;
  int or_qt;
  String or_addr;
  String or_contactNo;
  String or_payment;
 public Order() {
	
 }
public Order(String or_no, String cus_id, Date or_date, double or_price, int or_qt, String or_addr, String or_contactNo,
		String or_payment) {
	
	this.or_no = or_no;
	this.cus_id = cus_id;
	this.or_date = or_date;
	this.or_price = or_price;
	this.or_qt = or_qt;
	this.or_addr = or_addr;
	this.or_contactNo = or_contactNo;
	this.or_payment = or_payment;
}
public String getOr_no() {
	return or_no;
}
public void setOr_no(String or_no) {
	this.or_no = or_no;
}
public String getCus_id() {
	return cus_id;
}
public void setCus_id(String cus_id) {
	this.cus_id = cus_id;
}
public Date getOr_date() {
	return or_date;
}
public void setOr_date(Date or_date) {
	this.or_date = or_date;
}
public double getOr_price() {
	return or_price;
}
public void setOr_price(double or_price) {
	this.or_price = or_price;
}
public int getOr_qt() {
	return or_qt;
}
public void setOr_qt(int or_qt) {
	this.or_qt = or_qt;
}
public String getOr_addr() {
	return or_addr;
}
public void setOr_addr(String or_addr) {
	this.or_addr = or_addr;
}
public String getOr_contactNo() {
	return or_contactNo;
}
public void setOr_contactNo(String or_contactNo) {
	this.or_contactNo = or_contactNo;
}
public String getOr_payment() {
	return or_payment;
}
public void setOr_payment(String or_payment) {
	this.or_payment = or_payment;
}
@Override
public String toString() {
	return "Order [or_no=" + or_no + ", cus_id=" + cus_id + ", or_date=" + or_date + ", or_price=" + or_price
			+ ", or_qt=" + or_qt + ", or_addr=" + or_addr + ", or_contactNo=" + or_contactNo + ", or_payment="
			+ or_payment + "]";
}


 
  
  
  
}
