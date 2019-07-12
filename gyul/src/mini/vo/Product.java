package mini.vo;

import java.io.File;

public class Product {
	int pro_no;
	String pro_cate;
	String pro_name;
    double pro_price;
    int pro_st;
    String pro_img1;
    String pro_img2;
    String pro_img3;
    String farm_license_no;
    String farm_name;
    String farm_ceo;
    String farm_addr;
    String farm_phone;
	public Product() {
		
	}
	public Product(int pro_no, String pro_cate, String pro_name, double pro_price, int pro_st, String pro_img1,
			String pro_img2, String pro_img3, String farm_license_no, String farm_name, String farm_ceo,
			String farm_addr, String farm_phone) {
		super();
		this.pro_no = pro_no;
		this.pro_cate = pro_cate;
		this.pro_name = pro_name;
		this.pro_price = pro_price;
		this.pro_st = pro_st;
		this.pro_img1 = pro_img1;
		this.pro_img2 = pro_img2;
		this.pro_img3 = pro_img3;
		this.farm_license_no = farm_license_no;
		this.farm_name = farm_name;
		this.farm_ceo = farm_ceo;
		this.farm_addr = farm_addr;
		this.farm_phone = farm_phone;
	}
	
	public Product(int pro_no, String pro_cate, String pro_name, double pro_price, int pro_st, String pro_img2,
			String pro_img3, String farm_license_no, String farm_name, String farm_ceo, String farm_addr,
			String farm_phone) {
		
		this.pro_no = pro_no;
		this.pro_cate = pro_cate;
		this.pro_name = pro_name;
		this.pro_price = pro_price;
		this.pro_st = pro_st;
		this.pro_img2 = pro_img2;
		this.pro_img3 = pro_img3;
		this.farm_license_no = farm_license_no;
		this.farm_name = farm_name;
		this.farm_ceo = farm_ceo;
		this.farm_addr = farm_addr;
		this.farm_phone = farm_phone;
	}
	
	public Product(int pro_no, String pro_cate, String pro_name, double pro_price, int pro_st, String pro_img3,
			String farm_license_no, String farm_name, String farm_ceo, String farm_addr, String farm_phone) {
		
		this.pro_no = pro_no;
		this.pro_cate = pro_cate;
		this.pro_name = pro_name;
		this.pro_price = pro_price;
		this.pro_st = pro_st;
		this.pro_img3 = pro_img3;
		this.farm_license_no = farm_license_no;
		this.farm_name = farm_name;
		this.farm_ceo = farm_ceo;
		this.farm_addr = farm_addr;
		this.farm_phone = farm_phone;
	}
	public Product(int pro_no, String pro_cate, String pro_name, double pro_price, int pro_st, String farm_license_no,
			String farm_name, String farm_ceo, String farm_addr, String farm_phone) {
		
		this.pro_no = pro_no;
		this.pro_cate = pro_cate;
		this.pro_name = pro_name;
		this.pro_price = pro_price;
		this.pro_st = pro_st;
		this.farm_license_no = farm_license_no;
		this.farm_name = farm_name;
		this.farm_ceo = farm_ceo;
		this.farm_addr = farm_addr;
		this.farm_phone = farm_phone;
	}
	public Product(String farm_license_no, String farm_name, String farm_ceo, String farm_addr, String farm_phone) {
		
		this.farm_license_no = farm_license_no;
		this.farm_name = farm_name;
		this.farm_ceo = farm_ceo;
		this.farm_addr = farm_addr;
		this.farm_phone = farm_phone;
	}
	public Product(int pro_no, String pro_cate, String pro_name, double pro_price, int pro_st, String pro_img1,
			String pro_img2, String pro_img3) {
		
		this.pro_no = pro_no;
		this.pro_cate = pro_cate;
		this.pro_name = pro_name;
		this.pro_price = pro_price;
		this.pro_st = pro_st;
		this.pro_img1 = pro_img1;
		this.pro_img2 = pro_img2;
		this.pro_img3 = pro_img3;
	}
	public int getPro_no() {
		return pro_no;
	}
	public void setPro_no(int pro_no) {
		this.pro_no = pro_no;
	}
	public String getPro_cate() {
		return pro_cate;
	}
	public void setPro_cate(String pro_cate) {
		this.pro_cate = pro_cate;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public double getPro_price() {
		return pro_price;
	}
	public void setPro_price(double pro_price) {
		this.pro_price = pro_price;
	}
	public int getPro_st() {
		return pro_st;
	}
	public void setPro_st(int pro_st) {
		this.pro_st = pro_st;
	}
	public String getPro_img1() {
		return pro_img1;
	}
	public void setPro_img1(String pro_img1) {
		this.pro_img1 = pro_img1;
	}
	public String getPro_img2() {
		return pro_img2;
	}
	public void setPro_img2(String pro_img2) {
		this.pro_img2 = pro_img2;
	}
	public String getPro_img3() {
		return pro_img3;
	}
	public void setPro_img3(String pro_img3) {
		this.pro_img3 = pro_img3;
	}
	public String getFarm_license_no() {
		return farm_license_no;
	}
	public void setFarm_license_no(String farm_license_no) {
		this.farm_license_no = farm_license_no;
	}
	public String getFarm_name() {
		return farm_name;
	}
	public void setFarm_name(String farm_name) {
		this.farm_name = farm_name;
	}
	public String getFarm_ceo() {
		return farm_ceo;
	}
	public void setFarm_ceo(String farm_ceo) {
		this.farm_ceo = farm_ceo;
	}
	public String getFarm_addr() {
		return farm_addr;
	}
	public void setFarm_addr(String farm_addr) {
		this.farm_addr = farm_addr;
	}
	public String getFarm_phone() {
		return farm_phone;
	}
	public void setFarm_phone(String farm_phone) {
		this.farm_phone = farm_phone;
	}
	@Override
	public String toString() {
		return "Product [pro_no=" + pro_no + ", pro_cate=" + pro_cate + ", pro_name=" + pro_name + ", pro_price="
				+ pro_price + ", pro_st=" + pro_st + ", pro_img1=" + pro_img1 + ", pro_img2=" + pro_img2 + ", pro_img3="
				+ pro_img3 + ", farm_license_no=" + farm_license_no + ", farm_name=" + farm_name + ", farm_ceo="
				+ farm_ceo + ", farm_addr=" + farm_addr + ", farm_phone=" + farm_phone + "]";
	}
    
	
	
	
    
    
    
    
	
}
