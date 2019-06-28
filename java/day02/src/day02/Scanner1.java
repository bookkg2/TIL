package day02;

import java.util.Scanner;//라이브러리 import

public class Scanner1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);// Scanner 는 java가 제공해주는 라이브러리 그래서 import
		System.out.println("Input Number..?");
		String data = sc.nextLine();
		int intNum = Integer.parseInt(data);// 문자를 정수로 변환 . Integer는 자바가 제공하는 라이브러리
		System.out.println(intNum * 100);
		sc.close();
	}

}
