package bank;

public class Account {
	private String owner;
	private String accNum;
	private double balance;
	public static int cnt = 0;//static : 클래스 변수 (JVM 메서드 영역 안으로 들어감)
	
	public Account() {
		
	}
	public Account(String owner, String accNum, double balance) throws Exception {// Exception 경고 메세지 오류 처리
		if(accNum.length() != 5 ) { // String 의 사이즈   == length
			throw new Exception("E1000"); // E1000 에러 메세지 출력
		}
		this.owner = owner;
		this.accNum = accNum+cnt;// String 이 int 보다 우선 
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
			throw new Exception("E0001");//"E0001" : 에러 메시지
		}
		if(this.balance < money) {// 들어 오는 값이 balance 보다 크면 경고
			throw new Exception("E0002");
		}
		this.balance -= money;
	}
	
	public void deposit(double money) throws Exception {// Exception 문제가 발생 할 수 있어요 ,
		if(money <= 0) {
			throw new Exception("E0001");//"E0001" : 에러 메시지 출력
		}
		this.balance += money;
	}
	
	

}
