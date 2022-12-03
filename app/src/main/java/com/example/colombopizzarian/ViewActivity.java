package com.example.colombopizzarian;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        ListView listView = findViewById(R.id.listMenu);

        DB_Operations db = new DB_Operations(this);
        ArrayList<Pizza> pizzas = db.viewAllPizza();
        int count = pizzas.size();

        if (count > 0) {
            ArrayList<String> newList = new ArrayList<>();
            for(int x=0; x<count; x++){
                Pizza pizza = pizzas.get(x);
                newList.add(pizza.getId()+"/n"+pizza.getName()+"/n"+pizza.getPrice());
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,newList);
            listView.setAdapter(adapter);
        } else {
            Toast.makeText(this, "No pizza record found", Toast.LENGTH_SHORT).show();
        }

    }
}