package frame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Dao<K, V> {
	

	public void close(PreparedStatement con) {
		if(con !=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void close(ResultSet con) {
		if(con !=null) {//null 이면 어떠한 함수도 호출 할 수 없어서 오류!
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public abstract void insert(V v,Connection con) throws Exception;//Biz가 주는 Connection(commit 할지 Rollback 할지 )

	public abstract void delete(K k,Connection con) throws Exception;

	public abstract void update(V v,Connection con) throws Exception;

	public abstract V select(K k,Connection con) throws Exception;

	public abstract ArrayList<V> select(Connection con) throws Exception;
}
