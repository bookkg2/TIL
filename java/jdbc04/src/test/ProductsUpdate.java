package test;

import java.sql.Date;

import com.ProductsBiz;

import frame.Biz;
import vo.Products;

public class ProductsUpdate {

	public static void main(String[] args) {
		
		long millis=System.currentTimeMillis();  
		Date date=new java.sql.Date(millis);  
		Products user = new Products (7,"TV","PC08","10",date,10,100,10);
		Biz<Integer, Products> biz = new ProductsBiz();
		
		try {
			biz.modify(user);
			System.out.println("Update");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}
