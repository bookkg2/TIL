package ifswitch;

import java.util.Random;
import java.util.Scanner;

public class Game1 {

	public static void main(String[] args) {
		// Math.Random

//		double num = 0;
//		num = (int)(Math.random()*10)+1;//JAVA 라이브러리, double을 10 곱하면 0~ 9.xxxxx 니깐 INT로 해서
//		                                //0 부터9까지 숫자범위 출력 되고 1을 더해서 1부터 9까지 정수
//		//2. Random
//		Random r= new Random(); // import는 Ctrl + shif + o
//		int num2 = 0;
//		num2 = r.nextInt(3) +1;//0~2까지 이고 1을 더해서 1에서 3까지
//	
//		
//		System.out.println(num);

		// 1. 사용자는 1~3값을 입력 한다.
		// 2. 1~3 이외의 문자가 들어오면 "안녕" 이라고 출력하고 프로그램 종료.
		// 3. 컴퓨터는 1~3의 숫자를 랜덤하게 만든다.
		// 4. 사용자 숫자와 비교하여 이겼는지 졌는지 출력한다.

		Scanner sc = new Scanner(System.in);
		System.out.println("문자를 입력하시오");
		int com = 0;
		String user = " ";
		int a;
		user = sc.nextLine();
		a = Integer.parseInt(user);

		if (a < 1 | a > 3) {
			System.out.println("안녕");
			sc.close();
			return;
		}

		Random r = new Random();
		com = r.nextInt(3) + 1;

		int result = com - a;
		
		switch (result) {
		case 0:
			System.out.println("무승부");
			break;
		case 1:
			System.out.println("컴승");
			break;
		case 2: case -1:
			System.out.println("유저승");
			break;
		default : 
			System.out.println("컴승");
			break;
		}
		
		sc.close();
			
	}

}
