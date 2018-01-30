package com.jack.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.lang.Math;

public class MainActivity extends AppCompatActivity {

    EditText results;
    Button btnPlus, btnMult, btnMinus, btnDiv, btnEquals;
    Button btnSq, btnSqR, btnPercent, btnCos, btnSin, btnTan, btnBack, btnPi, btnChange, btnRand;

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


        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnMult = (Button) findViewById(R.id.btnMult);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnEquals = (Button) findViewById(R.id.btnEquals);


        btnBack = (Button) findViewById(R.id.btnBack);
        btnChange = (Button) findViewById(R.id.btnChange);
        btnTan = (Button) findViewById(R.id.btnTan);
        btnSin = (Button) findViewById(R.id.btnSin);
        btnCos = (Button) findViewById(R.id.btnCos);
        btnPercent = (Button) findViewById(R.id.btnPercent);
        btnSqR = (Button) findViewById(R.id.btnSqR);
        btnRand = (Button) findViewById(R.id.btnRand);
        btnPi = (Button) findViewById(R.id.btnPi);
        btnSq = (Button) findViewById(R.id.btnSq);
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

    public void btnMathOperationOnClick(View v) {
        int mathOperation = ((Button) v).getId();
        double currentNumber;

        if (newInput) {
            newInput = false;
        }

        if(mathOperation == btnRand.getId()) {
            results.setText(Double.toString(Math.random()));
        } else if (mathOperation == btnBack.getId()) {

            if(results.getText().toString().toLowerCase().equals("infinity")){
                results.setText("0");
            } else if((results.getText().toString().length() > 1 && Double.parseDouble(results.getText().toString()) > 0) ||
                    (results.getText().toString().length() > 2 && Double.parseDouble(results.getText().toString()) < 0)) {

                if (results.getText().toString().toLowerCase().contains("e") ) {

                    String[] split = results.getText().toString().toLowerCase().split("e");
                    String remake;
                    if (Integer.parseInt(split[1]) > 0) {
                        remake = split[0] + "E" + Integer.toString(Integer.parseInt(split[1]) - 1);
                    }else{
                        remake = split[0] + "E" + Integer.toString(Integer.parseInt(split[1]) + 1);
                    }

                    double rdb = Double.parseDouble(remake);
                    results.setText(Double.toString(rdb));

                }else{
                    results.setText(results.getText().toString().substring(0, results.getText().toString().length() - 1));
                }

            }else {
                results.setText("0");
            }

        } else if (mathOperation == btnChange.getId()) {

            if(Double.parseDouble(results.getText().toString()) > 0){
                currentNumber = Double.parseDouble(results.getText().toString());
                results.setText(Double.toString(currentNumber * -1));
            }else {
                currentNumber = Double.parseDouble(results.getText().toString());
                results.setText(Double.toString(currentNumber * -1));
            }

        }else if (mathOperation == btnSq.getId()) {

            currentNumber = Double.parseDouble(results.getText().toString());
            results.setText(Double.toString(currentNumber * currentNumber));

        }else if (mathOperation == btnPi.getId()) {

            results.setText(Double.toString(Math.PI));

        }else if (mathOperation == btnSqR.getId()) {
            currentNumber = Double.parseDouble(results.getText().toString());
            results.setText(Double.toString(Math.sqrt(currentNumber)));

        }else if (mathOperation == btnPercent.getId()) {
            currentNumber = Double.parseDouble(results.getText().toString());
            results.setText(Double.toString(currentNumber / 100.0));
        }
        else if (mathOperation == btnCos.getId()) {
            currentNumber = Double.parseDouble(results.getText().toString());
            results.setText(Double.toString(Math.cos(Math.toRadians(currentNumber))));

        }else if (mathOperation == btnSin.getId()) {
            currentNumber = Double.parseDouble(results.getText().toString());
            results.setText(Double.toString(Math.sin(Math.toRadians(currentNumber))));
        }else if (mathOperation == btnTan.getId()) {
            currentNumber = Double.parseDouble(results.getText().toString());
            results.setText(Double.toString(Math.tan(Math.toRadians(currentNumber))));
        }

        equalClicked = true;
//        previousResult = 0;
//        pendingOperation = 0;
        operand = Double.parseDouble(results.getText().toString());
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
