package forwhile;

import java.util.Scanner;

public class WEx2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {//������ �������� �� �� ���� ���
			System.out.println("Input Command..");
			String cmd = sc.next();// ���ѷ��� ���ٰ� 11���� �Է��� �ް� ����
			if(cmd.equals("q")) {
				System.out.println("Bye...");
				sc.close();
				break;//While�� ���� ����
				//return;// Main�� ���� ����
				//System.exit(0);//���α׷� ���� ����
			}else if(cmd.equals("i")) {
				System.out.println("Input 2 Num");
				int a = Integer.parseInt(sc.next());//�޴��ȿ� �޴��� �� ����
				
			}else if(cmd.equals("s")) {
				System.out.println("Selected..");
			}
			else {
				System.out.println("Re-Try");
				continue;//�ؿ��� skip
			}
			System.out.println("Completed..");
		}//end while 
		System.out.println("System Exit ..");

	}
	

}
