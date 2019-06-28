package w2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int count = 0;
		char al[][] = new char[9][9];
		char can[][] = new char[9][9];

		for (int i = 0; i < al.length; i++) {
			for (int j = 0; j < can.length; j++)
				al[i][j] = (char) ((Math.random() * 26) + 65);

		}
		for (int i = 0; i < can.length; i++) {
			for (int j = 0; j < can.length; j++) {
				can[i][j] = al[i][j];
			}
		}
		for (int i = 0; i < can.length; i++) {

			System.out.println(Arrays.toString(can[i]));

		}
		
		
		int userStart[][] = new int[9][9];
		int userChange[][] = new int[9][9];
		char temp[][] = new char[9][9];
		char temp2[] = new char[10];
		
		
		int loof = 0;
		while (true) {
			if(loof == 10) {
				break;
			}

			System.out.println("바꾸고 싶은 좌표는 ? ");
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			System.out.println("어느 좌표랑 ? ");
			int num3 = sc.nextInt();
			int num4 = sc.nextInt();
			if ((Math.abs((num3 - num1) + Math.abs(num4 - num2))) == 1  ) {
				temp[num1][num2] = can[num1][num2];
				can[num1][num2] = can[num3][num4];
				can[num3][num4] = temp[num1][num2];
				
			} else {
				System.out.println("하나씩만 가자!!");
				continue;
			}
			for(int i = 0 ; i < can.length; i++) {
				for(int j = 1 ; j < can.length-1; j++) {
					if(can[i][j-1] == can[i][j] && can[i][j] == can[i][j+1] ) {
					count ++;
					for(int h = j+1; h>= j-1; h--)
					can[i][h] = (char) ((Math.random() * 26) + 65);
					}
				}
			}
			for (int i = 0; i < can.length; i++) {
				
				System.out.println(Arrays.toString(can[i]));
			}

			loof++;
		}
		System.out.println("총 점수는 : " + count);
		
	}

}
