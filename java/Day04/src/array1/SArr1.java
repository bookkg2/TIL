package array1;

import java.util.Arrays;

public class SArr1 {

	public static void main(String[] args) {
		int a[] = {3,5,4};
		String s1[] = {"B","A","C"};//String pool에 있는 B ,A, C의 주소가 들어감
		String s2[] = new String[3];//힙 메모리 안에 다시 주소가 들어감
		s2[0] = new String("A");
		s2[1] = new String("B");
		s2[2] = new String("C");
		
		String str = "ILOVEYOU";
		char []c = str.toCharArray();//ABCDEFG 다짤라져서 배열로 들어감
		for(int i =0; i <str.length();i++) {
			c[i] = (char)(c[i] + 3);
		}
		System.out.println(Arrays.toString(c));
		
		String newStr = new String(c);//각각의 문자를 문자열로
		System.out.println(newStr);

	}

}
