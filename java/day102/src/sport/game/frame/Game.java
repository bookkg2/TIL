package sport.game.frame;

public abstract class Game {	

  	public void startGame() {
		System.out.println("게임을 시작합니다.");
	}
	public void endGame() {
		System.out.println("게임을 종료합니다.");
	}
	public abstract void result();
	public abstract void move(int x, int y);

}
