package stat;

public class CalcTest {

	public static void main(String[] args) {
		int a = 10;
		int b = 10;
		int sum = 0;
		
		sum = Calc.sum(a, b);// ex) Math API - > 이건 그냥 static area에 오로지 기능만 넣어 났음
		int datas [] = {1,2,3,4,5};
		int sums = Calc.sum(datas);
	}

}
