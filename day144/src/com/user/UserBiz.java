package com.user;

import java.sql.Connection;
import java.util.ArrayList;

import com.frame.Biz;
import com.frame.Dao;
import com.vo.User;

public class UserBiz extends Biz<String, User> {

	Dao<String,User> dao;
	
	public UserBiz(){
		dao = new UserDao();
	}
	@Override
	public void register(User v) throws Exception {
		Connection con = null;
		try {
			con = getCon();
			dao.insert(v, con);
			//dao.insert(v, con);
			con.commit();
		}catch(Exception e) {
			con.rollback();
			throw e;
		}finally {
			close(con);
		}
	}

	@Override
	public void remove(String k) throws Exception {
		Connection con = null; 
		try {
			con = getCon();
			dao.delete(k,con);
			con.commit();
		}catch(Exception e) {
			con.rollback();
			throw e;
		}finally {
			close(con);
		}
	
		
	}

	@Override
	public void modify(User v) throws Exception {
		Connection con = null;  // 여기서 connection을 만들어서 
		try {
			con = getCon();
			dao.update(v, con); 
			con.commit();   
		}catch(Exception e) {
			con.rollback(); 
			throw e;
		}finally {
		close(con);
		}
		
		
	}

	@Override
	public User get(String k) throws Exception {
		Connection con = null;
		User u = null;
		try {
			con = getCon();
			u = dao.select(k, con);
		}catch(Exception e) {
			throw e;
		}finally {
			close(con);
		}		
		return u;
	}

	@Override
	public ArrayList<User> get() throws Exception {
     ArrayList<User> list = new ArrayList<>();
		
		Connection con = null;  // 여기서 connection을 만들어서 
		try {
			con = getCon();
			list = dao.select(con); 

		}catch(Exception e) {
			throw e;
		}finally {
		close(con);
		}
		return list;
	}

}
