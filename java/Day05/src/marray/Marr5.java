package marray;

import java.util.Random;
import java.util.Scanner;

public class Marr5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ma[][] = new int[5][5];
		Random r = new Random();

		for (int i = 0; i < ma.length; i++) {
			for (int j = 0; j < ma[i].length; j++) {
				ma[i][j] = r.nextInt(100) + 1;
			}
		}
		//1~10까지의 숫자가 있다
		//입력 받은 값까지 출력하시오
		int a = 56; 
		out://for 문 두개다 멈추게 하기 위하여
		for(int i = 0; i < ma.length;i++ ) {
			for(int j = 0; j < ma[i].length;j++) {
				System.out.print(ma[i][j] + " ");
				if(ma[i][j] == a) {
					break out; // 안에 For문만 멈춤
				}
			}
			System.out.println();
		}
	}

}
