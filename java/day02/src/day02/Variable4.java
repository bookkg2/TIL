package day02;

public class Variable4 {

	public static void main(String[] args) {
		// Primitive Type
		int a=10;
		char c = 'a';
		//Reference Type
		String s1 = "abc";
		String s2 = "abc";
		String s3 = new String("abc");// Reference Type 다른 표현법 
		
		if(s1 == s2) {//메모리에 있는 주소를 비교 s1과 s2는 Heap에 있는 String pool 안에 있어서 주소가 같다.
			          //s3은 객체여서 s1과 주소가 다르다.
			System.out.println("case1");
		}
		
		if(s1.equals(s2)) {//값을 비교하고 싶으면 equals 를 사용
			System.out.println("case1");
		}
		
		int i1 = 10;//10진수
		int i2 = 010;//8진수
		int i3 = 0x10;//16진수
	
	    System.out.println(i1 + " " + i2 + " "+ i3);
	}

}
