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
			System.out.println("4�ڸ� ���ڸ� �Է��Ͻÿ�");
			for (int i = 0; i < 4; i++) {
				System.out.print(i + "° �ڸ� :");
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
				System.out.println("Ȩ�� !!!");
			} else if (counts == 0 && countb == 0) {
				System.out.println("�ƿ��Ф�");
			}
			System.out.println(counts + "S" + countb + "B");

			break;

		}

	}

}
