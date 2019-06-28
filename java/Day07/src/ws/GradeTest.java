package ws;

import java.util.Arrays;
import java.util.Scanner;

public class GradeTest {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int grade[] = new int[4];
		System.out.println("4개의 과목을 입력하시오.");
		for(int i =0 ; i< grade.length;i++) {
			grade[i] = sc.nextInt();
		}
		Grade grade1 = new Grade();
		System.out.println("총 합은 :" + grade1.sum(grade));
		System.out.println("평균은 :" + grade1.evg(grade));
		System.out.println("학점은 :" + grade1.score(grade));
		System.out.println("가장 높은 점수 : " + grade1.highlean(grade));
		System.out.println("가장 낮은 점수 : " + grade1.lowlean(grade));
		System.out.println("오름차순 : " + Arrays.toString(grade1.asort(grade)));
		System.out.println("내림차순 : " + Arrays.toString(grade1.desort(grade)));
		
		
		
		

	}

}
