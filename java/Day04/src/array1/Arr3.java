package array1;

import java.util.Arrays;
import java.util.Random;

public class Arr3 {

	public static void main(String[] args) {
		int a[] = new int[5];
		int sum = 0;
		float evg = 0;
		//10~99������ ���ڸ� �����ϰ� �迭�� �Է�
		//�հ� ����� ���Ͻÿ�
		
		Random r= new Random();
		for(int i = 0; i < a.length; i++) {
			a[i] = r.nextInt(90) + 10;//�ٽ� �ѹ� Ȯ��
			sum += a[i];
			evg = sum / (float)a.length;
			
			
			
		}
		System.out.println(Arrays.toString(a));
		System.out.println("������ : " + sum);
		System.out.println("����� : " + evg);
		System.out.println("----------------------------------------------");
		
		
		//�ִ� ���� �ּ� ���� ����Ͻÿ�
		int max = a[0];
		int min = a[0];
		
		for(int j = 1 ; j < a.length; j++) {//�ʱ� a[0] ���ٴ� 1�� �ʱ�ȭ �ؼ� ���� �ص� �� , 
										    //���� 0��°�� ���� �� �ʿ� ����.
			a[j] = r.nextInt(90) +10;
			if(a[j] > max) {
				max = a[j];
			}else if(a[j] < min) {
				min = a[j];
			}
		}
		
		System.out.println(Arrays.toString(a));
		System.out.println("�ִ��� : " + max);
		System.out.println("�ּҰ��� : " + min);
		System.out.println("----------------------------------------------");

		
		//���� �� ���� ���� �Ͻÿ�.
		for(int i=0;i<a.length;i++) {
			for(int j = 0; j<a.length-1-i;j++) {//�տ� ���� ���� ���ϴ� -1���� Ȯ���ϸ�ȴ�.
				if(a[j] > a[j+1]) {
					int temp = a[j];//�ֳ��ϸ� �������ϱ� ���� ���� 
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
			
		}
		
		System.out.println(Arrays.toString(a));
		System.out.println("----------------------------------------");
		
		//ū �������� ���� �Ͻÿ�
		for(int i=0;i<a.length;i++) {
			for(int j = 0; j<a.length-1-i;j++) {//�տ� ���� ���� ���ϴ� -1���� Ȯ���ϸ�ȴ�.
				if(a[j] < a[j+1]) {
					int temp = a[j];//�ֳ��ϸ� �������ϱ� ���� ���� 
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
			
		}
		System.out.println(Arrays.toString(a));
		System.out.println("----------------------------------------");
		//�迭�� �ִ� ���ڵ��� ���� ���Ͻÿ�,
	
		int count[] = new int[100];
		//{0,0,0,0,0,0..........................}
		for(int i =0; i < a.length;i++) {
			count[a[i]]++;
		}
		for(int i =0; i < count.length;i++) {
			System.out.println(i + " : "+ count[i]);
		}
		
		
	}

}
