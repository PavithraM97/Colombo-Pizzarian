package com.example.colombopizzarian;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SMSActivity extends AppCompatActivity {
    EditText txtNum,txtMsg;
    TextView lblcount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smsactivity);

        txtNum = findViewById(R.id.txtMobile);
        txtMsg=findViewById(R.id.txtMessage);
        lblcount=findViewById(R.id.lblCount);

        txtMsg.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                lblcount.setText(charSequence.length()+"/160");
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public void sendsms (View view){
        String number = txtNum.getText().toString();
        String message = txtMsg.getText().toString();
        SmsManager smsManager = SmsManager.getDefault();

        if(Build.VERSION.SDK_INT >= 23){
            if(ContextCompat.checkSelfPermission(SMSActivity.this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(SMSActivity.this , new String[]{ Manifest.permission.SEND_SMS},777);
            }

        }

        smsManager.sendTextMessage(number,null,message,null,null);
        Toast.makeText(this, "Message Sent", Toast.LENGTH_SHORT).show();
    }


}