package tv;

public class App {

	public static void main(String[] args) {
		STV stv = new STV(); //new »ç¿ë (Not Ioc)
		stv.turnOn();
		stv.volumeUp(10);
		System.out.println(stv);
	}

}
