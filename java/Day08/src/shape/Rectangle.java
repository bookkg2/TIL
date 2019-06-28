package shape;

public class Rectangle extends Shape {
	
	private int width;
	private int height;
	
	public Rectangle(Point point, int i, int j) {
		super(point);
		this.width = i;
		this.height = j;
	}
	
	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	

	@Override
	public double getArea() {
		double area = 0;
		area = width * height;
		return area;
	}

	@Override
	public double getCircume() {
		double circum =0;
		circum = 2 *(width + height);
		return circum;
	}

	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", height=" + height + "]";
	}

}
