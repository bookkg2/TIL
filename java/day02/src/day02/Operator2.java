package day02;

public class Operator2 {
	public static void main(String[] args) {
		double d = 3.14356523;
		//�Ҽ��� 3�ڸ� ���� ������ ����ϰ� ���
		double b = (int)(d*1000) / 1000.0;
//		double b = Math.floor(d*1000) / 1000.0;// Math.floor �� �Ҽ����� ������ ������ ������
		System.out.println(b);
		
		//�Ҽ��� 3�ڸ� ���� �ݿø��� ����ϰ� ���
		
		double d2 = (int)(d * 1000 + 0.5)/1000.0;//+0.5�� �ݿø� �ϱ����� ���
//		double e = Math.round(d * 1000); , Math.round = �ݿø� �ؼ� �� ����� ������ ������
		System.out.println(d2);
		
		//���� �ﰢ�� ���μ��ΰ� 5,4�� �ﰢ����
		//���� �� ���̸� ���Ͻÿ�.
		//hint Math Api�� �̿��� �� 
	//(1)	
//		double d4 = 0.0;
//		double a = 5;
//		double c = 4;
//		
//		 d4 = Math.sqrt(a*a + c*c); 
//		System.out.println(d4);
	
	//(2)
		double result = 0.0;
		result = Math.sqrt(Math.pow(5, 2) + Math.pow(4, 2));//Math.pow�� ���� ,Math.sqrt�� ��Ʈ JAVA ���̺귯��
		System.out.println(result);
		
		
	}

}
