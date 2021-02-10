package com.example.ecommerce_iotree;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GardenerActivity extends AppCompatActivity {
    CheckBox clearance, design, jet_washing, growth_prevention, lawn_mowing;
    String gardenerService = "", gName, gAddress, gPhone, gCharges, gid;
    Button requestGardenerBtn;
    BottomNavigationView btmnav;
    JSONPlaceHolderApi jsonPlaceHolderApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gardener);
        btmnav = findViewById(R.id.btmnav);
        btmnav.setSelectedItemId(R.id.gardener);
        btmnav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.predict:
                        startActivity(new Intent(getApplicationContext(),PredictionActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.gardener:
                        startActivity(new Intent(getApplicationContext(),GardenerActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.shop:
                        startActivity(new Intent(getApplicationContext(),StoreActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.donationActivity:
                        startActivity(new Intent(getApplicationContext(),DonationActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }
        });
        clearance = findViewById(R.id.garden_clearance);
        design = findViewById(R.id.garden_design);
        jet_washing = findViewById(R.id.jet_washing);
        growth_prevention = findViewById(R.id.overgrowth_prevention);
        lawn_mowing = findViewById(R.id.lawn_mowing);
        requestGardenerBtn = findViewById(R.id.requestGardener);
        requestGardenerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clearance.isChecked()){
                    gardenerService = "Clearance";
                }
                else if(design.isChecked()){
                    gardenerService = "Garden Designing";
                }
                else if (jet_washing.isChecked()){
                    gardenerService = "Jet Washing";
                }
                else if (growth_prevention.isChecked()){
                    gardenerService = "Overgrowth Prevention";
                }
                else if (lawn_mowing.isChecked()){
                    gardenerService = "Lawn Mowing";
                }
                else {
                    Toast.makeText(GardenerActivity.this,"Nothing Selected",Toast.LENGTH_LONG).show();
                }

                Intent in = new Intent(GardenerActivity.this, GardenerList.class);
                in.putExtra("gardenerService",gardenerService);
                startActivity(in);
            }
        });

    }

}