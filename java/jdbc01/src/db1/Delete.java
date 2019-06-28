package db1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {

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
				String sql = "DELETE FROM T_USER WHERE ID=?";
				PreparedStatement pstmt = null;
				try {
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, "id10");
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
