package frame;

public class Sql {
	
	public static String insertFactory = "INSERT INTO FACTORY VALUES (?,?,?)";
	public static String deleteFactory = "DELETE FROM FACTORY WHERE FACTNO = ?";
	public static String updateFactory = "UPDATE FACTORY SET FACNAME = ?, FACLOC = ? WHERE FACTNO = ?";
	public static String selectFactory = "SELECT * FROM FACTORY WHERE FACTNO = ?";
	public static String selectAllFactory = "SELECT * FROM FACTORY";
	
	public static String insertProducts = "INSERT INTO PRODUCTS VALUES (?,?,?,?,?,?,?,?)";
	public static String deleteProducts = "DELETE FROM PRODUCTS WHERE PDNO = ?";
	public static String updateProducts = "UPDATE PRODUCTS SET PDNAME =?, PDSUBNAME =?, FACTNO =?, PDDATE=?, PDCOST =?, PDPRICE =?, PDAMOUNT =? WHERE PDNO =?";
	public static String selectProducts = "SELECT * FROM PRODUCTS WHERE PDNO = ?";
	public static String selectAllUProducts = "SELECT * FROM PRODUCTS";

}

