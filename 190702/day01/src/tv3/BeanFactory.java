package tv3;

public class BeanFactory {
	public static Object getBean(String name) {
		if(name.equals("STV")) {
			return new STV();
		}else if(name.equals("LTV")) {
			return new LTV();
		}
		return null;
	}
}
