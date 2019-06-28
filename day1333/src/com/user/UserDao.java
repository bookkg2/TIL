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
		} catch (Exception e) {
			throw e;
		} finally {
			close(pstmt);
		}
	}

	@Override
	public void delete(String k, Connection con) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(Sql.deleteUser);
			pstmt.setString(1, k);
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			close(pstmt);
		}
	}

	@Override
	public void update(User v, Connection con) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(Sql.updateUser);
			pstmt.setString(1, v.getPwd()); // ���� �ٲ� �н�����
			pstmt.setString(2, v.getName()); // ���� �ٲ� �̸�
			pstmt.setString(3, v.getId()); // ���⿡ ��� ID ������ ������Ʈ �� ������ ID���� �־������
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
	}

	@Override
	public User select(String k, Connection con) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		User suser = null; // SELECT �� ���� ������ ��Ƽ� �����ؾ� �ϹǷ� USER �ʿ�
		try {
			pstmt = con.prepareStatement(Sql.selectUser);
			pstmt.setString(1, k); // �޾ƿ� ������ ID �Է�
			rset = pstmt.executeQuery();
			rset.next();
			String sid = rset.getString("ID");
			String spwd = rset.getString("PWD");
			String sname = rset.getString("NAME");
			suser = new User(sid, spwd, sname); // ������ ���� ���
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return suser; // ���⼭ ����
	}

	@Override
	public ArrayList<User> select(Connection con) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		User suser = null;
		ArrayList<User> susers = new ArrayList<User>(); // !! ArrayList �ʱ�ȭ !!
		try {
			pstmt = con.prepareStatement(Sql.selectAllUser);
			rset = pstmt.executeQuery();

			while (rset.next()) {

				String sid = rset.getString("ID");
				String spwd = rset.getString("PWD");
				String sname = rset.getString("NAME");
				suser = new User(sid, spwd, sname);
				susers.add(suser);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return susers;
	}

}
