package com.example.tutorapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

    public class Communication extends AppCompatActivity {


        final int SEND_SMS_PERMISSION_REQUEST_CODE = 1;
        EditText number;
        EditText message;
        Button send_M;
        Button callButton;

        EditText email;
        String Subject = "New job in the area";
        Button send_E;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_communication);

            number = (EditText) findViewById(R.id.phoneText);
            message = (EditText) findViewById(R.id.message);
            send_M = findViewById(R.id.sendButtonMessage);
            email = findViewById(R.id.email);
            send_E = findViewById(R.id.sendButtonEmail);
            send_M.setEnabled(false);
            callButton = findViewById(R.id.callbut);


            if (checkPermission(Manifest.permission.SEND_SMS)) {
                send_M.setEnabled(true);
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, SEND_SMS_PERMISSION_REQUEST_CODE);
            }

            send_E.setOnClickListener(new View.OnClickListener() {

                                          @Override
                                          public void onClick(View v) {
                                              Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:" + email.getText().toString()));
                                              intent.putExtra(Intent.EXTRA_SUBJECT, Subject);
                                              intent.putExtra(Intent.EXTRA_TEXT, message.getText().toString());
                                              startActivity(intent);
                                          }
                                      }
            );


        }

        public void onCall(View v) {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("cell:"+number.getText().toString()));
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            startActivity(intent);



        }
        public void onSend(View view){
            String phoneNumber = number.getText().toString();
            String smsMessage = message.getText().toString();

            if(phoneNumber == null || phoneNumber.length() == 0 || smsMessage == null || smsMessage.length()==0) {
                return;
            }
            if(checkPermission(Manifest.permission.SEND_SMS))
            {
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(phoneNumber,null,smsMessage,null,null);
                Toast.makeText(this, "Message Sent!", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
            }


        }
        public boolean checkPermission(String permission){
            int check = ContextCompat.checkSelfPermission(this,permission);
            return (check == PackageManager.PERMISSION_GRANTED);



        }

    }