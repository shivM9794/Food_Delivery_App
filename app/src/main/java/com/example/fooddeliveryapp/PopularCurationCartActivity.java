package com.example.fooddeliveryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class PopularCurationCartActivity extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular_curation_cart);
        findViewById(R.id.paybtnoss).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PopularCurationCartActivity.this,PaymentActivity.class));
                finish();
            }
        });
        imageView = findViewById(R.id.order_popular_cart);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PopularCurationCartActivity.this,PopularCurationActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}