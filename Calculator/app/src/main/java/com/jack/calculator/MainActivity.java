package com.jack.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText results;
    boolean usedDecimalPoint = false;
    Button btnPlus, btnMult, btnMinus, btnDiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        results = (EditText)findViewById( R.id.resultText);
        //results.setText(Double.toString(5.0-17.24));
        btnPlus = (Button)findViewById( R.id.btnPlus);
        btnMinus = (Button)findViewById( R.id.btnMinus);
        btnMult = (Button)findViewById( R.id.btnMult);
        btnDiv = (Button)findViewById( R.id.btnMinus);
    }

    public void btnOperationOnClick(View v){
        int operation = ((Button) v).getId();
        int btnPlusID = btnPlus.getId();
        Log.i("CALC", "ButtonID: " + operation );
        if(operation == btnPlusID) {
            Log.i("CALC", "PressedID was same: " + btnPlusID);

            Toast.makeText(this, "ButtonID: " + operation, Toast.LENGTH_SHORT).show();
        }

    }

    public void btnNumberOnClick(View v){
        String newButton = ((Button) v).getText().toString();
        String currentResult = results.getText().toString();
        if(newButton.equals(".")){
            if(!usedDecimalPoint){
                results.setText(currentResult + ".");
                usedDecimalPoint = true;
            }
        }else {
            results.setText(currentResult + newButton);
        }
    }

    public void btnClearOnClick(View v){
        results.setText("0");
        usedDecimalPoint = false;
    }


}
