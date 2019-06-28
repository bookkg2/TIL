package day02;

import java.util.Scanner;

public class Operator3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);// 자동 import Ctrl + Shift + 5
		String data = sc.next();
		char c = data.charAt(0); // 자바 라이브러리 : String 에 있는 0번째 값을 넣어라.
		if (('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z')) {
			
			System.out.println("문자입니다.");
			
			sc.close();// 안해주면 끝나버린다.
			return;//Main이 종료

		} else {
			System.out.println("숫자입니다.");
		}
		
		c++;
		System.out.println(c);
		sc.close();

	}
}
