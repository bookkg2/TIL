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

	public void fillColor(String color) {//오버라이딩 함수 X 그냥 정의된 함수 , 이 원 클래스에만 작동!!
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
