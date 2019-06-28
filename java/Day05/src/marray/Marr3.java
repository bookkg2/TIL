package marray;

import java.util.Arrays;
import java.util.Random;

public class Marr3 {

	public static void main(String[] args) {
		// 2차원 배열을 이용하여
		// 5명의 학생의 4과목 점수를
		// 생성 하여 출력 하시오

	
		int arr[][] = new int[5][4];
		int result = 0;
		Random r = new Random();

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = r.nextInt(100) + 1;
			}
		}
		for (int temp[] : arr) {// ma에서 힙에 생긴 행 1차원 배열을 가져오고
			for (int data : temp) {// 그 배열안에 있는 데이터 값을 가지고 온다.
				System.out.printf("%d\t", data);
			}
			System.out.println();
		}

		// 학생 별 평균을 출력 하시오.

	//	double sum = 0.0;
//			for(int i = 0; i < arr.length; i++) {
//				sum = 0.0;//다 돌고 다시 리셋
//				result = 0;//다 돌고 다시 리셋
//				for(int j = 0; j < arr[i].length; j++) {
//					result += arr[i][j];
//				}
//				sum = (double)(result / arr[i].length);
//				
//				System.out.println(i+"학생의 평균은 : " + sum);
//			}

		// 과목 별 평균을 출력 하시오.
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
		
		// 전체 평균을 출력 하시오.
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
