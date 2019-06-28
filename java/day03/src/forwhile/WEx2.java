package forwhile;

import java.util.Scanner;

public class WEx2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {//뭔가를 지속적으 할 때 자주 사용
			System.out.println("Input Command..");
			String cmd = sc.next();// 무한루프 돌다가 11에서 입력을 받고 멈춤
			if(cmd.equals("q")) {
				System.out.println("Bye...");
				sc.close();
				break;//While을 상대로 종료
				//return;// Main을 상대로 종료
				//System.exit(0);//프로그램 강제 종료
			}else if(cmd.equals("i")) {
				System.out.println("Input 2 Num");
				int a = Integer.parseInt(sc.next());//메뉴안에 메뉴를 또 만듬
				
			}else if(cmd.equals("s")) {
				System.out.println("Selected..");
			}
			else {
				System.out.println("Re-Try");
				continue;//밑에를 skip
			}
			System.out.println("Completed..");
		}//end while 
		System.out.println("System Exit ..");

	}
	

}
