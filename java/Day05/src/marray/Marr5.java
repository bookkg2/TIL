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
		//1~10������ ���ڰ� �ִ�
		//�Է� ���� ������ ����Ͻÿ�
		int a = 56; 
		out://for �� �ΰ��� ���߰� �ϱ� ���Ͽ�
		for(int i = 0; i < ma.length;i++ ) {
			for(int j = 0; j < ma[i].length;j++) {
				System.out.print(ma[i][j] + " ");
				if(ma[i][j] == a) {
					break out; // �ȿ� For���� ����
				}
			}
			System.out.println();
		}
	}

}
