package com.example.tutorapp;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class SubjectSearch extends AppCompatActivity {


    MyCustomAdapter dataAdapter = null;

    //Button btn_request;
    //TextView txt_request;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_search);


        //Generate list View from ArrayList
        displayListView();



//        btn_request.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                txt_request.setText("Tutor request being processed");
//            }
//        });



    }

    private void displayListView() {
        //Array list of countries
        ArrayList<TutorItem> tutorList = new ArrayList<TutorItem>();
        TutorItem tutorItem = new TutorItem("Name: Cindy Lam", "Subject: Math", "Topic: Calculus",
                "Rating: 4 Stars", "Cost: $20/hr", "Zip Code: 75001", R.drawable.femalebuns);
        tutorList.add(tutorItem);
        tutorItem = new TutorItem("Name: Mary Smith", "Subject: Test Preparation", "Topic: SAT Prep",
                "Rating: 3 Stars", "Cost: $12/hr", "Zip Code: 75006", R.drawable.femaleglasses);
        tutorList.add(tutorItem);
        tutorItem = new TutorItem("Name: Olivia Coleman", "Subject: Foreign Language", "Topic: Spanish",
                "Rating: 5 Stars", "Cost: $22/hr", "Zip Code: 75001", R.drawable.femalehoops);
        tutorList.add(tutorItem);
        tutorItem = new TutorItem("Name: Justin Miller", "Subject: Science", "Topic: Biology",
                "Rating: 4 Stars", "Cost: $18/hr", "Zip Code: 75014", R.drawable.malebeard);
        tutorList.add(tutorItem);
        tutorItem = new TutorItem("Name: David Wilson", "Subject: Language Arts", "Topic: Reading Comprehension",
                "Rating: 5 Stars", "Cost: $22/hr", "Zip Code: 75014", R.drawable.malemoustache);
        tutorList.add(tutorItem);
        tutorItem = new TutorItem("Name: Joe Brown", "Subject: Math", "Topic: Linear Algebra",
                "Rating: 2 Stars", "Cost: $12/hr", "Zip Code: 75011", R.drawable.maleyoung);
        tutorList.add(tutorItem);

        //create an ArrayAdaptar from the String Array
        dataAdapter = new MyCustomAdapter(this, R.layout.customlayout, tutorList);
        ListView listView = (ListView) findViewById(R.id.listView);
        // Assign adapter to ListView
        listView.setAdapter(dataAdapter);
        //enables filtering for the contents of the given ListView
        listView.setTextFilterEnabled(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // When clicked, show a toast with the TextView text
                TutorItem tutorItem = (TutorItem) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(),
                        tutorItem.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        EditText myFilter = (EditText) findViewById(R.id.myFilter);
        myFilter.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                dataAdapter.getFilter().filter(s.toString());
            }
        });

    }

    private class MyCustomAdapter extends ArrayAdapter<TutorItem> {

        private ArrayList<TutorItem> originalList;
        private ArrayList<TutorItem> tutorList;
        private TutorFilter filter;

        public MyCustomAdapter(Context context, int textViewResourceId,
                               ArrayList<TutorItem> tutorList) {
            super(context, textViewResourceId, tutorList);
            this.tutorList = new ArrayList<TutorItem>();
            this.tutorList.addAll(tutorList);
            this.originalList = new ArrayList<TutorItem>();
            this.originalList.addAll(tutorList);
        }

        @Override
        public Filter getFilter() {
            if (filter == null){
                filter  = new TutorFilter();
            }
            return filter;
        }
        private class ViewHolder {
            TextView name;
            TextView subject;
            TextView topic;
            TextView rating;
            TextView cost;
            TextView zip;
            ImageView image;

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder = null;
            Log.v("ConvertView", String.valueOf(position));
            if (convertView == null) {

                LayoutInflater vi = (LayoutInflater)getSystemService(
                        Context.LAYOUT_INFLATER_SERVICE);
                convertView = vi.inflate(R.layout.customlayout, null);
                final Button btn_request=(Button) convertView.findViewById(R.id.button_request);
                btn_request.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        btn_request.setText(R.string.Newreq);
                    }
                });
                holder = new ViewHolder();
                holder.name = (TextView) convertView.findViewById(R.id.textView_name);
                holder.subject = (TextView) convertView.findViewById(R.id.textView_subjects);
                holder.topic = (TextView) convertView.findViewById(R.id.textView_topics);
                holder.rating = (TextView) convertView.findViewById(R.id.textView_rating);
                holder.cost = (TextView) convertView.findViewById(R.id.textView_cost);
                holder.zip = (TextView) convertView.findViewById(R.id.textView_zip);
                holder.image = (ImageView) convertView.findViewById(R.id.imageView2);


                convertView.setTag(holder);

            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            TutorItem tutorItem = tutorList.get(position);
            holder.name.setText(tutorItem.getName());
            holder.subject.setText(tutorItem.getSubject());
            holder.topic.setText(tutorItem.getTopic());
            holder.rating.setText(tutorItem.getRating());
            holder.cost.setText(tutorItem.getCost());
            holder.zip.setText(tutorItem.getZip());
            holder.image.setImageResource(tutorItem.getImageT());


            return convertView;

        }

        private class TutorFilter extends Filter
        {

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                constraint = constraint.toString().toLowerCase();
                FilterResults result = new FilterResults();
                if(constraint != null && constraint.toString().length() > 0)
                {
                    ArrayList<TutorItem> filteredItems = new ArrayList<TutorItem>();

                    for(int i = 0, l = originalList.size(); i < l; i++)
                    {
                        TutorItem tutorItem = originalList.get(i);
                        if(tutorItem.toString().toLowerCase().contains(constraint))
                            filteredItems.add(tutorItem);
                    }
                    result.count = filteredItems.size();
                    result.values = filteredItems;
                }
                else
                {
                    synchronized(this)
                    {
                        result.values = originalList;
                        result.count = originalList.size();
                    }
                }
                return result;
            }

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint,
                                          FilterResults results) {

                tutorList = (ArrayList<TutorItem>)results.values;
                notifyDataSetChanged();
                clear();
                for(int i = 0, l = tutorList.size(); i < l; i++)
                    add(tutorList.get(i));
                notifyDataSetInvalidated();
            }
        }


    }


}