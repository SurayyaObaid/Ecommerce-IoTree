package com.example.ecommerce_iotree;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.ecommerce_iotree.Maintenance.PestGoals;
import com.example.ecommerce_iotree.Maintenance.WaterGoals;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SetGoalsActivity extends AppCompatActivity {
    CardView cardW, cardP, cardF, cardS, cardSun;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_goals);
        bottomNavigationView = findViewById(R.id.btmnav);
        bottomNavigationView.setSelectedItemId(R.id.track);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
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
        cardW = findViewById(R.id.WaterGoals);
        cardSun = findViewById(R.id.SunlightGoals);
        cardP = findViewById(R.id.PesticideGoals);
        cardF = findViewById(R.id.FertilizerGoals);
        cardS = findViewById(R.id.SoilQGoals);

        cardW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(SetGoalsActivity.this, WaterGoals.class);
                startActivity(in);
            }
        });
        cardP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(SetGoalsActivity.this, PestGoals.class);
                startActivity(in);
            }
        });
        cardW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(SetGoalsActivity.this, WaterGoals.class);
                startActivity(in);
            }
        });
        cardW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(SetGoalsActivity.this, WaterGoals.class);
                startActivity(in);
            }
        });
        cardW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(SetGoalsActivity.this, WaterGoals.class);
                startActivity(in);
            }
        });
    }
}