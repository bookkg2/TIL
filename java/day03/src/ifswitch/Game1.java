package ifswitch;

import java.util.Random;
import java.util.Scanner;

public class Game1 {

	public static void main(String[] args) {
		// Math.Random

//		double num = 0;
//		num = (int)(Math.random()*10)+1;//JAVA ���̺귯��, double�� 10 ���ϸ� 0~ 9.xxxxx �ϱ� INT�� �ؼ�
//		                                //0 ����9���� ���ڹ��� ��� �ǰ� 1�� ���ؼ� 1���� 9���� ����
//		//2. Random
//		Random r= new Random(); // import�� Ctrl + shif + o
//		int num2 = 0;
//		num2 = r.nextInt(3) +1;//0~2���� �̰� 1�� ���ؼ� 1���� 3����
//	
//		
//		System.out.println(num);

		// 1. ����ڴ� 1~3���� �Է� �Ѵ�.
		// 2. 1~3 �̿��� ���ڰ� ������ "�ȳ�" �̶�� ����ϰ� ���α׷� ����.
		// 3. ��ǻ�ʹ� 1~3�� ���ڸ� �����ϰ� �����.
		// 4. ����� ���ڿ� ���Ͽ� �̰���� ������ ����Ѵ�.

		Scanner sc = new Scanner(System.in);
		System.out.println("���ڸ� �Է��Ͻÿ�");
		int com = 0;
		String user = " ";
		int a;
		user = sc.nextLine();
		a = Integer.parseInt(user);

		if (a < 1 | a > 3) {
			System.out.println("�ȳ�");
			sc.close();
			return;
		}

		Random r = new Random();
		com = r.nextInt(3) + 1;

		int result = com - a;
		
		switch (result) {
		case 0:
			System.out.println("���º�");
			break;
		case 1:
			System.out.println("�Ľ�");
			break;
		case 2: case -1:
			System.out.println("������");
			break;
		default : 
			System.out.println("�Ľ�");
			break;
		}
		
		sc.close();
			
	}

}
