package shape;

public abstract class Shape {// �߻� Ŭ���� -�߻�޼ҵ尡 �ִ� Ŭ����

	protected Point point;

	public Shape() {// constructor�� ��� X{
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

	public abstract double getCircume();// abdstract�� �ݵ�� �ϳ��� ������

	

}
