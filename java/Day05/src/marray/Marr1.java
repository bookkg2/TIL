package marray;

import java.util.*;

public class Marr1 {

	public static void main(String[] args) {
		int a[] = new int[3];//dafault 값 -> 0
		
		int ma[][] = new int[5][5];
		
		System.out.println(ma.length);// 배열 기준에 행이여서 출력 2가 나옴
		System.out.println(ma[0].length); // 하면 3이 나옴
		
		Random r = new Random();
		
		for(int i = 0; i < ma.length;i++ ) {
			for(int j = 0; j < ma[i].length;j++) {
				ma[i][j] = r.nextInt(10)+1;
			}
		}
		System.out.println(Arrays.toString(ma));//주소가 찍힘
		
		for(int i = 0; i < ma.length;i++ ) {
			for(int j = 0; j < ma[i].length;j++) {
				System.out.println(ma[i][j] + " ");
			}
			System.out.println();
		}
		
		//Enhanced for Statement
		for(int temp[]:ma) {//ma에서 힙에 생긴 행 1차원 배열을 가져오고
			for(int data : temp) {//그 배열안에 있는 데이터 값을 가지고 온다.
				System.out.println(data + " ");
			}
		}
		
		//아니면
//		for(int i = 0 ; i < ma.length; i ++) {
//		  System.out.println(Arrays.toString(ma[i]));
//		}
		
	}

}
