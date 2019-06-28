package forwhile;

import java.util.Random;
import java.util.Scanner;

public class Game4 {

	public static void main(String[] args) {
		int count = 0;
		int result = 0;
		String user = " ";
		Scanner sc = new Scanner(System.in);
		int i = 0;

		while (true) {

			Random r = new Random(); // Random 객체 생성
			int num = 0;
			num = r.nextInt(3) + 1; // 1 ~ 3까지 랜덤 실행

			int a = 0;
			System.out.println("무엇을 내실 겁니까 ?");
			user = sc.nextLine();
			if (user.endsWith("q")) {
				break;
			}

			a = Integer.parseInt(user);
			result = num - a;

			if (a < 0 || a > 3) {
				System.out.println("다시 입력하시오 (0 ~ 3 )");
			}

			

			switch (result) {
			case 0:
				System.out.println("무승부");
				break;
			case 1:
				System.out.println("컴승");
				break;
			case 2:
			case -1:
				System.out.println("유저승");
				count++;
				break;
			case -2:
				System.out.println("컴승");
				break;
			
					
			}

			i++;
			
			
		}
		System.out.println("진행 횟수 : " + i);
		System.out.println("이긴 횟수는 : " + count);

	}

}
