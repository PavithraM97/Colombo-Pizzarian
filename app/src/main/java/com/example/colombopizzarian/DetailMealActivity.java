package com.example.colombopizzarian;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.colombopizzarian.Adapter.DailyAdapter;
import com.example.colombopizzarian.Adapter.DailyDetailsAdapter;
import com.example.colombopizzarian.Models.DailyDetailsModel;

import java.util.ArrayList;
import java.util.List;

public class DetailMealActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<DailyDetailsModel> dailyDetailsModelList;
    DailyDetailsAdapter dailyAdapter;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_meal);

        String type = getIntent().getStringExtra("type");

        recyclerView=findViewById(R.id.detailed_rec);
        imageView= findViewById(R.id.detailed_img);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        dailyDetailsModelList=new ArrayList<>();
        dailyAdapter= new DailyDetailsAdapter(dailyDetailsModelList);
        recyclerView.setAdapter(dailyAdapter);

        if(type!= null && type.equalsIgnoreCase("breakfast")){
            imageView.setImageResource(R.drawable.brek2);
            dailyDetailsModelList.add(new DailyDetailsModel(R.drawable.veg, "Vegetable Salad", "Breakfast Menu is available ","", "Rs.800.00" , "10 am to 12"));
            dailyDetailsModelList.add(new DailyDetailsModel(R.drawable.pasta1, "Blogneese Pasta", "Breakfast Menu is available ","", "Rs. 1200.00" , "10 am to 12"));
            dailyDetailsModelList.add(new DailyDetailsModel(R.drawable.veg2, "Cheesy Pasta", "Breakfast Menu is available ","", "Rs 900.00" , "10 am to 12"));
            dailyDetailsModelList.add(new DailyDetailsModel(R.drawable.pasta2, "Blogneese Spghetti", "Breakfast Menu is available ","", "Rs 1200.00" , "10 am to 12"));
            dailyDetailsModelList.add(new DailyDetailsModel(R.drawable.pasta3, "Spicy cheese Spghetti", "Breakfast Menu is available","", "Rs 900.00" , "10 am to 12"));
            dailyAdapter.notifyDataSetChanged();
        }

        if(type!= null && type.equalsIgnoreCase("lunch")){
            imageView.setImageResource(R.drawable.pizza3);
            dailyDetailsModelList.add(new DailyDetailsModel(R.drawable.pizza3, "Pepporoni Pizza", "Lunch Menu is available ","", "Rs. 1890.00" , "10 am to 12"));
            dailyDetailsModelList.add(new DailyDetailsModel(R.drawable.pizza2, "Chilli chiken Pizza", "Lunch Menu is available ","", " Rs.1500.00" , "10 am to 12"));
            dailyDetailsModelList.add(new DailyDetailsModel(R.drawable.chilichiken, "Cheesy Pizza", "Lunch Menu is available ","", "Rs.1590.00" , "10 am to 12"));
            dailyDetailsModelList.add(new DailyDetailsModel(R.drawable.pizza2, "Sausage Delight Pizza", "Lunch Menu is available from ","", "Rs.900.00" , "10 am to 12"));
            dailyDetailsModelList.add(new DailyDetailsModel(R.drawable.pizza3, "Chiken Pizza", "Lunch Menu is available from ","", "Rs `1400.00" , "10 am to 12"));
            dailyAdapter.notifyDataSetChanged();
        }

        if(type!= null && type.equalsIgnoreCase("Evening")){
            imageView.setImageResource(R.drawable.veg);
            dailyDetailsModelList.add(new DailyDetailsModel(R.drawable.dinner2, "Sausage delight Pizza", "Evening snacks are available","", "Rs. 1590.00" , "10 am to 12"));
            dailyDetailsModelList.add(new DailyDetailsModel(R.drawable.eve1, "Salad", "Evening snacks are available","", "Rs 800.00" , "10 am to 12"));
            dailyDetailsModelList.add(new DailyDetailsModel(R.drawable.veg2, "Cheesy Salad", "Evening snacks are available","", "Rs 900.00" , "10 am to 12"));
            dailyDetailsModelList.add(new DailyDetailsModel(R.drawable.chilichiken, "Chilli chiken Pizza", "Evening snacks are available","", "Rs 1500.00" , "10 am to 12"));
            dailyDetailsModelList.add(new DailyDetailsModel(R.drawable.pasta3, "Blogoneese Spghetti", "Evening snacks are available","", "Rs 800.00" , "10 am to 12"));
            dailyAdapter.notifyDataSetChanged();
        }

        if(type!= null && type.equalsIgnoreCase("Dinner")){
            imageView.setImageResource(R.drawable.pasta1);
            dailyDetailsModelList.add(new DailyDetailsModel(R.drawable.pizza2, "Pepporoni Pizza", "Dinner Menu is available","", "Rs.1200.00" , "10 am to 12"));
            dailyDetailsModelList.add(new DailyDetailsModel(R.drawable.pizza3, "Cheesy Pizza", "Dinner Menu is available","", "Rs.1890.00" , "10 am to 12"));
            dailyDetailsModelList.add(new DailyDetailsModel(R.drawable.chilichiken, "Chilli Chiken Pizza", "Dinner Menu is available","", "Rs.1590.00" , "10 am to 12"));
            dailyDetailsModelList.add(new DailyDetailsModel(R.drawable.pizza2, "Sausage Delight Pizza", "Dinner Menu is available","", "Rs 900.00" , "10 am to 12"));
            dailyDetailsModelList.add(new DailyDetailsModel(R.drawable.pasta5, "Pasta", "Dinner Menu is available","", "Rs.900.00" , "10 am to 12"));
            dailyAdapter.notifyDataSetChanged();
        }

    }
}