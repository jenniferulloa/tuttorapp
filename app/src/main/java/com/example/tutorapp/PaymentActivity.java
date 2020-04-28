package com.example.tutorapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class PaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        ImageButton PayPal;
        ImageButton Discover;
        ImageButton Visa;



        PayPal = (ImageButton) findViewById(R.id.btn_paypal);
        Discover= (ImageButton) findViewById(R.id.btn_discover);
        Visa=(ImageButton) findViewById(R.id.btn_visa);


        PayPal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPayPal();
            }
        });
        Discover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDiscover();
            }
        });
        Visa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openVisa();
            }
        });

    }

    private void openVisa() {
        Intent intent=new Intent(this,VisaActivity.class);
        startActivity(intent);
    }

    private void openDiscover() {
        Intent intent=new Intent(this,DiscoverActivity.class);
        startActivity(intent);
    }


    private void openPayPal() {
        Intent intent=new Intent(this,PayPalActivity.class);
        startActivity(intent);
    }
}