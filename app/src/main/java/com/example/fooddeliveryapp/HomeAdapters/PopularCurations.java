package com.example.fooddeliveryapp.HomeAdapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddeliveryapp.PopularCurationActivity;
import com.example.fooddeliveryapp.R;
import com.example.fooddeliveryapp.SubwayActivity;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class PopularCurations extends RecyclerView.Adapter<PopularCurations.EatViewHolder> {

    ArrayList<PopularCurationHelperClass> eatLocations;
    Context context;

    public PopularCurations(ArrayList<PopularCurationHelperClass> eatLocations, Context context) {
        this.eatLocations = eatLocations;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public EatViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_curations,parent,false);
        EatViewHolder eatViewHolder = new EatViewHolder(view);
        return eatViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull EatViewHolder holder, int position) {
        PopularCurationHelperClass eatHelperClass = eatLocations.get(position);
        holder.image.setImageResource(eatHelperClass.getImage());
        holder.title.setText(eatHelperClass.getTitle());

        holder.image.setOnClickListener(v -> {
            context.startActivity(new Intent(context, PopularCurationActivity.class));
        });


    }

    @Override
    public int getItemCount() {
        return eatLocations.size();
    }

    public static class EatViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView title;

        public EatViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.eat_img);
            title = itemView.findViewById(R.id.eat_logo);
        }
    }
}
