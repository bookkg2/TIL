package day02;

import java.util.Scanner;

public class Variable3 {

	public static void main(String[] args) {
		// 4������ ������ ������ �Է� �޴´�.
		// �հ� �� ����� ���Ͻÿ�.

		Scanner sc = new Scanner(System.in);

		double sum = 0.0;
		double e = 0.0;

		System.out.println("ù��° ������ ������ ?");
		String kor = sc.next();
		System.out.println("2��° ������ ������ ?");
		String eng = sc.next();
		System.out.println("3��° ������ ������ ?");
		String math = sc.next();
		System.out.println("4��° ������ ������ ?");
		String sci = sc.next();
		
		int a = Integer.parseInt(kor);
		int b = Integer.parseInt(eng);
		int c = Integer.parseInt(math);
		int d = Integer.parseInt(sci);
		
		sc.close();
		sum = a + b + c + d;
		e =  (sum) / 4;

		System.out.printf("�հ�� : %d\n", sum);
		System.out.printf("����� : %2.2f", e);
	}

}
