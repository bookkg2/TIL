package array1;

import java.util.Arrays;
import java.util.Random;

public class Arr4 {

	public static void main(String[] args) {
		int a[] = new int[100];// 100명이 실행
		
		//1~4까지의 숫자를 랜덤하게 배열에 입력
	
		
		Random r= new Random();
		for(int i = 0; i < a.length; i++) {
			a[i] = r.nextInt(4)+1;//다시 한번 확인
			
			
			
			
		}
		System.out.println(Arrays.toString(a));
		
		int count[] = new int[5];
		
		//투표 결과를 count 배열에 합산 하시오.
		
		for(int i=0; i < a.length;i++) {
			for(int j =0 ; j<count.length;j++)
				if(a[i] == j)
					count[j]++;
		}
		
		for(int c= 0 ; c<count.length;c++) {
			System.out.println((c)+ ":" + count[c]);
		}
//		System.out.println(Arrays.toString(count));
	}

}
