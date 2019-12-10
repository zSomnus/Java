package bus;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

import data.SportCarDB;

public class SportCar extends Car {
//	private String sn; // Serial number
//	private String brand;
//	private String model;
//	private float price;
//	private int nos; // Number of seats
//	private String date; // Made date
	
	public float gasCon; // Gas consumption
	
	public SportCar() {
		super();
		gasCon = 0.0f;
	} 
	public SportCar(String sn, String brand, String model, float price, int nos, String date, float gasCon) {
		super(sn, brand, model, price, nos, date);
		this.gasCon = gasCon;
	}
	
	public float getGasCon() {
		return gasCon;
	}
	public void setGasCon(float gasCon) {
		this.gasCon = gasCon;
	}
	
	@Override
	public String toString() {
		return "SportCar [gasCon=" + gasCon + ", getGasCon()=" + getGasCon() + ", getSn()=" + getSn() + ", getBrand()="
				+ getBrand() + ", getModel()=" + getModel() + ", getPrice()=" + getPrice() + ", getNos()=" + getNos()
				+ ", getDate()=" + getDate() + "]";
	}
	public Car clone() {
		return null;
	}
	
	public static HashMap<String, SportCar> getList() throws SQLException{
		return SportCarDB.getList();
	}

	public static long add(SportCar aSportCar) throws SQLException{
		return SportCarDB.insert(aSportCar);
	}

	public static long remove(String key) throws SQLException{
		return SportCarDB.delete(key);
	}
	public static int remove(SportCar aSportCar) throws SQLException{
		return SportCarDB.delete(aSportCar);
	}
	
	public static SportCar search(String key) throws SQLException{
		return SportCarDB.search(key);
	}
	
	
	public static int modify(String value){
		return SportCarDB.update(value);
	}

	public static Exception createTable(Connection myConnection) throws SQLException{
		return SportCarDB.createTable(myConnection);
	}
	
	public static Exception dropTable(Connection myConnection) throws SQLException{
		return SportCarDB.dropTable(myConnection);
	}
}
