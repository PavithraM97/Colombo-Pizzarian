package com.example.colombopizzarian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
    }

    public void home(View view) {
        startActivity(new Intent(MainPageActivity.this, CustomMenuActivity.class));
    }

    public void map(View view) {
        startActivity(new Intent(MainPageActivity.this, MapsActivity.class));
    }

    public void info(View view) {
        startActivity(new Intent(MainPageActivity.this, InfoActivity.class));
    }

    public void backbtn(View view) {
        startActivity(new Intent(MainPageActivity.this, PortalActivity.class));
    }

    public void review(View view) {
        startActivity(new Intent(MainPageActivity.this, CustomerReviewsActivity.class));
    }

    public void sms(View view) {
        startActivity(new Intent(MainPageActivity.this, SMSActivity.class));
    }

    public void placeorder(View view) {
        startActivity(new Intent(MainPageActivity.this, CheckActivity.class));
    }
}