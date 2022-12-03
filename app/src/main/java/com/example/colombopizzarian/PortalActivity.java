package com.example.colombopizzarian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class PortalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portal);
    }

    public void Login(View view) {
        startActivity(new Intent(PortalActivity.this, UsersActivity.class));
    }


    public void Adminl(View view) {
        startActivity(new Intent(PortalActivity.this, AdminLoginActivity.class));
    }

    public void user(View view) {
        startActivity(new Intent(PortalActivity.this, MainPageActivity.class));
    }
}