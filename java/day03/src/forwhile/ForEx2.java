package forwhile;

public class ForEx2 {

	public static void main(String[] args) {
		// 가위바위보 메트릭스를 출력하시오
		// p151

		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
//				int result = i - j;
//				switch(result) {
//				case 0 : 
//					System.out.print(" " + "무승부");
//					
//					break;
//				case -1: case 2:
//					System.out.print(" " + "컴승");
//					
//					break;
//				case -2: case 1:
//					System.out.print(" " + "유저승");
//					break;
//				}
				int z = i - j;
				String str = " ";
				if (z == 0) {
					str = "무승부";
				} else if (z == -1 || z == 2) {
					str = "컴승";
				} else {
					str = "유저승";
				}
				System.out.print(str + " ");
			}

			System.out.println();
		}

	}

}
