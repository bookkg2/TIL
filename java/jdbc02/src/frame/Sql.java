package frame;

public class Sql {//static은 객체 생성 안하고도 쓸 수 있음 
	public static String insertUser = "INSERT INTO T_USER VALUES(?,?,?)";
	public static String insertDelete = "DELETE FROM T_USER WHERE ID = ?";
	public static String insertUpdate = "UPDATE T_USER SET PWD=?,NAME=? WHERE ID=?";
	public static String insertSelect = "SELECT * FROM T_USER WHERE ID =?";
	public static String insertSelectAll = "SELECT * FROM T_USER ";
	
}
