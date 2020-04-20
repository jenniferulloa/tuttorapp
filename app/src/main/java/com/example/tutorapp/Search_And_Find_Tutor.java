package com.example.tutorapp;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class Search_And_Find_Tutor extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search__and__find__tutor);
        ListView list = (ListView) findViewById(R.id.List_view);
        Person John = new Person("John Doe", "Calculus I & II", "75201");

        //log.d(TAG, "On Create Started:");
        ArrayList<Person> personList = new ArrayList<>();
        personList.add(John);
        PersonListAdapter adapter = new PersonListAdapter(this,R.layout.adapter_view_layout,personList);
        list.setAdapter((ListAdapter) adapter);
    }
}