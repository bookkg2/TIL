package com.sds.component;

import java.util.ArrayList;

import com.sds.frame.Dao;
import com.sds.vo.Product;

public class ProductDao extends Dao<Integer, Product> {

	@Override
	public void insert(Product v) throws Exception {
		if(v.getId() == 02){
			throw new Exception("E0001");
		}
		System.out.println(v + "inserted..");
		
	}

	@Override
	public void delete(Integer k) throws Exception {
		if(k == 200){
			throw new Exception("E0002");
		}
		System.out.println(k + "delete");
		
		
		
	}

	@Override
	public void update(Product v) throws Exception {
		if(v.getId() == 02){
			throw new Exception("E0003");
		}
		System.out.println(v + "update..");
		
	}

	@Override
	public Product select(Integer k) throws Exception {
		Product p = new Product(k , "Tv" ,10000);
		return p;
	}

	@Override
	public ArrayList<Product> select() throws Exception {
		ArrayList<Product> list = new ArrayList<>();
		list.add(new Product(01, "tv1", 1000));
		list.add(new Product(02, "tv2", 1000));
		list.add(new Product(03, "tv3", 1000));
		list.add(new Product(04, "tv4", 1000));
		list.add(new Product(05, "tv5", 1000));
		return list;
	}

}
