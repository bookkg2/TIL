package recursive;

public class Power {

	public static void main(String[] args) {
		int x = 2;
		int n = 5;
		int result = 0;
		
		
		for(int i= 1 ; i <= n; i++ ) {
		    
			result += power(x,i);
			
		}
		System.out.println(result);
	}

	private static int power(int x, int n) {
		int result = 0;
		if(n == 1) {
			return x;
		}else {
		result = x * power(x, n-1);
		}
		return result;
	}

}
