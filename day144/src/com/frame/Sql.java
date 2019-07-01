package com.frame;

public class Sql {
	public static String insertUser
	= "INSERT INTO T_USER VALUES (?,?,?)";
	public static String insertDelete
	= "DELETE FROM T_USER WHERE ID = ?";
	public static String insertUpdate
	= "UPDATE T_USER SET PWD=?,NAME=? WHERE ID=?";
	public static String insertSelect
	= "SELECT * FROM T_USER WHERE ID = ?";
	public static String insertSelectAll
	= "SELECT * FROM T_USER";
	
	public static String insertProduct = "INSERT INTO T_PRODUCT VALUES (PSEQ.NEXTVAL,?,?,SYSDATE,?)";
	public static String deleteProduct = "DELETE FROM T_PRODUCT WHERE ID = ?";
	public static String updateProduct = "UPDATE T_PRODUCT SET NAME=?, PRICE=? IMGNAME=? WHERE ID=?";
	public static String selectProduct = "SELECT * FROM T_PRODUCT WHERE ID = ?";
	public static String selectAllProduct = "SELECT * FROM T_PRODUCT";

}
