package ws1;

public abstract class Transportation {
	String line;
	String color;
	Factor factor;

	public Transportation() {
	}

	public Transportation(Factor factor) {
		this.factor = factor;
	}

	public Transportation(String line, String color, Factor factor) {
		this.line = line;
		this.color = color;
		this.factor = factor;
	}

	public Factor getFactor() {
		return factor;
	}

	public void setFactor(Factor factor) {
		this.factor = factor;
	}

	public abstract double calcFare();

	public abstract int calcTime();

	@Override
	public String toString() {
		return "Transportation [factor=" + factor + "]";
	}

}
