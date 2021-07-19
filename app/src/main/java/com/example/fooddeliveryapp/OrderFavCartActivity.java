package com.example.fooddeliveryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class OrderFavCartActivity extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_fav_cart);
        findViewById(R.id.paybtno2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OrderFavCartActivity.this,PaymentActivity.class));
                finish();
            }
        });
        imageView = findViewById(R.id.order_cartfav);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderFavCartActivity.this,OrderFavActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}