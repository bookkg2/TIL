package company;

public class Manager extends Employee {

	private double incentive;
	
	public Manager() {
		
	}


	public Manager(String id, String name, double salary, String dept, double incentive) {
		//super(id, name, salary, dept);//super는 상위에 있는 것을 가져와
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.dept = dept;
		this.incentive = incentive;
	}

	@Override
	public double salaryM() {// 함수의 재 정의
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


	





	//재정의
	//Override - > 상속 받은 String 말고 새로운 String 사용 하고 싶을 때 , 상위 클래스에 있는 것을 재정의 하겠다.
	
	


	
	
	
	
}
