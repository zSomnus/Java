package data;

import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import bus.SportCar;

//import bus.EnumType;
//import bus.GamePlayer;

public class SportCarDB {
	public static Exception createTable(Connection currentConnection) throws SQLException{
        Statement currentStatement = null;

        String sqlString = "create table SportCar(sn varchar(20) primary key not null, brand varchar(50), model varchar(16), price float, seats int, dates varchar(10), gascon float)";

        currentStatement = currentConnection.createStatement();
        currentStatement.execute(sqlString);
        currentConnection.commit();
        currentConnection.close();

        return null;
    }

    public static Exception getTableDescription(Connection currentConnection) throws SQLException{
        Statement currentStatement = null;
        String sqlString = "desc SportCar";

        currentStatement = currentConnection.createStatement();
        currentStatement.execute(sqlString);
        currentConnection.commit();
        currentConnection.close();
        return null;
    }

    public static Exception alterTable(int id, Connection currentConnection) throws SQLException{
        Statement currentStatement = null;
        String sqlString = "alter table SportCar add constraint pk_ primary key(id)";
        currentStatement = currentConnection.createStatement();
        currentStatement.execute(sqlString);
        currentConnection.commit();
        currentConnection.close();

        return null;
    }

    public static Exception dropTable(Connection currentConnection) throws SQLException{
        Statement currentStatement = null;
        String sqlString = "drop table SportCar";
        currentStatement = currentConnection.createStatement();
        currentStatement.execute(sqlString);
        currentConnection.commit();
        currentConnection.close();

        return null;
    }

    public static HashMap<String, SportCar> getList() throws SQLException{
        HashMap<String, SportCar> myList = new HashMap<String, SportCar>();

        Connection myConnection = ConnectionDB.getInstance();
        String query = "select * from SportCar";
        Statement myStatement;
        ResultSet resultSet;

        myStatement = myConnection.createStatement();
        resultSet = myStatement.executeQuery(query);

        String sn, brand, model;
        float price;
        int nos;
        String dates;
        float gasCon;
        SportCar aSportCar;

        while(resultSet.next()){
            sn = resultSet.getString(1);
            brand = resultSet.getString(2);
            model = resultSet.getString(3);
            price = resultSet.getFloat(4);
            nos = resultSet.getInt(5);
            dates = resultSet.getString(6);
            gasCon = resultSet.getFloat(7);
            

            
            aSportCar = new SportCar(sn, brand, model, price, nos, dates, gasCon);
            myList.put(((SportCar)aSportCar).getSn(), aSportCar);
            
        }
        myConnection.close();
        return myList;
    }

    public static int insert(SportCar aSportCar) throws SQLException{
        int success = -1;

        Connection myConnection = ConnectionDB.getInstance();
        Statement myStatement = myConnection.createStatement();

        String request = "insert into SportCar (sn, brand, model, price, seats, dates, gascon)" + "values ("
        + "\'"        
		+ aSportCar.getSn() + "\'" + "," + "\'"
        + aSportCar.getBrand() + "\'" + "," + "\'"
        + aSportCar.getModel() + "\'" + "," 
        + aSportCar.getPrice() + ","
        + aSportCar.getNos() + "," + "\'"
        + aSportCar.getDate() + "\'" + ","
        + aSportCar.getGasCon()
        + ")";

        success = myStatement.executeUpdate(request);
        myConnection.commit();
        myConnection.close();

        return success;
    }

    public static int delete(SportCar aSportCar) throws SQLException{
        int success = -1;
        Connection myConnection = ConnectionDB.getInstance();
        Statement myStatement = myConnection.createStatement();

        String request = "delete from SportCar where sn=" + aSportCar.getSn();

        success = myStatement.executeUpdate(request);
        myConnection.commit();
        myConnection.close();
        return success;
    }

    public static long delete(String key) throws SQLException{
        int success = -1;
        Connection myConnection = ConnectionDB.getInstance();
        Statement myStatement = myConnection.createStatement();
        String request = "delete from SportCar where sn=" + key;

        success = myStatement.executeUpdate(request);
        myConnection.commit();
        myConnection.close();;
        return success;
    }

    public static SportCar search(String key) throws SQLException{
        Connection myConnection = ConnectionDB.getInstance();
        Statement myStatement = myConnection.createStatement();

        String request = "SELECT * FROM SPORTCAR WHERE SN = " + key;
        
        ResultSet myResultSet = myStatement.executeQuery(request);
        SportCar aSportCar = null;
        

        if(myResultSet.next()){
            aSportCar = new SportCar(myResultSet.getString("sn"), myResultSet.getString("brand"), myResultSet.getString("model"), myResultSet.getFloat("price"), myResultSet.getInt("seats"), myResultSet.getString("dates"), myResultSet.getFloat("gascon"));
        }
        return aSportCar;
    }

    

    public static int update(String value){
        return 0;
    }
	
}
