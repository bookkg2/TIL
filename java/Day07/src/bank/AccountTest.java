package bank;

public class AccountTest {

	public static void main(String[] args) {
		Account acc1 = null; // reference 타입의 초기값은  null
		Account acc2 = null;
		try {
			acc1 = new Account("Kim" , "12345" , 10000);
			System.out.println(acc1);
			System.out.println(Account.cnt);// 클래스 변수에 접근 법 why? 메서드 영역에 있으니깐
			acc2 = new Account("Lee" , "12346" , 20000);
			System.out.println(acc2);
			System.out.println(Account.cnt);
			
		} catch (Exception e) {
			System.out.println(e.getMessage()); // 클래스의 getMessage : Exception 에러 메세지 가져옴 
		}

	}

}
