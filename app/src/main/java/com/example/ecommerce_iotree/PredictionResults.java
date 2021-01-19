package com.example.ecommerce_iotree;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.ecommerce_iotree.JSONPlaceHolderApi.BASE_URL;

public class PredictionResults extends AppCompatActivity {
    TextView tValue;
    String tempValue;
    JSONPlaceHolderApi jsonPlaceHolderApi;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prediction_results);
        tValue = findViewById(R.id.tValue);
        Intent in= getIntent();
        Bundle desc = getIntent().getExtras();
        tempValue = desc.getString("Temperature");
        //tValue.append(tempValue);
        recyclerView = findViewById(R.id.predictionRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        loadPrediction();
    }

    private void loadPrediction() {
        //Loading data in textview
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://hibabintetariq.stig.pk/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        jsonPlaceHolderApi = retrofit.create(JSONPlaceHolderApi.class);
        Call<List<Plant>> call = jsonPlaceHolderApi.loadPrediction(tempValue);
        call.enqueue(new Callback<List<Plant>>() {
            @Override
            public void onResponse(Call<List<Plant>> call, Response<List<Plant>> response) {
                if (!response.isSuccessful()) {
                    tValue.setText("response isn't received");
                    return;
                }
                List<Plant> plants = response.body();
                for (Plant plant :plants) {
                    String content = "";
                    content  += plant.getBotanicalName();
                    content += plant.getLocalName();
                    content += plant.getPricePKR().toString();
                    content += "ID:\t" + plant.getPlantID() + "\n";
                    content += "Flowering Time:\t" + plant.getFlowering_time() + "\n";
                    content += "Family:\t" + plant.getFamily() + "\n";
                    content += "Spread in meters:\t" + plant.getSpread_in_metres() + "\n";
                    content += "Known Hazards:\t" + plant.getKnown_hazards() + "\n";
                    content += "Habitat:\t" + plant.getHabitat() + "\n";
                    content += "Soil:\t" + plant.getSoil() + "\n";
                    //content += "Maximum Temperature:\t" + plant.getTemperature().toString() + "\n" + "\n" + "\n";
                    tValue.append(content);
                    //recyclerView.setAdapter(new PredictionAdapter(PredictionResults.this,plants));

                }


            }

            @Override
            public void onFailure(Call<List<Plant>> call, Throwable t) {
                tValue.setText("Failed to get response");
            }
        });
    }


}