package company;

public class Employee {
	protected String id;// protected 하위 클래스에서 자유롭게 접근 가능 , 같은 패키지 안에서도 자유롭게 접근 가능
	protected String name;
	protected double salary;
	protected String dept;

	public Employee() {
	}

	public Employee(String id, String name, double salary, String dept) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.dept = dept;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", dept=" + dept + "]";
	}

	public double salaryM() {
		double money = 0;
		double temp = 0;
		// 4대 보험료 8.4% 공제
		// 세금 3.2% 공제
		temp += this.salary * 0.084;
		temp += this.salary * 0.032;
		money = this.salary - temp;

		return money;

	}

	public double salaryY() {
		double money = 0;

		money = this.salaryM() * 12;

		return money;
	}
}
