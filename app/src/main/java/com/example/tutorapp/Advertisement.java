package com.example.tutorapp;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Advertisement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advertisement);

        // Most Rated Tutor Button
        Button btnMostRatedTutor = findViewById(R.id.btnMostRatedTutor);
        btnMostRatedTutor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMostRatedTutor();
            }
        });

        // Best Rated Tutor Button
        Button btnBestRatedTutor = findViewById(R.id.btnBestRatedTutor);
        btnBestRatedTutor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBestRatedTutor();
            }
        });

        // Paid Tutor Button
        Button btnPaidTutor = findViewById(R.id.btnPaidTutor);
        btnPaidTutor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPaidTutor();
            }
        });

        // Buy Points Button
        Button btnBuyPoints = findViewById(R.id.btnBuyPoints);
        btnBuyPoints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBuyPoints();
            }
        });

        // Get Points Button
        Button btnWinPoints = findViewById(R.id.btnWinPoints);
        btnWinPoints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWinPoints();
            }
        });

        // Redeem Points Button
        Button btnRedeemPoints = findViewById(R.id.btnRedeemPoints);
        btnRedeemPoints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRedeemPoints();
            }
        });
    }


    public void openMostRatedTutor(){
        String name = "";
        //DatabaseReference tutor_db = FirebaseDatabase.
        //showTutor(name, rating, classes);
        Intent intent = new Intent(this, MostRatedTutor.class);
        startActivity(intent);
    }

    public void openBestRatedTutor(){
        //showTutor(name, rating, classes);
        Intent intent = new Intent(this, BestRatedTutor.class);
        startActivity(intent);
    }

    public void openPaidTutor(){
        //showTutor(name, rating, classes);
        Intent intent = new Intent(this, PaymentsMain.class);
        startActivity(intent);
    }

    public void openBuyPoints(){
        Intent intent = new Intent(this, PaymentsMain.class);
        startActivity(intent);
    }

    public void openWinPoints(){
        Intent intent = new Intent(this, WinPoints.class);
        startActivity(intent);
    }

    public void openRedeemPoints(){
        Intent intent = new Intent(this, RedeemPoint.class);
        startActivity(intent);
    }

    /*
    public void showTutor(String name, double rating, String classes){

    }
    */
}