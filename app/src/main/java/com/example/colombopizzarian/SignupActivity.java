package com.example.colombopizzarian;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    EditText txtuid,txtuname,txtupassword,txtuemail,txtaddress;
    Button bCancel,bProced;
    DB_Operations db;

    boolean isAllFieldsCheked= false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        db=new DB_Operations(this);

        txtuid=findViewById(R.id.txtuID);
        txtuname=findViewById(R.id.txtuID);
        txtupassword=findViewById(R.id.txtuPassword);
        txtuemail=findViewById(R.id.txtuEmail);
        txtaddress=findViewById(R.id.txtuAddress);

    }

    public void insertsignup(View view){


        Signup signup= new Signup();
        signup.setUid(Integer.parseInt(txtuid.getText().toString()));
        signup.setUsername(txtuname.getText().toString());
        signup.setPassword(txtupassword.getText().toString());
        signup.setEmail(txtuemail.getText().toString());
        signup.setAddress(txtaddress.getText().toString());

        try{
            db.insertsignup(signup);
            Toast.makeText(this,"Record Inserted",Toast.LENGTH_SHORT).show();
        }catch (Exception ex){
            Log.e("Error",ex.getMessage());
        }
    }
}