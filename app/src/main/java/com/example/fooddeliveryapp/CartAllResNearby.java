package com.example.fooddeliveryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class CartAllResNearby extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_all_res_nearby);
        findViewById(R.id.paybtnos).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CartAllResNearby.this,PaymentActivity.class));
                finish();
            }
        });
        imageView = findViewById(R.id.order_back3);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CartAllResNearby.this,AllResNearbyActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}