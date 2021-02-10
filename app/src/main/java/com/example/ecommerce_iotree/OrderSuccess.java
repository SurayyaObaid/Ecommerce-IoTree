package com.example.ecommerce_iotree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class OrderSuccess extends AppCompatActivity {
    ImageView anim;
    Button toHome;
    BottomNavigationView btmnav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_success);
        anim = findViewById(R.id.ordersuccessanim);
        anim.setBackgroundResource(R.drawable.success);
        final AnimationDrawable animationDrawable;
        animationDrawable = (AnimationDrawable)anim.getBackground();
        animationDrawable.start();
        toHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(OrderSuccess.this,HomeActivity.class);
                startActivity(in);
            }
        });
    }
}