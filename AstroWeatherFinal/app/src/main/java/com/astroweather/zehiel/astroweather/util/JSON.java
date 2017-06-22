package com.astroweather.zehiel.astroweather.util;

import com.astroweather.zehiel.astroweather.model.Units;
import com.astroweather.zehiel.astroweather.model.localization.LocalizationData;
import com.astroweather.zehiel.astroweather.model.weather.FutureWeather;
import com.astroweather.zehiel.astroweather.model.weather.Weather;
import com.astroweather.zehiel.astroweather.model.weather.WeatherNow;
import com.astroweather.zehiel.astroweather.model.weather.Wind;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by grusz on 22.06.2017.
 */

public class JSON {
    public static Weather getFromJsonAllWeatherData(JSONObject jsonObj) throws JSONException, ParseException {

        return new Weather(
                getFromJsonLocalizationData(jsonObj),
                getFromJsonActualWeatherData(jsonObj),
                getFromJsonWindData(jsonObj),
                getFromJsonoFutherWeatherData(jsonObj),
                getFromJsonUnits(jsonObj)
        );
    }

    public static WeatherNow getFromJsonActualWeatherData(JSONObject jsonObj) throws JSONException, ParseException {

        JSONObject json = selectSpecialData(jsonObj);
        String temperature = json.getJSONObject("item").getJSONObject("condition").getString("temp");
        String pressure = json.getJSONObject("atmosphere").getString("pressure");
        String description = json.getJSONObject("item").getJSONObject("condition").getString("text");
        String imageCode = json.getJSONObject("item").getJSONObject("condition").getString("code");

        return new WeatherNow(temperature, pressure,imageCode, description );
    }

    public static Wind getFromJsonWindData(JSONObject jsonObj) throws JSONException, ParseException {

        JSONObject json = selectSpecialData(jsonObj);
        String windForce = json.getJSONObject("wind").getString("speed");
        String windDirection = json.getJSONObject("wind").getString("direction");
        String humidity = json.getJSONObject("atmosphere").getString("humidity");
        String visibility = json.getJSONObject("atmosphere").getString("visibility");

        return new Wind(windDirection,windForce, humidity, visibility);
    }

    public static List<FutureWeather> getFromJsonoFutherWeatherData(JSONObject jsonObj) throws JSONException, ParseException {

        JSONObject json = selectSpecialData(jsonObj);
        JSONArray array = json.getJSONObject("item").getJSONArray("forecast");
        List<FutureWeather> futureWeathers = new ArrayList<>(7);

        for (int index = 1; index <= 7; index++) {

            JSONObject row = array.getJSONObject(index);
            String minTemperature = row.getString("low");
            String maxTemperature = row.getString("high");
            String day = row.getString("day");
            String imageCode = row.getString("code");

            futureWeathers.add(new FutureWeather( day,minTemperature, maxTemperature, imageCode));
        }

        return futureWeathers;
    }

    public static LocalizationData getFromJsonLocalizationData(JSONObject jsonObj) throws JSONException, ParseException {

        JSONObject json = selectSpecialData(jsonObj);
        String country = json.getJSONObject("location").getString("country");
        String city = json.getJSONObject("location").getString("city");
        String longitude = json.getJSONObject("item").getString("long");
        String latitude = json.getJSONObject("item").getString("lat");
        Date lastUpdateDate = new Date();

        return new LocalizationData(country,city,latitude,longitude,lastUpdateDate);
    }

    public static Units getFromJsonUnits(JSONObject jsonObj) throws JSONException, ParseException {

        JSONObject json = selectSpecialData(jsonObj);
        String pressure = json.getJSONObject("units").getString("pressure");
        String speed = json.getJSONObject("units").getString("speed");
        String temperature = "°" + json.getJSONObject("units").getString("temperature");
        String distance = json.getJSONObject("units").getString("distance");

        return new Units(speed,temperature,pressure,distance);
    }

    public static JSONObject getJSON(String url) throws JSONException {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            BufferedReader buffer = new BufferedReader(new InputStreamReader(inputStream));
            StringBuffer content = new StringBuffer();
            String line = "";

            while ((line = buffer.readLine()) != null) {
                content.append(line);
            }

            inputStream.close();
            connection.disconnect();
            return new JSONObject(content.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static JSONObject selectSpecialData(JSONObject weatherJSON) throws JSONException, ParseException {
        return weatherJSON.getJSONObject("query").getJSONObject("results").getJSONObject("channel");
    }
}
