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
		
			System.out.println(i+"번째 로또 구매:");
		
			for (int j = 0; j < 6; j++) {
				System.out.println("로또 숫자를 입력하세요");
				
				int count = sc.nextInt();
				
				
				if(check[count] == true) {
					System.out.println("중복값을 입력 했네요 (욕심쟁이 !!)");
					continue;
				}
				
				check[count] = true;
				
				if(count<0||count >20)
				{
					System.out.println("로또 숫자를 넘었습니다. 다시 입력하세요");
					j--;
					continue;
				}
				
				 buyRotto[i][j] = count;
			}
		}

	

	}

}
