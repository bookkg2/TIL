package day02;

import java.util.Scanner;

public class Operator3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);// �ڵ� import Ctrl + Shift + 5
		String data = sc.next();
		char c = data.charAt(0); // �ڹ� ���̺귯�� : String �� �ִ� 0��° ���� �־��.
		if (('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z')) {
			
			System.out.println("�����Դϴ�.");
			
			sc.close();// �����ָ� ����������.
			return;//Main�� ����

		} else {
			System.out.println("�����Դϴ�.");
		}
		
		c++;
		System.out.println(c);
		sc.close();

	}
}
