package com.astroweather.zehiel.astroweather.model;

import java.io.Serializable;

/**
 * Created by grusz on 22.06.2017.
 */

public class Units implements Serializable {

    private String speed = null;
    private String temperature = null;
    private String pressure = null;
    private String distance = null;

    public Units(String speed, String temperature, String pressure, String distance) {
        this.speed = speed;
        this.temperature = temperature;
        this.pressure = pressure;
        this.distance = distance;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
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

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }
}
