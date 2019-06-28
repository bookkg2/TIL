package sprt.game.test;

import java.util.Scanner;

import sport.game.component.Baseball;
import sport.game.component.Football;
import sport.game.component.Marathon;
import sport.game.frame.Game;

public class GameTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("어느 게임을 하시겠습니까 ?");
		String nam = sc.next();
		int palyer = sc.nextInt();
		
		switch (nam) {
		case "b":
			
			Baseball b = new Baseball(nam, palyer);
			b.startGame();
			String key = sc.next();
			if(key.equals("s") ) {
				b.catchBall();
			}
			System.out.println(b);
			break;
		case "m":
			Marathon m = new Marathon(nam, palyer);
			System.out.println(m);

			break;
		case "f":
			Football f = new Football(nam, palyer);
			System.out.println(f);
			break;

		}
		
		
		

	

	}

}
