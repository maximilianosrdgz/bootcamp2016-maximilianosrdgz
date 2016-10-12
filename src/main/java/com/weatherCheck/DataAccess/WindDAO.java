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
    Connection con;

    public void save(Wind wind, int recordCount){

        MySQLCon = MySQLConnection.getInstance();
        con = MySQLCon.getCon();
        Statement stmtInsert;

        try{
            stmtInsert = con.createStatement();
            String insert;

            //INSERT WINDDATAS
            insert = "insert into WindDatas (speed, direction)\n" +
                    "values ("+wind.getSpeed()+", "+wind.getDirection()+")";
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
