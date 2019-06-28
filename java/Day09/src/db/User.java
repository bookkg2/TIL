package db;

public class User {//User 라는 객체를 만들어서 전달 
	String id;
	String name;
	String pwd;
	public User() {
		
	}
	public User(String id, String name, String pwd) {
		this.id = id;
		this.name = name;
		this.pwd = pwd;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", pwd=" + pwd + "]";
	}
	
}
