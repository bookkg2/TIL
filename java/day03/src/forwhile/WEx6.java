package forwhile;

public class WEx6 {

	public static void main(String[] args) {
		// 구구단을 출력 하시오
		// 홀수 단만 출력하시오
		// 결과가 49일때 멈추시오
		int go = 0;
		out ://어디 for문까지 Out 할건지
		for (int i = 2; i <= 9; i++) {
//			if(go == 1) {//두개의 for문을 종료 하기 위하여
//				break;
//			}
			if (i % 2 == 0) {
				continue;
			}

			for (int j = 1; j <= 9; j++) {
				int result = i * j;
				if (result == 49) {
//					go = 1;//1을 주고 안에 for문 종료

					break out;//전체 모든 for문 종료->자바 라이브러리, break;는 현재 for문만 종료
				}

				System.out.printf("%d 단 : %d * %d = %d\n", i, i, j, result);
			}
		}

	}

}
