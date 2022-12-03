package com.example.colombopizzarian;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.colombopizzarian.Adapter.HomeHorAdapter;
import com.example.colombopizzarian.Models.HomeHorModel;

import java.util.ArrayList;
import java.util.List;

public class HomeshopActivity extends AppCompatActivity {


    RecyclerView homeHorizontalRec;
    List<HomeHorModel> homeHorModelList;
    HomeHorAdapter homeHorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeshop);

        homeHorizontalRec = findViewById(R.id.home_hor_rec);
        homeHorModelList = new ArrayList<>();

        homeHorModelList.add(new HomeHorModel(R.drawable.chilichiken, "pizza"));
        homeHorModelList.add(new HomeHorModel(R.drawable.chilichiken, "pizza"));
        homeHorModelList.add(new HomeHorModel(R.drawable.chilichiken, "pizza"));
        homeHorModelList.add(new HomeHorModel(R.drawable.chilichiken, "pizza"));


        homeHorizontalRec.setAdapter(homeHorAdapter);
        homeHorizontalRec.setLayoutManager(new LinearLayoutManager(getApplication(), RecyclerView.HORIZONTAL, false));
        homeHorizontalRec.setHasFixedSize(true);
        homeHorizontalRec.setNestedScrollingEnabled(false);
    }

}