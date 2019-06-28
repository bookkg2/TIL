package db1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Select {

	public static void main(String[] args) {
		//1. JDBC Driver Loadoing...
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Driver Loading Error...");
		}
		//2. Connection 1521 db(Workspace ID) db(비번)
		String id = "db";
		String password ="db";
		String url ="jdbc:oracle:thin:@70.12.50.234:1521:xe";//데이터베이스 마다 좀 다름 
		
		Connection con = null;//JDBC가 제공
		try {
		con = DriverManager.getConnection(url,id,password);
		}catch(Exception e) {
			System.out.println("connection Error");
			e.printStackTrace();//상세한 에러메세지 보고 싶을 때
		}
		
		//3. SQL 전송 & Receive
		String sql = "SELECT * FROM T_USER WHERE ID=?";
		PreparedStatement pstmt = null;//전송하는 놈 
		ResultSet rset = null;//받는 놈
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "id01");
			
			rset = pstmt.executeQuery();//ORACLE 로직에 접근
			rset.next();//한 칸 옮겨야함 ,빈공간을 처음에 가르키고 있어서 
			String uid = rset.getString("ID");
			String upwd = rset.getString("PWD");
			String uname= rset.getString("NAME");
			System.out.println(uid +" "+ upwd + " "+ uname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//4. close
		try {
			rset.close();
			pstmt.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
