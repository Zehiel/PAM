package com.astroweather.zehiel.astroweather.model.weather;

import java.io.Serializable;

/**
 * Created by grusz on 22.06.2017.
 */

public class FutureWeather implements Serializable {

    private String day = null;
    private String minTemp = null;
    private String maxTemp = null;
    private String imageCode = null;

    public FutureWeather(String day, String minTemp, String maxTemp, String imageCode) {
        this.day = day;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.imageCode = imageCode;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(String minTemp) {
        this.minTemp = minTemp;
    }

    public String getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(String maxTemp) {
        this.maxTemp = maxTemp;
    }

    public String getImageCode() {
        return imageCode;
    }

    public void setImageCode(String imageCode) {
        this.imageCode = imageCode;
    }
}
