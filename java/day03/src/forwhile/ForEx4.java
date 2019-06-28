package forwhile;

public class ForEx4 {

	public static void main(String[] args) {
		//주사위 3개를 굴렸을 때 나올수 있는 경우의 수 
		for (int i = 1; i <= 6; i++) {
			for (int j = 1; j <= 6; j++) {
				for (int z = 1; z <= 6; z++) {
					System.out.printf("%d%d%d \t", i ,j ,z);
				  
				}
			}
				System.out.println();
		}

	}
}
