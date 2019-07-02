package tv2;

public class App {
	public static void main(String args[]) {
		TV stv = new STV();
		TV ltv = new LTV();
		stv.turnOn();
		stv.volumeUp(10);
		System.out.println(stv);
	}
}
