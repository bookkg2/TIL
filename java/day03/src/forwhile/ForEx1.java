package forwhile;

public class ForEx1 {

	public static void main(String[] args) {
		System.out.println("Start");
		// �� ���� ���� 5�� ����� �͵��� ��
		int i = 1, j = 10;
		int sum = 0;
		for (; i <= 10 && j >= 0; i++, j--) {
			System.out.println(i + " " + j);
			if ((i * j) % 5 == 0) {
				sum = i*j;
			}
			
		}
		System.out.println(sum);
		
		

//		for(; i<=10 && j <= 5;i++,j++) {//i,j�� for������ ���� local ������
//			System.out.print(i+" "+j+",");
//		}

		// 1���� 10���� Ȧ���� ���
//		for (int i = 1; i <= 10; i++) {
//			if (i % 2 != 0) {
//				System.out.println(i);
//			}
//		}

//		// 10���� 0���� ��� �Ͻÿ�
//		for (int i = 10; i >= 0; i--) {
//			System.out.print(i);
//
//		}
//		System.out.println();// ��ĭ ������

//		for (int i = 0; i < 10; i++) {
//			System.out.print(i);
//
//		}

//		System.out.println("Last Value:" + (i+j));// ��ĭ ������
		System.out.println("End");

	}

}
