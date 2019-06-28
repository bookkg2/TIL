package ws3;

import java.util.Arrays;
import java.util.Random;

public class Game {

	public static void main(String[] args) {
		Random r = new Random();
		int bru[][] = new int[8][8];
		boolean b[] = new boolean[100];
		int player1 = 1000;
		int player2 = 1000;
//		int num = 0;
		int i = 0;
		//while(true) {
			for(int j = 0; j < bru[i].length;j++ ) {
				int num = 0;
				num = r.nextInt(10)+1;
				
//				if(b[num]==true) {
//					continue;
//				}
				
				b[num] = true;
				bru[i][j] = num;
				
				
				
				
			}
			//break;
		//}
			
		for(int j = 0 ; j < bru.length;j++) {
		System.out.println(Arrays.toString(bru[j]));
		}
	
		
		
		
		
		
	}

}
