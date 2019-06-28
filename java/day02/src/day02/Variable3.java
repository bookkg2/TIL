package day02;

import java.util.Scanner;

public class Variable3 {

	public static void main(String[] args) {
		// 4과목의 점수를 정수로 입력 받는다.
		// 합계 와 평균을 구하시오.

		Scanner sc = new Scanner(System.in);

		double sum = 0.0;
		double e = 0.0;

		System.out.println("첫번째 과목의 점수는 ?");
		String kor = sc.next();
		System.out.println("2번째 과목의 점수는 ?");
		String eng = sc.next();
		System.out.println("3번째 과목의 점수는 ?");
		String math = sc.next();
		System.out.println("4번째 과목의 점수는 ?");
		String sci = sc.next();
		
		int a = Integer.parseInt(kor);
		int b = Integer.parseInt(eng);
		int c = Integer.parseInt(math);
		int d = Integer.parseInt(sci);
		
		sc.close();
		sum = a + b + c + d;
		e =  (sum) / 4;

		System.out.printf("합계는 : %d\n", sum);
		System.out.printf("평균은 : %2.2f", e);
	}

}
