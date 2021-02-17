package com.example.ecommerce_iotree;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DisplayOrderPlaced extends AppCompatActivity {
    JSONPlaceHolderApi jsonPlaceHolderApi;
    RecyclerView approvedOrderRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_order_placed);
        approvedOrderRecyclerView = findViewById(R.id.orderRV);
        getApprovedOrders();
    }

    private void getApprovedOrders() {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://hibabintetariq.stig.pk/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        jsonPlaceHolderApi = retrofit.create(JSONPlaceHolderApi.class);
        //final String User_name= MainActivity.sessionUserName;
        final String User_name = "Surayya Obaid";
        Call<List<ApprovedOrderModel>> call = jsonPlaceHolderApi.getApprovedOrders(User_name);
        call.enqueue(new Callback<List<ApprovedOrderModel>>() {
            @Override
            public void onResponse(Call<List<ApprovedOrderModel>> call, Response<List<ApprovedOrderModel>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(DisplayOrderPlaced.this, "response isn't received",Toast.LENGTH_LONG).show();
                    return;
                }
                List<ApprovedOrderModel> approvedOrderModels = response.body();
                for (ApprovedOrderModel approvedOrderModel :approvedOrderModels) {
                    String content = "";
                    /*
                    String orderID = approvedOrderModel.getOrderID().toString();
                    holder.orName.setText(approvedOrderModel.getItemName());
                    holder.orPrice.setText(approvedOrderModel.getItemPrice());
                    holder.orDate.setText(approvedOrderModel.getDateOrdered());
                    holder.orArrival.setText(approvedOrderModel.getExpectedArrival());
                    holder.orAddress.setText(approvedOrderModel.getAddress());
                    holder.orMobile.setText(approvedOrderModel.getMobile());
                    */
                    content += "Item ID:\t" + approvedOrderModel.getOrderID().toString() + "\n";
                    content += "User ID:\t" + approvedOrderModel.getItemName() + "\n";
                    String plantID = approvedOrderModel.getItemPrice().toString();
                    content += "Plant ID:\t" + approvedOrderModel.getDateOrdered() + "\n";
                    content += "Item Name:\t" + approvedOrderModel.getExpectedArrival() + "\n";
                    content += "Item Quantity: \t" + approvedOrderModel.getAddress() + "\n";
                    content += "Item Price:\t" + approvedOrderModel.getMobile() + "\n";
                    approvedOrderRecyclerView.setAdapter(new ApprovedOrderAdapter(DisplayOrderPlaced.this, approvedOrderModels));
                    Log.d("content", content);
                    //Log.d("img-url", BASE_URL+cartModel.getImage());


                }


            }

            @Override
            public void onFailure(Call<List<ApprovedOrderModel>> call, Throwable t) {
                Toast.makeText(DisplayOrderPlaced.this, "Failed to get Response",Toast.LENGTH_LONG).show();

            }
        });

    }
}