package test;

import com.ProductsBiz;

import frame.Biz;
import vo.Products;

public class ProductsSelect {
	public static void main(String[] args) {
		Biz<Integer, Products> biz = new ProductsBiz();
		
		try {
			biz.get(5);
			System.out.println("Select");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
