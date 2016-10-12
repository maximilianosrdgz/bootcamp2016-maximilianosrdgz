package com.weatherCheck.DataAccess;

import com.weatherCheck.DBConfig.MySQLConnection;
import com.weatherCheck.Domain.Wind;

import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by MaxPower on 11/10/2016.
 */
public class WindDAO {

    MySQLConnection MySQLCon;
    //Connection con;

    public void save(Wind wind, int recordCount){

        MySQLCon = MySQLConnection.getInstance();
        Statement stmtInsert;

        try{
            stmtInsert = MySQLCon.getCon().createStatement();
            String insert;

            //INSERT WINDDATAS
            insert = "insert into WindDatas (speed, direction)\n" +
                    "values ("+wind.getSpeed()+", "+wind.getDirection()+")";
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
