package com.weatherCheck.DataAccess;

import com.weatherCheck.DBConfig.MySQLConnection;
import com.weatherCheck.Domain.Location;

import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by MaxPower on 11/10/2016.
 */
public class LocationDAO {

    MySQLConnection MySQLCon;
    //Connection con;

    public void save(Location loc, int recordCount){

        MySQLCon = MySQLConnection.getInstance();
        Statement stmtInsert;

        try{
            stmtInsert = MySQLCon.getCon().createStatement();
            String insert;

            //INSERT REGION
            insert = "insert into regions (region)\n" +
                    "values ('"+loc.getRegion()+"')";
            System.out.println(insert);
            stmtInsert.executeUpdate(insert);
            System.out.println("Data added");

            //INSERT COUNTRIES
            insert = "insert into countries (country, idRegion)\n" +
                    "values ('"+loc.getCountry()+"', "+recordCount+")";
            System.out.println(insert);
            stmtInsert.executeUpdate(insert);
            System.out.println("Data added");

            //INSERT CITIES
            insert = "insert into cities (city, idCountry)\n" +
                    "values ('"+loc.getCity()+"', "+recordCount+")";
            System.out.println(insert);
            stmtInsert.executeUpdate(insert);
            System.out.println("Data added");

            stmtInsert.close();
            //MySQLCon.getCon().close();
        }
        catch(Exception e){

        }



    }

}