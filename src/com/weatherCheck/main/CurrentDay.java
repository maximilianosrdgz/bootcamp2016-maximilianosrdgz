package com.weatherCheck.main;

import java.time.DayOfWeek;
import java.util.Date;

/**
 * Created by MaxPower on 24/09/2016.
 */
public class CurrentDay {

    private DayOfWeek day;
    private Date date;
    private float temperature;
    private String description;

    public CurrentDay(DayOfWeek day, Date date, float temperature, String description) {
        this.day = day;
        this.date = date;
        this.temperature = temperature;
        this.description = description;
    }

    public DayOfWeek getDay() {
        return day;
    }

    public void setDay(DayOfWeek day) {
        this.day = day;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString(){
        return "Day: "+day.toString()+
                "\nDate: "+date.toString()+
                "\nTemperature: "+temperature+
                "\nDescrpition: "+description;
    }



}
