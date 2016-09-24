package com.weatherCheck.main;

import java.awt.*;

/**
 * Created by MaxPower on 24/09/2016.
 */
public class ExtendedForecast {

    private List extForecast;

    public ExtendedForecast(List extForecast) {
        this.extForecast = extForecast;
    }

    public List getExtForecast() {
        return extForecast;
    }

    public void setExtForecast(List extForecast) {
        this.extForecast = extForecast;
    }

    @Override
    public String toString(){
        return "Extended forecast: "+extForecast.toString();
    }
}
