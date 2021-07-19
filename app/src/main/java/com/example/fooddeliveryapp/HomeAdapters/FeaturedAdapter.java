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

import com.example.fooddeliveryapp.McDonaldsActivity;
import com.example.fooddeliveryapp.R;
import com.example.fooddeliveryapp.SubwayActivity;

import java.util.ArrayList;

public class FeaturedAdapter extends RecyclerView.Adapter<FeaturedAdapter.FeaturedViewHolder>{

    ArrayList<FeaturedHelperClass> featuredLocations;
    Context context;


    public FeaturedAdapter(ArrayList<FeaturedHelperClass> featuredLocations, Context context) {
        this.featuredLocations = featuredLocations;
        this.context = context;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public FeaturedViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_card_design,parent,false);
        FeaturedViewHolder featuredViewHolder = new FeaturedViewHolder(view);
        return featuredViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull FeaturedAdapter.FeaturedViewHolder holder, int position) {
        FeaturedHelperClass featuredHelperClass = featuredLocations.get(position);
        holder.image.setImageResource(featuredHelperClass.getImage());
//        holder.title.setText(featuredHelperClass.getTitle());
//        holder.desc.setText(featuredHelperClass.getDescription());

        holder.image.setOnClickListener(v -> {
            context.startActivity(new Intent(context, SubwayActivity.class));

        });






    }

    @Override
    public int getItemCount() {
        return featuredLocations.size();
    }

    public static class FeaturedViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView title,desc;

        public FeaturedViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);


            //Hooks
            image = itemView.findViewById(R.id.featured_image);
//            title = itemView.findViewById(R.id.featured_title);
//            desc = itemView.findViewById(R.id.featured_desc);
        }
    }
}
