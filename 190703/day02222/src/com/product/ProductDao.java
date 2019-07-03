package com.product;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Repository;

import com.frame.Dao;
import com.vo.Product;

@Repository("pdo")
public class ProductDao implements Dao<Integer, Product> {
	Date date = new Date();
	@Override
	public void insert(Product v) throws Exception {
		System.out.println(v + "Product Insert.."); 
		
	}

	@Override
	public void update(Product v) throws Exception {
		System.out.println(v + "Product Update..");  
		
	}

	@Override
	public void delete(Integer k) throws Exception {
		System.out.println(k + "Product delete.."); 
		
	}

	@Override
	public Product select(Integer k) throws Exception {
		
		return new Product(1,"tv", 5000, date,"sss.jpg" ) ;
	}

	@Override
	public ArrayList<Product> select() throws Exception {
		ArrayList<Product> list = new ArrayList<>();
		list.add(new Product(1,"tv", 5000, date,"sss.jpg"));
		list.add(new Product(2,"tv2", 6000, date,"sss2.jpg"));
		list.add(new Product(3,"tv3", 7000, date,"sss3.jpg"));
		list.add(new Product(4,"tv4", 8000, date,"sss4.jpg"));
		return list;
	}

}
