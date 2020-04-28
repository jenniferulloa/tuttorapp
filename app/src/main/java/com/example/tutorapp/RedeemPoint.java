package com.example.tutorapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RedeemPoint extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redeem_point);

        Button btn_buyDay = findViewById(R.id.btn_buyDay);
        btn_buyDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BuyDay();
            }
        });

        Button btn_buyWeek = findViewById(R.id.btn_buyWeek);
        btn_buyWeek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BuyWeek();
            }
        });
    }


    public void BuyDay(){

        Log.i("MyApp","This is a magic log message!");
        Toast.makeText(getApplicationContext(), "You have successfully redeemed a day of advertisement!", Toast.LENGTH_SHORT)
                .show();

    }

    public void BuyWeek(){

        Log.i("MyApp","This is a magic log message!");
        Toast.makeText(getApplicationContext(), "You have successfully redeemed a week of advertisement!", Toast.LENGTH_SHORT)
                .show();

    }
}