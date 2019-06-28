package array1;

import java.util.Arrays;

public class Arr2 {

	public static void main(String[] args) {
			int a[] = new int[5];
			a[0] = 1;
			a[1] = 5;
			a[2] = 3;
				
			int b[] = {1,5,3};//이렇게 한번에 넣을 수도 있다.
			int c[] = {6,7,8,9,4};
			
			for(int i=0 ; i<b.length;i++) {//b 배열을 c에 복사 copy 방법(1)
				c[i] = b[i];
				
				
				
			}
			
			System.out.println(Arrays.toString(c));//배열은 for문 돌려서 출력해야 하는 데 , 자바는 Arrays.toString API를 제공
			
		    System.arraycopy(b, 1, c, 3, 2);//b의, 몇번째 부터 복사하여c, 의 몇번째 부터 붙이겠습니다, 몇개를
			System.out.println(Arrays.toString(c));
			
			
	}

}
