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
			System.out.println("���� ������ �Է��߽��ϴ�.");
			con.rollback();// �������̸� rollback
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
			System.out.println("���� ������ �Է��߽��ϴ�.");
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
			u = dao.select(k, con);// select�� commit,rollback(Transcation) �ʿ� X �׳� ����Ʈ ������
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
			System.out.println("���� ǰ���� �Է��߽��ϴ�.");
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
