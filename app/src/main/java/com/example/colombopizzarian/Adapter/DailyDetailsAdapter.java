package com.example.colombopizzarian.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.colombopizzarian.Models.DailyDetailsModel;
import com.example.colombopizzarian.R;

import java.util.List;

public class DailyDetailsAdapter extends RecyclerView.Adapter<DailyDetailsAdapter.ViewHolder> {

    List<DailyDetailsModel> list;

    public DailyDetailsAdapter(List<DailyDetailsModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.dailymenu_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(list.get(position).getImage());
        holder.price.setText(list.get(position).getPrice());
        holder.name.setText(list.get(position).getName());
        holder.description.setText(list.get(position).getDescription());
        holder.timing.setText(list.get(position).getRating());
        holder.rating.setText(list.get(position).getRating());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name,price,description,rating,timing;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.detailed_img);
            name=itemView.findViewById(R.id.detailed_name);
            price=itemView.findViewById(R.id.detailed_price);
            description=itemView.findViewById(R.id.detailed_des);
            rating=itemView.findViewById(R.id.detailed_rating);
            timing=itemView.findViewById(R.id.detailed_timing);
        }
    }
}
