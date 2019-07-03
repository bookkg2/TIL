package springtv;

public class STV implements TV {
	String status;
	int volume;
	int size;
	String color;
	
	
	public STV() {
		System.out.println("Constructor STV ...");
	}
	public void startTV() {
		System.out.println("Start STV ...");
	}
	
	public void endTV() {
		System.out.println("End STV ...");
	}
	
	@Override
	public void turnOn() {
		this.status = "STV ON";
	}

	@Override
	public void turnOff() {
		this.status = "STV OFF";
	}

	@Override
	public void volumeUp(int v) {
		this.volume += v;
	}

	@Override
	public void volumeDown(int v) {
		this.volume -= v;
	}
	@Override
	public String toString() {
		return "STV [status=" + status + ", volume=" + volume + ", size=" + size + ", color=" + color + "]";
	}

	
	
}




