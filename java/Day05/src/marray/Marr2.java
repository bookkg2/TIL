package marray;

import java.util.Arrays;
import java.util.Random;

public class Marr2 {

	public static void main(String[] args) {
		//�Ǵٸ� �迭 ����
//				int ma[][] = {
//						{2,4,3,5},
//						{8,4,3,5},
//						{3,4,3,5},
//						{1,4,3,5},
//				};
		// int ma[][] = new int[3][4];

		int ma[][] = new int[3][];// �̰� ���� ,int ma[][] = new int[][3]; ������ ��� �Ұ���
		ma[0] = new int[5];// �޸� ���� �׷����鼭 ���� !!
		ma[1] = new int[2];
		ma[2] = new int[3];
		
		
		Random r = new Random();

		for (int i = 0; i < ma.length; i++) {
			for (int j = 0; j < ma[i].length; j++) {
				ma[i][j] = r.nextInt(10) + 1;
			}
		}
		for(int temp[]:ma) {//ma���� ���� ���� �� 1���� �迭�� ��������
			for(int data : temp) {//�� �迭�ȿ� �ִ� ������ ���� ������ �´�.
				System.out.printf("%d\t",data );
			}
			System.out.println();
		}
	}

}
