package com.jack.calculator;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ConversionActivity extends BaseActivity {

    String resultStr = "";
    EditText editFrom;
    EditText editTo;
    ListView clistView;
    TextView cTo;
    TextView cFrom;

    String[] items = new String[41];

    Double[] conversionRates = {
            2.54,
            0.393701,
            1.60934,
            0.6213727366,
            15.7725,
            0.0634013,
            0.0205372,
            4.92892,
            0.333333,
            3.0,

            14.7868,
            0.0616115,
            0.0634013,
            240.0,
            0.24,
            0.50721,
            12.0,
            0.0833333,
            0.0328084,
            0.01,

            0.0109361,
            3.0,
            0.000568182,
            91.44,
            0.0009144,
            0.9144,
            3.28084,
            1.09361,
            100.0,
            0.000621371,

            0.001,
            39.3701,
            2.0,
            0.453592,
            453.592,
            0.0005,
            16.0,
            2.20462,
            0.00110231,
            35.274,

            3.14159265359

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion);
        setTitle(R.string.conversion);

        cFrom = findViewById(R.id.cFromText);
        cTo = findViewById(R.id.cToText);
        editFrom = findViewById( R.id.editFrom );
        editTo = findViewById( R.id.editTo );
        editTo.setFocusable(false);

        Intent intent = getIntent();
        resultStr = intent.getStringExtra("RESULT");
        editFrom.setText(resultStr);


        String[] itemStrings = getResources().getStringArray(R.array.items);
        for(int i = 0; i < 41; i++){
            items[i] = (i+1) + ". "  + itemStrings[i];
        }


        clistView = findViewById(R.id.cListView);

        ArrayAdapter adapter = new ArrayAdapter<String>( this, R.layout.activity_listview_cell, items );
        clistView = (ListView)findViewById( R.id.cListView );
        clistView.setAdapter( adapter );

        clistView.setOnItemClickListener( new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?>parent, View view, int position, long id){
                if(!editFrom.getText().toString().equals("")) {

                    String[] parts =  items[position].split(" ");
                    cFrom.setText(parts[1]);
                    cTo.setText(parts[3]);

                    performCalculation(position);

                    //Hide keyboard
                    try {
                        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }
            }
        } );


    }


    private void performCalculation( int position ) {
        //Double fromNumber, toNumber;
        ToastIt(getString(R.string.clickedAt) + " " + items[position]);
        editTo.setText(Double.toString(conversionRates[position] * Double.parseDouble(editFrom.getText().toString())));
    }

}
