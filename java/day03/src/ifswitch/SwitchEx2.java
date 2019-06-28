package ifswitch;

public class SwitchEx2 {

	public static void main(String[] args) {
		int month = 2;
		int lastDayOfMonth = 0;
		// 해당 월의 마지막 일자를 출력 하시오

		switch (month) {

		case 2:
			lastDayOfMonth = 28;
			break;

		case 4: case 6: case 9: case 11:
			lastDayOfMonth = 30;
			break;
		
		default:
			lastDayOfMonth = 31;
			break;

		}
		System.out.println(lastDayOfMonth);

	}

}
