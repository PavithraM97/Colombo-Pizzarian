package com.example.colombopizzarian.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.colombopizzarian.Adapter.HomeHorAdapter;
import com.example.colombopizzarian.Adapter.HomeVerAdapter;
import com.example.colombopizzarian.Adapter.UpdateVerticalRec;
import com.example.colombopizzarian.Models.HomeHorModel;
import com.example.colombopizzarian.Models.HomeVerModel;
import com.example.colombopizzarian.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements UpdateVerticalRec {

    RecyclerView homeHorizontalRec,homeVerticalRec;
    ArrayList<HomeHorModel> homeHorModelList;
    HomeHorAdapter homeHorAdapter;

//////////////////////////////////////Vertical

    ArrayList<HomeVerModel> homeVerModelList;
    HomeVerAdapter homeVerAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home,container,false);

        homeHorizontalRec = root.findViewById(R.id.home_hor_rec);
        homeVerticalRec = root.findViewById(R.id.home_ver_rec);
        //////////////////////////////////////////////////////////////////
        homeHorModelList = new ArrayList<>();

        homeHorModelList.add(new HomeHorModel(R.drawable.chilichiken, "Pizza Flavours"));
        homeHorModelList.add(new HomeHorModel(R.drawable.pasta3, "Pasta Flavours"));
        homeHorModelList.add(new HomeHorModel(R.drawable.drinks6, "Beverage Corner"));
        homeHorModelList.add(new HomeHorModel(R.drawable.veg2, "Veg Corner"));
        homeHorModelList.add(new HomeHorModel(R.drawable.dessert4, "Desserts Flavours"));


        homeHorAdapter = new HomeHorAdapter(this,getActivity(),homeHorModelList);
        homeHorizontalRec.setAdapter(homeHorAdapter);
        homeHorizontalRec.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        homeHorizontalRec.setHasFixedSize(true);
        homeHorizontalRec.setNestedScrollingEnabled(false);


        ////////////////////////////////////////////////////

        homeVerModelList = new ArrayList<>();
        homeVerModelList.add(new HomeVerModel(R.drawable.chilichiken, "pizza" , "10:00 - 10:30" ,"4.0", "Min-45"));
        homeVerModelList.add(new HomeVerModel(R.drawable.chilichiken, "pizza" , "10:00 - 10:30" ,"4.0", "Min-45"));
        homeVerModelList.add(new HomeVerModel(R.drawable.chilichiken, "pizza" , "10:00 - 10:30" ,"4.0", "Min-45"));
        homeVerModelList.add(new HomeVerModel(R.drawable.chilichiken, "pizza" , "10:00 - 10:30" ,"4.0", "Min-45"));
        homeVerModelList.add(new HomeVerModel(R.drawable.chilichiken, "pizza" , "10:00 - 10:30" ,"4.0", "Min-45"));

        homeVerAdapter = new HomeVerAdapter(getActivity(), homeVerModelList);
        homeVerticalRec.setAdapter(homeVerAdapter);
        homeVerticalRec.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));

        return root;
    }


    @Override
    public void callBack(int position, ArrayList<HomeVerModel> list) {
        homeVerAdapter=new HomeVerAdapter(getContext(),list);
        homeVerAdapter.notifyDataSetChanged();
        homeVerticalRec.setAdapter(homeVerAdapter);

    }
}