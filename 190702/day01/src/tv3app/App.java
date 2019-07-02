package tv3app;

import tv3.BeanFactory;
import tv3.TV;

public class App {
	//디자인 패턴 ... 기존의 자바의 기술을 가지고 클래스간 병합을 유연하게
	public static void main(String[] args) {
		TV stv = (TV) BeanFactory.getBean("STV");
		stv.turnOn();
		stv.volumeUp(10);
		System.out.println(stv);
		
	}

}
