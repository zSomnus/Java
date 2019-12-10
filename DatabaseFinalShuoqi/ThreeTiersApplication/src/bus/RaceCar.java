package bus;

public class RaceCar extends Car {
	public float powerCon; // Power consumption
	
	public RaceCar() {
		super();
		powerCon = 0.0f;
	} 
	public RaceCar(String sn, String brand, String model, float price, int nos, String date, float powerCon) {
		super(sn, brand, model, price, nos, date);
		this.powerCon = powerCon;
	}
	public float getPowerCon() {
		return powerCon;
	}
	public void setPowerCon(float powerCon) {
		this.powerCon = powerCon;
	}
	@Override
	public String toString() {
		return "RaceCar [powerCon=" + powerCon + ", getPowerCon()=" + getPowerCon() + ", getSn()=" + getSn()
				+ ", getBrand()=" + getBrand() + ", getModel()=" + getModel() + ", getPrice()=" + getPrice()
				+ ", getNos()=" + getNos() + ", getDate()=" + getDate() + "]";
	}
	
	public Car clone() {
		return null;
	}
}
