package ifswitch;

public class IfEx2 {

	public static void main(String[] args) {
		int a = 87;
		char c = 'F';
		if(90 <= a) {
			c = 'A';
		}else if(80 <= a) {
			c = 'B';
		}else if(70 <= a) {
			c = 'C';
		}else {
			c = 'F';
		}
		System.out.println(c);

	}

}
