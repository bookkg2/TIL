package com.product;

import java.util.ArrayList;

import com.frame.Dao;
import com.user.User;

public class ProductDao implements Dao<String, Product> {

	@Override
	public void insert(Product v) throws Exception {
		System.out.println(v+ "Inserted...");

	}

	@Override
	public void update(Product v) throws Exception {
		System.out.println(v+ "Updated...");

	}

	@Override
	public void delete(String k) throws Exception {
		System.out.println(k+ "deleted...");

	}

	@Override
	public Product select(String k) throws Exception {
		
		return new Product("id01","CLS",54000);
	}

	@Override
	public ArrayList<Product> select() throws Exception {
		ArrayList<Product> list = new ArrayList<>();
		list.add(new Product("id01","CLS",54000));
		list.add(new Product("id02","k9",4000));
		list.add(new Product("id03","k5",3000));
		list.add(new Product("id04","k3",2000));
		
		
		return list;
	}

}
