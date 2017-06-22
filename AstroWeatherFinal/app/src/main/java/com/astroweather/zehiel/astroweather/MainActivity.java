package com.astroweather.zehiel.astroweather;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.astroweather.zehiel.astroweather.model.localization.Localization;
import com.astroweather.zehiel.astroweather.model.localization.Localizations;
import com.astroweather.zehiel.astroweather.model.weather.Weather;
import com.astroweather.zehiel.astroweather.util.DefaultValues;
import com.astroweather.zehiel.astroweather.util.WeatherDataTask;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    private ViewPager pager;

    private double longitude = DefaultValues.longitude;
    private double latitude = DefaultValues.latitude;
    private int refreshTime = DefaultValues.refreshTime;

    public char system = DefaultValues.system;
    public String country = DefaultValues.actualLocalization.getCountry().substring(0);
    public String city = DefaultValues.actualLocalization.getCity().substring(0);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = (ViewPager) findViewById(R.id.pager);
        PagerAdapter pagerAdapter = new FragmentActivity(getSupportFragmentManager(), getResources().getConfiguration());
        pager.setAdapter(pagerAdapter);

        DefaultValues.localizations = loadLocalizationsFromFile();
        initWeatherData();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, SettingsActivity.class);

            intent.putExtra(String.valueOf(R.string.longitude_value_name), longitude);
            intent.putExtra(String.valueOf(R.string.latitude_value_name), latitude);
            intent.putExtra(String.valueOf(R.string.refreshTime_value_name), refreshTime);

            intent.putExtra(String.valueOf(R.string.country_value_name), country);
            intent.putExtra(String.valueOf(R.string.city_value_name), city);
            intent.putExtra(String.valueOf(R.string.system_value_name), system);

            startActivityForResult(intent, 1);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            latitude = data.getDoubleExtra(String.valueOf(R.string.latitude_value_name), DefaultValues.latitude);
            longitude = data.getDoubleExtra(String.valueOf(R.string.longitude_value_name), DefaultValues.longitude);
            refreshTime = data.getIntExtra(String.valueOf(R.string.refreshTime_value_name), DefaultValues.refreshTime);


            DefaultValues.latitude = latitude;
            DefaultValues.longitude = longitude;
            DefaultValues.refreshTime = refreshTime;

            country = data.getStringExtra(String.valueOf(R.string.country_value_name));
            city = data.getStringExtra(String.valueOf(R.string.city_value_name));
            system = data.getCharExtra(String.valueOf(R.string.system_value_name), DefaultValues.system);

            DefaultValues.latitude = latitude;
            DefaultValues.longitude = longitude;
            DefaultValues.refreshTime = refreshTime;
            DefaultValues.actualLocalization = new Localization(country.substring(0), city.substring(0));
            DefaultValues.system = system;

            try {
                if (!DefaultValues.localizations.contains(DefaultValues.actualLocalization.toString())) {
                    DefaultValues.localizations.addLocalization(DefaultValues.actualLocalization);
                }
                initWeatherData();
            } catch (Exception e) {}
        }

    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putDouble(String.valueOf(R.string.latitude_value_name), latitude);
        outState.putDouble(String.valueOf(R.string.longitude_value_name), longitude);
        outState.putInt(String.valueOf(R.string.refreshTime_value_name), refreshTime);
        outState.putString(String.valueOf(R.string.country_value_name), country);
        outState.putString(String.valueOf(R.string.city_value_name), city);
        outState.putChar(String.valueOf(R.string.system_value_name), system);

        outState.remove("android:support:fragments");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        longitude = savedInstanceState.getDouble(String.valueOf(R.string.longitude_value_name));
        latitude = savedInstanceState.getDouble(String.valueOf(R.string.latitude_value_name));
        refreshTime = savedInstanceState.getInt(String.valueOf(R.string.refreshTime_value_name));
        country = savedInstanceState.getString(String.valueOf(R.string.country_value_name));
        city = savedInstanceState.getString(String.valueOf(R.string.city_value_name));
        system = savedInstanceState.getChar(String.valueOf(R.string.system_value_name));

    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
        saveLocalizationsToFile(DefaultValues.localizations);
        saveWeatherToFile(DefaultValues.weather);
    }

    private void initWeatherData() {
        if (isOnline(this)) {
            initWeatherDataOnline();
        }else{
            showWarningNoInternetConnection();
            initWeatherDataOffline();
        }
        initWeatherDataOffline();
    }

    private void initWeatherDataOnline() {
        WeatherDataTask weatherDataTask = new WeatherDataTask();
        weatherDataTask.execute(system + "", city, country);
        try {
            DefaultValues.weather = weatherDataTask.get();
            saveLocalizationsToFile(DefaultValues.localizations);
            saveWeatherToFile(DefaultValues.weather);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        Toast.makeText(this, R.string.toast_update_weather_data, Toast.LENGTH_SHORT).show();

        saveWeatherToFile(DefaultValues.weather);
        saveLocalizationsToFile(DefaultValues.localizations);
    }

    private void initWeatherDataOffline() {
        DefaultValues.localizations = loadLocalizationsFromFile();
        DefaultValues.weather = loadWeatherFromFile();
    }

    private void showWarningNoInternetConnection() {
        new AlertDialog.Builder(this)
                .setTitle("Brak połączenia z internetem!")
                .setMessage("Aplikacja działa w trybie offline!")
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), R.string.no_weather_data_info, Toast.LENGTH_LONG).show();
//                        Toast.makeText(getApplicationContext(), R.string.outdated_weather_data_info, Toast.LENGTH_LONG).show();
                    }
                })
                .show();
    }

    private void saveWeatherToFile(Weather weather) {
        FileOutputStream fileOutputStream = null;
        try {
            File file = new File(getCacheDir() + File.separator + R.string.weather_file_name);
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(weather);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Weather loadWeatherFromFile() {
        FileInputStream fileInputStream = null;
        Weather weather = null;
        try {
            File file = new File(getCacheDir() + File.separator + R.string.weather_file_name);
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                weather = (Weather) objectInputStream.readObject();
                objectInputStream.close();
            }
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return weather;
    }

    private void saveLocalizationsToFile(Localizations localizations) {
        FileOutputStream fileOutputStream = null;
        try {
            File file = new File(getCacheDir() + File.separator + R.string.localization_file_name);
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(localizations);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Localizations loadLocalizationsFromFile() {
        FileInputStream fileInputStream = null;
        Localizations localizations = new Localizations();
        try {
            File file = new File(getCacheDir() + File.separator + R.string.localization_file_name);
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                localizations = (Localizations) objectInputStream.readObject();
                objectInputStream.close();
            }
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        if (localizations.getLocalizations().size() <= 0) {
            localizations = new Localizations();
            localizations.addLocalization(new Localization("pl", "lodz"));
        }
        return localizations;
    }

    public static boolean isOnline(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }
}