package ref;

public class RefTest {

	public static void main(String[] args) {
		Ref ref = new Ref();
		System.out.println(ref.a);
		//call by reference
		ref.sum2(ref);
		System.out.println(ref.a);// reference�� ������ 1100�� ����
		
		
		
		
		//call by value
		int data = 100;
		ref.sum(100);
		System.out.println(data);//�׳� 100�� ���� ������ Ŭ�������� �׳� �ش� �޼��� �ȿ����� �����ϰ� ���� ���� 
		
		

	}

}
