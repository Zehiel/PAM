package com.astroweather.zehiel.astroweather.model.weather;

import java.io.Serializable;

/**
 * Created by grusz on 22.06.2017.
 */

public class Wind implements Serializable {

    private String windDirection = null;
    private String windForce = null;
    private String humidity = null;
    private String visibility = null;

    public Wind(String windDirection, String windForce, String humidity, String visibility) {
        this.windDirection = windDirection;
        this.windForce = windForce;
        this.humidity = humidity;
        this.visibility = visibility;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public String getWindForce() {
        return windForce;
    }

    public void setWindForce(String windForce) {
        this.windForce = windForce;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }
}
