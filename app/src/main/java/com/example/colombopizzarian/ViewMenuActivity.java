package com.example.colombopizzarian;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.colombopizzarian.Adapter.ProductAdapter;

import java.util.ArrayList;

public class ViewMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_menu);

        ListView listView =findViewById(R.id.listMenu);

        DB_Operations db = new DB_Operations(this);
        ArrayList<Menu> menus=db.viewallmenu();

        if(menus.size()>0){
            ProductAdapter adapter = new ProductAdapter(this,menus);
            listView.setAdapter(adapter);
        }else{
            Toast.makeText(this, "Record not found", Toast.LENGTH_SHORT).show();
        }
    }


}