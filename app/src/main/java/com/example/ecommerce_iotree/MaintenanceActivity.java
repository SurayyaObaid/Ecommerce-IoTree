package com.example.ecommerce_iotree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MaintenanceActivity extends AppCompatActivity {
    Button mBuySeeds;

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

    }
}