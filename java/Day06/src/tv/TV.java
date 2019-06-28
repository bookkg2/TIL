package tv;

public class TV {//TV�� ����� ���� Ʋ !
	//�Ӽ�(attribute)
	private String color;// public ��𼭵� ��� ����, private�� ���ٿ� ��������->get�̶� set���� ����
	private boolean power;//���� ��Ű�� �ȿ����� ����
	public int channel;
	
	//constructor(attribute�� �ʱ�ȭ)
	TV(){//Ŭ���� �̸��� ���� ������ �Լ� ���� , �ʱⰪ �� ��
		color = "red";
		power = false;
		channel = 10;
	}
	TV(String color, boolean power, int channel){//Ŭ���� �̸��� ���� ������ �Լ� ����,String color, boolean power, int channel = argument
		this.color = color;
		this.power = power;
		this.channel = channel;
	}
	TV(String color){//Ŭ���� �̸��� ���� ������ �Լ� ����,String color, boolean power, int channel = argument
		this.color = color;
		this.power = false;
		this.channel = 10;
	}
	
	//���(function)
	
	void power() {
		power = !power;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {//������ �����ؼ� �������� ���(set ���) - > �߸��ٲٴ°��� ���´�.
		//���� �������� �Ѵ�.
		//�÷��� ��� ���ؼ� ���� �Ѵ�.
		if(color.equals("") || color == null) {
			return;//�Լ��� ������.
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
