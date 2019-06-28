package ws;

import java.util.*;

public class Vote {

	public static void main(String[] args) {
		int vote[] = new int[10];
		int check[] = new int[6];
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int count = 0;
		Random r = new Random();
		for (int i = 0; i < vote.length; i++) {
			vote[i] = r.nextInt(5) + 1;
		}
		for (int i = 0; i < vote.length; i++) {
			for (int j = 1; j < check.length; j++)
				if (vote[i] == j)
					check[j]++;
		}

		System.out.println("��ǥ ��� : " + Arrays.toString(vote));
		System.out.println("--------------------------------------------------");
		System.out.println("�� �ĺ� ��ǥ ��Ȳ : ");
		for (int c = 1; c < check.length; c++) {
			System.out.println((c) + "��" + ":" + check[c]);
		}
		int maxIndex =0;
		int minIndex =0;
		for (int j = 1; j < check.length; j++) {
						
			if (check[j] > max) {
				max = check[j];
				maxIndex = j;
				
			} 
			if (check[j] < min) {
				min = check[j];
				minIndex = j;
			}
		}
		
		System.out.println("�ִ� ��ǥ�� : " + maxIndex);
		System.out.println("�ּ� ��ǥ�� : " + minIndex);

		System.out.println("--------------------------------------------------");
		for (int i = 0; i < check.length; i++) {
			for (int j = 0; j < check.length - 1 - i; j++) {
				if (check[j] < check[j + 1]) {
					int temp = check[j];
					check[j] = check[j + 1];
					check[j + 1] = temp;
				}
			}

		}

		System.out.println("��ǥ�� ���� ���� ������ : " + Arrays.toString(check));
		
		for (int i = 0; i < check.length; i++) {
			for (int j = 0; j < check.length - 1 - i; j++) {
				if (check[j] > check[j + 1]) {
					int temp = check[j];
					check[j] = check[j + 1];
					check[j + 1] = temp;
				}
			}

		}

		System.out.println("��ǥ�� ���� ���� ������ : " + Arrays.toString(check));
		
	}

}
