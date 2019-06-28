package inter;

public class Gmarket implements Shop {

	@Override
	public void register() {
		System.out.println("Gmarket register");

	}

	@Override
	public void login() {
		System.out.println("Gmarket login");

	}

	@Override
	public void logout() {
		System.out.println("Gmarket logout");

	}

	@Override
	public void order() {
		System.out.println("Gmarket order");
	}

}
