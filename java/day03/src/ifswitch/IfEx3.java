package ifswitch;

import java.util.Scanner;

public class IfEx3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input 3 Number");
		int n1 = Integer.parseInt(sc.next());
		int n2 = Integer.parseInt(sc.next());
		int n3 = Integer.parseInt(sc.next());
		int min = 0, max = 0;
		//min
		if(n1 < n2 & n1 < n3) {
			min = n1;
		}else if(n1 > n2 & n2 < n3) {
			min = n2;
		}else 
			min = n3;
		
		
		
		//max
		//(1)
//		if(n1 > n2 & n1 > n3) {
//			max = n1;
//		}else if(n1 < n2 & n2 > n3) {
//			max = n2;
//		}else 
//			max = n3;
		
		//(2)
	    max = (n1 > n2) ? ((n1 > n3) ? n1 : n3 ) : ((n2 > n3) ? n2 : n3);
	    
	    //(3)
	    max = Math.max(n1, n2);
	    if(max < n3) {
	    	max = n3;
	    }
		System.out.printf("Min : %d, Max : %d", min, max);
	}

}
