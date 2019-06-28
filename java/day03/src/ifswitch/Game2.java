package ifswitch;

public class Game2 {

	public static void main(String[] args) {
		String str = "bookkg2@naver.com";
		int c = str.indexOf("@"); // 문자가 어디에 있냐 ? -위치 가져오기
		String id = str.substring(0, str.indexOf("@")); // 0부터 @까지 잘라라 할 때 쓰는 라이브러리는 substring
		String domain = str.substring(str.indexOf("@"), str.indexOf(".")); // 도메인 자르기
		
		
		System.out.println(id + " " + domain);
// for(int i = 0; i < c; i++) {
//			char d= str.charAt(i);
//			System.out.print(d);
//		}
		// char c = str.charAt(5);//해당 주소에 위치한 값 가져오기

	}

}
