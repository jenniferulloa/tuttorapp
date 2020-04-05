package com.example.tutorapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class Registration extends AppCompatActivity {

    public static final String TAG = "Tag";
    EditText FirstName,LastName,Username, Email, Password,ZipCode,PhoneNumber;
    CheckBox Tutor,Student;
    Button RegisterButton;
    FirebaseAuth fAuth;
    ProgressBar progressBar;
    String userID;
    FirebaseFirestore fStore;
    TextView LoginButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        FirstName = findViewById(R.id.FirstName);
        LastName = findViewById(R.id.LastName);
        Username = findViewById(R.id.Username);
        ZipCode = findViewById(R.id.ZipCode);
        PhoneNumber = findViewById(R.id.PhoneNumber);
        Email = findViewById(R.id.Email);
        Password = findViewById(R.id.Password);
        Tutor = findViewById(R.id.Tutor);
        Student = findViewById(R.id.Student);
        RegisterButton = findViewById(R.id.RegisterButton);
        LoginButton = findViewById(R.id.LoginButton);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        progressBar = findViewById(R.id.progressBar);

        if (fAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = Email.getText().toString().trim();
                String password = Password.getText().toString().trim();
                final String firstname = FirstName.getText().toString();
                final String lastname = LastName.getText().toString();
                final String zipcode = ZipCode.getText().toString();
                final String phonenumber = PhoneNumber.getText().toString();
                final String username = Username.getText().toString();
                if (TextUtils.isEmpty(email)) {
                    Email.setError("Email is Required");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Password.setError("Password is Required");
                    return;
                }
                if (password.length() < 6) {
                    Password.setError("Password has to be at least 6 characters long");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Registration.this, "User Created", Toast.LENGTH_SHORT).show();
                            userID = fAuth.getCurrentUser().getUid();
                            DocumentReference documentReference = fStore.collection("users").document(userID);
                            Map<String,Object> user = new HashMap<>();
                            user.put("fName",firstname);
                            user.put("LName",lastname);
                            user.put("email",email);
                            user.put("username",username);
                            user.put("zipcode",zipcode);
                            user.put("phone", phonenumber);

                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Log.d(Registration.TAG, "onSuccess: user Profile is created for "+ userID);
                                    startActivity(new Intent(Registration.this,MainActivity.class));//id registered they will be sent to homepage
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d(TAG, "onFailure"+e.toString());
                                }
                            });

                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        } else {
                            Toast.makeText(Registration.this, "Error!" + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }

                });
            }


        });
    }
}
