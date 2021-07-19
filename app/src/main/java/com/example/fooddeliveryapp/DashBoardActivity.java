package com.example.fooddeliveryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.fooddeliveryapp.HomeAdapters.CategoriesAdapter;
import com.example.fooddeliveryapp.HomeAdapters.CategoriesHelperClass;
import com.example.fooddeliveryapp.HomeAdapters.CouponsAdapter;
import com.example.fooddeliveryapp.HomeAdapters.CouponsHelperClass;
import com.example.fooddeliveryapp.HomeAdapters.OrderFavAdapter;
import com.example.fooddeliveryapp.HomeAdapters.OrderFavHelperClass;
import com.example.fooddeliveryapp.HomeAdapters.PopularCurations;
import com.example.fooddeliveryapp.HomeAdapters.PopularCurationHelperClass;
import com.example.fooddeliveryapp.HomeAdapters.FeaturedAdapter;
import com.example.fooddeliveryapp.HomeAdapters.FeaturedHelperClass;
import com.example.fooddeliveryapp.HomeAdapters.MostViewedAdapter;
import com.example.fooddeliveryapp.HomeAdapters.MostViewedHelperClass;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DashBoardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView featuredRecycler, mostViewedRecycler, categoriesRecycler, eatRecycler,coupon,orderRecycler;
    RecyclerView.Adapter adapter;
    ImageView menuIcon;
    TextView viewAll;
    MeowBottomNavigation bottomNavigation;
//    GradientDrawable gradient1,gradient2,gradient3,gradient4;



    //Drawer Layout
    DrawerLayout drawerLayout;
    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        findViewById(R.id.location_pin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashBoardActivity.this,MapsActivity.class));
            }
        });



    //Hooks
        featuredRecycler = findViewById(R.id.featured_recycler);
        mostViewedRecycler = findViewById(R.id.most_viewed_recycler);
        categoriesRecycler = findViewById(R.id.categories_recycler);
        eatRecycler = findViewById(R.id.eat_recycler);
        coupon = findViewById(R.id.coupons);
        orderRecycler = findViewById(R.id.order_recycler);

        bottomNavigation =findViewById(R.id.bottom_navigation);

        //Add menu
        bottomNavigation.add(new MeowBottomNavigation.Model(1,R.drawable.ic_home));
        bottomNavigation.add(new MeowBottomNavigation.Model(2,R.drawable.ic_info));
        bottomNavigation.add(new MeowBottomNavigation.Model(3,R.drawable.ic_setting));
        bottomNavigation.add(new MeowBottomNavigation.Model(4,R.drawable.ic_search));

        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                //Initialize fragments
                Fragment fragment = null;
                switch (item.getId()){
                    case 1:
                        fragment = new HomeFragment();
                        break;
                    case 2:
                        fragment = new InfoFragment();
                        break;
                    case 3:
                        fragment = new SearchFragment();
                        break;
                    case 4:
                        fragment = new SettingFragment();
                        break;
                }
                loadFragment(fragment);
            }
        });
        bottomNavigation.setCount(1,"10");
        bottomNavigation.show(2,true);
        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
                Toast.makeText(getApplicationContext(),"You Clicked" + item.getId(),Toast.LENGTH_SHORT).show();
            }
        });
        bottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {
                Toast.makeText(getApplicationContext(),"You Reselected" + item.getId(),Toast.LENGTH_SHORT).show();
            }
        });



        menuIcon = findViewById(R.id.img_1);






        //Menu Hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);


        navigationdrawer();


        featuredRecycler();
        mostViewedRecycler();
        categoriesRecycler();
        eatRecycler();
        coupon();
        orderRecycler();



    }

    private void loadFragment(Fragment fragment) {

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout,fragment)
                .commit();
    }

    private void orderRecycler() {
        orderRecycler.setHasFixedSize(true);
        orderRecycler.setLayoutManager(new GridLayoutManager(this,1));
        ArrayList<OrderFavHelperClass> orderFavLocations = new ArrayList<>();
        orderFavLocations.add(new OrderFavHelperClass(R.drawable.sagar,"Sagar Ratna","Family Restaurant","Civil Lines"));
        orderFavLocations.add(new OrderFavHelperClass(R.drawable.birthday_cake,"Paradise","Top and Fresh Quality","Balson Chauraha"));
        orderFavLocations.add(new OrderFavHelperClass(R.drawable.paneer_buttter_masals,"Shree Khana sweets & Res.","Serving the best","Allahabad"));
        orderFavLocations.add(new OrderFavHelperClass(R.drawable.chicken_lollipop,"Khan Chacha Restaurant","Family Restaurant","Allahabad"));
        orderFavLocations.add(new OrderFavHelperClass(R.drawable.dosa_icon,"Rohit Dosa Corner","100 variety od dosa","Civil Lines"));
        orderFavLocations.add(new OrderFavHelperClass(R.drawable.ice_cream_icon,"Kamadhenu Sweets & Icecreams","Taste that infuse your buds","Civil Lines"));
        orderFavLocations.add(new OrderFavHelperClass(R.drawable.north_indian_food_logo,"Sangam Restaurant","Best in thalis","Civil Lines"));
        orderFavLocations.add(new OrderFavHelperClass(R.drawable.south_indian_food_logo,"Anna Hotel","Experience the real taste","Civil Lines"));
        adapter = new OrderFavAdapter(orderFavLocations,this);
        orderRecycler.setAdapter(adapter);
    }

    private void coupon() {
        coupon.setHasFixedSize(true);
        coupon.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        ArrayList<CouponsHelperClass> couponsLocations = new ArrayList<>();
        couponsLocations.add(new CouponsHelperClass(R.drawable.food_coupon));
        couponsLocations.add(new CouponsHelperClass(R.drawable.food_coupon3));
        couponsLocations.add(new CouponsHelperClass(R.drawable.food_coupon_2));
        couponsLocations.add(new CouponsHelperClass(R.drawable.food_coupon));
        couponsLocations.add(new CouponsHelperClass(R.drawable.food_coupon));


        adapter = new CouponsAdapter(couponsLocations);
        coupon.setAdapter(adapter);
    }


    private void eatRecycler() {

        eatRecycler.setHasFixedSize(true);
        eatRecycler.setLayoutManager(new GridLayoutManager(this,3));

        ArrayList<PopularCurationHelperClass> eatLocations = new ArrayList<>();
        eatLocations.add(new PopularCurationHelperClass(R.drawable.paratha_logo, "Paratha"));
        eatLocations.add(new PopularCurationHelperClass(R.drawable.briyani_logo, "Biryani"));
        eatLocations.add(new PopularCurationHelperClass(R.drawable.masals_dosa, "Dosa"));
        eatLocations.add(new PopularCurationHelperClass(R.drawable.soya, "Soya Chap"));
        eatLocations.add(new PopularCurationHelperClass(R.drawable.diet_food_logo, "Diet"));
        eatLocations.add(new PopularCurationHelperClass(R.drawable.rolls_logo, "Rolls"));
        eatLocations.add(new PopularCurationHelperClass(R.drawable.desert_logo, "Deserts"));
        adapter = new PopularCurations(eatLocations,this);
        eatRecycler.setAdapter(adapter);
    }

    //navigation Drawer Function
    private void navigationdrawer() {

        //navigation Drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else drawerLayout.openDrawer(GravityCompat.START);
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else
            super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_all_categories:
                Intent intent = new Intent(getApplicationContext(), AllCategories.class);
                startActivity(intent);
                break;

            case R.id.nav_restaurants:
                Intent intent1 = new Intent(getApplicationContext(), Restaurants.class);
                startActivity(intent1);
                break;

            case R.id.nav_share:
                Intent intent2 = new Intent(getApplicationContext(),ShareActivity.class);
                startActivity(intent2);
                break;
            case R.id.nav_terms_and_condition:
                Intent intent4 = new Intent(getApplicationContext(),TandCActivity.class);
                startActivity(intent4);
                break;
            case R.id.nav_about_us:
                Intent intent3 = new Intent(getApplicationContext(),About_UsActivity.class);
                startActivity(intent3);
                break;
            case R.id.nav_payment:
                Intent intent5 = new Intent(getApplicationContext(),PaymentActivity.class);
                startActivity(intent5);
                break;

            case R.id.nav_logout:
                finish();


        }
        return true;
    }

    private void mostViewedRecycler() {

        mostViewedRecycler.setHasFixedSize(true);
        mostViewedRecycler.setLayoutManager(new GridLayoutManager(this,3));

        ArrayList<MostViewedHelperClass> mostViewedLocations = new ArrayList<>();
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.macd, "McDonald's"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.starbucks, "Starbucks"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.celebrations_logo, "Celebration"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.starbucks, "Starbucks"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.hakassan_logo, "Hakassan"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.elchico_logo, " Elchico"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.sagar_ratna_logo, "Sagar Ratna"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.dewsis_logo, "Dewsis"));

        adapter = new MostViewedAdapter(mostViewedLocations,this);
        mostViewedRecycler.setAdapter(adapter);

    }

    private void categoriesRecycler() {
//        gradient2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffd4cbe5, 0xffd4cbe5});
//        gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xff7adccf, 0xff7adccf});
//        gradient3 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xfff7c59f, 0xFFf7c59f});
//        gradient4 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffb8d7f5, 0xffb8d7f5});

        ArrayList<CategoriesHelperClass> categoriesHelperClasses = new ArrayList<>();
        categoriesHelperClasses.add(new CategoriesHelperClass(R.drawable.veg_momos, "Cafe Mayur"));
        categoriesHelperClasses.add(new CategoriesHelperClass(R.drawable.sweet_dish, "Chhappan Bhog"));
        categoriesHelperClasses.add(new CategoriesHelperClass(R.drawable.samosa_logo, "Samosas"));
        categoriesHelperClasses.add(new CategoriesHelperClass(R.drawable.italian_food_logo, "Italian Food"));
        categoriesHelperClasses.add(new CategoriesHelperClass(R.drawable.chinese_food_logo, "Chinese Foods"));
        categoriesHelperClasses.add(new CategoriesHelperClass(R.drawable.bbq_food_logo, "BBQ Nation"));
        categoriesHelperClasses.add(new CategoriesHelperClass(R.drawable.softdrinks_logo, "Soft Drinks"));


        categoriesRecycler.setHasFixedSize(true);
        adapter = new CategoriesAdapter(categoriesHelperClasses,this);
        categoriesRecycler.setLayoutManager(new GridLayoutManager(this,1));
        categoriesRecycler.setAdapter(adapter);
    }

    private void featuredRecycler() {
        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelperClass(R.drawable.macd, "McDonald's", "View All"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.starbucks, "Starbucks", "Welcome"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.domino, "Domino's", "I love pizzas"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.burger_king_logo, "Burger King", "I love pizzas"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.subway_logo, "Subway", "I love pizzas"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.kfc_logo2, "Kfc", "I love pizzas"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.dunkin_logo, "Dunkin'", "I love pizzas"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.pizza_hut_logo, "Pizza Hut", "I love pizzas"));


        adapter = new FeaturedAdapter(featuredLocations,this);
        featuredRecycler.setAdapter(adapter);
    }




}

