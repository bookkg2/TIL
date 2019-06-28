package com;

import java.sql.Connection;
import java.util.ArrayList;

import javax.xml.bind.ParseConversionEvent;

import frame.Biz;
import frame.Dao;
import vo.Factory;
import vo.Products;

public class ProductsBiz extends Biz<Integer, Products> {

	Dao<Integer, Products> dao;
	FactoryBiz fb = new FactoryBiz();

	public ProductsBiz() {
		dao = new ProductsDao();
	}

	@Override
	public void register(Products v) throws Exception {

		Connection con = null;
		ArrayList<Factory> rset = new ArrayList<>();

		rset = fb.get();

		boolean notFactory = false;

		try {
			con = getCon();
			dao.insert(v, con);
			for (int i = 0; i < rset.size(); i++) {

				if (rset.get(i).getFactNo() == v.getFactNo()) {
					
//					dao.insert(v, con);
					notFactory = true;
					con.commit();
				}
				
			

			}
			 

				
				

		} catch (Exception e) {
			System.out.println("없는 공장을 입력했습니다.");
			con.rollback();// 비정상이면 rollback
			throw e;
		} finally {
			close(con);
		}
	}

	@Override
	public void remove(Integer k) throws Exception {

		Connection con = null;
		try {
			con = getCon();
			dao.delete(k, con);
			con.commit();
		} catch (Exception e) {
			con.rollback();
			throw e;
		} finally {
			close(con);
		}

	}

	@Override
	public void modify(Products v) throws Exception {

		Connection con = null;
		ArrayList<Factory> rset = new ArrayList<>();

		rset = fb.get();
		boolean notFactory = false;

		try {
			con = getCon();
			dao.update(v, con);
			for (int i = 0; i < rset.size(); i++) {

				if (rset.get(i).getFactNo() == v.getFactNo()) {
					
					notFactory = true;
					con.commit();
				}
			}
			
			
		} catch (Exception e) {
			System.out.println("없는 공장을 입력했습니다.");
			con.rollback();
			throw e;
		} finally {
			close(con);
		}

	}

	@Override
	public Products get(Integer k) throws Exception {

		Connection con = null;
		Products u = null;
		Factory d = null;
		
		
		ArrayList<Factory> rset = new ArrayList<>();

		rset = fb.get();
		
		boolean notFactory = false;

		try {
			
			con = getCon();
			u = dao.select(k, con);// select는 commit,rollback(Transcation) 필요 X 그냥 데이트 가져옴
			con.commit();
//			for (int i = 0; i < rset.size(); i++) {
//
//				if (rset.get(i).getFactNo() == d.getFactNo()) {
//					
//					notFactory = true;
//					
//				}
//			}
//			
			

		} catch (Exception e) {
			System.out.println("없는 품목을 입력했습니다.");
			con.rollback();
			throw e;
		} finally {
			close(con);
		}
		return u;
	}

	@Override
	public ArrayList<Products> get() throws Exception {

		Connection con = null;
		Products u = null;

		ArrayList<Products> list = new ArrayList<>();
		try {
			con = getCon();
			list = dao.select(con);

		} catch (Exception e) {
			throw e;
		} finally {
			close(con);
		}
		return list;
	}

}
