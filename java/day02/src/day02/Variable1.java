package day02;

public class Variable1 {

	public static void main(String[] args) {
		int a = 10;
		int b = 10;
		double d = 123.456789;

		System.out.printf("\t result = %d,%d\n", a, b);
		System.out.printf("\t result = %o\n", a);// %o�� 8����
		System.out.printf("\t result = %x\n", a);// %x�� 16����
		System.out.printf("result = %10.3f\n", d);// ���ڸ� 10 �ڸ� �Ҽ� 3�ڸ�

	}

}
