package com.product;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frame.Biz;
import com.frame.Dao;
@Service("pb")
public class ProductBiz implements Biz<String, Product> {
	
	@Autowired
	Dao<String,Product> dao;
	@Override
	public void insert(Product v) throws Exception {
		dao.insert(v);
		
	}

	@Override
	public void update(Product v) throws Exception {
		
		dao.update(v);
	}

	@Override
	public void delete(String k) throws Exception {
		dao.delete(k);
		
	}

	@Override
	public Product select(String k) throws Exception {
		
		return dao.select(k);
	}

	@Override
	public ArrayList<Product> select() throws Exception {
		
		return dao.select();
	}

}
