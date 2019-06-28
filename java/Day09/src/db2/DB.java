package db2;

public abstract class DB {
	String ip;
	
	public DB() {
		
	}
	public DB(String ip) {//�ؿ� Ŭ������ ������ �ϴ°� !
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
