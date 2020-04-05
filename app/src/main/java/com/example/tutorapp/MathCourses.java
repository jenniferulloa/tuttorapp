package com.example.tutorapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.tabs.TabLayout;

public class MathCourses extends AppCompatActivity {
    TabLayout Mathtabs;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_math_courses);

        TabLayout mathtabLayout = new TabLayout(this);
        mathtabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    startActivity(new Intent(getApplicationContext(), TutoringCategories.class));

                } else if (tab.getPosition() == 1) {
                    startActivity(new Intent(getApplicationContext(), TutoringCategories.class));
                } else {
                    startActivity(new Intent(getApplicationContext(), TutoringCategories.class));
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}