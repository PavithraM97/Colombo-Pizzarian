package com.example.colombopizzarian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import java.util.ArrayList;
import java.util.List;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

public class AdmindashboardActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admindashboard);

        //spinner element

        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        //Spinner click listner
        spinner.setOnItemSelectedListener(this);

        //spinner dropdown elements
        List<String>categories= new ArrayList<String>();
        categories.add("Menu");
        categories.add("Edit Menu details");
        categories.add("View menu");
        categories.add("Password Reset");
        categories.add("Logout");


        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item =parent.getItemAtPosition(position).toString();
        Toast.makeText(this, "Selected", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void editmenu(View view) {
        startActivity(new Intent(AdmindashboardActivity.this, AdminOperationsActivity.class));
    }

    public void viewmenu(View view) {
        startActivity(new Intent(AdmindashboardActivity.this,CustomMenuActivity.class));
    }

    public void addpromo(View view) {
        startActivity(new Intent(AdmindashboardActivity.this, PromotionActivity.class));
    }

    public void logoutadmin(View view) {
        startActivity(new Intent(AdmindashboardActivity.this, AdminLogoutActivity.class));
    }

    public void editmenucat(View view) {
        startActivity(new Intent(AdmindashboardActivity.this, ProductActivity.class));
    }
}