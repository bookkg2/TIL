package forwhile;

public class ForEx2 {

	public static void main(String[] args) {
		// ���������� ��Ʈ������ ����Ͻÿ�
		// p151

		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
//				int result = i - j;
//				switch(result) {
//				case 0 : 
//					System.out.print(" " + "���º�");
//					
//					break;
//				case -1: case 2:
//					System.out.print(" " + "�Ľ�");
//					
//					break;
//				case -2: case 1:
//					System.out.print(" " + "������");
//					break;
//				}
				int z = i - j;
				String str = " ";
				if (z == 0) {
					str = "���º�";
				} else if (z == -1 || z == 2) {
					str = "�Ľ�";
				} else {
					str = "������";
				}
				System.out.print(str + " ");
			}

			System.out.println();
		}

	}

}
