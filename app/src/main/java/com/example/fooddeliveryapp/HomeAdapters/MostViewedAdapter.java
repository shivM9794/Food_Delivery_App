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

import java.util.ArrayList;

public class MostViewedAdapter extends RecyclerView.Adapter<MostViewedAdapter.MostViewedViewHolder>{

    ArrayList<MostViewedHelperClass> mostViewedLocations;
    Context context;

    public MostViewedAdapter(ArrayList<MostViewedHelperClass> mostViewedLocations,Context context) {
        this.mostViewedLocations = mostViewedLocations;
        this.context = context;
    }

    @NonNull
    @Override
    public MostViewedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.most_viewed_card_design, parent, false);
        MostViewedViewHolder mostViewedViewHolder = new MostViewedViewHolder(view);
        return mostViewedViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MostViewedViewHolder holder, int position) {
        MostViewedHelperClass helperClass = mostViewedLocations.get(position);

        holder.imageView.setImageResource(helperClass.getImage());
        holder.textView.setText(helperClass.getText());
//        holder.textView.setText(helperClass.getDesc());

        holder.imageView.setOnClickListener(v -> {
            context.startActivity(new Intent(context, McDonaldsActivity.class));
        });
    }


    @Override
    public int getItemCount() {
        return mostViewedLocations.size();
    }

    public static class MostViewedViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView,desc;

        public MostViewedViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.mv_image);
            textView = itemView.findViewById(R.id.mv_title);
//            desc = itemView.findViewById(R.id.mv_desc);
        }
    }
}
