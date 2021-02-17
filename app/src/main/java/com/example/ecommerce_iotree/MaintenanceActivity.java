package com.example.ecommerce_iotree;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MaintenanceActivity extends AppCompatActivity {
    Button mBuySeeds;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintenance);
        mBuySeeds = findViewById(R.id.goals);
        mBuySeeds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MaintenanceActivity.this, SetGoalsActivity.class);
                startActivity(in);
            }
        });
        BottomNavigationView btmnav= findViewById(R.id.btmnav);
        btmnav.setSelectedItemId(R.id.track);
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
                        startActivity(new Intent(getApplicationContext(),DonationMain.class));
                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }
        });
        ImageButton imageButton, profileButton;
        imageButton = findViewById(R.id.logoutbtn);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.sessionUser = null;
                Intent in = new Intent(MaintenanceActivity.this, MainActivity.class);
                startActivity(in);
            }
        });
        profileButton = findViewById(R.id.profile);
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.sessionUser = null;
                Intent in = new Intent(MaintenanceActivity.this, UserProfileActivity.class);
                startActivity(in);
            }
        });
    }
}