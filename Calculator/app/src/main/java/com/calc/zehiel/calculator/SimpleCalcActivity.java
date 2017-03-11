package com.calc.zehiel.calculator;

import android.content.Context;
import java.text.NumberFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Locale;
import java.util.Objects;

public class SimpleCalcActivity extends AppCompatActivity {

    private double valueMemory = 0.0;
    private char operationSign = 'x';
    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_calc);
        display = (EditText) findViewById(R.id.display);
        display.setText("0");
    }

    public void appendNumber(View view){

        if(view.getId()==R.id.zero_button){
            display.append("0");
        }else if(view.getId()==R.id.one_button){
            display.append("1");
        }else if(view.getId()==R.id.two_button){
            display.append("2");
        }else if(view.getId()==R.id.three_button){
            display.append("3");
        }else if(view.getId()==R.id.four_button){
            display.append("4");
        }else if(view.getId()==R.id.five_button){
            display.append("5");
        }else if(view.getId()==R.id.six_button){
            display.append("6");
        }else if(view.getId()==R.id.seven_button){
            display.append("7");
        }else if(view.getId()==R.id.eight_button){
            display.append("8");
        }else if(view.getId()==R.id.nine_button){
            display.append("9");
        }
    }

    public void deleteAll(View view){

        display.setText("0");
        valueMemory = 0.0;
        operationSign = 'x';
    }

    public void deleteLast(View view){
        //TODO null security
        String currentText = display.getText().toString();
        String textToPrint = currentText.substring(0,currentText.length()-1);
        if(textToPrint.length()==0){
            display.setText("0");
        }else {
            display.setText(textToPrint);
        }



    }

    public void addDot(View view){

        if(display.getText().toString().contains(".")){
            Context context = getApplicationContext();
            CharSequence msg = "Number cant contain more than one decimal point!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context,msg,duration);
            toast.show();
        }else if(display.getText().toString().length()==0){
            Context context = getApplicationContext();
            CharSequence msg = "Enter number first!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context,msg,duration);
            toast.show();
        }else {
            display.append(".");
        }

    }

    public void changeSign(View view){

        if(Double.parseDouble(display.getText().toString())!= 0.0){
            if(display.getText().charAt(0)!='-'){
                CharSequence currentText = display.getText();
                CharSequence textToPrint = "-"+currentText;
                display.setText(textToPrint);
            }else {
                CharSequence currentText = display.getText();
                CharSequence textToPrint = currentText.subSequence(1,currentText.length());
                display.setText(textToPrint);
            }
        }else {
            Context context = getApplicationContext();
            CharSequence msg = "Zero can't change sign or no number typed in yet!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context,msg,duration);
            toast.show();
        }

    }

    public void substract(View view){


            try{
                valueMemory = Double.parseDouble(display.getText().toString());
                operationSign = '-';
                display.setText("");
            }catch(NumberFormatException e){
                Context context = getApplicationContext();
                CharSequence msg = "Wprowadzono nieprawidlowa liczbe lub nie wprowadzono wartosci";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context,msg,duration);
                toast.show();
            }

    }

    public void add(View view){

            try{
                valueMemory = Double.parseDouble(display.getText().toString());
                operationSign = '+';
                display.setText("");
            }catch(NumberFormatException e){
                Context context = getApplicationContext();
                CharSequence msg = "Incorrect number entered or no value at all";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context,msg,duration);
                toast.show();
            }

    }

    public void multiply(View view){


            try{
                valueMemory = Double.parseDouble(display.getText().toString());
                operationSign = '*';
                display.setText("");
            }catch(NumberFormatException e){
                Context context = getApplicationContext();
                CharSequence msg = "Incorrect number entered or no value at all";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context,msg,duration);
                toast.show();
            }


    }

    public void divide(View view){


            try{
                valueMemory = Double.parseDouble(display.getText().toString());
                operationSign = '/';
                display.setText("");
            }catch(NumberFormatException e){
                Context context = getApplicationContext();
                CharSequence msg = "Wprowadzono nieprawidlowa liczbe lub nie wprowadzono wartosci";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context,msg,duration);
                toast.show();
            }

    }

    public void calculate(View view){
        NumberFormat format = NumberFormat.getNumberInstance(Locale.getDefault());
        format.setMinimumFractionDigits(0);
        format.setGroupingUsed(false);
        if(operationSign=='+' && display.getText().toString().length()!=0){
            Double result = Double.parseDouble(display.getText().toString()) + valueMemory;
            display.setText(format.format(result));
        }else if(operationSign=='-' && display.getText().toString().length()!=0){
            Double result = Double.parseDouble(display.getText().toString()) - valueMemory;
            display.setText(format.format(result));
        }else if(operationSign=='*' && display.getText().toString().length()!=0){
            Double result = Double.parseDouble(display.getText().toString()) * valueMemory;
            display.setText(format.format(result));
        }else if(operationSign=='/' && display.getText().toString().length()!=0){
            Double result = Double.parseDouble(display.getText().toString()) / valueMemory;
            display.setText(format.format(result));
        }else if(operationSign=='x' || display.getText().toString().length()==0){
            Context context = getApplicationContext();
            CharSequence msg = "No operation choose or no value entered";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context,msg,duration);
            toast.show();
        }
    }
}
