package com.example.tutorapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LanguageArtsCourses extends AppCompatActivity {

    TextView High, Secondary, Elementary,Form;
    Button Back_Button;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_arts_courses);
        Elementary = findViewById(R.id.Elementary);
        Secondary = findViewById(R.id.Secondary);
        High = findViewById(R.id.High);
        Form = findViewById(R.id.Form);
        Back_Button = findViewById(R.id.Back_Button);

        Back_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LanguageArtsCourses.this, TutoringCategories.class);
                startActivity(intent);
            }
        });

        Form.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LanguageArtsCourses.this, Form.class);
                startActivity(intent);
            }
        });
        Elementary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LanguageArtsCourses.this, Language_Arts_Tutors.class);
                startActivity(intent);

            }
        });
        Secondary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LanguageArtsCourses.this, Language_Arts_Tutors.class);
                startActivity(intent);

            }
        });
        High.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LanguageArtsCourses.this, Language_Arts_Tutors.class);
                startActivity(intent);

            }
        });
    }

}
