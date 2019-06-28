package db2;

public abstract class DB {
	String ip;
	
	public DB() {
		
	}
	public DB(String ip) {//밑에 클래스가 쓰려고 하는거 !
		this.ip = ip;
	}
	
	public void connection() {
		System.out.println(ip + "Connect....");
	}
	
	public void close() {
		System.out.println(ip + "Close...");
	}
	
	public abstract void insert(Object obj);
	public abstract Object select(Object obj);
}
