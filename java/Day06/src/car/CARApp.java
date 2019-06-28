package car;
import java.util.Scanner;
public class CARApp {

	public static void main(String[] args) {
		String user = "";
		Car car = new Car();
		
		Car cars[] = new Car[3];
		cars[0] = new Car("Red", "소형");
		cars[1] = new Car("Blue", "중형");
		cars[2] = new Car("Green", "대형");
				
		System.out.println("어떤 차를 원하십니까 ? ");
		for(int i = 0 ; i <cars.length; i++) {
		System.out.println(cars[i]);
		}
		
	    Scanner sc= new Scanner(System.in);
	    user = sc.next();
	    if(user.equals("소형")) {
	    	
	    }
	    
	    
		
		
		
		
	}

}

