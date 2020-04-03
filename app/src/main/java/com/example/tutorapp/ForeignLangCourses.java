package com.example.tutorapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;

public class ForeignLangCourses extends AppCompatActivity {
    ListView listView;
    FirebaseDatabase firebase;
    DatabaseReference dref;
    ArrayList<Courses> list;
    ArrayAdapter<Courses> adapter;
    Courses courses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foreign_lang_courses);

        courses = new Courses();
        listView = (ListView) findViewById(R.id.listView);
        firebase = FirebaseDatabase.getInstance();
        dref = firebase.getReference("Courses");
        list = new ArrayList<>();
        adapter = new ArrayAdapter<Courses>(this,R.layout.activity_foreign_lang_courses,list);
        dref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds: dataSnapshot.getChildren()){
                    courses = ds.getValue(Courses.class);
                    list.add(courses);

                }
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


}
