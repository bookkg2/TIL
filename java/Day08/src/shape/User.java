package shape;

public class User {
	String id;
	public User() {
		id = "Kim";
	}
	public void draw(Shape shape) {//Triangle, Rectangle, circle 이 들어 갈 수 있음 
		System.out.println(shape.getArea());
		System.out.println(shape.getCircume());
		System.out.println(shape.getPoint());
	}

}
