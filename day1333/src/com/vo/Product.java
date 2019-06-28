package com.vo;

import java.sql.Date;

public class Product {

	int id;
	String name;
	double price;
	Date regdata;
	String imgname;

	public Product() {
	}
	
	public Product(String name, double price, String imgname) {
		this.name = name;
		this.price = price;
		this.imgname = imgname;
	}
	
	public Product(int id, String name, double price, String imgname) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.imgname = imgname;
	}

	public Product(int id, String name, double price, Date regdata, String imgname) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.regdata = regdata;
		this.imgname = imgname;
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

	public Date getRegdata() {
		return regdata;
	}

	public void setRegdata(Date regdata) {
		this.regdata = regdata;
	}

	public String getImgname() {
		return imgname;
	}

	public void setImgname(String imgname) {
		this.imgname = imgname;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", regdata=" + regdata + ", imgname="
				+ imgname + "]";
	}
	
	
	

}
