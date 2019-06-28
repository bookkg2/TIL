package sport.game.component;

import sport.game.frame.Game;
import sport.game.inter.Ball;
import sport.game.inter.Run;

public class Marathon extends Game implements Run {
	String name;
	int player;

	public Marathon() {

	}

	public Marathon(String name, int player) {
		this.name = name;
		this.player = player;
	}

	@Override
	public void walk() {
		System.out.println(player + "번이 걷는다");

	}

	@Override
	public void run() {
		System.out.println(player + "번이 뛴다");

	}

	@Override
	public void result() {
		System.out.println("금메달");

	}

	@Override
	public String toString() {
		return "Marathon [name=" + name + ", player=" + player + "]";
	}

	@Override
	public void move(int x, int y) {
		double d = 0;
		d = Math.hypot(x, y);
		System.out.println(d + "만큼 이동");
	}


}
