package com.example.ecommerce_iotree;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class HomeActivity extends AppCompatActivity {
    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        imageButton = findViewById(R.id.logoutbtn);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.sessionUser = null;
                Intent in = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(in);
            }
        });
        CardView prediction= findViewById(R.id.first_menu);
        prediction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(HomeActivity.this,PredictionActivity.class);
                startActivity(i);
            }
        });
        CardView gardener= findViewById(R.id.second_menu);
        gardener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(HomeActivity.this,GardenerActivity.class);
                startActivity(i);
            }
        });
        CardView donate= findViewById(R.id.forth_menu);
        donate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(HomeActivity.this,DonationActivity.class);
                startActivity(i);
            }
        });
        CardView buy= findViewById(R.id.third_menu);
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(HomeActivity.this,StoreActivity.class);
                startActivity(i);
            }
        });
        CardView maintenance= findViewById(R.id.fifth_menu);
        maintenance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(HomeActivity.this,MaintenanceActivity.class);
                startActivity(i);
            }
        });
    }
}