package test;

import java.util.ArrayList;

import com.ProductsBiz;

import frame.Biz;
import vo.Products;

public class ProductsSelectAll {
	public static void main(String[] args) {
		Biz<Integer, Products> biz = new ProductsBiz();
		
		try {
						
			biz.get();
			
			System.out.println("Select");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
