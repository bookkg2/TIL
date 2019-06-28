package day02;

import java.util.Scanner;

public class Scanner2 {

	public static void main(String[] args) {
		//2개의 숫자를 받아 들인다.
		// a / b 를 계산한다.
		// 출력시 소숫점 3자리까지 출력 하시오.
		 
//		Scanner sc = new Scanner(System.in);
//		System.out.println("두개의 숫자를 입력하시오.");
//		int a= sc.nextInt();
//		int b = sc.nextInt();
//		
//		double result = (double)a / (double)b;
//		
//		System.out.printf("결과는 : %10.3f" , result);
//		

		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하시오.");
		String a = sc.nextLine();//sc.next : 하면 한칸을 띄고 한번에 두개를 받을 수 있다.
		System.out.println("숫자를 입력하시오.");
		String b = sc.nextLine();
		
		int i1 = Integer.parseInt(a);
		int i2 = Integer.parseInt(b);
		
		double result= 0;
		result = (double)i1/ (double)i2;//int를 각각을 double로 처리 해야한다. ,ctrl + space 치면 자바에서 제공하는 라이브러리를 볼 수 있다.
		
		System.out.printf("결과는 : %10.3f" , result);
		
		//sc.close();
		
		// 한칸에 띄어서 문자를 받으시오.
		String data1 = sc.next();
		String data2 = sc.next();
		
		System.out.println(data1 + " " + data2);
		sc.close();
	}

}

