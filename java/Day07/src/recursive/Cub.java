package recursive;

public class Cub {
	
	public static void main(String[] args) {
		int x = 2;
		int n = 5;
		int result = cub(x,n);
		System.out.println(result);

	}

	private static int cub(int x, int n) {
		int result = 0;
		if(n == 1) {
			return x;
		}else {
		result = x * cub(x, n-1);
		}
		return result;
	}

}
