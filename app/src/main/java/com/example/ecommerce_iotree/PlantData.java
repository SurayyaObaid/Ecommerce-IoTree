package com.example.ecommerce_iotree;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class PlantData {
    String PlantLocalName, PlantBotName, PlantPrice, PlantImage, PlantTemperature;
    String plantID="";

    public void retrieveData(String plantID){
    Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://hibabintetariq.stig.pk/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();
    JSONPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JSONPlaceHolderApi.class);
    Call<List<Plant>> call = jsonPlaceHolderApi.getPlants(plantID);
        call.enqueue(new Callback<List<Plant>>() {
        @Override
        public void onResponse(Call<List<Plant>> call, Response<List<Plant>> response) {
            if (!response.isSuccessful()) {
                return;
            }
            List<Plant> plants = response.body();
            for (Plant plant :plants) {
                PlantBotName = plant.getBotanicalName();
                PlantLocalName = plant.getLocalName();
                PlantPrice = plant.getPricePKR().toString();
                PlantTemperature = plant.getTemperature();
                Log.d("Data1","Name:\n" + PlantLocalName + "Bot:\n" + PlantBotName+ "Price: " +PlantPrice);
            }
        }
        @Override
        public void onFailure(Call<List<Plant>> call, Throwable t) {
        }
    });
    }
    public String getPlantBotName(){
        return PlantBotName;
    };
    public String getPlantPrice(){
        return PlantPrice;
    };
    public String getPlantImage(){

        if (plantID == "1"){
            PlantImage = "p1";
        }
        else if (plantID == "3"){
            PlantImage = "p3";
        }
        else if (plantID == "4"){
            PlantImage = "p4";
        }
        else if (plantID == "5"){
            PlantImage = "p5";
        }
        else if (plantID == "6"){
            PlantImage = "p6";
        }
        else if (plantID == "7"){
            PlantImage = "p7";
        }
        else if (plantID == "8"){
            PlantImage = "p8";
        }
        else if (plantID == "11"){
            PlantImage = "p11";
        }
        else if (plantID == "13"){
            PlantImage = "p13";
        }

        return PlantImage;
    };
    public String getPlantTemperature(){
        return PlantTemperature;
    };
    void CheckData(String plantID){
        retrieveData("1");
        Log.d("Data","Name:\n" + PlantLocalName + "Bot:\n" + PlantBotName);
    }
}
