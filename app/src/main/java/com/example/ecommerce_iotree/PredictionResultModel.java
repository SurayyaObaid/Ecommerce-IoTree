package com.example.ecommerce_iotree;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PredictionResultModel {
    @SerializedName("Plant_ID")
    @Expose
    private Integer plantID;

    @SerializedName("Botanical_name")
    @Expose private String botanicalName;

    @SerializedName("Local_name")
    @Expose private String localName;

    @SerializedName("Flowering_time")
    @Expose private String Flowering_time;

    @SerializedName("family")
    @Expose private String family;

    @SerializedName("spread_in_metres(in)")
    @Expose private String spread_in_metres;

    @SerializedName("Known_hazards")
    @Expose private String Known_hazards;

    @SerializedName("Habitat")
    @Expose private String Habitat;

    @SerializedName("Soil")
    @Expose private String Soil;

    @SerializedName("Sunlight")
    @Expose private String Sunlight;

    @SerializedName("Water")
    @Expose private String Water;

    @SerializedName("Temperature")
    @Expose private String Temperature;

    @SerializedName("pollution_removal_per_year_in_grams")
    @Expose private String pollution_removal_per_year_in_grams;

    @SerializedName("image")
    @Expose private String image;

    @SerializedName("price(PKR)")
    @Expose private Integer pricePKR;

    public String getFlowering_time() {
        return Flowering_time;
    }

    public void setFlowering_time(String flowering_time) {
        Flowering_time = flowering_time;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getSpread_in_metres() {
        return spread_in_metres;
    }

    public void setSpread_in_metres(String spread_in_metres) {
        this.spread_in_metres = spread_in_metres;
    }

    public String getKnown_hazards() {
        return Known_hazards;
    }

    public void setKnown_hazards(String known_hazards) {
        Known_hazards = known_hazards;
    }

    public String getHabitat() {
        return Habitat;
    }

    public void setHabitat(String habitat) {
        Habitat = habitat;
    }

    public String getSoil() {
        return Soil;
    }

    public void setSoil(String soil) {
        Soil = soil;
    }

    public String getSunlight() {
        return Sunlight;
    }

    public void setSunlight(String sunlight) {
        Sunlight = sunlight;
    }

    public String getWater() {
        return Water;
    }

    public void setWater(String water) {
        Water = water;
    }

    public String getTemperature() {
        return Temperature;
    }

    public void setTemperature(String temperature) {
        Temperature = temperature;
    }

    public String getPollution_removal_per_year_in_grams() {
        return pollution_removal_per_year_in_grams;
    }

    public void setPollution_removal_per_year_in_grams(String pollution_removal_per_year_in_grams) {
        this.pollution_removal_per_year_in_grams = pollution_removal_per_year_in_grams;
    }

    public Integer getPlantID() {
        return plantID;
    }

    public void setPlantID(Integer plantID) {
        this.plantID = plantID;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public String getBotanicalName() {
        return botanicalName;
    }

    public void setBotanicalName(String botanicalName) {
        this.botanicalName = botanicalName;
    }

    public Integer getPricePKR() {
        return pricePKR;
    }

    public void setPricePKR(Integer pricePKR) {
        this.pricePKR = pricePKR;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
