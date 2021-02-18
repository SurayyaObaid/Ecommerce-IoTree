package com.example.ecommerce_iotree;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DisplayDonations extends AppCompatActivity {

    JSONPlaceHolderApi jsonPlaceHolderApi;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_donations);
        recyclerView = findViewById(R.id.donationRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getDonations();
    }

    private void getDonations() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://hibabintetariq.stig.pk/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        jsonPlaceHolderApi = retrofit.create(JSONPlaceHolderApi.class);
        final String uid= MainActivity.sessionUser;
        Call<List<DonationModel>> call = jsonPlaceHolderApi.getDonations(uid);
        Log.d("donor",uid);
        call.enqueue(new Callback<List<DonationModel>>() {
            @Override
            public void onResponse(Call<List<DonationModel>> call, Response<List<DonationModel>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(DisplayDonations.this,"Response isn't received",Toast.LENGTH_LONG).show();
                    return;
                }
                List<DonationModel> donationModels = response.body();
                for (DonationModel donationModel :donationModels) {
                    String did = donationModel.getUserID();
                    String uname = donationModel.getUserName();
                    String amount = donationModel.getAmount().toString();
                    String contact = donationModel.getContact();
                    Log.d("donation params", did +"\n" + uname + "\n" + amount + "\n" + contact);
                    recyclerView.setAdapter(new DonationAdapter(DisplayDonations.this, donationModels));
                }
            }

            @Override
            public void onFailure(Call<List<DonationModel>> call, Throwable t) {
                Toast.makeText(DisplayDonations.this,"Failed to get response",Toast.LENGTH_LONG).show();
            }
        });

    }
}