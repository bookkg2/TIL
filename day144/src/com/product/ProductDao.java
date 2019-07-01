package com.product;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.frame.Dao;
import com.frame.Sql;
import com.vo.Product;
import com.vo.User;

public class ProductDao extends Dao<Integer, Product> {

	@Override
	public void insert(Product v, Connection con) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(Sql.insertProduct);
			pstmt.setString(1, v.getName());
			pstmt.setDouble(2, v.getPrice());
			pstmt.setString(3, v.getImgname());
			pstmt.executeUpdate();
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);	
		}
		
	}

	@Override
	public void delete(Integer k, Connection con) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(Sql.deleteProduct);
			pstmt.setInt(1,k);
		
			pstmt.executeUpdate();
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);	
		}
		
	}

	@Override
	public void update(Product v, Connection con) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(Sql.updateProduct);
			pstmt.setString(1, v.getName());
			pstmt.setDouble(2, v.getPrice());
			pstmt.setString(3, v.getImgname());
			pstmt.setInt(4, v.getId());
			pstmt.executeUpdate();
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);	
		}
		
	}

	@Override
	public Product select(Integer k, Connection con) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Product sd = null;
			try {
			pstmt=con.prepareStatement(Sql.selectProduct);
			pstmt.setInt(1, k);		
			rset = pstmt.executeQuery();  //받는거임
			rset.next();
			int pid = rset.getInt("ID");
			String pname = rset.getString("NAME");
			double price= rset.getDouble("PRICE");
			Date pdate = rset.getDate("REGDATE");
			String pimg = rset.getString("IMGNAME");
			
			sd = new Product(pid,pname,price,pdate,pimg);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			}
		return sd;
		
	}

	@Override
	public ArrayList<Product> select(Connection con) throws Exception {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Product> sps = new ArrayList<Product>();
		Product sp = null;
		try {
			pstmt = con.prepareStatement(Sql.selectAllProduct);
			rset = pstmt.executeQuery(); 
	
			
			while(rset.next()) {
				int pid = rset.getInt("ID");
				String pname = rset.getString("NAME");
				double price= rset.getDouble("PRICE");
				Date pdate = rset.getDate("REGDATE");
				String pimg = rset.getString("IMGNAME");
				sp = new Product(pid,pname,price,pdate,pimg);
				sps.add(sp);
				//System.out.println(uid+" "+upwd+" "+" "+ price+""+imgname);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sps;
	}

}
