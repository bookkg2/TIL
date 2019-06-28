package ref;

public class RefTest {

	public static void main(String[] args) {
		Ref ref = new Ref();
		System.out.println(ref.a);
		//call by reference
		ref.sum2(ref);
		System.out.println(ref.a);// reference를 넣으면 1100이 나옴
		
		
		
		
		//call by value
		int data = 100;
		ref.sum(100);
		System.out.println(data);//그냥 100일 찍힘 이유는 클래스에서 그냥 해당 메서드 안에서만 동작하고 없어 져서 
		
		

	}

}
