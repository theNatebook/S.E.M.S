package com.example.sems;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HumidityReadings extends AppCompatActivity implements SetValue.setValueListener{

    private Button room1h, room2h, room3h;
    private TextView curr1h, curr2h, curr3h;

    private String TAG = "HumidityReadings";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_humidity_readings);

        Button room1h = (Button) findViewById(R.id.room1H);
        Button room2h = (Button) findViewById(R.id.room2H);
        Button room3h = (Button) findViewById(R.id.room3H);

        TextView curr1h = (TextView) findViewById(R.id.room1humid);
        TextView curr2h = (TextView) findViewById(R.id.room2humid);
        TextView curr3h = (TextView) findViewById(R.id.room3humid);

        room1h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
        room2h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });

        room3h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
    }
    public void openDialog(){
        SetValue setValue = new SetValue();
        setValue.show(getSupportFragmentManager(),"Set New Value");
    }

    @Override
    public void applyText(String value) {
        Toast myToast = Toast.makeText(getApplicationContext(), "new value is set to " + value + "%", Toast.LENGTH_SHORT);
        myToast.show();
    }

}
