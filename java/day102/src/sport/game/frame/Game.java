package sport.game.frame;

public abstract class Game {	

  	public void startGame() {
		System.out.println("������ �����մϴ�.");
	}
	public void endGame() {
		System.out.println("������ �����մϴ�.");
	}
	public abstract void result();
	public abstract void move(int x, int y);

}
