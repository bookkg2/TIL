package recursive;

public class Factorial {

	public static void main(String[] args) {
		int n = 5;
		int result = 0;
		result = factorial(n);
		
		System.out.println(result);
	}

	private static int factorial(int n) {
		int result = 0;
		if(n == 1) {
			result = 1;
		}else {
			result = n * factorial(n-1);// factorial는 다른 곳에서 실행되는 중 
		}
		return result;
//		if(n <= 1) return 1;//1일때 까지만 
//		
//		return n * factorial(n-1);// 다시 자신을 호출
	}

}
