package forwhile;

public class WEx5 {

	public static void main(String[] args) {
//		int i = 0;
//		int sum = 0;
//		while (i <= 10) {
//			if (i == 7) {//break�� ������ ���� ù��°�� �ϴ� ���� ����.
//				break;
//
//			}
//			if (i % 2 == 0) {//for���̶� ���� i++�� ����������� �Ѵ�. for�� ���ǹ��� �������� �־
//				i++;
//				continue;// �ؿ��� SKip!! �ϰ� while�� �̵�, �̰� �Ⱦ��� �ؿ� Process�� ��� ����
//				}
//
//			sum += i;
//
//			i++;
//			System.out.println("Process");
//
//			
//
//		}
//		System.out.println(sum);

		// for ��
		int i = 0;
		int sum = 0;
		for (; i <= 10; i++) {
			if (i == 6) {
				break;
			}
			if (i % 2 == 0) {
				continue;//�ؿ��� Skip ->for������ �̵�
			}
			sum += i;
			System.out.println("Process");

		}
		System.out.println(sum);
	}

}
