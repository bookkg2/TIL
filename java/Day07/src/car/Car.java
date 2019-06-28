package car;

public class Car {
	// attribute
	private String name;
	private String color;
	private int fSize;
	private int cfSize;//통안에 들어가있는 사이즈
	private int speed;
	private int maxSpeed;
	private int defaultSize = 100;
	private static int serial = 1;
	
	// initialization block -> Car c = new 하면 실행 됨 , 클래스 내의 인스턴스 초기화 할때 어떤 조건을 주고 싶을 때
	{//consructor 가 동작 되기 전에 실행 
		cfSize = defaultSize * 2;
		if(cfSize <= 0) {
			cfSize = 0;
		}
		cfSize++;
	}
	static {
		serial *= 1000; // 1000 부터 시작하겠다.
	}
	
	// constructor
	public Car() {// default 값
		this.name = "K1";
		this.color = "red";
		this.fSize = 50;// 기름 값
		this.maxSpeed = 50;
	}

	public Car(String name, String color, int fSize) {// 클래스의 인스턴스 진행시 생성해주는 함수
		this.name = name;
		this.color = color;
		this.fSize = fSize;
	}

	public Car(String name, String color, int fSize, int cfSize, int speed) {// Car 이름이 같아도 됨 - 오버로드
		this.name = name;
		this.color = color;
		this.fSize = fSize;
		this.cfSize = cfSize;
		this.speed = speed;
	}

	public Car(String name, String color, int fSize, int maxSpeed) {
		this.name = name;
		this.color = color;
		this.fSize = fSize;
		this.maxSpeed = maxSpeed;
	}

	// function

	@Override
	public String toString() {
		return "Car [name=" + name + ", color=" + color + ", fSize=" + fSize + ", cfSize=" + cfSize + ", speed=" + speed
				+ "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getfSize() {
		return fSize;
	}

	public void setfSize(int fSize) {
		this.fSize = fSize;
	}

	public int getCfSize() {
		
		return cfSize;
	}

	public void setCfSize(int cfSize) throws Exception {//() 들어온 기름 Exception 사용할때 잘못될 수 있습니다. 
		 
		if(this.cfSize + cfSize > fSize) {
			throw new Exception();// 문제 생긴것을알려준다. , 잘못 되면 밑으로 내려 가지 않음
			
		}
		this.cfSize += cfSize; // 0 에 cfSize 값을 더해라 
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {// speed를 바꿀수 있는 함수 즉, set은 무언가를 바꿀 때 사용
		if(this.maxSpeed < speed) {
			this.speed = maxSpeed;//아무리 달려도 50 임
			return;
		}
		this.speed = speed;
	}

	public int go(int level) {// ( ) : 값을 받을 수 있도록 설계 함수의 argument -> return
		// level 1~5
		// speed up 1:20km
		// fuel down 1L 10km
		switch (level) {
		case 1:
			this.setSpeed(20);
			this.cfSize -= 1;
			break;
		case 2:
			this.setSpeed(40);
			this.cfSize -= 2;
			break;
		case 3:
			this.setSpeed(60);
			this.cfSize -= 3;
			break;
		case 4:
			this.setSpeed(80);
			this.cfSize -= 4;
			break;
		case 5:
			this.setSpeed(100);
			this.cfSize -= 5;
			break;
		default:
			break;
		}

		return level;
	}

	public void stop() {
		this.speed = 0;
	}

}
