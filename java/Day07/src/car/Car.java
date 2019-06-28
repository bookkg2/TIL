package car;

public class Car {
	// attribute
	private String name;
	private String color;
	private int fSize;
	private int cfSize;//��ȿ� ���ִ� ������
	private int speed;
	private int maxSpeed;
	private int defaultSize = 100;
	private static int serial = 1;
	
	// initialization block -> Car c = new �ϸ� ���� �� , Ŭ���� ���� �ν��Ͻ� �ʱ�ȭ �Ҷ� � ������ �ְ� ���� ��
	{//consructor �� ���� �Ǳ� ���� ���� 
		cfSize = defaultSize * 2;
		if(cfSize <= 0) {
			cfSize = 0;
		}
		cfSize++;
	}
	static {
		serial *= 1000; // 1000 ���� �����ϰڴ�.
	}
	
	// constructor
	public Car() {// default ��
		this.name = "K1";
		this.color = "red";
		this.fSize = 50;// �⸧ ��
		this.maxSpeed = 50;
	}

	public Car(String name, String color, int fSize) {// Ŭ������ �ν��Ͻ� ����� �������ִ� �Լ�
		this.name = name;
		this.color = color;
		this.fSize = fSize;
	}

	public Car(String name, String color, int fSize, int cfSize, int speed) {// Car �̸��� ���Ƶ� �� - �����ε�
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

	public void setCfSize(int cfSize) throws Exception {//() ���� �⸧ Exception ����Ҷ� �߸��� �� �ֽ��ϴ�. 
		 
		if(this.cfSize + cfSize > fSize) {
			throw new Exception();// ���� ��������˷��ش�. , �߸� �Ǹ� ������ ���� ���� ����
			
		}
		this.cfSize += cfSize; // 0 �� cfSize ���� ���ض� 
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {// speed�� �ٲܼ� �ִ� �Լ� ��, set�� ���𰡸� �ٲ� �� ���
		if(this.maxSpeed < speed) {
			this.speed = maxSpeed;//�ƹ��� �޷��� 50 ��
			return;
		}
		this.speed = speed;
	}

	public int go(int level) {// ( ) : ���� ���� �� �ֵ��� ���� �Լ��� argument -> return
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
