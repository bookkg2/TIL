package ws;
 
import java.util.Arrays;
import java.util.*;
 
public class Lotto {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int usernum = 0;
        int user[] = new int[6];
        int com[] = new int[6];
        boolean[] b = new boolean[11];
        // ����� ����
 
        int i = 0;
        while (true) {
 
            if (i == user.length) {
                break;
            }
            System.out.print("6���� ���ڸ� �Է� ->  ");
            usernum = sc.nextInt();
            if (usernum < 0 || usernum > 10) {
                System.out.println(" (���) 1 ~ 10���� ���ڷ� �ٽ� �Է��Ͻÿ�.");
                continue;
            }
 
            if (b[usernum] == true) {
 
                System.out.println("(���) �ߺ����� �Է��ϼ̽��ϴ�.");
 
                continue;
            }
 
            user[i] = usernum;
 
            b[usernum] = true;
 
            i++;
 
        }
        System.out.println("----------------------------------------------------------------");
        System.out.println("�� ��ȣ�� : " + " " + Arrays.toString(user));
 
        Random r = new Random(); // Random ��ü ����
 
        for (int a = 0; a < com.length; a++) {
 
            com[a] = r.nextInt(10) + 1;
            for (int j = 0; j < a; j++) {
 
                if (com[a] == com[j]) {
                    a--;
                }
            }
 
        }
 
        System.out.println("��÷ ��ȣ�� : " + Arrays.toString(com));
 
        int result = 0;
        for (int a = 0; a < user.length; a++) {
            for (int j = 0; j < user.length; j++)
 
                if (user[a] == com[j]) {
                    count++;
                }
 
        }
        System.out.println("��� :" + count);
 
        long money = 0;
        long resultmoney = 0;
        money = r.nextInt(90) + 10;
        money *= 100000000L;
 
        System.out.println("�� ��÷�� : " + money + "���Դϴ�.");
        switch (count) {
        case 3:
            resultmoney = money *= 0.05;
            break;
        case 4:
            resultmoney = money *= 0.1;
            break;
        case 5:
            resultmoney = money *= 0.2;
            break;
        case 6:
            resultmoney = money *= 0.5;
            break;
        }
 
        System.out.println("��û���� : " + resultmoney + "���Դϴ�.");
 
    }
 
}
