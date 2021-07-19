package com.example.fooddeliveryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AllCategories extends AppCompatActivity {
    ImageView backBtn;
    Button expandAll;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_categories);

        expandAll = findViewById(R.id.expand_all);
        expandAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),McDonaldsActivity.class);
                startActivity(intent);
                finish();
            }
        });
//        backBtn = findViewById(R.id.back_pressed2);
//        backBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AllCategories.super.onBackPressed();
//            }
//        });
    }
}

