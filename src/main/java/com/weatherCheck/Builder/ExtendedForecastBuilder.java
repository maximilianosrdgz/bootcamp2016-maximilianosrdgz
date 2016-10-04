package com.weatherCheck.Builder;

import com.weatherCheck.Domain.Day;
import com.weatherCheck.Domain.ExtendedForecast;

import java.util.ArrayList;

/**
 * Created by MaxPower on 04/10/2016.
 */
public final class ExtendedForecastBuilder {
    private ArrayList<Day> extForecast;

    private ExtendedForecastBuilder() {
    }

    public static ExtendedForecastBuilder anExtendedForecast() {
        return new ExtendedForecastBuilder();
    }

    public ExtendedForecastBuilder withExtForecast(ArrayList<Day> extForecast) {
        this.extForecast = extForecast;
        return this;
    }

    public ExtendedForecast build() {
        ExtendedForecast extendedForecast = new ExtendedForecast();
        extendedForecast.setExtForecast(extForecast);
        return extendedForecast;
    }
}
