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
    Connection con;

    public void save(Atmosphere atmos, int recordCount){

        MySQLCon = MySQLConnection.getInstance();
        con = MySQLCon.getCon();
        Statement stmtInsert;

        try{
            stmtInsert = con.createStatement();
            String insert;

            //INSERT ATMOSPHERICDATAS
            insert = "insert into AtmosphericDatas (humidity, preasure, visibility)\n" +
                    "values ("+atmos.getHumidity()+", "+atmos.getPressure()+
                    ", "+atmos.getVisibility()+")";
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
