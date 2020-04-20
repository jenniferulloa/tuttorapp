package com.example.tutorapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MathCourses extends AppCompatActivity {


    TextView Algebra, Calculus, Geometry, Form;
    Button Back_Button;


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_courses);
        Algebra = findViewById(R.id.Algebra);
        Calculus = findViewById(R.id.Calculus);
        Geometry = findViewById(R.id.Geometry);
        Form = findViewById(R.id.Form);
        Back_Button = findViewById(R.id.Back_Button);

        Back_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MathCourses.this, TutoringCategories.class);
                startActivity(intent);
            }
        });

        Form.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MathCourses.this, Form.class);
                startActivity(intent);
            }
        });


    }

    }
