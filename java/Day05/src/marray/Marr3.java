package marray;

import java.util.Arrays;
import java.util.Random;

public class Marr3 {

	public static void main(String[] args) {
		// 2���� �迭�� �̿��Ͽ�
		// 5���� �л��� 4���� ������
		// ���� �Ͽ� ��� �Ͻÿ�

	
		int arr[][] = new int[5][4];
		int result = 0;
		Random r = new Random();

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = r.nextInt(100) + 1;
			}
		}
		for (int temp[] : arr) {// ma���� ���� ���� �� 1���� �迭�� ��������
			for (int data : temp) {// �� �迭�ȿ� �ִ� ������ ���� ������ �´�.
				System.out.printf("%d\t", data);
			}
			System.out.println();
		}

		// �л� �� ����� ��� �Ͻÿ�.

	//	double sum = 0.0;
//			for(int i = 0; i < arr.length; i++) {
//				sum = 0.0;//�� ���� �ٽ� ����
//				result = 0;//�� ���� �ٽ� ����
//				for(int j = 0; j < arr[i].length; j++) {
//					result += arr[i][j];
//				}
//				sum = (double)(result / arr[i].length);
//				
//				System.out.println(i+"�л��� ����� : " + sum);
//			}

		// ���� �� ����� ��� �Ͻÿ�.
//     double cavg = 0.0;
//		
//		for (int i = 0; i < arr[0].length; i++) {
//			 int sum = 0;
//			 
//			for (int j = 0; j < arr.length; j++) {
//				 sum += arr[j][i];
//
//			}
//			cavg = (double)(sum / (arr.length));
//			
//			System.out.print(cavg);
//			
//			
//		}
//		System.out.println("--------------------------------------");
//		
//		
		
		// ��ü ����� ��� �Ͻÿ�.
//		double avg = 0.0;
//		int total = 0;
//		 for(int i = 0 ; i < arr.length; i++) {
//			 
//			 for(int j= 0 ; j<arr[i].length;j++) {
//				total += arr[i][j];
//			 }
//			 
//		 }
//		 avg = (double)(total / (arr.length*arr[0].length));
//		 System.out.println(avg);
//		
//		 int sum3=-0;
//		 for(int[] temp : arr) {
//			 for(int i : temp) {
//				 sum3 += i;
//			 }
//		 }
	}

}
