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

import com.example.fooddeliveryapp.OrderFavActivity;
import com.example.fooddeliveryapp.R;
import com.example.fooddeliveryapp.SubwayActivity;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class OrderFavAdapter extends RecyclerView.Adapter<OrderFavAdapter.OrderFavViewHolder> {

    ArrayList<OrderFavHelperClass> orderFavLocations;
    Context context;

    public OrderFavAdapter(ArrayList<OrderFavHelperClass> orderFavLocations, Context context) {
        this.orderFavLocations = orderFavLocations;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public OrderFavViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_favourite_card_design,parent,false);
        OrderFavViewHolder orderFavViewHolder = new OrderFavViewHolder(view);
        return orderFavViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull OrderFavViewHolder holder, int position) {
        OrderFavHelperClass orderFavHelperClass =orderFavLocations.get(position);
        holder.image.setImageResource(orderFavHelperClass.getImage());
        holder.title.setText(orderFavHelperClass.getTitle());
        holder.desc.setText(orderFavHelperClass.getDesc());
        holder.source.setText(orderFavHelperClass.getSource());

        holder.image.setOnClickListener(v -> {
            context.startActivity(new Intent(context, OrderFavActivity.class));
        });

    }

    @Override
    public int getItemCount() {
        return orderFavLocations.size();
    }

    public static class OrderFavViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView title,desc,source;

        public OrderFavViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.img);
            title = itemView.findViewById(R.id.titlename);
            desc = itemView.findViewById(R.id.desc);
            source = itemView.findViewById(R.id.source);
        }
    }
}
