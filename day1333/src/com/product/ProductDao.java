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
		} catch (Exception e) {
			throw e;
		} finally {
			close(pstmt);
		}
	}

	@Override
	public void delete(Integer k, Connection con) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(Sql.deleteProduct);
			pstmt.setInt(1, k);
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
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
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

	}

	@Override
	public Product select(Integer k, Connection con) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Product sp = null; // SELECT �� ���� ������ ��Ƽ� �����ؾ� �ϹǷ� USER �ʿ�
		try {
			pstmt = con.prepareStatement(Sql.selectProduct);
			pstmt.setInt(1, k);
			rset = pstmt.executeQuery();
			rset.next();
			int spid = rset.getInt("ID");
			String spname = rset.getString("NAME");
			double spprice = rset.getDouble("PRICE");
			Date spdate = rset.getDate("REGDATE");
			String spimgName = rset.getString("IMGNAME");
			sp = new Product(spid, spname, spprice, spdate, spimgName);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return sp;
	}

	@Override
	public ArrayList<Product> select(Connection con) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Product sp = null;
		ArrayList<Product> sps = new ArrayList<Product>(); // !! ArrayList �ʱ�ȭ !!

		try {
			pstmt = con.prepareStatement(Sql.selectAllUProduct);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				int spid = rset.getInt("ID");
				String spname = rset.getString("NAME");
				double spprice = rset.getDouble("PRICE");
				Date spdate = rset.getDate("REGDATE");
				String spimgName = rset.getString("IMGNAME");
				sp = new Product(spid, spname, spprice, spdate, spimgName);
				sps.add(sp);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sps;
	}
}
