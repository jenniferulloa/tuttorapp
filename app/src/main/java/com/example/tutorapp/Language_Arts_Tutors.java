package com.example.tutorapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Language_Arts_Tutors extends AppCompatActivity {

    TextView High, Secondary, Elementary;
    Button Back_Button;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language__arts__tutors);
        Elementary = findViewById(R.id.Elementary);
        Secondary = findViewById(R.id.Secondary);
        High = findViewById(R.id.High);
        Back_Button = findViewById(R.id.Back_Button);

        Back_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Language_Arts_Tutors.this, SubjectSearch.class);
                startActivity(intent);
            }
        });


        Elementary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Language_Arts_Tutors.this, SubjectSearch.class);
                startActivity(intent);

            }
        });
        Secondary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Language_Arts_Tutors.this, SubjectSearch.class);
                startActivity(intent);

            }
        });
        High.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Language_Arts_Tutors.this, SubjectSearch.class);
                startActivity(intent);

            }
        });
    }

}