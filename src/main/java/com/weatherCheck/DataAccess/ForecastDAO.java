package com.weatherCheck.DataAccess;

import com.weatherCheck.DBConfig.MySQLConnection;
import com.weatherCheck.Domain.Forecast;

import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by MaxPower on 11/10/2016.
 */
public class ForecastDAO {

    MySQLConnection MySQLCon;
    Connection con;

    public void save(Forecast fore, int recordCount){

        MySQLCon = MySQLConnection.getInstance();
        con = MySQLCon.getCon();
        Statement stmtInsert;

        try{
            stmtInsert = con.createStatement();
            String insert;

            //INSERT FORECASTS
            insert = "insert into Forecasts (idCity, idDay, idAtmosphericData, idWindData)\n" +
                    "values ("+recordCount+", "+recordCount+", "+recordCount+", "+recordCount+")";
            System.out.println(insert);
            stmtInsert.executeUpdate(insert);
            System.out.println("Data added");

            stmtInsert.close();
            con.close();
        }
        catch(Exception e){

        }
    }

}
