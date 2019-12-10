package client;
import java.io.IOException;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import bus.SportCar;
import bus.YearComparator;
import data.ConnectionDB;

public class TesterV1 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		
		// Check if table Player already exists
		DatabaseMetaData dbm = ConnectionDB.getInstance().getMetaData();
		System.out.println(dbm.getTables(null, "SYSTEM", "SPORTCAR", null).next());
		if(dbm.getTables(null, "SYSTEM", "SPORTCAR", null).next()) {
			System.out.println("Table exist");
			SportCar.dropTable(ConnectionDB.getInstance());     
		}
		
		SportCar.createTable(ConnectionDB.getInstance());
		
		SportCar aSportCar = new SportCar("A100", "Company1", "aaa", 100.0f, 5, "2018/12/10", 7.0f);
		SportCar bSportCar = new SportCar("B200", "Company2", "bbb", 200.0f, 7, "2019/12/10", 10.0f);
		
		// Add a sport car
		String msg;
		if (SportCar.add(aSportCar)>0)
        	msg = ".......Sport car added with succes........";
        else 
            msg = "...Sport car not added with success...";					  
        System.out.println( msg); 
        
        if (SportCar.add(bSportCar)>0)
        	msg = ".......Sport car added with succes........";
        else 
            msg = "...Sport car not added with success...";					  
        System.out.println( msg); 
		
		System.out.println("\n\n............ Display all sport car............\n");
        
        HashMap<String, SportCar> hashMapSportCar = null;
		try {
			hashMapSportCar = SportCar.getList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        for(SportCar sportCar : hashMapSportCar.values()) 
        {
            System.out.println(sportCar);
        }

        System.out.println("------------------------------------\n");
        
        // Search for a sport car by serial number
        System.out.println("Search sport car which has SN: A100\n");
        System.out.println(SportCar.search("\'A100\'"));
        
        // Sort sport cars by years in descending order
        System.out.println("\n\nSort sport cars by years in descending order\n");
        ArrayList<SportCar> sportCarList = new ArrayList<SportCar>();
        sportCarList.add(aSportCar);
        sportCarList.add(bSportCar);
        
        Collections.sort(sportCarList, new YearComparator());
        for(SportCar car : sportCarList) {
        	System.out.println(car);
        }
        System.out.println("------------------------------------\n");
        
        // Remove a sport car
        System.out.println("Remove sport car which has SN: B200\n");
        SportCar.remove("\'B200\'");
        
        System.out.println("\n\n............ Display all sport car............\n");
		try {
			hashMapSportCar = SportCar.getList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        for(SportCar sportCar : hashMapSportCar.values()) 
        {
            System.out.println(sportCar);
        }
        
        // Display all sport cars
        System.out.println("\n\n............ Display all sport car............\n");
        
        try {
			hashMapSportCar = SportCar.getList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        for(SportCar sportCar : hashMapSportCar.values()) 
        {
            System.out.println(sportCar);
        }
	}

}
