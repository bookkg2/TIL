package ws;

public class CarTest {
	
	public static void main(String[] args) {
		int makingNumber = 0 ;
		try {
		Engine e= new Engine(7,7);
		Car c = new Car("K1", e, "Red",makingNumber);
		System.out.print(c.toString());
		}catch (Exception r) {
			System.out.println(r.getMessage()); // Ŭ������ getMessage : Exception ���� �޼��� ������ 
		}
		
		
//		Car c = new Car("K1", e, "Red",makingNumber);
		
		

	}

}
