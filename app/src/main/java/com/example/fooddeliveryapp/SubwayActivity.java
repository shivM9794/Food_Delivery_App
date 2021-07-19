package com.example.fooddeliveryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class SubwayActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subway);

        Toolbar toolbar = findViewById(R.id.toolbar);
        AppBarLayout appBarLayout = findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
//        getSupportActionBar().setHomeButtonEnabled(true);
        button = findViewById(R.id.place_order);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SubwayActivity.this,CartActivity.class);
                startActivity(i);
                finish();
            }
        });

        final CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collaspingToolbar);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbarLayout.setTitle("Starbucks Coffee");
                    isShow = false;
                } else {
                    collapsingToolbarLayout.setTitle("");
                    isShow = true;
                }
            }
        });
    }
}



