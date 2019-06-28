package array1;

import java.util.Arrays;
import java.util.Random;

public class Arr3 {

	public static void main(String[] args) {
		int a[] = new int[5];
		int sum = 0;
		float evg = 0;
		//10~99까지의 숫자를 랜덤하게 배열에 입력
		//합과 평균을 구하시오
		
		Random r= new Random();
		for(int i = 0; i < a.length; i++) {
			a[i] = r.nextInt(90) + 10;//다시 한번 확인
			sum += a[i];
			evg = sum / (float)a.length;
			
			
			
		}
		System.out.println(Arrays.toString(a));
		System.out.println("총점은 : " + sum);
		System.out.println("평균은 : " + evg);
		System.out.println("----------------------------------------------");
		
		
		//최대 값과 최소 값을 출력하시오
		int max = a[0];
		int min = a[0];
		
		for(int j = 1 ; j < a.length; j++) {//초기 a[0] 보다는 1로 초기화 해서 시작 해도 됨 , 
										    //굳이 0번째를 가져 올 필요 없다.
			a[j] = r.nextInt(90) +10;
			if(a[j] > max) {
				max = a[j];
			}else if(a[j] < min) {
				min = a[j];
			}
		}
		
		System.out.println(Arrays.toString(a));
		System.out.println("최댓값은 : " + max);
		System.out.println("최소값은 : " + min);
		System.out.println("----------------------------------------------");

		
		//작은 수 부터 정렬 하시오.
		for(int i=0;i<a.length;i++) {
			for(int j = 0; j<a.length-1-i;j++) {//앞에 기준 값을 정하니 -1번만 확인하면된다.
				if(a[j] > a[j+1]) {
					int temp = a[j];//왜냐하면 없어지니깐 따로 저장 
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
			
		}
		
		System.out.println(Arrays.toString(a));
		System.out.println("----------------------------------------");
		
		//큰 순서부터 나열 하시오
		for(int i=0;i<a.length;i++) {
			for(int j = 0; j<a.length-1-i;j++) {//앞에 기준 값을 정하니 -1번만 확인하면된다.
				if(a[j] < a[j+1]) {
					int temp = a[j];//왜냐하면 없어지니깐 따로 저장 
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
			
		}
		System.out.println(Arrays.toString(a));
		System.out.println("----------------------------------------");
		//배열에 있는 숫자들의 합을 구하시오,
	
		int count[] = new int[100];
		//{0,0,0,0,0,0..........................}
		for(int i =0; i < a.length;i++) {
			count[a[i]]++;
		}
		for(int i =0; i < count.length;i++) {
			System.out.println(i + " : "+ count[i]);
		}
		
		
	}

}
