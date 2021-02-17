package com.example.ecommerce_iotree;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GardenerList extends AppCompatActivity {
    RecyclerView gardenerRecycler;
    Button gtoHome;
    JSONPlaceHolderApi jsonPlaceHolderApi;
    String gardenerService = "", gName, gAddress, gPhone, gCharges, gid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gardener_list);
        gardenerRecycler = findViewById(R.id.gardenerRV);
        gardenerRecycler.setLayoutManager(new LinearLayoutManager(this));
        Intent in = getIntent();
        gardenerService = in.getStringExtra("gardenerService");
        getGardener();
    }
    private void getGardener() {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://hibabintetariq.stig.pk/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        jsonPlaceHolderApi = retrofit.create(JSONPlaceHolderApi.class);
        Call<List<GardenerModel>> call = jsonPlaceHolderApi.getGardener(gardenerService);
        call.enqueue(new Callback<List<GardenerModel>>() {
            @Override
            public void onResponse(Call<List<GardenerModel>> call, Response<List<GardenerModel>> response) {
                if (!response.isSuccessful()) {
                    //textView.setText("response isn't received");
                    return;
                }
                List<GardenerModel> gardenerModels = response.body();
                for (GardenerModel gardenerModel :gardenerModels) {
                    gName = gardenerModel.getGardenerName();
                    //gAddress = gardenerModel.getGardenerAddress();
                    gPhone = gardenerModel.getGardenerNumber();
                    gCharges = gardenerModel.getServiceCharges();

                    String content = "";
                    content += "ID:\t" + gardenerModel.getGardenerID() + "\n";
                    content += "Name:\t" + gName + "\n";
                    //content += "Address:\t" + gAddress + "\n";
                    content += "Phone:\t" + gPhone + "\n";
                    //content += "Charges:\t" + gCharges + "\n";

                    Log.d("gardener",content);
                    gardenerRecycler.setAdapter(new GardenerAdapter(GardenerList.this, gardenerModels));

                }


            }

            @Override
            public void onFailure(Call<List<GardenerModel>> call, Throwable t) {
                Toast.makeText(GardenerList.this,"onFailure",Toast.LENGTH_LONG).show();
            }
        });

    }
}