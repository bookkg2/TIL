package forwhile;

public class WEx1 {

	public static void main(String[] args) {
//		// for
//		for(int i = 1; i<=10;i++) {
//			System.out.println(i);
//		}
//		// while
//		int i = 1;
//		while(i<=10) {
//			System.out.println(i);
//			i++;
//		}

		// 2중 for 문
		for (int a = 0; a <= 10; a++) {
			for (int b = 10; b >= 0; b--) {
				System.out.println(a + " " + b);

			}

		}
		System.out.println();
		
		//while 문으로 

		int n = 0;

		while (n <= 10 ) {
			int m = 10;
			while (m >= 0) {
				System.out.println(n + " " + m);
				m--;
			}
			n++;

		}

	}

}
