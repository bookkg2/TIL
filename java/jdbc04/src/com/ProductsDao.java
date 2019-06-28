package com;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import frame.Dao;
import frame.Sql;
import vo.Factory;
import vo.Products;

public class ProductsDao extends Dao<Integer, Products> {

	@Override
	public void insert(Products v, Connection con) throws Exception {

		PreparedStatement pstmt = null;

		try {

			pstmt = con.prepareStatement(Sql.insertProducts);
			pstmt.setInt(1, v.getPdNo());
			pstmt.setString(2, v.getPdName());
			pstmt.setString(3, v.getPdsUBName());
			pstmt.setString(4, v.getFactNo());
			pstmt.setDate(5, (Date) v.getPdDate());
			pstmt.setInt(6, v.getPdCost());
			pstmt.setInt(7, v.getPdPrice());
			pstmt.setInt(8, v.getPdAmount());
			pstmt.executeUpdate();

		} catch (Exception e) {
			throw e;// Exception으로 던짐
		} finally {
			close(pstmt);// 반드시 실행 될 수 있도록 ~
		}

	}

	@Override
	public void delete(Integer k, Connection con) throws Exception {
		PreparedStatement pstmt = null;

		try {

			pstmt = con.prepareStatement(Sql.deleteProducts);
			pstmt.setInt(1, k);
			pstmt.executeUpdate();

		} catch (Exception e) {
			throw e;// Exception으로 던짐
		} finally {
			close(pstmt);// 반드시 실행 될 수 있도록 ~
		}

	}

	@Override
	public void update(Products v, Connection con) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(Sql.updateProducts);
			pstmt.setString(1, v.getPdName());
			pstmt.setString(2, v.getPdsUBName());
			pstmt.setString(3, v.getFactNo());
			pstmt.setDate(4, (Date)v.getPdDate());
			pstmt.setInt(5, v.getPdCost());
			pstmt.setInt(6, v.getPdPrice());
			pstmt.setInt(7, v.getPdAmount());
			pstmt.setInt(8, v.getPdNo());
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			close(pstmt);
		}

	

	}

	@Override
	public Products select(Integer k, Connection con) throws Exception {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Products list = null;

		try {
			pstmt = con.prepareStatement(Sql.selectProducts);
			pstmt.setInt(1, k);
			rset = pstmt.executeQuery();// ORACLE 로직에 접근
			rset.next();// 한 칸 옮겨야함 ,빈공간을 처음에 가르키고 있어서

			int uid = rset.getInt("PDNO");
			String upwd = rset.getString("PDNAME");
			String uname = rset.getString("PDSUBNAME");
			String uno = rset.getString("FACTNO");
			Date upddate = rset.getDate("PDDATE");
			int updcost = rset.getInt("PDCOST");
			int updprice = rset.getInt("PDPRICE");
			int updamount = rset.getInt("PDAMOUNT");
			list = new Products(uid, upwd, uname, uno, upddate, updcost, updprice, updamount);
			System.out.println(list);
		} catch (Exception e) {
			throw e;
		} finally {
			close(pstmt);
			close(rset);
		}
		return list;

	}

	@Override
	public ArrayList<Products> select(Connection con) throws Exception {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Products> list = new ArrayList<>();

		try {
			pstmt = con.prepareStatement(Sql.selectAllUProducts);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				int uid = rset.getInt("PDNO");
				String upwd = rset.getString("PDNAME");
				String uname = rset.getString("PDSUBNAME");
				String uno = rset.getString("FACTNO");
				Date upddate = rset.getDate("PDDATE");
				int updcost = rset.getInt("PDCOST");
				int updprice = rset.getInt("PDPRICE");
				int updamount = rset.getInt("PDAMOUNT");
				list.add(new Products(uid, upwd, uname, uno, upddate, updcost, updprice, updamount));
				System.out.println("["+ uid + " " + upwd + " " + uname + " " + uno + " " + upddate+ " "+ updcost + " " + updprice +" "+ updamount+"]");
			}
			
			
			
		} catch (Exception e) {
			throw e;
		} finally {
			close(pstmt);
			close(rset);
		}
		return list;

	}

}
