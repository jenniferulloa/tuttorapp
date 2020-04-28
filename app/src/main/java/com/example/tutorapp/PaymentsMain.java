package com.example.tutorapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PaymentsMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payments_main);

        Button Payments;
        Button Search;

        Payments= (Button) findViewById(R.id.btn_payments);
        Search=(Button) findViewById(R.id.btn_search);

        Payments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPayments();
            }
        });

        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSearch();
            }
        });

    }

    private void openSearch() {
        Intent intent=new Intent(this,SubjectSearch.class);
        startActivity(intent);
    }

    private void openPayments() {
        Intent intent=new Intent(this,PaymentActivity.class);
        startActivity(intent);
    }
}