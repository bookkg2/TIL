package array1;

public class Ref {

	public static void main(String[] args) {
		//primitive type
		int a = 10;
		boolean b = true;
		char c = 'A';
		
		//reference type
		String s1 = "ABC";//String은 클래스 -> 자바 API , s1은 클래스타입의 변수 즉 s1은 HEAP주소를 가짐
		String s2 = new String("ABC");
		
		int r = a + c;
		System.out.println(r);

	}

}
