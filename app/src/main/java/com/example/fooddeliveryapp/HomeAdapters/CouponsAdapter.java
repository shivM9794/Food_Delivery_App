package com.example.fooddeliveryapp.HomeAdapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddeliveryapp.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class CouponsAdapter extends RecyclerView.Adapter<CouponsAdapter.CouponsViewHolder> {

    ArrayList<CouponsHelperClass> couponsLocations;

    public CouponsAdapter(ArrayList<CouponsHelperClass> couponsLocations) {
        this.couponsLocations = couponsLocations;
    }

    @NonNull
    @NotNull
    @Override
    public CouponsViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.coupons,parent,false);
        CouponsViewHolder couponsViewHolder = new CouponsViewHolder(view);
        return couponsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CouponsViewHolder holder, int position) {
        CouponsHelperClass couponsHelperClass = couponsLocations.get(position);
        holder.coupon_image.setImageResource(couponsHelperClass.getImage());

    }

    @Override
    public int getItemCount() {
        return couponsLocations.size();
    }


    public static class CouponsViewHolder extends RecyclerView.ViewHolder{

        ImageView coupon_image;

        public CouponsViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            coupon_image = itemView.findViewById(R.id.food_coupon);
        }
    }
}
