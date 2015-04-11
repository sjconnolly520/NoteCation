package com.example.stevo.notecation;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {


    SeekBar distanceSlider;
    Button clicker;
    TextView distanceValue;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeVars();


        distanceValue.setText(distanceSlider.getProgress()+ " YDs");


        distanceSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            int progressChange = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d("debug", "Progress = " + progress);
                progressChange = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                distanceValue.setText(progressChange + " YDs");
            }
        });
    }

    //ChangeMessage on Button click
    public void ChangeMessage(View view){

        intent = new Intent(this, map_activity.class);
        startActivity(intent);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void initializeVars() {
        distanceSlider = (SeekBar) findViewById(R.id.seekBar);
        clicker = (Button) findViewById(R.id.main_button);
        distanceValue = (TextView) findViewById(R.id.textView3);
    }

}
