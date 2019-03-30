package com.example.usuario_06.sensores;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    ConstraintLayout layouyFondo;
    MediaPlayer mpI;
    MediaPlayer mpD;
    MediaPlayer mpAt;
    MediaPlayer mpAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SensorManager sensor = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor.registerListener(this, sensor.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);

        mpI = MediaPlayer.create(this, R.raw.i);
        mpD = MediaPlayer.create(this, R.raw.d);
        mpAt = MediaPlayer.create(this, R.raw.at);
        mpAd = MediaPlayer.create(this, R.raw.ad);


    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Log.i("valor", "x:" + sensorEvent.values[0] + ", y:"
                + sensorEvent.values[1] + ", z:" + sensorEvent.values[2]);

        if(sensorEvent.values[0]>7){
            mpI.start();
        }else if(sensorEvent.values[0]<-7){
            mpD.start();
        }else if(sensorEvent.values[2]>7){
            mpAt.start();
        }else if(sensorEvent.values[2]<-7){
            mpAd.start();
        }



    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
