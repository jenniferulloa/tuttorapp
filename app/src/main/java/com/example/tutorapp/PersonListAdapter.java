package com.example.tutorapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class PersonListAdapter extends ArrayAdapter<Person> {
     Context mContext;
     int mResource;

    public PersonListAdapter(android.content.Context context, int resources, ArrayList<Person> objects)
    {
        super(context,resources,objects);
        mContext = context;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String name = getItem(position).getName();
        String courses = getItem(position).getCourse();
        String zipcode = getItem(position).getZipcode();

        Person person = new Person(name,courses,zipcode);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource,parent,false);

        TextView txName = (TextView) convertView.findViewById(R.id.textView1);
        TextView txCourse = (TextView) convertView.findViewById(R.id.textView2);
        TextView txZipcode = (TextView) convertView.findViewById(R.id.textView3);

        txName.setText(name);
        txCourse.setText(courses);
        txZipcode.setText(zipcode);



        return convertView;
    }
}
