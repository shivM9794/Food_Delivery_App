package com.example.fooddeliveryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AllResNearbyActivity extends AppCompatActivity {
    ImageView imageView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_res_nearby);
        button = findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllResNearbyActivity.this,CartAllResNearby.class);
                startActivity(intent);
                finish();
            }
        });
        imageView = findViewById(R.id.order_fav3);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllResNearbyActivity.this,DashBoardActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}