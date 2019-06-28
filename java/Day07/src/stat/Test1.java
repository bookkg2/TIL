package stat;

public class Test1 {
	static int temp =0; // static main 안에서 사용 할거니깐 static 을 붙여 줘야함 
	public static int max(int a, int b) {// 객체 지향 X 단지 함수를 만든거임 , main이 static 이여서 반드시 static 함수만 쓸 수 있음 
		
		int max =0;
		if(a > b) {
			max = a;
		}else {
			max = b;
		}
		return max;
		
	}
	public static void main(String[] args) {
		int a  = 10;
		int b = 20;
		temp = 0;
		temp = max(a,b);
		System.out.println(temp);
		
	}

}
