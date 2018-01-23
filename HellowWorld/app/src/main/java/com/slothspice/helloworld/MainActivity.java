package com.slothspice.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    Button mul;
    Button div;
    Button add;
    Button min;
    EditText editResult;
    EditText number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mul = findViewById( R.id.btnMul);
        div = findViewById( R.id.btnDiv);
        min = findViewById( R.id.btnMin);
        add = findViewById( R.id.btnAdd);
        editResult = findViewById( R.id.result);
        number = findViewById( R.id.result2);

    }

//    public void btnOnClick(View v){
//
////        if (btn1.getText() == "Jack"){
////            btn1.setText("Hello");
////        }else{
////            btn1.setText("Jack");
////        }
//
//        //((Button)v).setText("Jack");
//        Double multiplier = Double.parseDouble(this.number.getText().toString());
//        Double currentNumber = Double.parseDouble(editResult.getText().toString());
//        editResult.setText(Double.toString(currentNumber+1));
//
//    }

    public void btnMul(View v){

        Double multiplier = Double.parseDouble(this.number.getText().toString());
        Double currentNumber = Double.parseDouble(editResult.getText().toString());
        editResult.setText(Double.toString(currentNumber*multiplier));

    }


    public void btnDiv(View v){

        Double multiplier = Double.parseDouble(this.number.getText().toString());
        Double currentNumber = Double.parseDouble(editResult.getText().toString());
        editResult.setText(Double.toString(currentNumber/multiplier));

    }

    public void btnMin(View v){

        Double multiplier = Double.parseDouble(this.number.getText().toString());
        Double currentNumber = Double.parseDouble(editResult.getText().toString());
        editResult.setText(Double.toString(currentNumber-multiplier));

    }

    public void btnAdd(View v){

        Double multiplier = Double.parseDouble(this.number.getText().toString());
        Double currentNumber = Double.parseDouble(editResult.getText().toString());
        editResult.setText(Double.toString(currentNumber+multiplier));

    }



}
