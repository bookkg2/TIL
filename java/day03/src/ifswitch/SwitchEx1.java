package ifswitch;

public class SwitchEx1 {

	public static void main(String[] args) {
		//������ Permission Control �� �� �������� ���� ��
		int a = 2;// long, float, double �� �ȵ� !! , int value , String
		String str = "";
		switch(a) {//���� ������ �� ���� break ����
		case 1 : str += "Super Admin\n";
		case 2: str += "Middle Admin\n";
		case 3: str += "Admin\n";
		break;
		
		default: str = "FAIL";
		break;
		}
		System.out.println(str);

	}

}
