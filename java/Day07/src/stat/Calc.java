package stat;

public class Calc {//�츮���� ����
	public static int sum(int a, int b) {// static �� ���� ������ main���� ������ , �Լ��� ��ɸ� ���� ��
		return (a+b);
	}
	public static int sum(int a[]) {//argument�� �ٸ��� �Լ� �̸��� ���� ���� ���� -> �����ε�(�ڹ��� ���� ū Ư¡)
	 int sum = 0;
	 for(int data :a) {
		 sum +=data;
	 }
	 return sum;
	}
	
	
}
