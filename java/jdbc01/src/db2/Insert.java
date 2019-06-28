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
		//2. Connection 1521 db(Workspace ID) db(���)
		String id = "db";
		String password ="db";
		String url ="jdbc:oracle:thin:@70.12.50.225:1521:xe";//�����ͺ��̽� ���� �� �ٸ� 
		
		Connection con = null;//JDBC�� ����
		try {
		con = DriverManager.getConnection(url,id,password);
		}catch(Exception e) {
			System.out.println("connection Error");
			e.printStackTrace();//���� �����޼��� ���� ���� ��
		}
		
		//3. SQL ����
		String sql = "INSERT INTO T_PRODUCT VALUES (?,?,?,SYSDATE)";//��¥�� �׳� ������ ��
		PreparedStatement pstmt = null;
		try {
			Date date = null;
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "P09");
			pstmt.setString(2, "TV");
			pstmt.setInt(3, 50000);
//			pstmt.setDate(4,date);
			
			int result = pstmt.executeUpdate();//ORACLE ������ ����
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
