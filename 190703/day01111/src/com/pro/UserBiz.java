package com.pro;



public class UserBiz implements Biz {
	
	Dao dao;
	
	private Dao dus; //agreegation °ü°è
	
	public UserBiz(){
		
	}

	
	public UserBiz(Dao dus) {
		
		this.dus = dus;
	}


	public Dao getDao() {
		return dao;
	}


	public void setDao(Dao dao) {
		this.dao = dao;
	}


	public void register() {
		dao.insert();
		
	}
}
