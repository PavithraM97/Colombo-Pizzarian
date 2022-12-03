package com.example.colombopizzarian;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class CustomerReviewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_reviews);

        Button getRating = findViewById(R.id.getRating);
        final RatingBar ratingBar = findViewById(R.id.rating);
        getRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rating = "You have rated as :" + ratingBar.getRating();
                Toast.makeText(CustomerReviewsActivity.this, rating, Toast.LENGTH_LONG).show();
            }
        });
    }
}