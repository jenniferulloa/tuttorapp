package com.example.tutorapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    EditText Username,Password,Email;
    Button LoginButton;
    TextView CreateButton,ForgotPassword;
    ProgressBar progressBar;
    FirebaseAuth fAuth;
    int attempt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Email = findViewById(R.id.Email);
        Password = findViewById(R.id.Password);
        LoginButton = findViewById(R.id.LoginButton);
        progressBar = findViewById(R.id.progressBar);
        fAuth = FirebaseAuth.getInstance();
        CreateButton = findViewById(R.id.createText);
        ForgotPassword = findViewById(R.id.ForgotPassword);

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (attempt == 4) {
                    Toast.makeText(getApplicationContext(), "Login limits exceeded please reset password", Toast.LENGTH_LONG).show();
                } else {
                    String password = Password.getText().toString().trim();
                    String email = Email.getText().toString().trim();


                    if (TextUtils.isEmpty(password)) {
                        Password.setError("Password is Required.");
                        return;
                    }

                    if (TextUtils.isEmpty(email)) {
                        Password.setError("Email is Required.");
                        return;
                    }

                    if (password.length() < 6) {
                        Password.setError("Password Must be >= 6 Characters");
                        return;
                    }

                    progressBar.setVisibility(View.VISIBLE);

                    // authenticate the user
                    fAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Login.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            } else {
                                Toast.makeText(Login.this, "Error ! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                progressBar.setVisibility(View.GONE);
                                attempt++;
                            }

                        }
                    });
                }
            }
        });
        CreateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Registration.class));
            }
        });
        ForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = Email.getText().toString();
                if(TextUtils.isEmpty(email))
                {
                    Toast.makeText(Login.this, "Please enter your email in the email box above ", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    fAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful())
                            {
                                Toast.makeText(Login.this, "Sucessful: Password reset instructions sent to your email",Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                String message = task.getException().getMessage();
                                Toast.makeText(Login.this,"Error! Reset link not sent "+message,Toast.LENGTH_SHORT).show();

                            }
                        }
                    });

                }
            }
        });

    }
}
