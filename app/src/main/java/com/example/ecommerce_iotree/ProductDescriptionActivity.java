package com.example.ecommerce_iotree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductDescriptionActivity extends AppCompatActivity {

    JSONPlaceHolderApi jsonPlaceHolderApi;
    TextView textView, protitle, proName, proPrice;
    EditText proQuantity;
    ImageView image;
    String pid;
    String protitletext ="", proNameText = "", proPriceText = "", proQuantityText = "";
    String rprice, rname;
    Button addprotocart;
    String quantityText ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_description);
        textView = findViewById(R.id.ProductDescriptionTV);
        image = findViewById(R.id.proimg);
        addprotocart = findViewById(R.id.addprotocart);
        protitle = findViewById(R.id.protitle);
        proName = findViewById(R.id.localName);
        proPrice = findViewById(R.id.proprice);
        proQuantity = findViewById(R.id.quantity);

        proQuantityText = proQuantity.getText().toString();
        Log.d("Q Values: ",quantityText);

        //inserting data in cart table
        addprotocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("Plant_ID",pid);
                UserModel userModel = new UserModel();
                String userID= MainActivity.sessionUser;
                bundle.putString("User_ID", userID);
                insertProductIntoCart();
                Intent in = new Intent(ProductDescriptionActivity.this, CartActivity.class);
                in.putExtras(bundle);
                startActivity(in);
            }
        });


        Intent in= getIntent();
        Bundle desc = getIntent().getExtras();
        pid = desc.getString("Plant_ID");
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int resId = bundle.getInt("image");
            image.setImageResource(resId);

        }
        getPlants();
    }

    private void insertProductIntoCart() {
        String url = "http://hibabintetariq.stig.pk/insertintocart.php";
        StringRequest sr = new StringRequest(1, url,
                new com.android.volley.Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(ProductDescriptionActivity.this, response,
                                Toast.LENGTH_SHORT).show();

                        Intent in = new Intent(ProductDescriptionActivity.this, CartActivity.class);
                        startActivity(in);
                    }

                }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Plant plant = new Plant();
                UserModel userModel = new UserModel();
                String plant_ID, user_ID, iName, iPrice, iQuantity, image;
                //plant_ID = plant.getPlantID().toString();
                user_ID = MainActivity.sessionUser;
                //iName = plant.getLocalName();
                //iPrice = plant.getPricePKR().toString();
                iQuantity = proQuantity.getText().toString();
                Log.d("Values: ",iQuantity);
                Map<String, String> map = new HashMap<>();
                map.put("Plant_ID" , pid);
                map.put("User_ID" , user_ID);
                map.put("Item_name" , proNameText);
                map.put("Item_price", proPriceText);
                map.put("Item_quantity", iQuantity);
                Log.d("Values: ",pid + "\n" + user_ID + "\n" + proNameText +"\n" + proNameText +"\n" +iQuantity);
                return map;
            }
        };

        RequestQueue rq = Volley.newRequestQueue(ProductDescriptionActivity.this);
        rq.add(sr);


    }

    private void getPlants(){

        //Loading data in textview
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://hibabintetariq.stig.pk/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        int plantid= 1;
        jsonPlaceHolderApi = retrofit.create(JSONPlaceHolderApi.class);
        Call<List<Plant>> call = jsonPlaceHolderApi.getPlants(pid);
        call.enqueue(new Callback<List<Plant>>() {
            @Override
            public void onResponse(Call<List<Plant>> call, Response<List<Plant>> response) {
                if (!response.isSuccessful()) {
                    textView.setText("response isn't received");
                    return;
                }
                List<Plant> plants = response.body();
                for (Plant plant :plants) {
                    protitletext = plant.getBotanicalName();
                    proNameText = plant.getLocalName();
                    proPriceText = plant.getPricePKR().toString();

                    String content = "";
                    content += "ID:\t" + plant.getPlantID() + "\n";
                    content += "Flowering Time:\t" + plant.getFlowering_time() + "\n";
                    content += "Family:\t" + plant.getFamily() + "\n";
                    content += "Spread in meters:\t" + plant.getSpread_in_metres() + "\n";
                    content += "Known Hazards:\t" + plant.getKnown_hazards() + "\n";
                    content += "Habitat:\t" + plant.getHabitat() + "\n";
                    content += "Soil:\t" + plant.getSoil() + "\n";
                    content += "Maximum Temperature:\t" + plant.getTemperature() + "\n";
                    textView.append(content);
                    protitle.append(protitletext);
                    proPrice.append(proPriceText);
                    proName.append(proNameText);

                }


            }

            @Override
            public void onFailure(Call<List<Plant>> call, Throwable t) {
                textView.setText("Failed to get response");
            }
        });








    }
}