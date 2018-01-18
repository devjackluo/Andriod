package com.slothspice.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    Button btn2;
    EditText editResult;
    EditText multiplier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById( R.id.btn1);
        btn2 = findViewById( R.id.btn2);
        editResult = findViewById( R.id.result);
        multiplier = findViewById( R.id.result2);

    }

    public void btnOnClick(View v){

//        if (btn1.getText() == "Jack"){
//            btn1.setText("Hello");
//        }else{
//            btn1.setText("Jack");
//        }

        //((Button)v).setText("Jack");
        Double multiplier = Double.parseDouble(this.multiplier.getText().toString());
        Double currentNumber = Double.parseDouble(editResult.getText().toString());
        editResult.setText(Double.toString(currentNumber+1));

    }

    public void btnMul(View v){

        Double multiplier = Double.parseDouble(this.multiplier.getText().toString());
        Double currentNumber = Double.parseDouble(editResult.getText().toString());
        editResult.setText(Double.toString(currentNumber*multiplier));

    }




}
