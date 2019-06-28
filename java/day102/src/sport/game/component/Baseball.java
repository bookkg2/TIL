package sport.game.component;

import sport.game.frame.Game;
import sport.game.inter.Ball;
import sport.game.inter.Run;

public class Baseball extends Game implements Ball, Run {
	String name;
	int player;
	Game g = null;
	public Baseball() {
	}
	
	public Baseball(String name, int player) {
		this.name = name;
		this.player = player;
	}
	


	@Override
	public void walk() {
		
	
		System.out.println(this.player + "�ȴ´�.");
		

	}

	@Override
	public void run() {
		
		System.out.println(this.player + "�ڴ�.");
	}

	@Override
	public void hit() {
	
		System.out.println(this.player + "Ÿ��");
	}

	@Override
	public void throwball() {
		System.out.println(this.player + "������.");
		
	}

	@Override
	public void catchBall() {
		System.out.println(this.player + "��´�.");

	}

	@Override
	public void result() {
		
		System.out.println(this.player + "�� �̰���ϴ�.");
	}

	@Override
	public void move(int x, int y) {
		g.startGame();
		
		g.endGame();
		
	}
	

	@Override
	public String toString() {
		return "Baseball [name=" + name + ", player=" + player + "]";
	}

}
