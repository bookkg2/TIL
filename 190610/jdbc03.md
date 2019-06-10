### SQL 활용(3) (Eclipce)!

- User

```java
package com;

import java.sql.Connection;
import java.util.ArrayList;

import frame.Biz;
import frame.Dao;
import vo.User;

public class UserBiz extends Biz<String, User> {
	
	Dao<String,User> dao;
	public UserBiz() {
		dao = new UserDao();
	}
	@Override
	public void register(User v) throws Exception {
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
	public void modify(User v) throws Exception {
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
	public User get(String k) throws Exception {
		Connection con = null;
		User u = null;

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
	public ArrayList<User> get() throws Exception {
		Connection con = null;
		User u = null;
		ArrayList<User> list = new ArrayList<>() ;
		try {
			con = getCon();
			list = dao.select(con);
		}catch(Exception e) {
			throw e;
		}finally {
			close(con);
		}
		return null;
	}

}

```



- UserBiz

  ```java
  package com;
  
  import java.sql.Connection;
  import java.util.ArrayList;
  
  import frame.Biz;
  import frame.Dao;
  import vo.User;
  
  public class UserBiz extends Biz<String, User> {
  	
  	Dao<String,User> dao;
  	public UserBiz() {
  		dao = new UserDao();
  	}
  	@Override
  	public void register(User v) throws Exception {
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
  	public void modify(User v) throws Exception {
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
  	public User get(String k) throws Exception {
  		Connection con = null;
  		User u = null;
  
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
  	public ArrayList<User> get() throws Exception {
  		Connection con = null;
  		User u = null;
  		ArrayList<User> list = new ArrayList<>() ;
  		try {
  			con = getCon();
  			list = dao.select(con);
  		}catch(Exception e) {
  			throw e;
  		}finally {
  			close(con);
  		}
  		return null;
  	}
  
  }
  
  ```

  

- UserDao

```java
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
	public void insert(User v, Connection con) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(Sql.insertUser);
			pstmt.setString(1, v.getId());
			pstmt.setString(2, v.getName());
			pstmt.setString(3, v.getPwd());
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;// Exception으로 던짐
		} finally {
			close(pstmt);// 반드시 실행 될 수 있도록 ~
		}
	}

	@Override
	public void delete(String k, Connection con) throws Exception {

		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(Sql.insertDelete);
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
			pstmt = con.prepareStatement(Sql.insertUpdate);
			pstmt.setString(1, v.getPwd());
			pstmt.setString(2, v.getName());
			pstmt.setString(3, v.getId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			close(pstmt);
		}

	}

	@Override
	public User select(String k, Connection con) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = con.prepareStatement(Sql.insertSelect);
			pstmt.setString(1, k);

			rset = pstmt.executeQuery();// ORACLE 로직에 접근
			rset.next();// 한 칸 옮겨야함 ,빈공간을 처음에 가르키고 있어서
			String uid = rset.getString("ID");
			String upwd = rset.getString("PWD");
			String uname = rset.getString("NAME");
			System.out.println(uid + " " + upwd + " " + uname);
		} catch (Exception e) {
			throw e;
		} finally {
			close(pstmt);
		}
		return null;
	}

	@Override
	public ArrayList<User> select(Connection con) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = con.prepareStatement(Sql.insertSelectAll);

			rset = pstmt.executeQuery();
			while (rset.next()) {
				String uid = rset.getString("ID");
				String upwd = rset.getString("PWD");
				String uname = rset.getString("NAME");
				System.out.println(uid + " " + upwd + " " + uname);

			}
		} catch (Exception e) {
			throw e;
		} finally {
			close(pstmt);
			close(rset);
		}
		return null;
	}

}

```

- Biz

```java
package frame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Biz<K,V> {

	String id;
	String pwd;
	String url;

	public Biz() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {

			System.out.println("Driver Loading Error...");
		}
		id = "db";
		pwd = "db";
		url = "jdbc:oracle:thin:@70.12.50.225:1521:xe";
	}

	public Connection getCon() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, id, pwd);
			con.setAutoCommit(false);//transcation 내가 관리 할거야 ~(Commit , Rollback)
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return con;
	}

	public void close(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}
	public abstract void register(V v) throws Exception;

	public abstract void remove(K k) throws Exception;

	public abstract void modify(V v) throws Exception;

	public abstract V get(K k) throws Exception;

	public abstract ArrayList<V> get() throws Exception;
	
	
}



```

- Dao

```java
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

```

- Sql

```java
package frame;

public class Sql {//static은 객체 생성 안하고도 쓸 수 있음 
	public static String insertUser = "INSERT INTO T_USER VALUES(?,?,?)";
	public static String insertDelete = "DELETE FROM T_USER WHERE ID = ?";
	public static String insertUpdate = "UPDATE T_USER SET PWD=?,NAME=? WHERE ID=?";
	public static String insertSelect = "SELECT * FROM T_USER WHERE ID =?";
	public static String insertSelectAll = "SELECT * FROM T_USER ";
	
}

```

- Test(UserInsert)

```java
package test;

import vo.User;

import com.UserBiz;

import frame.Biz;

public class UserInsert {

	public static void main(String[] args) {
		User u = new User("id67","pwd67","이말숙");//rollback 당해서 안들어감
		Biz<String, User> biz= new UserBiz();
		
		try {
			biz.register(u);
			System.out.println("OK");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

```

- Test(UserDelete)

```java
package test;

import com.UserBiz;

import frame.Biz;
import vo.User;

public class UserDelete {

	public static void main(String[] args) {
        Biz<String,User> biz = new UserBiz();
		
		try {
			biz.remove("id06");
			System.out.println("Delete");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}

```

- Test(UserSelect)

```java
package test;

import com.UserBiz;

import frame.Biz;
import vo.User;

public class UserSelect {

	public static void main(String[] args) {
		
		
		Biz<String,User> biz = new UserBiz();
		
		try {
			biz.get("id55");
			System.out.println("Select");
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}

```

- Test(UserSelectAll)

```java
package test;

import com.UserBiz;
import com.UserDao;

import frame.Biz;
import frame.Dao;
import vo.User;

public class UserSelectAll {

	public static void main(String[] args) {
     Biz<String,User> biz = new UserBiz();
		
		try {
			biz.get();
			System.out.println("Select");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

```

- Test(UserUpdate)

```java
package test;

import com.UserBiz;

import frame.Biz;
import vo.User;

public class UserUpdate {

	public static void main(String[] args) {
		User user = new User( "id55", "2222","김재영");
		Biz<String,User> biz = new UserBiz();
		try {
			biz.modify(user);
			System.out.println("수정완료 ");
		}catch(Exception e) {
			e.getStackTrace();
		}
	}

}

```

