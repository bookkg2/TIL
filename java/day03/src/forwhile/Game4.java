package forwhile;

import java.util.Random;
import java.util.Scanner;

public class Game4 {

	public static void main(String[] args) {
		int count = 0;
		int result = 0;
		String user = " ";
		Scanner sc = new Scanner(System.in);
		int i = 0;

		while (true) {

			Random r = new Random(); // Random ��ü ����
			int num = 0;
			num = r.nextInt(3) + 1; // 1 ~ 3���� ���� ����

			int a = 0;
			System.out.println("������ ���� �̴ϱ� ?");
			user = sc.nextLine();
			if (user.endsWith("q")) {
				break;
			}

			a = Integer.parseInt(user);
			result = num - a;

			if (a < 0 || a > 3) {
				System.out.println("�ٽ� �Է��Ͻÿ� (0 ~ 3 )");
			}

			

			switch (result) {
			case 0:
				System.out.println("���º�");
				break;
			case 1:
				System.out.println("�Ľ�");
				break;
			case 2:
			case -1:
				System.out.println("������");
				count++;
				break;
			case -2:
				System.out.println("�Ľ�");
				break;
			
					
			}

			i++;
			
			
		}
		System.out.println("���� Ƚ�� : " + i);
		System.out.println("�̱� Ƚ���� : " + count);

	}

}
