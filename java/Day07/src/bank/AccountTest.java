package bank;

public class AccountTest {

	public static void main(String[] args) {
		Account acc1 = null; // reference Ÿ���� �ʱⰪ��  null
		Account acc2 = null;
		try {
			acc1 = new Account("Kim" , "12345" , 10000);
			System.out.println(acc1);
			System.out.println(Account.cnt);// Ŭ���� ������ ���� �� why? �޼��� ������ �����ϱ�
			acc2 = new Account("Lee" , "12346" , 20000);
			System.out.println(acc2);
			System.out.println(Account.cnt);
			
		} catch (Exception e) {
			System.out.println(e.getMessage()); // Ŭ������ getMessage : Exception ���� �޼��� ������ 
		}

	}

}
