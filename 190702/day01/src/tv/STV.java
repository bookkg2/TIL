package tv;

public class STV {
	int volume;
	String status;
	public STV() {}
	
	public void turnOn() {
		this.status = "STV On";
	}
	public void turnOff() {
		this.status = "STV Off";
	}
	public void volumeUp(int v) {
		this.volume += v;
	}
	public void volumeDown(int v) {
		this.volume -= v;
	}

	@Override
	public String toString() {
		return "STV [volume=" + volume + ", status=" + status + "]";
	}
	
}










