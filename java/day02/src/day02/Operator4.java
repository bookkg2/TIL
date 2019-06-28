package day02;

public class Operator4 {

	public static void main(String[] args) {
		String result = "";
		int a = 10;
		int b = 20;
//		if(a > b) {
//			result = "A"; 
//		}else {
//			result = "B";
//		}
		
		//삼항 연산자로 바꿔라
		
//	    result = (a > b) ? "A" : "B";
//		System.out.println(result);
		
		int i1 = 20;
		int i2 = 10;
		int i3 = 30;
		
		// 최대값을 구하시오
		// 단, 3항 연산자를 이용 할 것 
		int max = 0;
		
		max = (i1 > i2) ? ((i1 > i3) ? i1 : i3) : ((i2 > i3) ? i2 : i3 ) ;
		System.out.println(max);
		
	}

}
