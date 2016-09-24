package com.weatherCheck.main;

/**
 * Created by MaxPower on 23/09/2016.
 */
public class Forecast {

    private Atmosphere atmosphere;
    private CurrentDay currentDay;
    private ExtendedForecast extendedForecast;
    private Location location;
    private Wind wind;

    public Forecast(Atmosphere atmosphere, CurrentDay currentDay, ExtendedForecast extendedForecast, Location location, Wind wind) {
        this.atmosphere = atmosphere;
        this.currentDay = currentDay;
        this.extendedForecast = extendedForecast;
        this.location = location;
        this.wind = wind;
    }

    public Atmosphere getAtmosphere() {
        return atmosphere;
    }

    public void setAtmosphere(Atmosphere atmosphere) {
        this.atmosphere = atmosphere;
    }

    public CurrentDay getCurrentDay() {
        return currentDay;
    }

    public void setCurrentDay(CurrentDay currentDay) {
        this.currentDay = currentDay;
    }

    public ExtendedForecast getExtendedForecast() {
        return extendedForecast;
    }

    public void setExtendedForecast(ExtendedForecast extendedForecast) {
        this.extendedForecast = extendedForecast;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    @Override
    public String toString(){
        return "Forecast: "+atmosphere.toString()+
                "\nCurrent Day: "+currentDay.toString()+
                "\nExtended Forecast: "+extendedForecast.toString()+
                "\nLocation: "+location.toString()+
                "\nWind: "+wind.toString();
    }
}
