package com.weatherCheck.DBConfig;

import static com.weatherCheck.DBConfig.Initialize.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by MaxPower on 02/10/2016.
 */
public class MySQLConnection {
    private static MySQLConnection ourInstance;
    private Connection con;

    public static MySQLConnection getInstance() {
        if(ourInstance == null){
            ourInstance = new MySQLConnection();
        }
        return ourInstance;
    }

    private MySQLConnection() {

        try {

            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static MySQLConnection getOurInstance() {
        return ourInstance;
    }

    public static void setOurInstance(MySQLConnection ourInstance) {
        MySQLConnection.ourInstance = ourInstance;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
}
