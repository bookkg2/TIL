package ws4;

import java.util.Arrays;
import java.util.Random;

public class Game {

	public static void main(String[] args) {
		int[][] blu = new int[8][8];
		int player1 = 1000;
		int player2 = 1000;

		Random r = new Random();
		boolean[] check = new boolean[11];
		for (int j = 0; j < blu.length; j++) {

			blu[0][j] = r.nextInt(10) + 1;
			blu[j][0] = r.nextInt(10) + 1;
			if (check[blu[0][j]] == true) {
				j--;
				continue;
			} else if (check[blu[j][0]] == true) {
				j--;
				continue;

			}

			check[blu[0][j]] = true;
			check[blu[j][0]] = true;

		}

		for (int a = 0; a < blu.length; a++) {

			System.out.println(Arrays.toString(blu[a]));

		}
	}

}
