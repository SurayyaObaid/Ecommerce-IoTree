package com.example.ecommerce_iotree;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.logging.Level;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.ecommerce_iotree.JSONPlaceHolderApi.BASE_URL;

public class CartActivity extends AppCompatActivity {

    TextView idTV,uidTV;
    JSONPlaceHolderApi jsonPlaceHolderApi;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        //idTV = findViewById(R.id.idTV);
        //uidTV = findViewById(R.id.uidTV);
        Intent in= getIntent();
        Bundle desc = getIntent().getExtras();
        //String plant_id = desc.getString("Plant_ID");
        //String user_id = desc.getString("User_ID");
        //idTV.append("Plant ID: "+plant_id+ "\n User ID: "+user_id);
        //final String uid= MainActivity.sessionUser;
        //uidTV.append(uid);

        recyclerView = findViewById(R.id.cartRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
       // insertintoCart();
        getCart();
    }

    private void getCart() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://hibabintetariq.stig.pk/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        jsonPlaceHolderApi = retrofit.create(JSONPlaceHolderApi.class);
        final String uid= MainActivity.sessionUser;
        Call<List<CartModel>> call = jsonPlaceHolderApi.getCart(uid);
        call.enqueue(new Callback<List<CartModel>>() {
            @Override
            public void onResponse(Call<List<CartModel>> call, Response<List<CartModel>> response) {
                if (!response.isSuccessful()) {
                    idTV.setText("response isn't received");
                    return;
                }
                List<CartModel> cartModels = response.body();
                for (CartModel cartModel :cartModels) {
                    String content = "";
                    content += "Item ID:\t" + cartModel.getItem_ID() + "\n";
                    content += "User ID:\t" + cartModel.getUser_ID() + "\n";
                    String plantID = cartModel.getPlant_ID();
                    content += "Plant ID:\t" + cartModel.getPlant_ID() + "\n";
                    content += "Item Name:\t" + cartModel.getItem_name() + "\n";
                    content += "Item Quantity: \t" + cartModel.getItem_quantity() + "\n";
                    content += "Item Price:\t" + cartModel.getItem_price() + "\n";
                    content +=  "Imagepath: \t" + cartModel.getImage() + "\n";
                    //idTV.append(content);
                    recyclerView.setAdapter(new CartAdapter(CartActivity.this, cartModels));
                    //Log.d("content", content);
                    //Log.d("img-url", BASE_URL+cartModel.getImage());


                }


            }

            @Override
            public void onFailure(Call<List<CartModel>> call, Throwable t) {
                idTV.setText("Failed to get response");
            }
        });

    }
}