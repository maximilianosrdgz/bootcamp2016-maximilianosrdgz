package com.weatherCheck.main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by MaxPower on 23/09/2016.
 */
public class Main {
    public static void main(String [] args){



            String url = "jdbc:sqlserver://localhost:1433;" +
                    "databaseName=WeatherCheckTest;user=MaxPower;password=";

            Connection con=null;
            Statement stmnt=null;
            ResultSet rs=null;

        try {
            // Establish the connection.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(url);

            // Create and execute an SQL statement that returns some data.
            String SQL = "SELECT * FROM Forecasts";
            stmnt = con.createStatement();
            rs = stmnt.executeQuery(SQL);

            System.out.println(rs.getInt("idForecast"));

            rs.close();
            stmnt.close();
            con.close();

        }
        catch (Exception e){

        }


    }
}
