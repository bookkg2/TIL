package stat;

public class Calc {//우리만의 계산기
	public static int sum(int a, int b) {// static 을 쓰는 이유는 main에서 쓰려고 , 함수의 기능만 있을 때
		return (a+b);
	}
	public static int sum(int a[]) {//argument가 다르면 함수 이름을 같이 쓸수 있음 -> 오버로드(자바의 가장 큰 특징)
	 int sum = 0;
	 for(int data :a) {
		 sum +=data;
	 }
	 return sum;
	}
	
	
}
