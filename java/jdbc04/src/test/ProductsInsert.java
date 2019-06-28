package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

import com.ProductsBiz;

import frame.Biz;
import vo.Products;

public class ProductsInsert {
	public static void main(String[] args) throws ParseException {
		
		
		long millis=System.currentTimeMillis();  
		Date date=new java.sql.Date(millis);  
		
		Products u = new Products (9, "PC", "PC01", "60", date, 10, 100, 2);// rollback 당해서 안들어감
		Biz<Integer, Products> biz = new ProductsBiz();

		try {
			biz.register(u);
			System.out.println("OK");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
