package com.example.ecommerce_iotree;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApprovedOrderModel {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("Order_ID")
    @Expose
    private Integer orderID;
    @SerializedName("Item_ID")
    @Expose
    private Integer itemID;
    @SerializedName("Item_name")
    @Expose
    private String itemName;
    @SerializedName("Item_quantity")
    @Expose
    private Integer itemQuantity;
    @SerializedName("Item_price")
    @Expose
    private Integer itemPrice;
    @SerializedName("Date_ordered")
    @Expose
    private String dateOrdered;
    @SerializedName("Expected_Arrival")
    @Expose
    private String expectedArrival;
    @SerializedName("Address")
    @Expose
    private String address;
    @SerializedName("mobile")
    @Expose
    private String mobile;
    @SerializedName("User_name")
    @Expose
    private String userName;
    @SerializedName("Total")
    @Expose
    private Integer total;
    @SerializedName("Product_type")
    @Expose
    private String productType;
    @SerializedName("Admin_approved")
    @Expose
    private Integer adminApproved;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public Integer getItemID() {
        return itemID;
    }

    public void setItemID(Integer itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(Integer itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public Integer getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Integer itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getDateOrdered() {
        return dateOrdered;
    }

    public void setDateOrdered(String dateOrdered) {
        this.dateOrdered = dateOrdered;
    }

    public String getExpectedArrival() {
        return expectedArrival;
    }

    public void setExpectedArrival(String expectedArrival) {
        this.expectedArrival = expectedArrival;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Integer getAdminApproved() {
        return adminApproved;
    }

    public void setAdminApproved(Integer adminApproved) {
        this.adminApproved = adminApproved;
    }

}