package com.astroweather.zehiel.astroweather.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.astroweather.zehiel.astroweather.R;
import com.astroweather.zehiel.astroweather.util.DefaultValues;
import com.astroweather.zehiel.astroweather.util.ImageResources;

/**
 * Created by grusz on 22.06.2017.
 */

public class FutureWeatherFragment extends Fragment {
    private TextView weatherFutureDay1;
    private ImageButton weatherFutureImg1;
    private TextView weatherFutureTemp1;

    private TextView weatherFutureDay2;
    private ImageButton weatherFutureImg2;
    private TextView weatherFutureTemp2;

    private TextView weatherFutureDay3;
    private ImageButton weatherFutureImg3;
    private TextView weatherFutureTemp3;

    private TextView weatherFutureDay4;
    private ImageButton weatherFutureImg4;
    private TextView weatherFutureTemp4;

    private TextView weatherFutureDay5;
    private ImageButton weatherFutureImg5;
    private TextView weatherFutureTemp5;

    private TextView weatherFutureDay6;
    private ImageButton weatherFutureImg6;
    private TextView weatherFutureTemp6;

    private TextView weatherFutureDay7;
    private ImageButton weatherFutureImg7;
    private TextView weatherFutureTemp7;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_weather_future, container, false);
    }

    private void initFields() {
        weatherFutureDay1 = (TextView) getActivity().findViewById(R.id.textWeatherFutureDay1);
        weatherFutureImg1 = (ImageButton) getActivity().findViewById(R.id.textWeatherFutureImg1);
        weatherFutureTemp1 = (TextView) getActivity().findViewById(R.id.textWeatherFutureTemp1);

        weatherFutureDay2 = (TextView) getActivity().findViewById(R.id.textWeatherFutureDay2);
        weatherFutureImg2 = (ImageButton) getActivity().findViewById(R.id.textWeatherFutureImg2);
        weatherFutureTemp2 = (TextView) getActivity().findViewById(R.id.textWeatherFutureTemp2);

        weatherFutureDay3 = (TextView) getActivity().findViewById(R.id.textWeatherFutureDay3);
        weatherFutureImg3 = (ImageButton) getActivity().findViewById(R.id.textWeatherFutureImg3);
        weatherFutureTemp3 = (TextView) getActivity().findViewById(R.id.textWeatherFutureTemp3);

        weatherFutureDay4 = (TextView) getActivity().findViewById(R.id.textWeatherFutureDay4);
        weatherFutureImg4 = (ImageButton) getActivity().findViewById(R.id.textWeatherFutureImg4);
        weatherFutureTemp4 = (TextView) getActivity().findViewById(R.id.textWeatherFutureTemp4);

        weatherFutureDay5 = (TextView) getActivity().findViewById(R.id.textWeatherFutureDay5);
        weatherFutureImg5 = (ImageButton) getActivity().findViewById(R.id.textWeatherFutureImg5);
        weatherFutureTemp5 = (TextView) getActivity().findViewById(R.id.textWeatherFutureTemp5);

        weatherFutureDay6 = (TextView) getActivity().findViewById(R.id.textWeatherFutureDay6);
        weatherFutureImg6 = (ImageButton) getActivity().findViewById(R.id.textWeatherFutureImg6);
        weatherFutureTemp6 = (TextView) getActivity().findViewById(R.id.textWeatherFutureTemp6);

        weatherFutureDay7 = (TextView) getActivity().findViewById(R.id.textWeatherFutureDay7);
        weatherFutureImg7 = (ImageButton) getActivity().findViewById(R.id.textWeatherFutureImg7);
        weatherFutureTemp7 = (TextView) getActivity().findViewById(R.id.textWeatherFutureTemp7);
    }

    private void fillFields() {

        weatherFutureDay1.setText(DefaultValues.weather.getFutureWeatherList().get(0).getDay());
        weatherFutureImg1.setImageResource(ImageResources.getImageResource(DefaultValues.weather.getFutureWeatherList().get(0).getImageCode()));
        weatherFutureTemp1.setText(DefaultValues.weather.getFutureWeatherList().get(0).getMinTemp() + " - " +
                DefaultValues.weather.getFutureWeatherList().get(0).getMaxTemp() + DefaultValues.weather.getUnits().getTemperature());

        weatherFutureDay2.setText(DefaultValues.weather.getFutureWeatherList().get(1).getDay());
        weatherFutureImg2.setImageResource(ImageResources.getImageResource(DefaultValues.weather.getFutureWeatherList().get(1).getImageCode()));
        weatherFutureTemp2.setText(DefaultValues.weather.getFutureWeatherList().get(1).getMinTemp() + " - " +
                DefaultValues.weather.getFutureWeatherList().get(1).getMaxTemp() + DefaultValues.weather.getUnits().getTemperature());

        weatherFutureDay3.setText(DefaultValues.weather.getFutureWeatherList().get(2).getDay());
        weatherFutureImg3.setImageResource(ImageResources.getImageResource(DefaultValues.weather.getFutureWeatherList().get(2).getImageCode()));
        weatherFutureTemp3.setText(DefaultValues.weather.getFutureWeatherList().get(2).getMinTemp() + " - " +
                DefaultValues.weather.getFutureWeatherList().get(2).getMaxTemp() + DefaultValues.weather.getUnits().getTemperature());

        weatherFutureDay4.setText(DefaultValues.weather.getFutureWeatherList().get(3).getDay());
        weatherFutureImg4.setImageResource(ImageResources.getImageResource(DefaultValues.weather.getFutureWeatherList().get(3).getImageCode()));
        weatherFutureTemp4.setText(DefaultValues.weather.getFutureWeatherList().get(3).getMinTemp() + " - " +
                DefaultValues.weather.getFutureWeatherList().get(3).getMaxTemp() + DefaultValues.weather.getUnits().getTemperature());

        weatherFutureDay5.setText(DefaultValues.weather.getFutureWeatherList().get(4).getDay());
        weatherFutureImg5.setImageResource(ImageResources.getImageResource(DefaultValues.weather.getFutureWeatherList().get(4).getImageCode()));
        weatherFutureTemp5.setText(DefaultValues.weather.getFutureWeatherList().get(4).getMinTemp() + " - " +
                DefaultValues.weather.getFutureWeatherList().get(4).getMaxTemp() + DefaultValues.weather.getUnits().getTemperature());

        weatherFutureDay6.setText(DefaultValues.weather.getFutureWeatherList().get(5).getDay());
        weatherFutureImg6.setImageResource(ImageResources.getImageResource(DefaultValues.weather.getFutureWeatherList().get(5).getImageCode()));
        weatherFutureTemp6.setText(DefaultValues.weather.getFutureWeatherList().get(5).getMinTemp() + " - " +
                DefaultValues.weather.getFutureWeatherList().get(5).getMaxTemp() + DefaultValues.weather.getUnits().getTemperature());

        weatherFutureDay7.setText(DefaultValues.weather.getFutureWeatherList().get(6).getDay());
        weatherFutureImg7.setImageResource(ImageResources.getImageResource(DefaultValues.weather.getFutureWeatherList().get(6).getImageCode()));
        weatherFutureTemp7.setText(DefaultValues.weather.getFutureWeatherList().get(6).getMinTemp() + " - " +
                DefaultValues.weather.getFutureWeatherList().get(6).getMaxTemp() + DefaultValues.weather.getUnits().getTemperature());

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
