package com.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.frame.Dao;
import com.frame.Sql;
import com.vo.User;

public class UserDao extends Dao<String, User> {

	@Override
	public void insert(User v, Connection con) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(Sql.insertUser);
			pstmt.setString(1, v.getId());
			pstmt.setString(2, v.getPwd());
			pstmt.setString(3, v.getName());
			pstmt.executeUpdate();
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);	
		}
		
	}

	@Override
	public void delete(String k, Connection con) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(Sql.insertDelete);
			pstmt.setString(1, k);
			pstmt.executeUpdate();
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);	
		}
		
	}

	@Override
	public void update(User v, Connection con) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(Sql.insertUpdate);
			pstmt.setString(1, v.getPwd());
			pstmt.setString(2, v.getName());
			pstmt.setString(3, v.getId());
			pstmt.executeUpdate();
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);	
		}
		
	}

	@Override
	public User select(String k, Connection con) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		User sd = null;
			try {
			pstmt=con.prepareStatement(Sql.insertSelect);
			pstmt.setString(1, k);		
			rset = pstmt.executeQuery();  //받는거임
			rset.next();
			String uid = rset.getString("ID");
			String upwd= rset.getString("PWD");
			String uname = rset.getString("NAME");
			sd = new User(uid,upwd,uname);
			System.out.println(uid+" "+upwd+" "+uname);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			}
		return sd;
	}

	@Override
	public ArrayList<User> select(Connection con) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<User> list = new ArrayList<User>();
		User sp = null;
		try {
			pstmt = con.prepareStatement(Sql.insertSelectAll);
			rset = pstmt.executeQuery(); 
			
			
			while(rset.next()) {
				String uid = rset.getString("ID");
				String upwd = rset.getString("PWD");
				String uname = rset.getString("NAME");
				sp = new User(uid, upwd, uname);
				list.add(sp);
				//System.out.println(uid+" "+upwd+" "+uname);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
