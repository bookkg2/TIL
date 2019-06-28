package shape;

public class ShcapleTest {

	public static void main(String[] args) {
		//Shape s= new Shape(new Point(10,10));
//		Shape s1 = new Circlr(new Point(1,1),5);//��� �����̸� ���� �̷��� !!
//		Shape s2 = new Triangle(new Point(2,2),5,6);
		
		//heterigenius Collection
		Shape s[] = new Shape[3];
		s[0] = new Circlr(new Point(1,1),5);
		s[1] = new Triangle(new Point(2,2),5,6);
		s[2] = new Rectangle(new Point(3,3),5,6);
		
		//Polymorphism ������ = �ǹ̴� ������ ǥ���� �ٸ���.
		for(Shape sh:s) {
			sh.move(6,5);
			if(sh instanceof Circlr) {// ��ü�� ��ȯ�ϰ� ���� �� ��ü�� ���� �� !!
				Circlr c= (Circlr)sh;
				c.fillColor("red");
				
			}
			System.out.println(sh.toString());
//			System.out.println(sh.getArea());
//			System.out.println(sh.getCircume());
		}

	}

}
