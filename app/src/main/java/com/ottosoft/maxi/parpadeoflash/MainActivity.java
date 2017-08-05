package com.ottosoft.maxi.parpadeoflash;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    LinearLayout ln;
    SensorManager sm;
    TextView tv;
    Sensor sensorDeOrientacion;
    Sensor sensor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ln = (LinearLayout) findViewById(R.id.linear);
        tv = (TextView) findViewById(R.id.texto);
        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        sensorDeOrientacion = sm.getDefaultSensor(Sensor.TYPE_ORIENTATION);


        if(sm == null){
             tv.setText("No hay Sensor de Proximidad");
        }
        else{
            sm.registerListener(this, sensor, SensorManager.SENSOR_DELAY_FASTEST);
        }
/*
        if(sensorDeOrientacion == null){
            tv.setText("No hay Sensor de Orientacion");
        }
        else{
            sm.registerListener(this, sensorDeOrientacion, SensorManager.SENSOR_DELAY_NORMAL);
        }
*/

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

    @Override
    public void onSensorChanged(SensorEvent event) {

        String texto = String.valueOf(event.values[0]);

        tv.setText("aaaa:" + texto);

        float valor=Float.parseFloat(String.valueOf(event.values[0]));
        if (valor == 0)
            ln.setBackgroundColor(Color.BLACK);
        else
            ln.setBackgroundColor(Color.RED);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
