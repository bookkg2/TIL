package db;

public abstract class Dao {
	private String ip;//ip ��巹��

	public Dao() {
	}

	public Dao(String ip) {
		this.ip = ip;
	}
	
	public void connection() {//ip �ּҷ� ������ ���̽��� ������ �ߴ�.
		System.out.println(ip + ": connected...");
	}
	
	public void close() {
		System.out.println(ip + ": closed...");
	}
	
	public abstract void insert(Object obj);//�߻� �Լ� , ��� Ŭ������ Object�� ��� �޾Ƽ�!!
	public abstract Object select(Object obj);//��δ� ���� �� �� �ְ� Object�� ���� !!
	public abstract void delete(Object obj);
	
}
