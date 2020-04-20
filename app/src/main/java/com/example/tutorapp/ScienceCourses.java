package com.example.tutorapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ScienceCourses extends AppCompatActivity {


    TextView Biology, Physics, Chemistry, Form;
    Button Back_Button;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science_courses);
        Biology = findViewById(R.id.Biology);
        Chemistry = findViewById(R.id.Chemistry);
        Physics = findViewById(R.id.Physics);
        Form = findViewById(R.id.Form);
        Back_Button = findViewById(R.id.Back_Button);

        Back_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScienceCourses.this, TutoringCategories.class);
                startActivity(intent);
            }
        });

        Form.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScienceCourses.this, Form.class);
                startActivity(intent);
            }
        });


    }

}