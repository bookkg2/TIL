package com;

import java.sql.Connection;
import java.util.ArrayList;

import frame.Biz;
import frame.Dao;
import vo.Factory;



public class FactoryBiz extends Biz<String, Factory> {
	Dao<String, Factory> dao = new FactoryDao();
	
	@Override
	public void register(Factory v) throws Exception {
	
		Connection con = null;

		try {
			con = getCon();
			dao.insert(v,con);
			//dao.insert(v,con);
			con.commit();//위에 둘다 정상이면 commit
		} catch (Exception e) {
			con.rollback();//비정상이면 rollback
			throw e;
		} finally {
			close(con);
		}
		
	}

	@Override
	public void remove(String k) throws Exception {
		Connection con = null;
		try {
			con = getCon();
			dao.delete(k, con);
			con.commit();
		}catch(Exception e){
			con.rollback();
			throw e;
		}finally {
			close(con);
		}

		
	}

	@Override
	public void modify(Factory v) throws Exception {
		Connection con = null;
		try {
			con = getCon();
			dao.update(v, con);
			con.commit();
		}catch(Exception e){
			con.rollback();
			throw e;
		}finally {
			close(con);
		}
		
	}

	@Override
	public Factory get(String k) throws Exception {
		Connection con = null;
		Factory u = null;

		try {
			con = getCon();
			u = dao.select(k,con);//select는 commit,rollback(Transcation) 필요 X 그냥 데이트 가져옴 
			
		} catch (Exception e) {
		   throw e;
		} finally {
			close(con);
		}
		return u;
	}

	@Override
	public ArrayList<Factory> get() throws Exception {
		
		Connection con = null;
		
		ArrayList<Factory> list = new ArrayList<>() ;
		
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
