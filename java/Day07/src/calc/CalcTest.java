package calc;

import java.util.Arrays;

public class CalcTest {

	public static void main(String[] args) {
		int a[] = { 5, 3, 7, 6, 2, 1 };

		Calc c = new Calc(a);
		System.out.println(c.sum(a));
		System.out.println(c.avg(a));

		System.out.println(Arrays.toString(c.asort(a)));
		System.out.println(Arrays.toString(c.desort(a)));

	}

}
