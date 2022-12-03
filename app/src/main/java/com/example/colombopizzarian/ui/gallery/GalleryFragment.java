package com.example.colombopizzarian.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.colombopizzarian.Adapter.DailyAdapter;
import com.example.colombopizzarian.Models.DailyModel;
import com.example.colombopizzarian.R;


import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {

    RecyclerView recyclerView;
    List<DailyModel> dailyModels;
    DailyAdapter dailyAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_menu,container,false);


        recyclerView=root.findViewById(R.id.dailymenu_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        dailyModels=new ArrayList<>();
        dailyModels.add(new DailyModel(R.drawable.brek,"Breakfast Menu", "30% off", "Breakfast Menu is available from 10.00a.m-12.30p.m." , "Breakfast"));
        dailyModels.add(new DailyModel(R.drawable.lunch1,"Lunch Menu", "30% off", "Lunch Menu is available from 12.30p.m-2.00p.m", "Lunch"));
        dailyModels.add(new DailyModel(R.drawable.eve1,"Evening Snaks", "30% off", "Evening snacks are available from 2.00p.m-4.00p.m", "Evening"));
        dailyModels.add(new DailyModel(R.drawable.dinner1,"Dinner Menu", "30% off", "Dinner Menu is available  from 4.00p.m-9.00p.m", "dinner"));

        dailyAdapter= new DailyAdapter(getContext(),dailyModels);
        recyclerView.setAdapter(dailyAdapter);
        dailyAdapter.notifyDataSetChanged();
        return root;
    }


}