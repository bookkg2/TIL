package marray;

import java.util.Arrays;
import java.util.Random;

public class Marr2 {

	public static void main(String[] args) {
		//또다른 배열 선언
//				int ma[][] = {
//						{2,4,3,5},
//						{8,4,3,5},
//						{3,4,3,5},
//						{1,4,3,5},
//				};
		// int ma[][] = new int[3][4];

		int ma[][] = new int[3][];// 이건 가능 ,int ma[][] = new int[][3]; 기준이 없어서 불가능
		ma[0] = new int[5];// 메모리 구조 그려가면서 공부 !!
		ma[1] = new int[2];
		ma[2] = new int[3];
		
		
		Random r = new Random();

		for (int i = 0; i < ma.length; i++) {
			for (int j = 0; j < ma[i].length; j++) {
				ma[i][j] = r.nextInt(10) + 1;
			}
		}
		for(int temp[]:ma) {//ma에서 힙에 생긴 행 1차원 배열을 가져오고
			for(int data : temp) {//그 배열안에 있는 데이터 값을 가지고 온다.
				System.out.printf("%d\t",data );
			}
			System.out.println();
		}
	}

}
