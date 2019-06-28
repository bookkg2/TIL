package com.sds.component;

import java.util.ArrayList;

import com.sds.frame.Biz;
import com.sds.frame.Dao;
import com.sds.vo.User;

public class UserBiz extends Biz<String, User> {

	Dao<String, User> dao;// DB�� Biz �� �ʿ� �ϴϱ�.

	public UserBiz() {
		dao = new UserDao();// Dao���� UserDao�� ����ϰڴ�.
	}

	@Override
	public void register(User v) throws Exception {
		checkData(v);
		transactionStart();
		try {
			dao.insert(v);// dao ���� insert�϶�� ��û, dao���� �޾ƿ� Exception�� �ڵ����� ������.
		} catch (Exception e) {// ������ �߻��� ���� ó���� �޾ƿ�.
			throw e;// ���ܸ� ��Ƽ� ������!
		} finally {//����������, ���ܸ� ������ �ᱹ ���� !! �� ���쿡�� ���� !
			transactionEnd();// ������ �ȵǸ� ������ ����ó���� �ɸ� ���� �� Dao�κп��� ���ܿ� �ɸ�
		}
	}

	@Override
	public void remove(String k) throws Exception {
		
		transactionStart();
		try {
			dao.delete(k);// dao ���� insert�϶�� ��û, dao���� �޾ƿ� Exception�� �ڵ����� ������.
		} catch (Exception e) {// ������ �߻��� ���� ó���� �޾ƿ�.
			throw e;// ���ܸ� ��Ƽ� ������!
		} finally {//����������, ���ܸ� ������ �ᱹ ���� !! �� ���쿡�� ���� !
			transactionEnd();// ������ �ȵǸ� ������ ����ó���� �ɸ� ���� �� Dao�κп��� ���ܿ� �ɸ�
		}

	}

	@Override
	public void modify(User v) throws Exception {
		checkData(v);
		transactionStart();
		try {
			dao.update(v);// dao ���� insert�϶�� ��û, dao���� �޾ƿ� Exception�� �ڵ����� ������.
		} catch (Exception e) {// ������ �߻��� ���� ó���� �޾ƿ�.
			throw e;// ���ܸ� ��Ƽ� ������!
		} finally {//����������, ���ܸ� ������ �ᱹ ���� !! �� ���쿡�� ���� !
			transactionEnd();// ������ �ȵǸ� ������ ����ó���� �ɸ� ���� �� Dao�κп��� ���ܿ� �ɸ�
		}

	}

	@Override
	public User get(String k) throws Exception {
		// TODO Auto-generated method stub
		return dao.select(k);
	}

	@Override
	public ArrayList<User> get() throws Exception {
		// TODO Auto-generated method stub
		return dao.select();
	}

}
