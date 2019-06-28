package shape;

public abstract class Shape {// 추상 클래스 -추상메소드가 있는 클래스

	protected Point point;

	public Shape() {// constructor는 상속 X{
	}

	public Shape(Point point) {
		this.point = point;
		
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}
	
	public void move(int x , int y) {
		this.point.setX(x);
		this.point.setY(y);
	}


	@Override
	public String toString() {
		return "Shape [point=" + point + "]";
	}
	
	
	public abstract double getArea();

	public abstract double getCircume();// abdstract는 반드시 하나는 가져옴

	

}
