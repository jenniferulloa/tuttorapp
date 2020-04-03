package com.example.tutorapp;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import android.content.Intent;


public class TutoringCategories extends AppCompatActivity {
    Button MathButton, ScienceButton, TestPrepButton, LanguageArtsButton, ForeignLanguageButtons;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutoringcat);

        MathButton = findViewById(R.id.MathButton);
        ScienceButton = findViewById(R.id.ScienceButton);
        ForeignLanguageButtons = findViewById(R.id.ForeignLanguageButton);
        LanguageArtsButton = findViewById(R.id.LanguageArtsButton);
        TestPrepButton = findViewById(R.id.TestPrepButton);

        fAuth = FirebaseAuth.getInstance();

        MathButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //display math courses
                //click math course waned
                openMathCourses();

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

    public void openMathCourses() {
        Intent intent = new Intent(TutoringCategories.this, MathCourses.class);
        startActivity(intent);
    }

}