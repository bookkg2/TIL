package day02;

public class Variable4 {

	public static void main(String[] args) {
		// Primitive Type
		int a=10;
		char c = 'a';
		//Reference Type
		String s1 = "abc";
		String s2 = "abc";
		String s3 = new String("abc");// Reference Type �ٸ� ǥ���� 
		
		if(s1 == s2) {//�޸𸮿� �ִ� �ּҸ� �� s1�� s2�� Heap�� �ִ� String pool �ȿ� �־ �ּҰ� ����.
			          //s3�� ��ü���� s1�� �ּҰ� �ٸ���.
			System.out.println("case1");
		}
		
		if(s1.equals(s2)) {//���� ���ϰ� ������ equals �� ���
			System.out.println("case1");
		}
		
		int i1 = 10;//10����
		int i2 = 010;//8����
		int i3 = 0x10;//16����
	
	    System.out.println(i1 + " " + i2 + " "+ i3);
	}

}
