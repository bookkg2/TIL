package marray;

import java.util.*;

public class Marr1 {

	public static void main(String[] args) {
		int a[] = new int[3];//dafault �� -> 0
		
		int ma[][] = new int[5][5];
		
		System.out.println(ma.length);// �迭 ���ؿ� ���̿��� ��� 2�� ����
		System.out.println(ma[0].length); // �ϸ� 3�� ����
		
		Random r = new Random();
		
		for(int i = 0; i < ma.length;i++ ) {
			for(int j = 0; j < ma[i].length;j++) {
				ma[i][j] = r.nextInt(10)+1;
			}
		}
		System.out.println(Arrays.toString(ma));//�ּҰ� ����
		
		for(int i = 0; i < ma.length;i++ ) {
			for(int j = 0; j < ma[i].length;j++) {
				System.out.println(ma[i][j] + " ");
			}
			System.out.println();
		}
		
		//Enhanced for Statement
		for(int temp[]:ma) {//ma���� ���� ���� �� 1���� �迭�� ��������
			for(int data : temp) {//�� �迭�ȿ� �ִ� ������ ���� ������ �´�.
				System.out.println(data + " ");
			}
		}
		
		//�ƴϸ�
//		for(int i = 0 ; i < ma.length; i ++) {
//		  System.out.println(Arrays.toString(ma[i]));
//		}
		
	}

}
