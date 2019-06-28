package ws;

import java.text.SimpleDateFormat;

public class Car {
	private String carName;
	Engine engine;
	private String color;
	private long serialNumber;
	public static int cnt =1000;
	
	public Car(String carName, Engine engine, String color, long serialNumber) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String today= formatter.format(new java.util.Date());
        
		this.carName = carName;
		this.engine = engine;
		this.color = color;
		this.serialNumber = Long.parseLong(today + cnt)  ;
		cnt++;
	
	}
	
	
	


	

	@Override
	public String toString() {
		return "Car [carName=" + carName + ", engine=" + engine + ", color=" + color + ", serialNumber=" + serialNumber
				+ "]";
	}
	
	
	
	
}
