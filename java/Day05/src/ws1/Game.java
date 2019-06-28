package ws1;

import java.util.*;

public class Game {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Random r = new Random();
		int num = 0;
		int user[] = new int[4];
		int com[] = new int[4];
		boolean b[] = new boolean[100];

		int a = 0;
		while (true) {

			if (a == com.length) {
				break;
			}

			num = r.nextInt(10);// 2

			if (b[num] == true) {
				continue;
			}
			b[num] = true;

			com[a] = num;

			a++;
		}

		int loop = 0;
		while (true) {
			System.out.println(Arrays.toString(com));
			System.out.println("4자리 숫자를 입력하시오");
			for (int i = 0; i < 4; i++) {
				System.out.print(i + "째 자리 :");
				user[i] = sc.nextInt();

			}
			System.out.println(Arrays.toString(user));
			int counts = 0;
			int countb = 0;
			for (int i = 0; i < com.length; i++) {
				for (int j = 0; j < user.length; j++) {
					if (com[i] == user[j] && i == j) {
						counts++;

					} else if (com[i] == user[j] && i != j) {
						countb++;
					}

				}
			}
			if (counts == 4) {
				System.out.println("홈런 !!!");
			} else if (counts == 0 && countb == 0) {
				System.out.println("아웃ㅠㅠ");
			}
			System.out.println(counts + "S" + countb + "B");

			break;

		}

	}

}
