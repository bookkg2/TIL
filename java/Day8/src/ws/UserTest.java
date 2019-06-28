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

		   

		   System.out.println("메뉴");

		   

		   System.out.println("1.계좌입금");

		   

		   System.out.println("2.로또구매");

		   

		   System.out.println("3.잔액조회");

		   

		   System.out.println("4.유저정보출력");

		   

		   

		   int n = sc.nextInt();

		   

		   switch(n) {

		   

		   

		    case 1: 

		     System.out.println("입금할 금액을 입력하세요");

		     int money = sc.nextInt();

		     acc.deposit(money);

		     break;

		    case 2:

		     System.out.println("로또 몇개 구매 하시겠어요");

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

		    System.out.println("축하합니다 1등입니다"); 

		    player.withdraw(10000000000L); 

		   }

		   

		   else if(winnerRate ==2) {

		    System.out.println("축하합니다 2등입니다.");

		    player.withdraw(1000000000L); 

		   }

		   

		   else if(winnerRate ==3) {

		    System.out.println("축하합니다 3등입니다.");

		    player.withdraw(100000000L); 

		   }

		   

		   

		  }

		  

		 




	}

}
