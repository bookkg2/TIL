package ws;

import java.util.Scanner;

public class UserTest {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);

		  


		  

		  User player = new User("Lee",acc);

		  

		  Rotto lotto = new Rotto(0);

		  int count =0;

		  while(true) {

		  

		   count++;

		   lotto.times = count;

		   

		   System.out.println("�޴�");

		   

		   System.out.println("1.�����Ա�");

		   

		   System.out.println("2.�ζǱ���");

		   

		   System.out.println("3.�ܾ���ȸ");

		   

		   System.out.println("4.�����������");

		   

		   

		   int n = sc.nextInt();

		   

		   switch(n) {

		   

		   

		    case 1: 

		     System.out.println("�Ա��� �ݾ��� �Է��ϼ���");

		     int money = sc.nextInt();

		     acc.deposit(money);

		     break;

		    case 2:

		     System.out.println("�ζ� � ���� �Ͻðھ��");

		     int number = sc.nextInt();

		     player.buyRotto(number);

		     break;

		     

		    case 3:

		     System.out.println(player.UserInfo());

		     break;

		     

		   

		   }

		   

		   lotto.makeLotNumber();

		   

		   int winnerRate = lotto.play(player.lotNumbers);

		   

		   if(winnerRate == 1)

		   {

		    System.out.println("�����մϴ� 1���Դϴ�"); 

		    player.withdraw(10000000000L); 

		   }

		   

		   else if(winnerRate ==2) {

		    System.out.println("�����մϴ� 2���Դϴ�.");

		    player.withdraw(1000000000L); 

		   }

		   

		   else if(winnerRate ==3) {

		    System.out.println("�����մϴ� 3���Դϴ�.");

		    player.withdraw(100000000L); 

		   }

		   

		   

		  }

		  

		 




	}

}
