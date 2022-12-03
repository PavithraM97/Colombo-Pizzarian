package com.example.colombopizzarian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AdminSigninActivity extends AppCompatActivity {

    Button bCancel,bSignup;
    EditText name,email,password,confirmpassword;

    boolean isAllFieldsChecked=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_signin);

        bSignup=findViewById(R.id.buttonRegister);
        bCancel=findViewById(R.id.buttonCancel);

        name=findViewById(R.id.editName);
        email=findViewById(R.id.editEmail);
        password=findViewById(R.id.editPassword);
        confirmpassword=findViewById(R.id.editconfirmPassword);

        bSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isAllFieldsChecked=CheckAllFields();

                if(isAllFieldsChecked){
                    startActivity(new Intent(AdminSigninActivity.this, AdmindashboardActivity.class));
                }
            }
        });

        bCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdminSigninActivity.this.finish();
                System.exit(0);
            }
        });


    }

    private boolean CheckAllFields() {
        if (name.length() == 0) {
              name.setError("This field required");
              return false;
        }
        if (email.length() == 0) {
            email.setError("This field required");
            return false;
        }
        if (password.length() == 0) {
            password.setError("This field required");
            return false;
        }
        if (confirmpassword.length() == 0) {
            confirmpassword.setError("This field required");
            return false;
        }

        return true;
    }

}