package bus;

public class Car implements IClonableCar {
	
	private String sn; // Serial number
	private String brand;
	private String model;
	private float price;
	private int nos; // Number of seats
	private String date; // Made date
	
	public Car() {
		sn = "";
		brand = "";
		model = "";
		price = 0.0f;
		nos = 0;
		date = "";
	}
	
	public Car(String sn, String brand, String model, float price, int nos, String date) {
		this.sn = sn;
		this.brand = brand;
		this.model = model;
		this.price = price;
		this.nos = nos;
		this.date = date;
	}
	
	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getNos() {
		return nos;
	}

	public void setNos(int nos) {
		this.nos = nos;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Car [sn=" + sn + ", brand=" + brand + ", model=" + model + ", price=" + price + ", nos=" + nos + "]";
	}

	
	public Car clone() {
		return null;
	}
}
