package shape;

public class ShcapleTest {

	public static void main(String[] args) {
		//Shape s= new Shape(new Point(10,10));
//		Shape s1 = new Circlr(new Point(1,1),5);//상속 관계이면 가능 이렇게 !!
//		Shape s2 = new Triangle(new Point(2,2),5,6);
		
		//heterigenius Collection
		Shape s[] = new Shape[3];
		s[0] = new Circlr(new Point(1,1),5);
		s[1] = new Triangle(new Point(2,2),5,6);
		s[2] = new Rectangle(new Point(3,3),5,6);
		
		//Polymorphism 다형성 = 의미는 같지만 표현이 다르다.
		for(Shape sh:s) {
			sh.move(6,5);
			if(sh instanceof Circlr) {// 개체를 교환하고 싶을 때 객체를 먼저 비교 !!
				Circlr c= (Circlr)sh;
				c.fillColor("red");
				
			}
			System.out.println(sh.toString());
//			System.out.println(sh.getArea());
//			System.out.println(sh.getCircume());
		}

	}

}
