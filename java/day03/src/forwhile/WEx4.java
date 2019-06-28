package forwhile;

public class WEx4 {

	public static void main(String[] args) {
		int sum = 0;
		int i = 0;

//		//피보나치 수열
//		while((sum += ++i) <= 100) {
//			System.out.println(i + " " + sum);
//		}

		// for 문으로 변경
		for (int ss = 1, ii =1; ss<=100; ss+=++ii) {//while은 조건식에서 1을 증가하고 하니깐 
													//여기서는 같으려면 초기값을 1로!!!
			
				System.out.println(ii+ " " + ss);
			
		}
	}

}
