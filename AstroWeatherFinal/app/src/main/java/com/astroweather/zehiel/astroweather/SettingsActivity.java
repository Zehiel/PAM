package com.astroweather.zehiel.astroweather;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;

import com.astroweather.zehiel.astroweather.util.DefaultValues;

import java.text.DecimalFormat;

public class SettingsActivity extends AppCompatActivity {

    private EditText longitudeView;
    private EditText latitudeView;
    private EditText refreshRateView;

    private Spinner systemList;
    private AutoCompleteTextView localizationList;
    private ArrayAdapter<String> localizationAdapter;


    private DecimalFormat precision = new DecimalFormat("0.000");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        longitudeView = (EditText) findViewById(R.id.textLongitude);
        latitudeView = (EditText) findViewById(R.id.textLatitude);
        refreshRateView = (EditText) findViewById(R.id.textRefresh);

        longitudeView.setText(precision.format(getIntent().getDoubleExtra(String.valueOf(R.string.longitude_value_name), DefaultValues.longitude)).replace(",", "."));
        latitudeView.setText(precision.format(getIntent().getDoubleExtra(String.valueOf(R.string.latitude_value_name), DefaultValues.latitude)).replace(",", "."));
        refreshRateView.setText(String.format("%d", getIntent().getIntExtra(String.valueOf(R.string.refreshTime_value_name), DefaultValues.refreshTime)));

        systemList = (Spinner) findViewById(R.id.spinnerDegrees);
        ArrayAdapter<CharSequence> degreesAdapter = ArrayAdapter.createFromResource(this, R.array.system, android.R.layout.simple_spinner_item);
        degreesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        systemList.setAdapter(degreesAdapter);
        systemList.setSelection(DefaultValues.system == 'c' ? 0 : 1);

        localizationList = (AutoCompleteTextView) findViewById(R.id.localizationTextView);
        localizationAdapter =  new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, (String[]) DefaultValues.localizations.getStringValues().toArray());
        localizationList.setAdapter(localizationAdapter);


    }

    public void saveSettings(View view) {
        Intent intentResult = new Intent();
        intentResult.putExtra(String.valueOf(R.string.longitude_value_name), Double.valueOf(longitudeView.getText().toString().replace(",", ".")));
        intentResult.putExtra(String.valueOf(R.string.latitude_value_name), Double.valueOf(latitudeView.getText().toString().replace(",", ".")));
        intentResult.putExtra(String.valueOf(R.string.refreshTime_value_name), Integer.valueOf(refreshRateView.getText().toString().replace(",", ".")));

        if (localizationList.getText().toString().matches("^.*(, ){1}.*$")) {
            intentResult.putExtra(String.valueOf(R.string.city_value_name), localizationList.getText().toString().split(", ")[0]);
            intentResult.putExtra(String.valueOf(R.string.country_value_name), localizationList.getText().toString().split(", ")[1]);
        } else if (localizationList.getText().toString().matches("^.*$")) {
            intentResult.putExtra(String.valueOf(R.string.city_value_name), localizationList.getText().toString());
            intentResult.putExtra(String.valueOf(R.string.country_value_name), "");
        } else {
            intentResult.putExtra(String.valueOf(R.string.city_value_name), DefaultValues.actualLocalization.getCity());
            intentResult.putExtra(String.valueOf(R.string.country_value_name), DefaultValues.actualLocalization.getCountry());
        }
        if ("Metryczny".equals(systemList.getSelectedItem().toString())) {
            intentResult.putExtra(String.valueOf(R.string.system_value_name), 'c');
        } else {
            intentResult.putExtra(String.valueOf(R.string.system_value_name), 'f');
        }

        setResult(1, intentResult);
        finish();
    }

}
