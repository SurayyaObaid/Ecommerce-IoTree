package com.example.ecommerce_iotree;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DisplayPlant extends AppCompatActivity {


    LinearLayout productlayout;
    GridView gridView;
    RecyclerView recyclerView;
    List<Plant> newPlantlist;
    RecyclerView.Adapter adapter;
    //CustomAdapter customAdapeter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_plant);
        
        recyclerView = findViewById(R.id.recyclerView);
        productlayout = findViewById(R.id.productlayout);
        newPlantlist = new ArrayList<>();

        //gridView = findViewById(R.id.plantsGrid);
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl(JSONPlaceHolderApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JSONPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JSONPlaceHolderApi.class);
        Call<List<Plant>> call = jsonPlaceHolderApi.getAllPlants();
        call.enqueue(new Callback<List<Plant>>() {
            @Override
            public void onResponse(Call<List<Plant>> call, Response<List<Plant>> response) {
                List<Plant> plantList = response.body();

               /* for (Plant plantItem:plantList){
                    Log.d("lname", plantItem.getLocalName());
                    Log.d("bname", plantItem.getBotanicalName());
                    Log.d("price", plantItem.getPricePKR().toString());
                    plantList.add(plantItem);
                }*/
                PutData(plantList);

            }

            @Override
            public void onFailure(Call<List<Plant>> call, Throwable t) {

            }
        });

    }

    private void PutData(List<Plant> plantList) {
        ProductAdapter adapter= new ProductAdapter(this, plantList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

}