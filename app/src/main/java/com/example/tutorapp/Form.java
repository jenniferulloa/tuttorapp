package com.example.tutorapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Form extends AppCompatActivity {
    Button Submit_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        Submit_Button = findViewById(R.id.Submit_Button);

        Submit_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Form.this,"Your Suggestion has been submitted and will be reviewed shortly", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
