package com.example.tutorapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Tutoring Categories Button
        Button btnTutoringCategories = findViewById(R.id.btnTutoringCategories);
        btnTutoringCategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTutoringCategories();
            }
        });

        // Payments Button
        Button btnPayments = findViewById(R.id.btnPayments);
        btnPayments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPayments();
            }
        });

        // Communication Button
        Button btnCommunication = findViewById(R.id.btnCommunication);
        btnCommunication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCommunication();
            }
        });
        // Advertisement Button
        Button btnAdvertisement = findViewById(R.id.btnAdvertisement);
        btnAdvertisement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAdvertisement();
            }
        });
        //Review a Tutor Button
        Button btnReviewATutor = findViewById(R.id.btnReviewATutor);
        btnReviewATutor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openReviewATutor();
            }
        });

        Button btnLogin = findViewById(R.id.RegisterLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegister(v);
            }
        });


        //Search And Find a Tutor Button
        Button btnSearchAndFindATutor = findViewById(R.id.btnSearchAndFindATutor);
        btnSearchAndFindATutor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSearchAndFindATutor();
            }
        });



        // Become A Tutor Button
        Button btnBecomeATutor = findViewById(R.id.btnBecomeATutor);
        btnBecomeATutor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBecomeATutor();
            }
        });


    }
    public void openRegister(View v) {
        /*
        Log.i("MyApp","This is a magic log message!");
        Toast.makeText(getApplicationContext(), "Register/Login!", Toast.LENGTH_SHORT)
                .show();
         */
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    public void openSearchAndFindATutor(){
        Intent intent = new Intent(this, SubjectSearch.class);
        startActivity(intent);
    }


    public void openBecomeATutor(){
        Intent intent = new Intent(this, BecomeATutor.class);
        startActivity(intent);
    }


    public void openReviewATutor(){
        Intent intent = new Intent(this, ReviewATutor.class);
        startActivity(intent);
    }

    public void openAdvertisement(){
        Intent intent = new Intent(this, Advertisement.class);
        startActivity(intent);
    }

    public void openTutoringCategories(){
        Intent intent = new Intent(this, TutoringCategories.class);
        startActivity(intent);
    }
    public void openPayments(){
        Intent intent = new Intent(this, PaymentsMain.class);
        startActivity(intent);
    }
    public void openCommunication(){
        Intent intent = new Intent(this, Communication.class);
        startActivity(intent);
    }
}

