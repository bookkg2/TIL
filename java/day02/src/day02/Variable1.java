package day02;

public class Variable1 {

	public static void main(String[] args) {
		int a = 10;
		int b = 10;
		double d = 123.456789;

		System.out.printf("\t result = %d,%d\n", a, b);
		System.out.printf("\t result = %o\n", a);// %o는 8진수
		System.out.printf("\t result = %x\n", a);// %x는 16진수
		System.out.printf("result = %10.3f\n", d);// 앞자리 10 자리 소수 3자리

	}

}
