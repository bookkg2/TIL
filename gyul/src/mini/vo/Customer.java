package mini.vo;

public class Customer {
	String cus_id;
	String cus_pwd;
	String cus_name;
	String cus_phone;
	String cus_addr;
	String cus_email;
	String cus_admin;

	public Customer() {

	}

	public Customer(String cus_id, String cus_pwd, String cus_name, String cus_phone, String cus_addr, String cus_email,
			String cus_admin) {

		this.cus_id = cus_id;
		this.cus_pwd = cus_pwd;
		this.cus_name = cus_name;
		this.cus_phone = cus_phone;
		this.cus_addr = cus_addr;
		this.cus_email = cus_email;
		this.cus_admin = cus_admin;
	}

	public Customer(String cus_id, String cus_pwd, String cus_name, String cus_phone, String cus_addr,
			String cus_admin) {

		this.cus_id = cus_id;
		this.cus_pwd = cus_pwd;
		this.cus_name = cus_name;
		this.cus_phone = cus_phone;
		this.cus_addr = cus_addr;
		this.cus_admin = cus_admin;
	}
	
	public String getCus_id() {
		return cus_id;
	}

	public void setCus_id(String cus_id) {
		this.cus_id = cus_id;
	}

	public String getCus_pwd() {
		return cus_pwd;
	}

	public void setCus_pwd(String cus_pwd) {
		this.cus_pwd = cus_pwd;
	}

	public String getCus_name() {
		return cus_name;
	}

	public void setCus_name(String cus_name) {
		this.cus_name = cus_name;
	}

	public String getCus_phone() {
		return cus_phone;
	}

	public void setCus_phone(String cus_phone) {
		this.cus_phone = cus_phone;
	}

	public String getCus_addr() {
		return cus_addr;
	}

	public void setCus_addr(String cus_addr) {
		this.cus_addr = cus_addr;
	}

	public String getCus_email() {
		return cus_email;
	}

	public void setCus_email(String cus_email) {
		this.cus_email = cus_email;
	}

	public String getCus_admin() {
		return cus_admin;
	}

	public void setCus_admin(String cus_admin) {
		this.cus_admin = cus_admin;
	}

	@Override
	public String toString() {
		return "Customer [cus_id=" + cus_id + ", cus_pwd=" + cus_pwd + ", cus_name=" + cus_name + ", cus_phone="
				+ cus_phone + ", cus_addr=" + cus_addr + ", cus_email=" + cus_email + ", cus_admin=" + cus_admin + "]";
	}

}
