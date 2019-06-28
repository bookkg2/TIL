package day02;

public class Operator2 {
	public static void main(String[] args) {
		double d = 3.14356523;
		//소숫점 3자리 이하 버림을 계산하고 출력
		double b = (int)(d*1000) / 1000.0;
//		double b = Math.floor(d*1000) / 1000.0;// Math.floor 는 소숫점을 버리고 정수로 돌려줌
		System.out.println(b);
		
		//소숫점 3자리 이하 반올림을 계산하고 출력
		
		double d2 = (int)(d * 1000 + 0.5)/1000.0;//+0.5는 반올림 하기위해 사용
//		double e = Math.round(d * 1000); , Math.round = 반올림 해서 그 결과를 정수로 돌려줌
		System.out.println(d2);
		
		//직각 삼각형 가로세로가 5,4인 삼각형의
		//빗변 의 길이를 구하시오.
		//hint Math Api를 이용할 것 
	//(1)	
//		double d4 = 0.0;
//		double a = 5;
//		double c = 4;
//		
//		 d4 = Math.sqrt(a*a + c*c); 
//		System.out.println(d4);
	
	//(2)
		double result = 0.0;
		result = Math.sqrt(Math.pow(5, 2) + Math.pow(4, 2));//Math.pow는 제곱 ,Math.sqrt는 루트 JAVA 라이브러리
		System.out.println(result);
		
		
	}

}
