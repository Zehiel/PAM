package com.astroweather.zehiel.astroweather.model.localization;

import java.io.Serializable;

/**
 * Created by grusz on 22.06.2017.
 */

public class Localization implements Serializable {

    private String country = null;
    private String city = null;

    public Localization(String country, String city) {
        this.country = country;
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return country + ',' + city;
    }
}
