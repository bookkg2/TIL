package day02;

import java.util.Scanner;

public class Scanner2 {

	public static void main(String[] args) {
		//2���� ���ڸ� �޾� ���δ�.
		// a / b �� ����Ѵ�.
		// ��½� �Ҽ��� 3�ڸ����� ��� �Ͻÿ�.
		 
//		Scanner sc = new Scanner(System.in);
//		System.out.println("�ΰ��� ���ڸ� �Է��Ͻÿ�.");
//		int a= sc.nextInt();
//		int b = sc.nextInt();
//		
//		double result = (double)a / (double)b;
//		
//		System.out.printf("����� : %10.3f" , result);
//		

		Scanner sc = new Scanner(System.in);
		System.out.println("���ڸ� �Է��Ͻÿ�.");
		String a = sc.nextLine();//sc.next : �ϸ� ��ĭ�� ��� �ѹ��� �ΰ��� ���� �� �ִ�.
		System.out.println("���ڸ� �Է��Ͻÿ�.");
		String b = sc.nextLine();
		
		int i1 = Integer.parseInt(a);
		int i2 = Integer.parseInt(b);
		
		double result= 0;
		result = (double)i1/ (double)i2;//int�� ������ double�� ó�� �ؾ��Ѵ�. ,ctrl + space ġ�� �ڹٿ��� �����ϴ� ���̺귯���� �� �� �ִ�.
		
		System.out.printf("����� : %10.3f" , result);
		
		//sc.close();
		
		// ��ĭ�� �� ���ڸ� �����ÿ�.
		String data1 = sc.next();
		String data2 = sc.next();
		
		System.out.println(data1 + " " + data2);
		sc.close();
	}

}

