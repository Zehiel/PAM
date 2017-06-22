package com.astroweather.zehiel.astroweather.util;

import com.astroweather.zehiel.astroweather.model.localization.Localization;
import com.astroweather.zehiel.astroweather.model.localization.Localizations;
import com.astroweather.zehiel.astroweather.model.weather.Weather;

public class DefaultValues {

    public static int refreshTime = 5;
    public static double longitude = 19.3952;
    public static double latitude = 51.7931;

    public static char system = 'c';
    public static Localization actualLocalization = new Localization("pl", "lodz");

    public static final String[] WEATHER_URL = {"https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20u%3D%22",
            "%22%20and%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22",
            "%2C%20",
            "%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys"};

    public static final String[] CHECK_LOCALIZATION_URL = null;

    public static Weather weather = null;
    public static Localizations localizations = new Localizations();
}
