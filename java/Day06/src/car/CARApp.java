package car;
import java.util.Scanner;
public class CARApp {

	public static void main(String[] args) {
		String user = "";
		Car car = new Car();
		
		Car cars[] = new Car[3];
		cars[0] = new Car("Red", "����");
		cars[1] = new Car("Blue", "����");
		cars[2] = new Car("Green", "����");
				
		System.out.println("� ���� ���Ͻʴϱ� ? ");
		for(int i = 0 ; i <cars.length; i++) {
		System.out.println(cars[i]);
		}
		
	    Scanner sc= new Scanner(System.in);
	    user = sc.next();
	    if(user.equals("����")) {
	    	
	    }
	    
	    
		
		
		
		
	}

}

