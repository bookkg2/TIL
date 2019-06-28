package db;

public abstract class Dao {
	private String ip;//ip 어드레스

	public Dao() {
	}

	public Dao(String ip) {
		this.ip = ip;
	}
	
	public void connection() {//ip 주소로 데이터 베이스에 접속을 했다.
		System.out.println(ip + ": connected...");
	}
	
	public void close() {
		System.out.println(ip + ": closed...");
	}
	
	public abstract void insert(Object obj);//추상 함수 , 모든 클래스는 Object에 상속 받아서!!
	public abstract Object select(Object obj);//모두다 리턴 할 수 있게 Object로 리턴 !!
	public abstract void delete(Object obj);
	
}
