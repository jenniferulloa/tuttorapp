package com.example.tutorapp;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;

public class ReviewATutor extends AppCompatActivity {

    EditText Username,Class;
    Button button;
    RatingBar ratingStars;
    float myRating = 0;
    private String rideId, currentUserId, customerId, driverId, userDriverOrCustomer, rateeId;
    private RatingBar mRatingBar;
    private DatabaseReference historyRideInfoDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_atutor);


        Username = findViewById(R.id.Username);
        Class = findViewById(R.id.Class);
        button = findViewById(R.id.btnRating);
        ratingStars = findViewById(R.id.ratingBar);
        //currentUserId = FirebaseAuth.getInstance().getCurrentUser().getUid();




        ratingStars.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                int rating = (int) v;

                myRating = ratingBar.getRating();

                //Toast.makeText(ReviewATutor.this, "Rating "+ (int) myRating, Toast.LENGTH_SHORT).show();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = Username.getText().toString().trim();
                String course = Class.getText().toString().trim();

                if (TextUtils.isEmpty(username)) {
                    Username.setError("Valid Tutor Name is Required.");
                    return;
                }

                if (TextUtils.isEmpty(course)) {
                    Class.setError("Valid Class is Required.");
                    return;
                }



                int rating = (int) myRating;
                if (rating == 0)
                {
                    Toast.makeText(ReviewATutor.this, "Please enter a valid rating.", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(ReviewATutor.this, "Thank you for your rating of "+ (int) rating, Toast.LENGTH_SHORT).show();
                    finish();
                }

                //Toast.makeText(ReviewATutor.this, currentUserId, Toast.LENGTH_SHORT).show();
            }
        });

    }
}