package com.example.tutorapp;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ItemsPreviewActivity extends AppCompatActivity{



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_preview_items);

            ImageView imageView = findViewById(R.id.imageView);
            TextView textView = findViewById(R.id.textView);

            Intent intent = getIntent();
            if(intent.getExtras() != null){
                ItemsModel itemsModel = (ItemsModel) intent.getSerializableExtra("items");
                imageView.setImageResource(itemsModel.getImages());
                textView.setText(itemsModel.getName());
            }



        }
    }
