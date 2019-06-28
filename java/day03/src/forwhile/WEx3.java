package forwhile;

public class WEx3 {

	public static void main(String[] args) throws InterruptedException {
		int i = 5;
//		while(++i <= 10) {// 증감식이 어디 있냐에 따라 다르게 나온다. 지금은 1을 증가하고 작동
//			System.out.println(i);
//			
//		}

		while(i-- != 0) {
			Thread.sleep(1000);//현재 동작 되는 프로세스를 1초동안 멈춰라 1000이 1초
			System.out.println(i);
		}
		
	}

}
