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
		
		//���� �����ڷ� �ٲ��
		
//	    result = (a > b) ? "A" : "B";
//		System.out.println(result);
		
		int i1 = 20;
		int i2 = 10;
		int i3 = 30;
		
		// �ִ밪�� ���Ͻÿ�
		// ��, 3�� �����ڸ� �̿� �� �� 
		int max = 0;
		
		max = (i1 > i2) ? ((i1 > i3) ? i1 : i3) : ((i2 > i3) ? i2 : i3 ) ;
		System.out.println(max);
		
	}

}
