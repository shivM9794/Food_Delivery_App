package com.example.fooddeliveryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CartActivity extends AppCompatActivity {
   ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
       imageView = findViewById(R.id.order_back);
       imageView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(CartActivity.this,SubwayActivity.class);
               startActivity(intent);
               finish();
           }
       });
       findViewById(R.id.paybtno).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(CartActivity.this,PaymentActivity.class));
               finish();
           }
       });

    }
}

