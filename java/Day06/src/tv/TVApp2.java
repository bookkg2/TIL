package tv;

public class TVApp2 {

	public static void main(String[] args) {
		TV tv = new TV();

		System.out.println(tv.toString());
		TV tv2 = new TV("blue", false, 9);

		System.out.println(tv2.toString());

		TV tv3 = new TV("green");

		System.out.println(tv3.toString());
		tv.setColor("");// ÄÃ·¯ »ö±òÀÌ ¾ø¾îÁü
		
		System.out.println(tv3.getColor());
		

	}

}
