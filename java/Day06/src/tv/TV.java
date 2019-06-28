package tv;

public class TV {//TV를 만들어 내는 틀 !
	//속성(attribute)
	private String color;// public 어디서든 사용 가능, private은 접근에 제한있음->get이랑 set으로 접근
	private boolean power;//같은 패키지 안에서만 가능
	public int channel;
	
	//constructor(attribute를 초기화)
	TV(){//클래스 이름과 동일 하지만 함수 영역 , 초기값 줄 때
		color = "red";
		power = false;
		channel = 10;
	}
	TV(String color, boolean power, int channel){//클래스 이름과 동일 하지만 함수 영역,String color, boolean power, int channel = argument
		this.color = color;
		this.power = power;
		this.channel = channel;
	}
	TV(String color){//클래스 이름과 동일 하지만 함수 영역,String color, boolean power, int channel = argument
		this.color = color;
		this.power = false;
		this.channel = 10;
	}
	
	//기능(function)
	
	void power() {
		power = !power;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {//조건을 만족해서 들어오도록 사용(set 기능) - > 잘못바꾸는것을 막는다.
		//숫자 못들어오게 한다.
		//컬러는 몇개로 정해서 동작 한다.
		if(color.equals("") || color == null) {
			return;//함수를 끝낸다.
		}
		this.color = color;
	}
	public boolean isPower() {
		return power;
	}
	public void setPower(boolean power) {
		this.power = power;
	}
	public int getChannel() {
		return channel;
	}
	public void setChannel(int channel) {
		this.channel = channel;
	}
	void channelUp() {
		channel++;
	}
	void channelDown() {
		channel--;
	}
	
	@Override
	public String toString() {
		return "TV [color=" + color + ", power=" + power + ", channel=" + channel + "]";
	}
	
}
