package array1;

import java.util.Random;

public class Arr1 {

	public static void main(String[] args) {
		int i = 10;
		int a[] = new int[10];// �迭 ������ Fix, �迭�� Ÿ���� Reference type
//		a[0] = 10;
//		a[1] = 30;
//		a[2] = 20;

		// a�迭�� �� �ε�����
		// 1~9������ ������ �߻� �Ͽ� �Է� �Ͻÿ�
		// for�� ���

		Random r = new Random();
		for (int in = 0; in < a.length; in++) {//���̺��� �۾��Ѵ� ������ ����

//			if(a[in] ==  )
//			{
//				continue;
//			}
			a[in] = r.nextInt(9) + 1;//1���� 9���� �ϱ� 
			

		}
		System.out.println(a);
		System.out.println(a.length);
		System.out.println("--------------------------------------------");

		//System.out.println(a);
		//System.out.println(a.length);// �迭�� ����

//		for(int ind = 0 ; ind < a.length; ind++) {
//			System.out.println(a[ind]);///a�� ���� �������ÿ�
//		}

		for (int temp : a) {// a �ȿ� �ִ� int Ÿ�� '��'�� temp�� ����.���ڽ� for ��Ʈ����Ʈ ���,
							// ���� : �ƹ��������� �����͸� ��ġ��� ���� ���� : ������Ҵ����� ��
			System.out.println(temp);
		}

	}

}
