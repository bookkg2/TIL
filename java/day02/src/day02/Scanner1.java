package day02;

import java.util.Scanner;//���̺귯�� import

public class Scanner1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);// Scanner �� java�� �������ִ� ���̺귯�� �׷��� import
		System.out.println("Input Number..?");
		String data = sc.nextLine();
		int intNum = Integer.parseInt(data);// ���ڸ� ������ ��ȯ . Integer�� �ڹٰ� �����ϴ� ���̺귯��
		System.out.println(intNum * 100);
		sc.close();
	}

}
