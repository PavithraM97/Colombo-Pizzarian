package com.example.colombopizzarian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PromotionActivity extends AppCompatActivity {

    EditText txtPid,txtPname,txtPdes,txtpdiscount;
    Button Backbtn;
    DB_Operations db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotion);

        Backbtn=findViewById(R.id.back);

        db=new DB_Operations(this);

        txtPid=findViewById(R.id.txtpid);
        txtPname=findViewById(R.id.txtpname);
        txtPdes=findViewById(R.id.txtpdescription);
        txtpdiscount=findViewById(R.id.txtpdiscount);

    }
    public void insert(View view){
        Promotion promotion= new Promotion();
        promotion.setPid(Integer.parseInt(txtPid.getText().toString()));
        promotion.setPname(txtPname.getText().toString());
        promotion.setDescription(txtPdes.getText().toString());
        promotion.setDiscount(Integer.parseInt(txtpdiscount.getText().toString()));
        try{

            Toast.makeText(this,"Record Inserted Sucessfully",Toast.LENGTH_SHORT).show();
        }catch (Exception ex){
            Log.e("Error",ex.getMessage());
        }

    }


    public void back(View view) {
        startActivity(new Intent(PromotionActivity.this, AdmindashboardActivity.class));

    }
}