package com.example.ecommerce_iotree;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.ecommerce_iotree.Maintenance.PestGoals;
import com.example.ecommerce_iotree.Maintenance.WaterGoals;

public class SetGoalsActivity extends AppCompatActivity {
    CardView cardW, cardP, cardF, cardS, cardSun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_goals);
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