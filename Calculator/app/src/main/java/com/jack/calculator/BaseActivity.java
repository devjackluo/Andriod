package com.jack.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

/**
 * Created by Jack on 2/27/2018.
 */

public class BaseActivity extends AppCompatActivity{

    //Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView( R.layout.activity_base );


        // Insert toolbar
        //toolbar = findViewById( R.id.toolbar );
        //toolbar.setTitle("Calculator");

    }

    public void ToastIt( String message ){
        Toast.makeText( getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item ){
        Intent intent;

        switch ( item.getItemId() ) {
            case R.id.menuConversion :
                intent = new Intent( getApplicationContext(), ConversionActivity.class );

                if(this.getClass() == MainActivity.class) {
                    //Log.d("class", this.getClass().toString());
                    EditText result = findViewById(R.id.resultText);
                    if(!(result.getText().toString().equals("0") || result.getText().toString().equals("NaN") || result.getText().toString().equals("Infinity"))) {
                        intent.putExtra("RESULT", result.getText().toString());
                    }
                }

                startActivity( intent );
                break;

            case R.id.menuCalculator :
                intent = new Intent( getApplicationContext(), MainActivity.class );

                if(this.getClass() == ConversionActivity.class) {
                    EditText result = findViewById(R.id.editTo);
                    if(!(result.getText().toString().equals(""))) {
                        intent.putExtra("RESULT", result.getText().toString());
                    }
                }

                startActivity( intent );
                break;

            case R.id.menuHistory :
                intent = new Intent( getApplicationContext(), HistoryActivity.class );
                startActivity( intent );
                break;

            case R.id.menuAbout :
                intent = new Intent( getApplicationContext(), AboutActivity.class );
                startActivity( intent );
                break;

            default :
                return true;

        }
        return true;
    }

}
