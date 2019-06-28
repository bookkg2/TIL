package day02;

public class Variable2 {
	public static void main(String[] args) {
		int i = 10;
		boolean b = true;
		int j = 20;
		int result = i+j;
		
		char c = 'a';
		int cc = c;
		System.out.println(cc); //유니코드가 나옴 
		
		byte bt =10;
		int aa = bt;// byte를 int에 넣는 것은 가능
		bt = (byte)aa;//int는 byte보다 크니깐 형변환을 해줘야함 
		
		
	
	}
}
