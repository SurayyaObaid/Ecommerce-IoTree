package com.example.ecommerce_iotree;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
    RecyclerView predictioRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prediction_results);
        tValue = findViewById(R.id.tValue);
        Intent in= getIntent();
        Bundle desc = getIntent().getExtras();
        tempValue = desc.getString("Temperature");
        //tValue.append(tempValue);
        predictioRecyclerView = findViewById(R.id.predictionRecycler);
        predictioRecyclerView.setLayoutManager(new LinearLayoutManager(this));
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
        Call<List<PredictionResultModel>> call = jsonPlaceHolderApi.loadPrediction(tempValue);
        call.enqueue(new Callback<List<PredictionResultModel>>() {
            @Override
            public void onResponse(Call<List<PredictionResultModel>> call, Response<List<PredictionResultModel>> response) {
                if (!response.isSuccessful()) {
                    tValue.setText("response isn't received");
                    return;
                }
                List<PredictionResultModel> predictionResultModels = response.body();
                for (PredictionResultModel predictionResultModel :predictionResultModels) {
                    String content = "";
                    content  += predictionResultModel.getBotanicalName();
                    content += predictionResultModel.getLocalName();
                    content += predictionResultModel.getPricePKR().toString();
                    content += "ID:\t" + predictionResultModel.getPlantID() + "\n";
                    content += "Flowering Time:\t" + predictionResultModel.getFlowering_time() + "\n";
                    content += "Family:\t" + predictionResultModel.getFamily() + "\n";
                    content += "Spread in meters:\t" + predictionResultModel.getSpread_in_metres() + "\n";
                    content += "Known Hazards:\t" + predictionResultModel.getKnown_hazards() + "\n";
                    content += "Habitat:\t" + predictionResultModel.getHabitat() + "\n";
                    content += "Soil:\t" + predictionResultModel.getSoil() + "\n";
                    //content += "Maximum Temperature:\t" + predictionResultModel.getTemperature().toString() + "\n" + "\n" + "\n";
                    //tValue.append(content);
                    Log.d("prediction",content);
                    predictioRecyclerView.setAdapter(new PredictionAdapter(PredictionResults.this,predictionResultModels));

                }


            }

            @Override
            public void onFailure(Call<List<PredictionResultModel>> call, Throwable t) {
                tValue.setText("Failed to get response");
            }
        });
    }


}