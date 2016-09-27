package com.weatherCheck.main;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by MaxPower on 23/09/2016.
 */
public class Main {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/WeatherCheckTest?useSSL=false";

    static final String USER = "root";
    static final String PASS = "imladris";

    public static void main(String [] args) {

        Connection conn = null;
        Statement stmt = null;
        try {
            //JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //Open connection
            System.out.println("Flag 1 Connecting");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //Query
            System.out.println("Flag 2 Statement");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT idForecast, humidity, preassure, visibility FROM Forecasts";
            ResultSet rs = stmt.executeQuery(sql);

            //Extract data from rs
            while (rs.next()) {

                int idForecast = rs.getInt("idForecast");
                float humidity = rs.getFloat("humidity");
                float preassure = rs.getFloat("preassure");
                float visibility = rs.getFloat("visibility");

                //Output
                System.out.print("ID: " + idForecast);
                System.out.print(", Hum: " + humidity);
                System.out.print(", Preass: " + preassure);
                System.out.println(", Visib: " + visibility);
            }

            rs.close();
            stmt.close();
            conn.close();
        }
        catch(Exception e){

        } // Estas excepciones estaban el uno de los códigos que usé para guiarme, pero si las agrego no reonoce el objeto SQLException,
          // así que no estoy manejando excepciones aún

        /*
        catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }   //end try   */
        System.out.println("Flag 3 End");
    }
    }