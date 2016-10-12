package com.weatherCheck.DataAccess;

import com.weatherCheck.DBConfig.MySQLConnection;
import com.weatherCheck.Domain.Atmosphere;

import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by MaxPower on 11/10/2016.
 */
public class AtmosphereDAO {

    MySQLConnection MySQLCon;
    //Connection con;

    public void save(Atmosphere atmos, int recordCount){

        MySQLCon = MySQLConnection.getInstance();
        Statement stmtInsert;

        try{
            stmtInsert = MySQLCon.getCon().createStatement();
            String insert;

            //INSERT ATMOSPHERICDATAS
            insert = "insert into AtmosphericDatas (humidity, preasure, visibility)\n" +
                    "values ("+atmos.getHumidity()+", "+atmos.getPressure()+
                    ", "+atmos.getVisibility()+")";
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
