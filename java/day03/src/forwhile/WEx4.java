package forwhile;

public class WEx4 {

	public static void main(String[] args) {
		int sum = 0;
		int i = 0;

//		//�Ǻ���ġ ����
//		while((sum += ++i) <= 100) {
//			System.out.println(i + " " + sum);
//		}

		// for ������ ����
		for (int ss = 1, ii =1; ss<=100; ss+=++ii) {//while�� ���ǽĿ��� 1�� �����ϰ� �ϴϱ� 
													//���⼭�� �������� �ʱⰪ�� 1��!!!
			
				System.out.println(ii+ " " + ss);
			
		}
	}

}
