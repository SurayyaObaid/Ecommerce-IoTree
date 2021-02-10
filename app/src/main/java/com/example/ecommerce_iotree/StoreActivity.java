package com.example.ecommerce_iotree;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class StoreActivity extends AppCompatActivity {

    Button description1,description2,description3,description4,description5,description6,description7,description8;
    TextView title1,title2,title3,title4,title5,title6,title7,title8,price1,price2,price3,price4,price5,price6,price7,price8;
    ImageView image1,image2,image3,image4,image5,image6,image7,image8;
    ImageButton cartbtn, topaybtn, profilebtn;
    BottomNavigationView btmnav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        btmnav= findViewById(R.id.btmnav);
        btmnav.setSelectedItemId(R.id.shop);
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
        cartbtn = findViewById(R.id.cartbtn);
        topaybtn = findViewById(R.id.toPayButton);
        profilebtn = findViewById(R.id.profilebtn);

        cartbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(StoreActivity.this,CartActivity.class);
                startActivity(in);
            }
        });
        topaybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(StoreActivity.this,OrderActivity.class);
                startActivity(in);
            }
        });
        profilebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(StoreActivity.this,ProfileActivity.class);
                startActivity(in);
            }
        });
        title1 = findViewById(R.id.title1);
        price1 = findViewById(R.id.price1);
        image1 = findViewById(R.id.image1);

        title2 = findViewById(R.id.title2);
        price2 = findViewById(R.id.price2);
        image2 = findViewById(R.id.image2);

        title3 = findViewById(R.id.title3);
        price3 = findViewById(R.id.price3);
        image3 = findViewById(R.id.image3);

        title4 = findViewById(R.id.title4);
        price4 = findViewById(R.id.price4);
        image4 = findViewById(R.id.image4);

        title5 = findViewById(R.id.title5);
        price5 = findViewById(R.id.price5);
        image5 = findViewById(R.id.image5);

        title6 = findViewById(R.id.title6);
        price6 = findViewById(R.id.price6);
        image6 = findViewById(R.id.image6);

        title7 = findViewById(R.id.title7);
        price7 = findViewById(R.id.price7);
        image7 = findViewById(R.id.image7);

        title8 = findViewById(R.id.title8);
        price8 = findViewById(R.id.price8);
        image8 = findViewById(R.id.image8);



        description1 = findViewById(R.id.description1);
        description2 = findViewById(R.id.description2);
        description3 = findViewById(R.id.description3);
        description4 = findViewById(R.id.description4);
        description5 = findViewById(R.id.description5);
        description6 = findViewById(R.id.description6);
        description7 = findViewById(R.id.description7);
        description8 = findViewById(R.id.description8);
        description1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(StoreActivity.this,ProductDescriptionActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("title",title1.getText().toString());
                bundle.putString("price",price1.getText().toString());
                bundle.putString("Plant_ID","13");
                intent.putExtras(bundle);
                intent.putExtra("image",R.drawable.moneyplant);
                startActivity(intent);
            }
        });
        description2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(StoreActivity.this,ProductDescriptionActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("title",title2.getText().toString());
                bundle.putString("price",price2.getText().toString());
                bundle.putString("Plant_ID","1");
                intent.putExtras(bundle);
                intent.putExtra("image",R.drawable.aloevera);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        description3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(StoreActivity.this,ProductDescriptionActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("title",title3.getText().toString());
                bundle.putString("price",price3.getText().toString());
                bundle.putString("Plant_ID","4");
                intent.putExtras(bundle);
                intent.putExtra("image",R.drawable.chinesebanyan);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        description4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(StoreActivity.this,ProductDescriptionActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("title",title4.getText().toString());
                bundle.putString("price",price4.getText().toString());
                bundle.putString("Plant_ID","8");
                intent.putExtras(bundle);
                intent.putExtra("image",R.drawable.rubberfig);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        description5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(StoreActivity.this,ProductDescriptionActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("title",title5.getText().toString());
                bundle.putString("price",price5.getText().toString());
                bundle.putString("Plant_ID","7");
                intent.putExtras(bundle);
                intent.putExtra("image",R.drawable.birdofparadise);
                startActivity(intent);
            }
        });
        description6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(StoreActivity.this,ProductDescriptionActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("title",title6.getText().toString());
                bundle.putString("price",price6.getText().toString());
                bundle.putString("Plant_ID","3");
                intent.putExtras(bundle);
                intent.putExtra("image",R.drawable.arecapalm);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        description7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(StoreActivity.this,ProductDescriptionActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("title",title7.getText().toString());
                bundle.putString("price",price7.getText().toString());
                bundle.putString("Plant_ID","11");
                intent.putExtras(bundle);
                intent.putExtra("image",R.drawable.graftedcactus);
                startActivity(intent);
            }
        });
        description8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(StoreActivity.this,ProductDescriptionActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("title",title8.getText().toString());
                bundle.putString("price",price8.getText().toString());
                bundle.putString("Plant_ID","7");
                intent.putExtras(bundle);
                intent.putExtra("image",R.drawable.haworthia);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}