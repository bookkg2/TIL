package ws;

public class Engine {

	private int smokeSize ;
	private int smokeMethod ;

	public Engine() {
	}

	public Engine(int smokeSize, int smokeMethod) {
		this.smokeSize = smokeSize;
		this.smokeMethod = smokeMethod;
	}

	public Engine(int smokeMethod) {
		this.smokeMethod = smokeMethod;
	}

	public int getSmokeSize() {
		return smokeSize;
	}

	public void setSmokeSize(int smokeSize) throws Exception {
		if(smokeSize != 4 && smokeSize !=6) {
			throw new Exception("엔진 오류");
		}
		this.smokeSize = smokeSize;
	}

	@Override
	public String toString() {
		return "Engine [smokeSize=" + smokeSize + ", smokeMethod=" + smokeMethod + "]";
	}
	
	
	

}
