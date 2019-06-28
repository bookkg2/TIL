package com.sds.component;

import java.util.ArrayList;

import com.sds.frame.Biz;
import com.sds.frame.Dao;
import com.sds.vo.User;

public class UserBiz extends Biz<String, User> {

	Dao<String, User> dao;// DB는 Biz 가 필요 하니깐.

	public UserBiz() {
		dao = new UserDao();// Dao에서 UserDao를 사용하겠다.
	}

	@Override
	public void register(User v) throws Exception {
		checkData(v);
		transactionStart();
		try {
			dao.insert(v);// dao 에게 insert하라고 요청, dao에서 받아온 Exception은 자동으로 던진다.
		} catch (Exception e) {// 위에서 발생한 예외 처리를 받아옴.
			throw e;// 예외를 잡아서 던져라!
		} finally {//정상적으로, 예외를 던지고도 결국 실행 !! 즉 어떤경우에도 실행 !
			transactionEnd();// 실행이 안되면 위에서 예외처리에 걸린 것임 즉 Dao부분에서 예외에 걸림
		}
	}

	@Override
	public void remove(String k) throws Exception {
		
		transactionStart();
		try {
			dao.delete(k);// dao 에게 insert하라고 요청, dao에서 받아온 Exception은 자동으로 던진다.
		} catch (Exception e) {// 위에서 발생한 예외 처리를 받아옴.
			throw e;// 예외를 잡아서 던져라!
		} finally {//정상적으로, 예외를 던지고도 결국 실행 !! 즉 어떤경우에도 실행 !
			transactionEnd();// 실행이 안되면 위에서 예외처리에 걸린 것임 즉 Dao부분에서 예외에 걸림
		}

	}

	@Override
	public void modify(User v) throws Exception {
		checkData(v);
		transactionStart();
		try {
			dao.update(v);// dao 에게 insert하라고 요청, dao에서 받아온 Exception은 자동으로 던진다.
		} catch (Exception e) {// 위에서 발생한 예외 처리를 받아옴.
			throw e;// 예외를 잡아서 던져라!
		} finally {//정상적으로, 예외를 던지고도 결국 실행 !! 즉 어떤경우에도 실행 !
			transactionEnd();// 실행이 안되면 위에서 예외처리에 걸린 것임 즉 Dao부분에서 예외에 걸림
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
