package array1;

import java.util.Random;

public class Arr1 {

	public static void main(String[] args) {
		int i = 10;
		int a[] = new int[10];// 배열 사이즈 Fix, 배열도 타입이 Reference type
//		a[0] = 10;
//		a[1] = 30;
//		a[2] = 20;

		// a배열의 각 인덱스에
		// 1~9까지의 난수를 발생 하여 입력 하시오
		// for문 사용

		Random r = new Random();
		for (int in = 0; in < a.length; in++) {//길이보다 작아한다 같으면 오류

//			if(a[in] ==  )
//			{
//				continue;
//			}
			a[in] = r.nextInt(9) + 1;//1에서 9까지 니깐 
			

		}
		System.out.println(a);
		System.out.println(a.length);
		System.out.println("--------------------------------------------");

		//System.out.println(a);
		//System.out.println(a.length);// 배열의 길이

//		for(int ind = 0 ; ind < a.length; ind++) {
//			System.out.println(a[ind]);///a의 값을 가져오시오
//		}

		for (int temp : a) {// a 안에 있는 int 타입 '값'을 temp에 저장.인핸스 for 스트레이트 기술,
							// 장점 : 아무생각없이 데이터를 펼치기는 편함 단점 : 몇번돌았는지는 모름
			System.out.println(temp);
		}

	}

}
