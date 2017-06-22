package com.astroweather.zehiel.astroweather.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by grusz on 22.06.2017.
 */

public class LocalizationData implements Serializable {

    private String country = null;
    private String city = null;
    private String latitude = null;
    private String longitude = null;
    private Date lastUpdateData = null;

    public LocalizationData(String country, String city, String latitude, String longitude, Date lastUpdateData) {
        this.country = country;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
        this.lastUpdateData = lastUpdateData;
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

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Date getLastUpdateData() {
        return lastUpdateData;
    }

    public void setLastUpdateData(Date lastUpdateData) {
        this.lastUpdateData = lastUpdateData;
    }


}
