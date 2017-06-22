package com.astroweather.zehiel.astroweather.util;

import java.text.ParseException;
import android.os.AsyncTask;

import com.astroweather.zehiel.astroweather.model.weather.Weather;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by grusz on 22.06.2017.
 */

public class WeatherDataTask extends AsyncTask<String,Void,Weather> {
    @Override
    protected Weather doInBackground(String... params) {
        Weather weather = null;
        String units = params[0];
        String country = params[1];
        String city = params[2];

        try {
            JSONObject json = JSON.getJSON(DefaultValues.WEATHER_URL[0] + units +
                    DefaultValues.WEATHER_URL[1] + city + DefaultValues.WEATHER_URL[2]
                    + country + DefaultValues.WEATHER_URL[3]);
            weather = JSON.getFromJsonAllWeatherData(json);
        } catch (JSONException | ParseException e) {
            e.printStackTrace();
        }

        return weather;
    }
}
