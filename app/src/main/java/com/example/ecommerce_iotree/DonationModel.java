package com.example.ecommerce_iotree;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DonationModel {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("donationID")
    @Expose
    private Integer donationID;
    @SerializedName("user_ID")
    @Expose
    private String userID;
    @SerializedName("nic_Number")
    @Expose
    private String nicNumber;
    @SerializedName("user_Name")
    @Expose
    private String userName;
    @SerializedName("numOfTrees")
    @Expose
    private Integer numOfTrees;
    @SerializedName("amount")
    @Expose
    private Integer amount;
    @SerializedName("contact")
    @Expose
    private String contact;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getDonationID() {
        return donationID;
    }

    public void setDonationID(Integer donationID) {
        this.donationID = donationID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getNicNumber() {
        return nicNumber;
    }

    public void setNicNumber(String nicNumber) {
        this.nicNumber = nicNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getNumOfTrees() {
        return numOfTrees;
    }

    public void setNumOfTrees(Integer numOfTrees) {
        this.numOfTrees = numOfTrees;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

}