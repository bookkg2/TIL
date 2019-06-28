package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import frame.Dao;
import frame.Sql;
import vo.Factory;

public class FactoryDao extends Dao<String, Factory> {

	@Override
	public void insert(Factory v, Connection con) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(Sql.insertFactory);
			pstmt.setString(1,v.getFactNo());
			pstmt.setString(2,v.getFactName());
			pstmt.setString(3,v.getFacLoc());
			
			pstmt.executeUpdate();
			
		}
		catch(Exception e) {
			throw e;
		}
		finally {
			close(pstmt);
		}
		
	}

	@Override
	public void delete(String k, Connection con) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(Sql.deleteFactory);
			pstmt.setString(1,k);
			pstmt.executeUpdate();
		
		}
		catch(Exception e) {
			throw e;
		}
		finally {
			close(pstmt);
		}
		
	}

	@Override
	public void update(Factory v, Connection con) throws Exception {
		
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(Sql.updateFactory);
			pstmt.setString(1,v.getFactName());
			pstmt.setString(2,v.getFacLoc());
			pstmt.setString(3,v.getFactNo());
			
		}
		catch(Exception e) {
			throw e;
		}
		finally {
			close(pstmt);
		}
		
	}

	@Override
	public Factory select(String k, Connection con) throws Exception {
		
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Factory facotry = null;
		
		try {
			pstmt = con.prepareStatement(Sql.selectFactory);
			pstmt.setString(1, k);
			rset = pstmt.executeQuery();
	
			rset.next(); 
			String uid = rset.getString("FACTNO");
			String upwd = rset.getString("FACNAME");
			String uname = rset.getString("FACLOC");
			
			facotry = new Factory(uid,upwd,uname);
			
		} catch (Exception e) {
			throw e;
		} finally {
			close(pstmt);
			close(rset);
		}
		return facotry;
	}

	@Override
	public ArrayList<Factory> select(Connection con) throws Exception {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Factory> list = new ArrayList<>();
		
		try {
			pstmt = con.prepareStatement(Sql.selectAllFactory);
			rset = pstmt.executeQuery();
			
			while (rset.next()) {
				String uid = rset.getString("FACTNO");
				String upwd = rset.getString("FACNAME");
				String uname = rset.getString("FACLOC");
				
				list.add(new Factory(uid,upwd,uname));
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
