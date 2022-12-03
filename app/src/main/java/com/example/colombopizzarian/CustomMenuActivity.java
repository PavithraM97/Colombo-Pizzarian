package com.example.colombopizzarian;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.colombopizzarian.Adapter.HomeHorAdapter;
import com.example.colombopizzarian.Adapter.HomeVerAdapter;
import com.example.colombopizzarian.Adapter.UpdateVerticalRec;
import com.example.colombopizzarian.Models.HomeHorModel;
import com.example.colombopizzarian.Models.HomeVerModel;

import java.util.ArrayList;

public class CustomMenuActivity extends AppCompatActivity {

    RecyclerView homeHorizontalRec,homeVerticalRec;
    ArrayList<HomeHorModel> homeHorModelList;
    HomeHorAdapter homeHorAdapter;

    ArrayList<HomeVerModel> homeVerModelList;
    HomeVerAdapter homeVerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_menu);

        homeHorizontalRec = findViewById(R.id.home_hor_rec);
        homeVerticalRec = findViewById(R.id.home_ver_rec);
        //////////////////////////////////////////////////////////////////
        homeHorModelList = new ArrayList<>();

        homeHorModelList.add(new HomeHorModel(R.drawable.chilichiken, "Pizza Flavours"));
        homeHorModelList.add(new HomeHorModel(R.drawable.pasta3, "Pasta Flavours"));
        homeHorModelList.add(new HomeHorModel(R.drawable.drinks6, "Beverage Corner"));
        homeHorModelList.add(new HomeHorModel(R.drawable.veg2, "Veg Corner"));
        homeHorModelList.add(new HomeHorModel(R.drawable.dessert4, "Desserts Flavours"));



        homeHorizontalRec.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.HORIZONTAL, false));
        homeHorizontalRec.setHasFixedSize(true);
        homeHorizontalRec.setNestedScrollingEnabled(false);


        ////////////////////////////////////////////////////

        homeVerModelList = new ArrayList<>();
        homeVerModelList.add(new HomeVerModel(R.drawable.chilichiken, "Chilli Chiken Pizza" , "" ,"5.0", "Rs.1900.00"));
        homeVerModelList.add(new HomeVerModel(R.drawable.pizza2, "Pepporoni Pizza" , "" ,"4.8", "Rs 1900.00"));
        homeVerModelList.add(new HomeVerModel(R.drawable.pizza3, "Chiken Pizza" , "" ,"4.8", "Rs.1850.00"));
        homeVerModelList.add(new HomeVerModel(R.drawable.pasta1, "Bolgoneese Pasta" , "" ,"4.5", "Rs.850.00"));
        homeVerModelList.add(new HomeVerModel(R.drawable.pasta2, "Bolgoneese Spghetti" , "" ,"4.7", "Rs.800.00"));
        homeVerModelList.add(new HomeVerModel(R.drawable.pasta3, "Mix Pasta" , "" ,"5.0", "Rs 1100.00"));
        homeVerModelList.add(new HomeVerModel(R.drawable.pasta5, "Chiken Pasta" , "" ,"4.8", "Rs 900.00"));
        homeVerModelList.add(new HomeVerModel(R.drawable.drink1, "Shakes" , "" ,"4.0", "Rs 750.00"));
        homeVerModelList.add(new HomeVerModel(R.drawable.drink2, "Coca Cola" , "" ,"4.0", "Rs 150.00"));
        homeVerModelList.add(new HomeVerModel(R.drawable.drink3, "Sprite" , "" ,"4.0", "Rs.150.00"));
        homeVerModelList.add(new HomeVerModel(R.drawable.dssrt1, "Choclate Cupcake" , "" ,"4.8", "Rs 250.00"));
        homeVerModelList.add(new HomeVerModel(R.drawable.dessert3, "Brownies" , "" ,"4.5", "Rs 500.00"));
        homeVerModelList.add(new HomeVerModel(R.drawable.dessert4, "Moouse" , "" ,"4.5", "Rs 400.00"));
        homeVerModelList.add(new HomeVerModel(R.drawable.dssrt6, "Cheese Cake" , "" ,"4.0", "Rs.450.00"));

        homeVerAdapter = new HomeVerAdapter(getApplication(), homeVerModelList);
        homeVerticalRec.setAdapter(homeVerAdapter);
        homeVerticalRec.setLayoutManager(new LinearLayoutManager(getApplication(), RecyclerView.VERTICAL, false));

    }

}
