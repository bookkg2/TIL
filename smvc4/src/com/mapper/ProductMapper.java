package com.mapper;

import java.util.ArrayList;

import com.vo.Product;


public interface ProductMapper {
	public void insert(Product obj);
	public void delete(int obj);
	public void update(Product obj);
	public Product select(int obj);
	public ArrayList<Product> selectall();

}



