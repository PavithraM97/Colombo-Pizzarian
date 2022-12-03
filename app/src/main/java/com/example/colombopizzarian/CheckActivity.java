package com.example.colombopizzarian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class CheckActivity extends AppCompatActivity {

    CheckBox  ChillieChiken, Pepporoni,Chiken,Pasta,Spghetti,shakes,cola,sprite,lemonade,moouse,cake;
    Button buttonOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

        ChillieChiken = findViewById(R.id.checkBox);
        Pepporoni = findViewById(R.id.checkBox2);
        Chiken = findViewById(R.id.checkBox3);
        Pasta = findViewById(R.id.checkBox4);
        Spghetti = findViewById(R.id.checkBox5);
        shakes = findViewById(R.id.checkBox6);
        cola = findViewById(R.id.checkBox7);
        sprite = findViewById(R.id.checkBox6);
        lemonade = findViewById(R.id.checkBox7);
        moouse = findViewById(R.id.checkBox6);
        cake = findViewById(R.id.checkBox7);
        buttonOrder = findViewById(R.id.button);
        buttonOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int totalAmount = 0;
                StringBuilder result = new StringBuilder();
                result.append("Selected Items");
                if ( ChillieChiken.isChecked()) {
                    result.append("\nChillie Chiken - Rs.1900.00");
                    totalAmount += 1900;
                }
                if ( Pepporoni.isChecked()) {
                    result.append("\nPepporoni Pizza - Rs.1900.00");
                    totalAmount += 1900;
                }
                if (Chiken.isChecked()) {
                    result.append("\nChiken Pizza - Rs.1850.00");
                    totalAmount += 1850;
                }
                if ( Pasta.isChecked()) {
                    result.append("\nBlogoneese Pasta - Rs.850.00");
                    totalAmount += 850;
                }
                if (Spghetti.isChecked()) {
                    result.append("\nBolgoneese Spghetti - Rs.800.00");
                    totalAmount += 800;
                }
                if ( shakes.isChecked()) {
                    result.append("\nShakes - Rs.750.00");
                    totalAmount += 750;
                }
                if (cola.isChecked()) {
                    result.append("\nCoca Cola -Rs.150.00");
                    totalAmount += 150;
                }
                if ( sprite.isChecked()) {
                    result.append("\nSpirite - Rs.150.00");
                    totalAmount += 150;
                }
                if (lemonade.isChecked()) {
                    result.append("\nLemonade -Rs.120.00");
                    totalAmount += 120;
                }
                if ( moouse.isChecked()) {
                    result.append("\nChoclate Moouse-Rs.400.00");
                    totalAmount += 400;
                }
                if (cake.isChecked()) {
                    result.append("\nCheese Cake-Rs.450.00");
                    totalAmount += 450;
                }

                result.append("\nTotal: " + totalAmount + "Rs");
                Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void place(View view) {
        startActivity(new Intent(CheckActivity.this, RegistationActivity.class));
    }

    public void backbtn(View view) {
        startActivity(new Intent(CheckActivity.this, MainPageActivity.class));
    }
}