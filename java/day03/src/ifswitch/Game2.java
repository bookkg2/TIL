package ifswitch;

public class Game2 {

	public static void main(String[] args) {
		String str = "bookkg2@naver.com";
		int c = str.indexOf("@"); // ���ڰ� ��� �ֳ� ? -��ġ ��������
		String id = str.substring(0, str.indexOf("@")); // 0���� @���� �߶�� �� �� ���� ���̺귯���� substring
		String domain = str.substring(str.indexOf("@"), str.indexOf(".")); // ������ �ڸ���
		
		
		System.out.println(id + " " + domain);
// for(int i = 0; i < c; i++) {
//			char d= str.charAt(i);
//			System.out.print(d);
//		}
		// char c = str.charAt(5);//�ش� �ּҿ� ��ġ�� �� ��������

	}

}
