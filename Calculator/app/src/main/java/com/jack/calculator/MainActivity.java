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
    Button btnPlus, btnMult, btnMinus, btnDiv, btnEquals;

    int pendingOperation;
    double previousResult, currentValue, operand;

    boolean equalClicked = false;
    boolean newInput = false;
    boolean usedDecimalPoint = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        results = (EditText) findViewById(R.id.resultText);
        results.setFocusable(false);
        //results.setText(Double.toString(5.0-17.24));
        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnMult = (Button) findViewById(R.id.btnMult);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnEquals = (Button) findViewById(R.id.btnEquals);
    }

    public void btnEqualsOnClick(View v) {
        equalClicked = true;
        if (pendingOperation != 0) {
            switch (pendingOperation) {
                case R.id.btnPlus:

                    currentValue = previousResult + operand;
                    previousResult = currentValue;
                    results.setText(Double.toString(currentValue));
                    break;

                case R.id.btnMinus:
                    //operand = Double.parseDouble(results.getText().toString());
                    currentValue = previousResult - operand;
                    previousResult = currentValue;
                    results.setText(Double.toString(currentValue));
                    break;

                case R.id.btnMult:
                    //operand = Double.parseDouble(results.getText().toString());
                    currentValue = previousResult * operand;
                    previousResult = currentValue;
                    results.setText(Double.toString(currentValue));
                    break;

                case R.id.btnDiv:
                    //operand = Double.parseDouble(results.getText().toString());
                    currentValue = previousResult / operand;
                    previousResult = currentValue;
                    results.setText(Double.toString(currentValue));
                    break;

                default:
                    break;
            }


        }
    }


    public void btnOperationOnClick(View v) {
        int operation = ((Button) v).getId();


        //Log.i("CALC", "ButtonID: " + operation );

        if (operation == btnPlus.getId()) {

            if (pendingOperation != 0 && !newInput && !equalClicked) {
                btnEquals.performClick();
            }

            previousResult = Double.parseDouble(results.getText().toString());
            //Log.i("CALC", "PressedID was same: " + btnPlusID);
            //Toast.makeText(this, "ButtonID: " + operation, Toast.LENGTH_SHORT).show();
            pendingOperation = btnPlus.getId();
            newInput = true;

            equalClicked = false;
            operand = 0;
            //results.setText("");

        } else if (operation == btnMinus.getId()) {

            if (pendingOperation != 0 && !newInput && !equalClicked) {
                btnEquals.performClick();
            }

            previousResult = Double.parseDouble(results.getText().toString());
            pendingOperation = btnMinus.getId();
            newInput = true;
            equalClicked = false;
            operand = 0;


        } else if (operation == btnMult.getId()) {

            if (pendingOperation != 0 && !newInput && !equalClicked) {
                btnEquals.performClick();
            }

            previousResult = Double.parseDouble(results.getText().toString());
            pendingOperation = btnMult.getId();
            newInput = true;
            equalClicked = false;
            operand = 0;

        } else if (operation == btnDiv.getId()) {

            if (pendingOperation != 0 && !newInput && !equalClicked) {
                btnEquals.performClick();
            }

            previousResult = Double.parseDouble(results.getText().toString());
            pendingOperation = btnDiv.getId();
            newInput = true;
            equalClicked = false;
            operand = 0;

        }

    }

    public void btnNumberOnClick(View v) {

        if (equalClicked) {
            btnClearOnClick(v);
        }


        String newButton = ((Button) v).getText().toString();
        String currentResult = results.getText().toString();
        if (newButton.equals(".")) {

            if (newInput) {
                results.setText("0.");
                newInput = false;
            } else {

                if (!currentResult.contains(".")) {
                    results.setText(currentResult + ".");
                    usedDecimalPoint = true;
                }

            }

        } else {

            if (newInput) {

                results.setText(newButton);
                newInput = false;

            } else {

                if (currentResult.equals("0")) {
                    results.setText(newButton);
                } else {
                    results.setText(currentResult + newButton);
                }

            }

        }


        operand = Double.parseDouble(results.getText().toString());


    }

    public void btnClearOnClick(View v) {
        equalClicked = false;
        pendingOperation = 0;
        previousResult = 0;
        results.setText("0");
        usedDecimalPoint = false;
    }


}
