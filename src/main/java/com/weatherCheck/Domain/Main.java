package com.weatherCheck.Domain;

import com.weatherCheck.Builder.*;
import com.weatherCheck.DBConfig.MySQLConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by MaxPower on 23/09/2016.
 */
public class Main {

    public static void main(String [] args) {

        //DB Connection variables
        Connection con;
        Statement stmtSelect;
        Statement stmtInsert;
        Statement stmtCount;
        int recordCount = 0;

        //Object Forecast variables
        Forecast forec;
        Atmosphere atm;
        Day da;
        ExtendedForecast extForec;
        Location loc;
        Wind win;

        String desc, count, cit, reg;
        float hum, pres, vis, maxT, minT, spd, dir;
        ArrayList<Day> extF = new ArrayList<Day>(10);
        DayOfWeek d;
        Date dt;
        Calendar cal = Calendar.getInstance();

        //OBJECTS CREATION

        Scanner scannIn = new Scanner(System.in);

        //Location
        System.out.println("Region: ");
        reg = scannIn.nextLine();
        System.out.println("Country: ");
        count = scannIn.nextLine();
        System.out.println("City: ");
        cit = scannIn.nextLine();

        //Atmosphere
        System.out.println("Humidity: ");
        hum = scannIn.nextFloat();
        System.out.println("Preassure: ");
        pres = scannIn.nextFloat();
        System.out.println("Visibility: ");
        vis = scannIn.nextFloat();

        //Day
        System.out.println("Day of the Week: ");
        System.out.println("Friday");
        d = DayOfWeek.FRIDAY;
        System.out.println("Date: Today");
        dt = cal.getTime();
        System.out.println("Max Temp: ");
        maxT = scannIn.nextFloat();
        System.out.println("Min Temp: ");
        minT = scannIn.nextFloat();
        System.out.println("Day description: sunny");
        desc = "sunny";
        System.out.println("Ext Forec Init");

        //Ext Forecast
        for (int i=0; i>10; i++){
            extF.add(new Day());
        }

        //Wind
        System.out.println("Wind speed: ");
        spd = scannIn.nextFloat();
        System.out.println("Wind direction: ");
        dir = scannIn.nextFloat();

        //Object Build with Builders
        atm = AtmosphereBuilder.anAtmosphere()
                .withHumidity(hum)
                .withPressure(pres)
                .withVisibility(vis)
                .build();
        da = DayBuilder.aDay()
                .withDate(dt)
                .withDay(d)
                .withDescription(desc)
                .withMaxTemp(maxT)
                .withMinTemp(minT)
                .build();
        loc = LocationBuilder.aLocation()
                .withCity(cit)
                .withCountry(count)
                .withRegion(reg)
                .build();
        extForec = ExtendedForecastBuilder.anExtendedForecast()
                .withExtForecast(extF)
                .build();
        win = WindBuilder.aWind()
                .withDirection(dir)
                .withSpeed(spd)
                .build();

        forec = ForecastBuilder.aForecast()
                .withAtmosphere(atm)
                .withDay(da)
                .withExtendedForecast(extForec)
                .withLocation(loc)
                .withWind(win)
                .build();

        //Object Build w/o Builder
        //loc = new Location(cit, count, reg);
        //atm = new Atmosphere(hum, pres, vis);
        //da = new Day(d, dt, maxT, minT, desc);
        //extForec = new ExtendedForecast(extF);
        //win = new Wind(spd, dir);

        //forec = new Forecast(atm, da, extForec, loc, win);

        try {

            //Open connection
            System.out.println("Flag 1 Connecting");
            MySQLConnection MySQLCon = MySQLConnection.getInstance();
            con = MySQLCon.getCon();

            stmtCount = con.createStatement();
            System.out.println("Statement created");
            String selCount;
            selCount = "select count(*) 'recordCount' from Forecasts";
            ResultSet rsCount = stmtCount.executeQuery(selCount);
            System.out.println("Statement executed");

            while (rsCount.next()) {

                recordCount = rsCount.getInt("recordCount");

                //Output
                System.out.print("Record Count: " + recordCount);

            }
            recordCount++;

            rsCount.close();
            stmtCount.close();

            //INSERT
            stmtInsert = con.createStatement();
            String insert;

            //INSERT REGION
            insert = "insert into regions (region)\n" +
                    "values ('"+forec.getLocation().getRegion()+"')";
            System.out.println(insert);
            stmtInsert.executeUpdate(insert);
            System.out.println("Data added");

            //INSERT COUNTRIES
            insert = "insert into countries (country, idRegion)\n" +
                    "values ('"+forec.getLocation().getCountry()+"', "+recordCount+")";
            System.out.println(insert);
            stmtInsert.executeUpdate(insert);
            System.out.println("Data added");

            //INSERT CITIES
            insert = "insert into cities (city, idCountry)\n" +
                    "values ('"+forec.getLocation().getCity()+"', "+recordCount+")";
            System.out.println(insert);
            stmtInsert.executeUpdate(insert);
            System.out.println("Data added");

            //INSERT DESCRIPTIONS
            insert = "insert into Descriptions (description)\n" +
                    "values ('"+forec.getDay().getDescription()+"')";
            System.out.println(insert);
            stmtInsert.executeUpdate(insert);
            System.out.println("Data added");

            //INSERT WEEKDAYS
            insert = "insert into WeekDays (weekDay)\n" +
                    "values ('"+forec.getDay().getDay().toString()+"')";
            System.out.println(insert);
            stmtInsert.executeUpdate(insert);
            System.out.println("Data added");

            //INSERT ATMOSPHERICDATAS
            insert = "insert into AtmosphericDatas (humidity, preasure, visibility)\n" +
                    "values ("+forec.getAtmosphere().getHumidity()+", "+forec.getAtmosphere().getPressure()+
                    ", "+forec.getAtmosphere().getVisibility()+")";
            System.out.println(insert);
            stmtInsert.executeUpdate(insert);
            System.out.println("Data added");

            //INSERT WINDDATAS
            insert = "insert into WindDatas (speed, direction)\n" +
                    "values ("+forec.getWind().getSpeed()+", "+forec.getWind().getDirection()+")";
            System.out.println(insert);
            stmtInsert.executeUpdate(insert);
            System.out.println("Data added");

            //INSERT DAYS
            insert = "insert into Days (date, idWeekDay, maxTemp, minTemp, idDescription)\n" +
                    "values ('2016/01/01', "+recordCount+", "+forec.getDay().getMaxTemp()+
                    ", "+forec.getDay().getMinTemp()+", "+recordCount+")";
            System.out.println(insert);
            stmtInsert.executeUpdate(insert);
            System.out.println("Data added");

            //INSERT FORECASTS
            insert = "insert into Forecasts (idCity, idDay, idAtmosphericData, idWindData)\n" +
                    "values ("+recordCount+", "+recordCount+", "+recordCount+", "+recordCount+")";
            System.out.println(insert);
            stmtInsert.executeUpdate(insert);
            System.out.println("Data added");

            //INSERT EXTENDEDFORECASTS
            insert = "insert into ExtendedForecasts (idForecast, idDay)\n" +
                    "values ("+recordCount+", "+recordCount+")";
            System.out.println(insert);
            stmtInsert.executeUpdate(insert);
            System.out.println("Data added");




            //Test SELECT
            System.out.println("Flag 2 Statement");
            stmtSelect = con.createStatement();
            String select;
            select = "SELECT idForecast, idCity, idDay, idAtmosphericData FROM Forecasts";
            ResultSet rs = stmtSelect.executeQuery(select);

            //Extract data from rs
            while (rs.next()) {

                int idForecast = rs.getInt("idForecast");
                float idCity = rs.getFloat("idCity");
                float idDay = rs.getFloat("idDay");
                float idAtmosphericData = rs.getFloat("idAtmosphericData");

                //Output
                System.out.print("ID Forec: " + idForecast);
                System.out.print(", ID City: " + idCity);
                System.out.print(", ID Day: " + idDay);
                System.out.println(", ID Atm: " + idAtmosphericData);

            }


            rs.close();
            stmtSelect.close();


            con.close();
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