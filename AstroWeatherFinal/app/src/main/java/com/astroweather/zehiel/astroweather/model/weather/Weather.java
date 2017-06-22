package com.astroweather.zehiel.astroweather.model.weather;

import com.astroweather.zehiel.astroweather.model.localization.LocalizationData;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by grusz on 22.06.2017.
 */

public class Weather implements Serializable {
    private LocalizationData localizationData = null;
    private WeatherNow weatherNow = null;
    private Wind wind = null;
    private List<FutureWeather> futureWeatherList = new ArrayList<>(7);
    private Units units = null;

    public Weather(LocalizationData localizationData, WeatherNow weatherNow, Wind wind, List<FutureWeather> futureWeatherList, Units units) {
        this.localizationData = localizationData;
        this.weatherNow = weatherNow;
        this.wind = wind;
        this.futureWeatherList = futureWeatherList;
        this.units = units;
    }

    public LocalizationData getLocalizationData() {
        return localizationData;
    }

    public void setLocalizationData(LocalizationData localizationData) {
        this.localizationData = localizationData;
    }

    public WeatherNow getWeatherNow() {
        return weatherNow;
    }

    public void setWeatherNow(WeatherNow weatherNow) {
        this.weatherNow = weatherNow;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public List<FutureWeather> getFutureWeatherList() {
        return futureWeatherList;
    }

    public void setFutureWeatherList(List<FutureWeather> futureWeatherList) {
        this.futureWeatherList = futureWeatherList;
    }

    public Units getUnits() {
        return units;
    }

    public void setUnits(Units units) {
        this.units = units;
    }
}
