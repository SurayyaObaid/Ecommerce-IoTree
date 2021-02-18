package com.example.ecommerce_iotree;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DonationMain extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    CardView campaigns, donations, pastdonations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_main);
        bottomNavigationView = findViewById(R.id.btmnav);
        bottomNavigationView.setSelectedItemId(R.id.donationActivity);
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
                        startActivity(new Intent(getApplicationContext(),DonationMain.class));
                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }
        });
        pastdonations = findViewById(R.id.pastDonations);
        pastdonations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(DonationMain.this, DisplayDonations.class);
                startActivity(in);
            }
        });
        campaigns = findViewById(R.id.viewCampaigns);
        donations = findViewById(R.id.donateNow);
        campaigns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(DonationMain.this, Campaigns.class);
                startActivity(in);
            }
        });
        donations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(DonationMain.this, DonationActivity.class);
                startActivity(in);
            }
        });
    }
}