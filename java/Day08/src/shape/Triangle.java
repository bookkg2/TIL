package shape;

public class Triangle extends Shape {
	private int width;
	private int height;

	
	public Triangle(Point point, int i, int j) {
		super(point);
		this.width = i;
		this.height = j;
	}
	
	public Triangle(int width, int height) {
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
		double circum = 0;
		circum = width + height +Math.hypot(width, height);
		return circum;
	}

	@Override
	public String toString() {
		return "Triangle [width=" + width + ", height=" + height + "]";
	}

}
