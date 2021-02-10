package com.example.ecommerce_iotree;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONException;
import org.json.JSONObject;

import static java.lang.String.valueOf;


public class PredictionActivity extends AppCompatActivity {
    TextView aqTextValue, pmTextValue, tempTextValue, humidityTextValue;
    ImageButton pred_home;
    Button resultbtn;
    String temperatureValue;
    ImageButton imageButton, profileButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prediction);
        imageButton = findViewById(R.id.logoutbtn);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.sessionUser = null;
                Intent in = new Intent(PredictionActivity.this, MainActivity.class);
                startActivity(in);
            }
        });
        profileButton = findViewById(R.id.profile);
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.sessionUser = null;
                Intent in = new Intent(PredictionActivity.this, UserProfileActivity.class);
                startActivity(in);
            }
        });
        aqTextValue = findViewById(R.id.aqText);
        pmTextValue = findViewById(R.id.pmText);
        tempTextValue = findViewById(R.id.tempText);
        humidityTextValue = findViewById(R.id.humidityText);
        resultbtn = findViewById(R.id.resultbtn);
        resultbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(PredictionActivity.this,PredictionResults.class);
                Bundle bundle = new Bundle();
                bundle.putString("Temperature",temperatureValue);
                in.putExtras(bundle);
                startActivity(in);
            }
        });
        BottomNavigationView btmnav= findViewById(R.id.btmnav);
        btmnav.setSelectedItemId(R.id.predict);
        btmnav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.predict:
                        startActivity(new Intent(getApplicationContext(),PredictionActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.gardener:
                        startActivity(new Intent(getApplicationContext(),GardenerActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.shop:
                        startActivity(new Intent(getApplicationContext(),StoreActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.donationActivity:
                        startActivity(new Intent(getApplicationContext(),DonationActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }
        });
//        pred_home = findViewById(R.id.pred_home);



        getAirQualityValues();
        getPMValue();
        getTempValue();
        getHumidityValue();


    }

    private void getTempValue() {
    }

    private void getHumidityValue() {
    }

    private void getPMValue() {
    }


    private void getAirQualityValues() {
        String pred_url = "https://api.waqi.info/feed/karachi/?token=69aba2265057bac952c44a6ecdd8d85205e66bf3";
        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, pred_url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject data_obj = response.getJSONObject("data");
                    //JSONObject aq_obj = data_obj.getJSONObject("aqi");
                    JSONObject iaqi_obj = data_obj.getJSONObject("iaqi");
                    JSONObject pm_obj = iaqi_obj.getJSONObject("pm25");
                    JSONObject h_obj = iaqi_obj.getJSONObject("h");
                    JSONObject temp_obj = iaqi_obj.getJSONObject("t");

                    //Log.d("aq",aq_obj.toString());
                    Log.d("pm",pm_obj.toString());
                    Log.d("h",h_obj.toString());
                    Log.d("t",temp_obj.toString());

                    String aq, pm, temp, humidity;

                    pm = pm_obj.getString("v");
                    Log.d("pm",pm);
                    pmTextValue.setText(pm);

                    aq =valueOf(data_obj.getDouble("aqi"));
                    aqTextValue.setText(aq);

                    temp = temp_obj.getString("v");
                    tempTextValue.setText(temp);
                    temperatureValue = temp;

                    humidity = h_obj.getString("v");
                    humidityTextValue.setText(humidity);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(jor);
    }
}