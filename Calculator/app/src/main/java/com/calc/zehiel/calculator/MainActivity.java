package com.calc.zehiel.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gotoSimpleCalcActivity(View view){
        Intent intent = new Intent(this,SimpleCalcActivity.class);
        this.startActivity(intent);
    }

    public void gotoAdvancedCalcActivity(View view){
        Intent intent = new Intent(this,AdvancedCalcActivity.class);
        this.startActivity(intent);
    }

    public void gotoAboutActivity(View view){
        Intent intent = new Intent(this,AboutActivity.class);
        this.startActivity(intent);
    }

    public void quitApp(View view){
        this.finishAffinity();
    }
}
