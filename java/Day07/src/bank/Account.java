package bank;

public class Account {
	private String owner;
	private String accNum;
	private double balance;
	public static int cnt = 0;//static : Ŭ���� ���� (JVM �޼��� ���� ������ ��)
	
	public Account() {
		
	}
	public Account(String owner, String accNum, double balance) throws Exception {// Exception ��� �޼��� ���� ó��
		if(accNum.length() != 5 ) { // String �� ������   == length
			throw new Exception("E1000"); // E1000 ���� �޼��� ���
		}
		this.owner = owner;
		this.accNum = accNum+cnt;// String �� int ���� �켱 
		this.balance = balance;
		cnt++;
	}
	public String getOwner() {
		return owner;
	}
	public String getAccNum() {
		return accNum;
	}
	public double getBalance() {
		return balance;
	}
	@Override
	public String toString() {
		return "Account [owner=" + owner + ", accNum=" + accNum + ", balance=" + balance + "]";
	}

	public void withdraw(double money) throws Exception {
		if(money <= 0) {
			throw new Exception("E0001");//"E0001" : ���� �޽���
		}
		if(this.balance < money) {// ��� ���� ���� balance ���� ũ�� ���
			throw new Exception("E0002");
		}
		this.balance -= money;
	}
	
	public void deposit(double money) throws Exception {// Exception ������ �߻� �� �� �־�� ,
		if(money <= 0) {
			throw new Exception("E0001");//"E0001" : ���� �޽��� ���
		}
		this.balance += money;
	}
	
	

}
