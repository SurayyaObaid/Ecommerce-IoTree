package com.example.ecommerce_iotree;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GardenerModel {
    //SELECT `GardenerID`, `gardenerName`, `gardenerService`, `gardenerNumber`, `gardenerAddress`, `serviceCharges` FROM `Gardeners`
    @SerializedName("GardenerID")
    @Expose
    private Integer GardenerID;

    @SerializedName("gardenerName")
    @Expose
    private String gardenerName;

    @SerializedName("gardenerService")
    @Expose
    private String gardenerService;

    @SerializedName("gardenerNumber")
    @Expose
    private String gardenerNumber;

    @SerializedName("serviceCharges")
    @Expose
    private String serviceCharges;

    @SerializedName("gardenerAddress")
    @Expose
    private String gardenerAddress;

    public Integer getGardenerID() {
        return GardenerID;
    }

    public void setGardenerID(Integer gardenerID) {
        GardenerID = gardenerID;
    }

    public String getGardenerName() {
        return gardenerName;
    }

    public void setGardenerName(String gardenerName) {
        this.gardenerName = gardenerName;
    }

    public String getGardenerService() {
        return gardenerService;
    }

    public void setGardenerService(String gardenerService) {
        this.gardenerService = gardenerService;
    }

    public String getGardenerNumber() {
        return gardenerNumber;
    }

    public void setGardenerNumber(String gardenerNumber) {
        this.gardenerNumber = gardenerNumber;
    }

    public String getServiceCharges() {
        return serviceCharges;
    }

    public void setServiceCharges(String serviceCharges) {
        this.serviceCharges = serviceCharges;
    }

    public String getGardenerAddress() {
        return gardenerAddress;
    }

    public void setGardenerAddress(String gardenerAddress) {
        this.gardenerAddress = gardenerAddress;
    }
}
