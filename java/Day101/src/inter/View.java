package inter;

public class View {

	public static void main(String[] args) {
		Shop shop = new Gmarket();
		shop.register();
		shop.login();
		shop.order();
		shop.logout();

	}

}
