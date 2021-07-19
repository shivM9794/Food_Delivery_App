package com.example.fooddeliveryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MostVisitedCartActivity extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_most_visited_cart);
        findViewById(R.id.paybtno1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MostVisitedCartActivity.this,PaymentActivity.class));
                finish();
            }
        });
        imageView = findViewById(R.id.order_mv);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MostVisitedCartActivity.this,McDonaldsActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}