package com.weatherCheck.DataAccess;

import com.weatherCheck.DBConfig.MySQLConnection;
import com.weatherCheck.Domain.Day;

import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by MaxPower on 11/10/2016.
 */
public class DayDAO {

    MySQLConnection MySQLCon;
    //Connection con;

    public void save(Day d, int recordCount){

        MySQLCon = MySQLConnection.getInstance();
        Statement stmtInsert;

        try{
            //INSERT DESCRIPTIONS
            stmtInsert = MySQLCon.getCon().createStatement();
            String insert;

            insert = "insert into Descriptions (description)\n" +
                    "values ('"+d.getDescription()+"')";
            System.out.println(insert);
            stmtInsert.executeUpdate(insert);
            System.out.println("Data added");

            //INSERT WEEKDAYS
            insert = "insert into WeekDays (weekDay)\n" +
                    "values ('"+d.getDay().toString()+"')";
            System.out.println(insert);
            stmtInsert.executeUpdate(insert);
            System.out.println("Data added");

            //INSERT DAYS
            insert = "insert into Days (date, idWeekDay, maxTemp, minTemp, idDescription)\n" +
                    "values ('2016/01/01', "+recordCount+", "+d.getMaxTemp()+
                    ", "+d.getMinTemp()+", "+recordCount+")";
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
