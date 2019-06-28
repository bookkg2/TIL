package shape;

public class Circlr extends Shape {
	private int readius;
	
	private String color;


	public Circlr(Point point, int radius, String color) {
		super(point);
		this.readius = radius;
		this.color = color;
	}

	public Circlr(Point point, int reaidus) {
		super(point);
		this.readius = reaidus;
	}

	public void fillColor(String color) {//�������̵� �Լ� X �׳� ���ǵ� �Լ� , �� �� Ŭ�������� �۵�!!
		this.color = color;
	}

	@Override
	public double getArea() {
		double area =0;
		area = readius *readius * Math.PI;
		return area;
	}

	@Override
	public double getCircume() {
		double circum;
		circum = 2*readius*Math.PI;
		return circum;
	}

	@Override
	public String toString() {
		return "Circlr [radius=" + readius + ", color=" + color + "]";
	}

	
	

}
