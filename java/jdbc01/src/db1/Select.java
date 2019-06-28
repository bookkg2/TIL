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
		//2. Connection 1521 db(Workspace ID) db(���)
		String id = "db";
		String password ="db";
		String url ="jdbc:oracle:thin:@70.12.50.234:1521:xe";//�����ͺ��̽� ���� �� �ٸ� 
		
		Connection con = null;//JDBC�� ����
		try {
		con = DriverManager.getConnection(url,id,password);
		}catch(Exception e) {
			System.out.println("connection Error");
			e.printStackTrace();//���� �����޼��� ���� ���� ��
		}
		
		//3. SQL ���� & Receive
		String sql = "SELECT * FROM T_USER WHERE ID=?";
		PreparedStatement pstmt = null;//�����ϴ� �� 
		ResultSet rset = null;//�޴� ��
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "id01");
			
			rset = pstmt.executeQuery();//ORACLE ������ ����
			rset.next();//�� ĭ �Űܾ��� ,������� ó���� ����Ű�� �־ 
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
