package forwhile;

public class WEx3 {

	public static void main(String[] args) throws InterruptedException {
		int i = 5;
//		while(++i <= 10) {// �������� ��� �ֳĿ� ���� �ٸ��� ���´�. ������ 1�� �����ϰ� �۵�
//			System.out.println(i);
//			
//		}

		while(i-- != 0) {
			Thread.sleep(1000);//���� ���� �Ǵ� ���μ����� 1�ʵ��� ����� 1000�� 1��
			System.out.println(i);
		}
		
	}

}
