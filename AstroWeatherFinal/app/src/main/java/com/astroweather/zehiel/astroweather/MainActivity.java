package com.astroweather.zehiel.astroweather;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.astroweather.zehiel.astroweather.util.DefaultValues;

public class MainActivity extends AppCompatActivity {

    private ViewPager pager;

    private double longitude = DefaultValues.longitude;
    private double latitude = DefaultValues.latitude;
    private int refreshTime = DefaultValues.refreshTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = (ViewPager) findViewById(R.id.pager);
        PagerAdapter pagerAdapter = new FragmentActivity(getSupportFragmentManager(), getResources().getConfiguration());
        pager.setAdapter(pagerAdapter);

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



        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putDouble(String.valueOf(R.string.latitude_value_name), latitude);
        outState.putDouble(String.valueOf(R.string.longitude_value_name), longitude);
        outState.putInt(String.valueOf(R.string.refreshTime_value_name), refreshTime);

        outState.remove("android:support:fragments");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        longitude = savedInstanceState.getDouble(String.valueOf(R.string.longitude_value_name));
        latitude = savedInstanceState.getDouble(String.valueOf(R.string.latitude_value_name));
        refreshTime = savedInstanceState.getInt(String.valueOf(R.string.refreshTime_value_name));

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }






}
