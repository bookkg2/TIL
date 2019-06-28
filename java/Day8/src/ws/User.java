package ws;

import java.util.Arrays;
import java.util.Scanner;

public class User {
	Account acc;
	String name;
	int[][] Number;

	public User(Account acc, String name) {
		this.acc = acc;
		this.name = name;
	}

	public User(Account acc, String name, int[][] number) {
		this.acc = acc;
		this.name = name;
		Number = number;
	}

	@Override
	public String toString() {
		return "User [acc=" + acc.getSerialNumber() + ", name=" + name + ", Number=" + Arrays.toString(Number) + "]";
	}

	public void buyRotto(int number) {
		
		Scanner sc = new Scanner(System.in);
	
		int[][] buyRotto = new int[number][6];
		boolean[]check = new boolean[21];
	

		for (int i = 0; i < number; i++) {
		
			System.out.println(i+"��° �ζ� ����:");
		
			for (int j = 0; j < 6; j++) {
				System.out.println("�ζ� ���ڸ� �Է��ϼ���");
				
				int count = sc.nextInt();
				
				
				if(check[count] == true) {
					System.out.println("�ߺ����� �Է� �߳׿� (������� !!)");
					continue;
				}
				
				check[count] = true;
				
				if(count<0||count >20)
				{
					System.out.println("�ζ� ���ڸ� �Ѿ����ϴ�. �ٽ� �Է��ϼ���");
					j--;
					continue;
				}
				
				 buyRotto[i][j] = count;
			}
		}

	

	}

}
