package forwhile;

public class WEx6 {

	public static void main(String[] args) {
		// �������� ��� �Ͻÿ�
		// Ȧ�� �ܸ� ����Ͻÿ�
		// ����� 49�϶� ���߽ÿ�
		int go = 0;
		out ://��� for������ Out �Ұ���
		for (int i = 2; i <= 9; i++) {
//			if(go == 1) {//�ΰ��� for���� ���� �ϱ� ���Ͽ�
//				break;
//			}
			if (i % 2 == 0) {
				continue;
			}

			for (int j = 1; j <= 9; j++) {
				int result = i * j;
				if (result == 49) {
//					go = 1;//1�� �ְ� �ȿ� for�� ����

					break out;//��ü ��� for�� ����->�ڹ� ���̺귯��, break;�� ���� for���� ����
				}

				System.out.printf("%d �� : %d * %d = %d\n", i, i, j, result);
			}
		}

	}

}
