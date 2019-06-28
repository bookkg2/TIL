package test;

import com.ProductsBiz;

import frame.Biz;
import vo.Products;

public class ProductsDelete {
	public static void main(String[] args) {
		
	Biz<Integer, Products> biz = new ProductsBiz();
		
		try {
			biz.remove(10);
			System.out.println("Removed");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
}
