package com.example.colombopizzarian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AdminLoginActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private Button Register;
    private int counter=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        Name=(EditText)findViewById(R.id.Username);
        Password=(EditText)findViewById(R.id.Password);
        Info=(TextView) findViewById(R.id.attempts);
        Login=(Button)findViewById(R.id.btnLogin);
        Register=(Button)findViewById(R.id.btnreg);

        Info.setText("Number of attempts remaining : 5");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(),Password.getText().toString());
            }
        });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AdminLoginActivity.this, AdminSigninActivity.class));
            }
        });

    }


    private void validate (String userName,String userPassword){
        if((userName.equals("Admin")) && (userPassword.equals("Admin"))){
            Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(AdminLoginActivity.this, AdmindashboardActivity.class));
        }else{
            counter--;

            Info.setText("No attempts remaining" + String.valueOf(counter));

            if(counter==0){
                Login.setEnabled(false);
            }

        }



    }
}