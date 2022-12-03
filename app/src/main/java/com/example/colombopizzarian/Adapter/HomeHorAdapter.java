package com.example.colombopizzarian.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.colombopizzarian.Models.HomeHorModel;
import com.example.colombopizzarian.Models.HomeVerModel;
import com.example.colombopizzarian.R;

import java.util.ArrayList;
import java.util.List;

public class HomeHorAdapter extends RecyclerView.Adapter<HomeHorAdapter.ViewHolder> {
    UpdateVerticalRec updateVerticalRec;
    Activity activity;
    ArrayList<HomeHorModel> list;

    boolean check = true;
    boolean select = true;
    int row_index= 1;

    public HomeHorAdapter(UpdateVerticalRec updateVerticalRec, Activity activity, ArrayList<HomeHorModel> list) {
        this.updateVerticalRec = updateVerticalRec;
        this.activity = activity;
        this.list = list;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_horizontal_items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());

        if(check) {
            ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
            homeVerModels.add(new HomeVerModel(R.drawable.chilichiken , " Chilli Chiken Pizza" , "10:00 - 12:30" ,"5.0", "Rs 1900.00"));
            homeVerModels.add(new HomeVerModel(R.drawable.sweetchiken , "Hawai Pizza" , "12:00 - 04:30" ,"4.0", "Rs 900.00"));
            homeVerModels.add(new HomeVerModel(R.drawable.pizza2 , " Sausage Delight Pizza" , "12:00 - 01:30" ,"4.8", "Rs 1600.00"));
            homeVerModels.add(new HomeVerModel(R.drawable.pizza3 , "Pepporoni Special Pizza" , "10:00 - 12:30" ,"4.0", "Rs 1900.00"));
            homeVerModels.add(new HomeVerModel(R.drawable.pizza3 , "Thandoori Chiken Pizza" , "10:00 - 12:30" ,"4.5", "Rs 1850.00"));
            updateVerticalRec.callBack(position, homeVerModels);
            check = false;
        }
            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    row_index=position;
                    notifyDataSetChanged();

                    if(position==0){
                        ArrayList<HomeVerModel> homeVerModels= new ArrayList<>();
                        homeVerModels.add(new HomeVerModel(R.drawable.chilichiken , " Chilli Chiken Pizza" , "10:00 - 12:30" ,"5.0", "Rs 1900.00"));
                        homeVerModels.add(new HomeVerModel(R.drawable.sweetchiken , "Hawai Pizza" , "12:00 - 04:30" ,"4.0", "Rs 900.00"));
                        homeVerModels.add(new HomeVerModel(R.drawable.pizza2 , " Sausage Delight Pizza" , "12:00 - 01:30" ,"4.8", "Rs 1600.00"));
                        homeVerModels.add(new HomeVerModel(R.drawable.pizza3 , "Pepporoni Special Pizza" , "10:00 - 12:30" ,"4.0", "Rs 1900.00"));
                        homeVerModels.add(new HomeVerModel(R.drawable.pizza3 , "Thandoori Chiken Pizza" , "10:00 - 12:30" ,"4.5", "Rs 1850.00"));
                        updateVerticalRec.callBack(position,homeVerModels);

                    }
                    else if(position==1){
                        ArrayList<HomeVerModel> homeVerModels= new ArrayList<>();
                        homeVerModels.add(new HomeVerModel(R.drawable.pasta1 , " Bolgoneese Pasta" , "12:00 - 03:30" ,"4.0", "Rs 850.00"));
                        homeVerModels.add(new HomeVerModel(R.drawable.pasta2 , "Bolgoneese Spghetti" , "12:00 - 03:30" ,"4.8", "Rs 800.00"));
                        homeVerModels.add(new HomeVerModel(R.drawable.pasta3 , "Mix Pasta" , "12:00 - 03:30" ,"4.8", "Rs 1100.00"));
                        homeVerModels.add(new HomeVerModel(R.drawable.pasta4 , "Chiken pasta" , "10:00 - 10:30" ,"4.5", "Rs.900"));
                        homeVerModels.add(new HomeVerModel(R.drawable.pasta5 , "Cream Pasta" , "10:00 - 10:30" ,"4.0", "Rs 850.00"));
                        updateVerticalRec.callBack(position,homeVerModels);

                    }
                    else if(position==2){
                        ArrayList<HomeVerModel> homeVerModels= new ArrayList<>();
                        homeVerModels.add(new HomeVerModel(R.drawable.drink1 , "Shakes" , "Always" ,"", "Rs.750.00"));
                        homeVerModels.add(new HomeVerModel(R.drawable.drink2 , "CocaCola" , "Always" ,"", "Rs 150.00"));
                        homeVerModels.add(new HomeVerModel(R.drawable.drink3 , "Sprite" , "Always" ,"", "Rs. 150.00"));
                        homeVerModels.add(new HomeVerModel(R.drawable.drinks6 , "Orange Juice" , "Always" ,"", "Rs 400.00"));
                        homeVerModels.add(new HomeVerModel(R.drawable.drink5 , "Strawberry Mojito" , "12:00-05:00" ,"4.0", "Es. 650.00"));
                        updateVerticalRec.callBack(position,homeVerModels);
                    }
                    else if(position==3){
                        ArrayList<HomeVerModel> homeVerModels= new ArrayList<>();
                        homeVerModels.add(new HomeVerModel(R.drawable.veg , "Mix Salad" , "10:00 - 9:00" ,"4.0", "Rs 450.00"));
                        homeVerModels.add(new HomeVerModel(R.drawable.veg2 , "Cheesy Salad" , "10:00 - 9:00" ,"4.8", "Rs 600.00"));
                        homeVerModels.add(new HomeVerModel(R.drawable.veg3 , "Vegi Pizza" , "10:00 - 9:00" ,"5.0", "Rs 1590"));
                        homeVerModels.add(new HomeVerModel(R.drawable.veg4 , "Potato Wedges" , "10:00 - 9:00" ,"4.8", "Rs 390.00"));
                        updateVerticalRec.callBack(position,homeVerModels);
                    }
                    else if(position==4){
                        ArrayList<HomeVerModel> homeVerModels= new ArrayList<>();
                        homeVerModels.add(new HomeVerModel(R.drawable.dssrt1 , "Choclate Cupcake" , "11:00 - 10:30" ,"4.0", "Rs 250.00"));
                        homeVerModels.add(new HomeVerModel(R.drawable.dessert3 , "Brownies" , "11:00 - 10:30" ,"4.8", "Rs 500.00"));
                        homeVerModels.add(new HomeVerModel(R.drawable.dessert4 , "Moose" , "11:00 - 10:30" ,"4.8", "Rs 400.00"));
                        homeVerModels.add(new HomeVerModel(R.drawable.dssrt6 , "Cheese Cake" , "11:00 - 10:30" ,"4.8", "Rs 450.00"));
                        updateVerticalRec.callBack(position,homeVerModels);
                    }
                }
            });

            if (select) {
                if(position==0){
                    holder.cardView.setBackgroundResource(R.drawable.default_bg);
                }
            }

            else{
                if(row_index == position){
                    holder.cardView.setBackgroundResource(R.drawable.default_bg);
                }
            }

        }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.hor_img);
            name=itemView.findViewById(R.id.hor_text);
            cardView=itemView.findViewById(R.id.cardView);
        }
    }
}
