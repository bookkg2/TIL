package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import frame.Dao;
import frame.Sql;
import vo.User;

public class UserDao extends Dao<String, User> {

	@Override
	public void insert(User v) throws Exception {
		PreparedStatement pstmt = null;
		Connection con = null;
		try {
			con = getCon();
			pstmt = getCon().prepareStatement(Sql.insertUser);
			pstmt.setString(1, v.getId());// exception 처리에 걸리면 밑에가 죽을 수 있음 !
			pstmt.setString(2, v.getPwd());
			pstmt.setString(3, v.getName());
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {// 이렇게 해결 한데 위의 문제를 !
			close(pstmt);
			close(con);
		}
	}

	@Override
	public void delete(String k) throws Exception {
		PreparedStatement pstmt = null;
		Connection con = null;
		try {
			con = getCon();
			pstmt = con.prepareStatement(Sql.insertDelete);
			pstmt.setString(1, k);
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {

			close(pstmt);
			close(con);
		}
	}

	@Override
	public void update(User v) throws Exception {
		PreparedStatement pstmt = null;
		Connection con = null;
		con = getCon();
		try {
			pstmt = con.prepareStatement(Sql.insertUpdate);
			pstmt.setString(1, v.getPwd());
			pstmt.setString(2, v.getName());
			pstmt.setString(3, v.getId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			close(pstmt);
			close(con);
		}
	}

	@Override
	public User select(String k) throws Exception {
		PreparedStatement pstmt = null;
		Connection con = null;
		con = getCon();
		ResultSet rset = null;//받는 놈
		
		try {
			pstmt = con.prepareStatement(Sql.insertSelect);
			pstmt.setString(1, k);
			
			rset = pstmt.executeQuery();//ORACLE 로직에 접근
			rset.next();//한 칸 옮겨야함 ,빈공간을 처음에 가르키고 있어서 
			String uid = rset.getString("ID");
			String upwd = rset.getString("PWD");
			String uname= rset.getString("NAME");
			System.out.println(uid +" "+ upwd + " "+ uname);
		   
		} catch (Exception e) {
			throw e;
		} finally {
			close(pstmt);
			close(con);
		}
		return null;
	}

	@Override
	public ArrayList<User> select() throws Exception {
		ArrayList<User> list = new ArrayList<>();
		User u =new User();
		PreparedStatement pstmt = null;
		Connection con = null;
		con = getCon();
		ResultSet rset = null;//받는 놈
		
		try {
			pstmt = con.prepareStatement(Sql.insertSelectAll);
				
			rset = pstmt.executeQuery();//ORACLE 로직에 접근
			while(rset.next()) {//한 칸 옮겨야함 ,빈공간을 처음에 가르키고 있어서 
			String uid = rset.getString("ID");
			String upwd = rset.getString("PWD");
			String uname= rset.getString("NAME");
			System.out.println(uid +" "+ upwd + " "+ uname);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			close(pstmt);
			close(con);
		}
		
		return list;
	}

}
