package ws;

import java.util.Arrays;
import java.util.Scanner;

public class GradeTest {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int grade[] = new int[4];
		System.out.println("4���� ������ �Է��Ͻÿ�.");
		for(int i =0 ; i< grade.length;i++) {
			grade[i] = sc.nextInt();
		}
		Grade grade1 = new Grade();
		System.out.println("�� ���� :" + grade1.sum(grade));
		System.out.println("����� :" + grade1.evg(grade));
		System.out.println("������ :" + grade1.score(grade));
		System.out.println("���� ���� ���� : " + grade1.highlean(grade));
		System.out.println("���� ���� ���� : " + grade1.lowlean(grade));
		System.out.println("�������� : " + Arrays.toString(grade1.asort(grade)));
		System.out.println("�������� : " + Arrays.toString(grade1.desort(grade)));
		
		
		
		

	}

}
