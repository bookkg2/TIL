package array1;

public class Ref {

	public static void main(String[] args) {
		//primitive type
		int a = 10;
		boolean b = true;
		char c = 'A';
		
		//reference type
		String s1 = "ABC";//String�� Ŭ���� -> �ڹ� API , s1�� Ŭ����Ÿ���� ���� �� s1�� HEAP�ּҸ� ����
		String s2 = new String("ABC");
		
		int r = a + c;
		System.out.println(r);

	}

}
