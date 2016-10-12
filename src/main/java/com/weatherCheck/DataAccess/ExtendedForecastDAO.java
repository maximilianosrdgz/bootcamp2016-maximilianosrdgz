package com.weatherCheck.DataAccess;

import com.weatherCheck.DBConfig.MySQLConnection;
import com.weatherCheck.Domain.ExtendedForecast;

import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by MaxPower on 11/10/2016.
 */
public class ExtendedForecastDAO {

    MySQLConnection MySQLCon;
    //Connection con;

    public void save(ExtendedForecast extFore, int recordCount){

        MySQLCon = MySQLConnection.getInstance();
        Statement stmtInsert;

        try{
            stmtInsert = MySQLCon.getCon().createStatement();
            String insert;

            //INSERT EXTENDEDFORECASTS
            insert = "insert into ExtendedForecasts (idForecast, idDay)\n" +
                    "values ("+recordCount+", "+recordCount+")";
            System.out.println(insert);
            stmtInsert.executeUpdate(insert);
            System.out.println("Data added");

            stmtInsert.close();
            MySQLCon.getCon().close();
        }
        catch(Exception e){

        }
    }

}
