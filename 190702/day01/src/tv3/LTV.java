package tv3;

public class LTV implements TV {
	String status;
	int volume;
	
	@Override
	public void turnOn() {
		this.status = "LTV ON";
	}

	@Override
	public void turnOff() {
		this.status = "LTV OFF";
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
		return "LTV [status=" + status + ", volume=" + volume + "]";
	}
	
}
