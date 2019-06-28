package inter;

public class Auction implements Shop {

	@Override
	public void register() {
		System.out.println("Auction register");

	}

	@Override
	public void login() {
		System.out.println("Auction login");

	}

	@Override
	public void logout() {
		System.out.println("Auction logout");

	}

	@Override
	public void order() {
		System.out.println("Auction order");

	}

}
