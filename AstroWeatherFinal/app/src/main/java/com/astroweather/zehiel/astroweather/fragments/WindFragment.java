package com.astroweather.zehiel.astroweather.fragments;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.astroweather.zehiel.astroweather.R;
import com.astroweather.zehiel.astroweather.util.DefaultValues;

/**
 * Created by grusz on 22.06.2017.
 */

public class WindFragment extends Fragment {

    private TextView windForce;
    private TextView windDirection;
    private TextView humidity;
    private TextView visibility;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_wind, container, false);
    }

    private void initFields() {
        windForce = (TextView) getActivity().findViewById(R.id.textWindForce);
        windDirection = (TextView) getActivity().findViewById(R.id.textWindDirection);
        humidity = (TextView) getActivity().findViewById(R.id.textHumidity);
        visibility = (TextView) getActivity().findViewById(R.id.textVisibility);
    }

    private void fillFields() {
        windForce.setText(DefaultValues.weather.getWind().getWindForce() + DefaultValues.weather.getUnits().getSpeed());
        windDirection.setText(DefaultValues.weather.getWind().getWindDirection());
        humidity.setText(DefaultValues.weather.getWind().getHumidity() + "%");
        visibility.setText(DefaultValues.weather.getWind().getVisibility() + DefaultValues.weather.getUnits().getDistance());
    }

    @Override
    public void onResume() {
        super.onResume();
        initFields();
        fillFields();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

}
