package sport.game.component;

import sport.game.frame.Game;
import sport.game.inter.Ball;
import sport.game.inter.Run;

public class Football extends Game implements Ball, Run {

	String name;
	int player;
	int throwNum;
	int catchNum;

	public Football() {
	}

	public Football(String name, int player) {
		this.name = name;
		this.player = player;
	}

	@Override
	public void walk() {
		System.out.println("Walking");
	}

	@Override
	public void run() {
		System.out.println("Running");

	}

	@Override
	public void hit() {
		System.out.println("Hit!");

	}

	@Override
	public void throwball() {
		System.out.println("Throw~");
		throwNum++;
	}

	@Override
	public void catchBall() {
		System.out.println("Catch!");
		catchNum++;
	}

	@Override
	public void result() {
		if (catchNum > throwNum) {
			System.out.println("Lose..");
		} else if (catchNum < throwNum) {
			System.out.println("WIN!");
		} else if (catchNum == throwNum) {
			System.out.println("Draw");
		}
	}

	@Override
	public void move(int x, int y) {

		if (x < 0) {
			System.out.println("Going Left");
		}
		if (x > 0) {
			System.out.println("Going Right");
		}
		if (y > 0) {
			System.out.println("Going Up");
		}
		if (x > 0) {
			System.out.println("Going Down");
		}

	}

	@Override
	public String toString() {
		return "Football [name=" + name + ", player=" + player + "]";
	}

}
