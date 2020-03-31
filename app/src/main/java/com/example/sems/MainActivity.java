package com.example.sems;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageButton humidityB, tempB, lightB, settingsB, supportB, advicesB, graphB, floorB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton tempB = (ImageButton) findViewById(R.id.TempButton);
        ImageButton humidityB = (ImageButton) findViewById(R.id.HumidityButton);
        ImageButton lightB = (ImageButton) findViewById(R.id.lightUseButton);
        ImageButton settingsB = (ImageButton) findViewById(R.id.SettingsButton);
        ImageButton supportB = (ImageButton) findViewById(R.id.serviceButton);
        ImageButton advicesB = (ImageButton) findViewById(R.id.adviceButton);
        ImageButton graphB = (ImageButton) findViewById(R.id.graphButton);
        ImageButton floorB = (ImageButton) findViewById(R.id.FloorPlanButton);

        tempB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTemp();
            }
        });

        humidityB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHumidity();
            }
        });

        settingsB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettings();
            }
        });

    }
    public void openTemp(){
        Intent i = new Intent(this, TempReadings.class);
        startActivity(i);
    }

    public void openHumidity(){
        Intent n = new Intent(this, HumidityReadings.class);
        startActivity(n);
    }

    public void openSettings(){
        Intent i = new Intent(this, Settings.class);
        startActivity(i);
    }


}
