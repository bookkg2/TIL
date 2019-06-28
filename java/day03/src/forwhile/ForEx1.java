package forwhile;

public class ForEx1 {

	public static void main(String[] args) {
		System.out.println("Start");
		// 두 수의 곱이 5의 배수인 것들의 합
		int i = 1, j = 10;
		int sum = 0;
		for (; i <= 10 && j >= 0; i++, j--) {
			System.out.println(i + " " + j);
			if ((i * j) % 5 == 0) {
				sum = i*j;
			}
			
		}
		System.out.println(sum);
		
		

//		for(; i<=10 && j <= 5;i++,j++) {//i,j는 for문에만 도는 local 변수임
//			System.out.print(i+" "+j+",");
//		}

		// 1부터 10까지 홀수만 출력
//		for (int i = 1; i <= 10; i++) {
//			if (i % 2 != 0) {
//				System.out.println(i);
//			}
//		}

//		// 10부터 0까지 출력 하시오
//		for (int i = 10; i >= 0; i--) {
//			System.out.print(i);
//
//		}
//		System.out.println();// 한칸 밑으로

//		for (int i = 0; i < 10; i++) {
//			System.out.print(i);
//
//		}

//		System.out.println("Last Value:" + (i+j));// 한칸 밑으로
		System.out.println("End");

	}

}
