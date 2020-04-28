package com.example.tutorapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ForeignLangCourses extends AppCompatActivity {


    TextView Arabic, French, English,Form;
    Button Back_Button;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foreign_lang_courses);
        Arabic = findViewById(R.id.Arabic);
        French = findViewById(R.id.French);
        English = findViewById(R.id.English);
        Form = findViewById(R.id.Form);
        Back_Button = findViewById(R.id.Back_Button);

        Back_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForeignLangCourses.this, TutoringCategories.class);
                startActivity(intent);
            }
        });

        Form.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForeignLangCourses.this, Form.class);
                startActivity(intent);
            }
        });
        Arabic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForeignLangCourses.this, Foreign_Language_Tutors.class);
                startActivity(intent);
            }
        });
        French.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForeignLangCourses.this, Foreign_Language_Tutors.class);
                startActivity(intent);
            }
        });
        English.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForeignLangCourses.this, Foreign_Language_Tutors.class);
                startActivity(intent);
            }
        });

    }

}
