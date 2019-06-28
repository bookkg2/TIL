package car;
import java.util.Random;
public class Car {
	
	Random r = new Random();
	boolean break2;
	private String model;
	private String color;
	boolean navigation;
	public char number;
	
	Car(){
		break2 = true;		
	}
	
	Car(String color, String model){
		this.color = color;
		this.model = model;
	}
	
	Car(boolean break2, String model, boolean navigation, char number){
		this.break2 = break2; 
		this.model = model;
		this.navigation = navigation;
		this.number = number;
	}
	Car(boolean break2){
		this.break2 = break2;
	}
	
	Car(char number){
		this.number = number;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "Car [model=" + model + ", color=" + color + "]";
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
	
	
	
		
			

}
