package com.astroweather.zehiel.astroweather.model.weather;

import java.io.Serializable;

/**
 * Created by grusz on 22.06.2017.
 */

public class WeatherNow implements Serializable {
    private String temperature = null;
    private String pressure = null;
    private String imageCode = null;
    private String description = null;

    public WeatherNow(String temperature, String pressure, String imageCode, String description) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.imageCode = imageCode;
        this.description = description;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getImageCode() {
        return imageCode;
    }

    public void setImageCode(String imageCode) {
        this.imageCode = imageCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
