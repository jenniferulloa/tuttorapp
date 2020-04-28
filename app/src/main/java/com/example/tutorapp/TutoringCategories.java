package com.example.tutorapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;


public class TutoringCategories extends AppCompatActivity {
    Button mathButton, ScienceButton, TestPrepButton, LanguageArtsButton, ForeignLanguageButtons;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutoringcat);

        ScienceButton = findViewById(R.id.ScienceButton);
        mathButton = (Button) findViewById(R.id.mathButton);
        ForeignLanguageButtons = findViewById(R.id.ForeignLanguageButton);
        LanguageArtsButton = findViewById(R.id.LanguageArtsButton);
        TestPrepButton = findViewById(R.id.TestPrepButton);

        fAuth = FirebaseAuth.getInstance();

        mathButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TutoringCategories.this, Math_course.class);
                startActivity(intent);
            }
        });

        ScienceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //display math courses
                //click math course waned
                openScienceCourses();
            }
        });
        ForeignLanguageButtons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //display math courses
                //click math course waned
                openForeignLangCourses();

            }
        });
        LanguageArtsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //display math courses
                //click math course waned
                openLanguageCourses();

            }
        });
        TestPrepButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //display math courses
                //click math course waned
                openTestPrepCourses();

            }
        });
    }

    private void openTestPrepCourses() {
        Intent intent = new Intent(TutoringCategories.this, TestPrepCourses.class);
        startActivity(intent);
    }
    private void openForeignLangCourses() {
        Intent intent = new Intent(TutoringCategories.this, ForeignLangCourses.class);
        startActivity(intent);
    }
    private void openLanguageCourses() {
        Intent intent = new Intent(TutoringCategories.this, LanguageArtsCourses.class);
        startActivity(intent);
    }
    private void openScienceCourses() {
        Intent intent = new Intent(TutoringCategories.this, ScienceCourses.class);
        startActivity(intent);
    }
    private void openMathCourses() {
        Intent intent = new Intent(TutoringCategories.this, Math_course.class);
        startActivity(intent);
    }
}