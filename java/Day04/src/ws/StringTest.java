package ws;

import java.util.*;

public class StringTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("소문자로 입력하시오.");
		String num = sc.next();
		char c[] = new char[num.length()];

		for (int i = 0; i < num.length(); i++) {
			c[i] = num.charAt(i);
		}

		for (int i = 0; i < c.length; i++) {
			if (c[i] > 'a' || c[i] < 'z') {
				c[i] -= 32;
			}

		}
		for (int j = c.length - 1; j > 0; j--) {// 버그는 범위 문제
			for (int i = 0; i < c.length; i++) {
				char temp = c[j];
				c[j] = c[j - 1];
				c[j - 1] = temp;
			}

		}

		System.out.println(Arrays.toString(c));
	}

}
