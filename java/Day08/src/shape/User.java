package shape;

public class User {
	String id;
	public User() {
		id = "Kim";
	}
	public void draw(Shape shape) {//Triangle, Rectangle, circle �� ��� �� �� ���� 
		System.out.println(shape.getArea());
		System.out.println(shape.getCircume());
		System.out.println(shape.getPoint());
	}

}
