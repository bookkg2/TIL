package tv2;

public class STV implements TV {
	String status;
	int volume;
	
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
		return "STV [status=" + status + ", volume=" + volume + "]";
	}
	
}




