package ifswitch;

public class SwitchEx1 {

	public static void main(String[] args) {
		//관리자 Permission Control 할 때 협업에서 많이 씀
		int a = 2;// long, float, double 은 안됨 !! , int value , String
		String str = "";
		switch(a) {//여러 권한을 줄 때는 break 삭제
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
