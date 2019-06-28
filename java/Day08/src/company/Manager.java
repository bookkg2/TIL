package company;

public class Manager extends Employee {

	private double incentive;
	
	public Manager() {
		
	}


	public Manager(String id, String name, double salary, String dept, double incentive) {
		//super(id, name, salary, dept);//super�� ������ �ִ� ���� ������
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.dept = dept;
		this.incentive = incentive;
	}

	@Override
	public double salaryM() {// �Լ��� �� ����
		double money =0 ;
		money = super.salaryM() + this.incentive;
		return money;
	}
	
	@Override
	public double salaryY() {
		double money = 0;
		money = this.salaryM() * 12;
		return money;
	}


	@Override
	public String toString() {
		return "Manager [incentive=" + incentive + ", id=" + id + ", name=" + name + ", salary=" + salary + ", dept="
				+ dept + "]";
	}


	





	//������
	//Override - > ��� ���� String ���� ���ο� String ��� �ϰ� ���� �� , ���� Ŭ������ �ִ� ���� ������ �ϰڴ�.
	
	


	
	
	
	
}
