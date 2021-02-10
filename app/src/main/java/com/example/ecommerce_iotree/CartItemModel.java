package com.example.ecommerce_iotree;

import android.content.Intent;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CartItemModel {@Expose
@SerializedName("Item_ID")
private String Item_ID;

    @Expose
    @SerializedName("Plant_ID")
    private String Plant_ID;

    @Expose
    @SerializedName("User_ID")
    private String User_ID;

    @Expose
    @SerializedName("Item_name")
    private String Item_name;

    @Expose
    @SerializedName("Item_quantity")
    private String Item_quantity;

    @Expose
    @SerializedName("item_price")
    private Integer item_price;

    @Expose
    @SerializedName("image")
    private String image;

    public String getItem_ID() {
        return Item_ID;
    }

    public void setItem_ID(String item_ID) {
        Item_ID = item_ID;
    }

    public String getPlant_ID() {
        return Plant_ID;
    }

    public void setPlant_ID(String plant_ID) {
        Plant_ID = plant_ID;
    }

    public String getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(String user_ID) {
        User_ID = user_ID;
    }

    public String getItem_name() {
        return Item_name;
    }

    public void setItem_name(String item_name) {
        Item_name = item_name;
    }

    public String getItem_quantity() {
        return Item_quantity;
    }

    public void setItem_quantity(String item_quantity) {
        Item_quantity = item_quantity;
    }

    public Integer getItem_price() {
        return item_price;
    }

    public void setItem_price(Integer item_price) {
        this.item_price = item_price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}