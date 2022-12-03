package com.example.colombopizzarian.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.colombopizzarian.Adapter.CartAdapter;
import com.example.colombopizzarian.Models.CartModel;
import com.example.colombopizzarian.R;
import com.example.colombopizzarian.databinding.FragmentSlideshowBinding;

import java.util.ArrayList;
import java.util.List;

public class SlideshowFragment extends Fragment {

   List<CartModel> list;
   CartAdapter cartAdapter;
   RecyclerView recyclerView;
    private View btnProduct;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_slideshow,container,false);

        recyclerView = view.findViewById(R.id.cart_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        list=new ArrayList<>();
        list.add(new CartModel(R.drawable.chilichiken,"chilichiken"," Rs 1900.00",""));
        list.add(new CartModel(R.drawable.pizza2,"Sausage Delight","Rs 2100.00",""));
        list.add(new CartModel(R.drawable.pasta5,"Pasta","Rs.1000.00",""));
        cartAdapter= new CartAdapter(list);
        recyclerView.setAdapter(cartAdapter);


        return view;

    }


}