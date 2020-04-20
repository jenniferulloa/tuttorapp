package com.example.tutorapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TestPrepCourses extends AppCompatActivity {

    TextView ACT, SAT, MCAT, Form;
    Button Back_Button;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_prep_courses);
        ACT = findViewById(R.id.ACT);
        SAT = findViewById(R.id.SAT);
        MCAT = findViewById(R.id.MCAT);
        Form = findViewById(R.id.Form);
        Back_Button = findViewById(R.id.Back_Button);

        Back_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestPrepCourses.this, TutoringCategories.class);
                startActivity(intent);
            }
        });

        Form.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestPrepCourses.this, Form.class);
                startActivity(intent);
            }
        });
    }

}


