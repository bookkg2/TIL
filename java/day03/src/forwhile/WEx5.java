package forwhile;

public class WEx5 {

	public static void main(String[] args) {
//		int i = 0;
//		int sum = 0;
//		while (i <= 10) {
//			if (i == 7) {//break는 무조건 먼저 첫번째에 하는 것이 좋다.
//				break;
//
//			}
//			if (i % 2 == 0) {//for문이랑 차이 i++을 증가시켜줘야 한다. for는 조건문에 증감식이 있어서
//				i++;
//				continue;// 밑에는 SKip!! 하고 while로 이동, 이걸 안쓰면 밑에 Process가 계속 나옴
//				}
//
//			sum += i;
//
//			i++;
//			System.out.println("Process");
//
//			
//
//		}
//		System.out.println(sum);

		// for 문
		int i = 0;
		int sum = 0;
		for (; i <= 10; i++) {
			if (i == 6) {
				break;
			}
			if (i % 2 == 0) {
				continue;//밑에는 Skip ->for문으로 이동
			}
			sum += i;
			System.out.println("Process");

		}
		System.out.println(sum);
	}

}
