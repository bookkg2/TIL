package db2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {

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
		String url ="jdbc:oracle:thin:@70.12.50.225:1521:xe";//데이터베이스 마다 좀 다름 
		
		Connection con = null;//JDBC가 제공
		try {
		con = DriverManager.getConnection(url,id,password);
		}catch(Exception e) {
			System.out.println("connection Error");
			e.printStackTrace();//상세한 에러메세지 보고 싶을 때
		}
		
		//3. SQL 전송
		String sql = "INSERT INTO T_PRODUCT VALUES (?,?,?,SYSDATE)";//날짜는 그냥 넣으면 됨
		PreparedStatement pstmt = null;
		try {
			Date date = null;
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "P09");
			pstmt.setString(2, "TV");
			pstmt.setInt(3, 50000);
//			pstmt.setDate(4,date);
			
			int result = pstmt.executeUpdate();//ORACLE 로직에 접근
			System.out.println(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//4. close
		try {
			pstmt.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
