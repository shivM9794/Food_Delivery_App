package com.example.fooddeliveryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class PopularCurationActivity extends AppCompatActivity {
    ImageView imageView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular_curation);
        button = findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PopularCurationActivity.this,PopularCurationCartActivity.class);
                startActivity(intent);
                finish();
            }
        });
        imageView = findViewById(R.id.order_popular);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PopularCurationActivity.this,DashBoardActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}