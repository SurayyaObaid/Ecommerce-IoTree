package com.example.ecommerce_iotree;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class DonationActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    BottomNavigationView btmnav;
    Spinner treesCount;
    String treeCount, dUserName, nic, address, contact,donUserID;
    String city, country, locality;
    ImageButton locationBtn;
    Button accesssloc;
    EditText donName, cnic, locationTextfield, contactNum;
    FusedLocationProviderClient fusedLocationProviderClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation);
        donName = findViewById(R.id.donusername);
        cnic = findViewById(R.id.donnic);
        locationTextfield = findViewById(R.id.donLocation);
        locationBtn = findViewById(R.id.donLocationButton);
        accesssloc = findViewById(R.id.donateBtn);
        contactNum = findViewById(R.id.donnum);

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        accesssloc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ActivityCompat.checkSelfPermission(DonationActivity.this,
                        Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    //getDonorLocation();
                } else {
                    ActivityCompat.requestPermissions(DonationActivity.this,
                            new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
                }
                insertDonationRequest();
            }

        });

        treesCount = findViewById(R.id.treeSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.trees, R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        treesCount.setAdapter(adapter);
        treesCount.setOnItemSelectedListener(this);
        btmnav = findViewById(R.id.btmnav);
        btmnav.setSelectedItemId(R.id.donationActivity);
        btmnav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.predict:
                        startActivity(new Intent(getApplicationContext(), PredictionActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.gardener:
                        startActivity(new Intent(getApplicationContext(), GardenerActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.shop:
                        startActivity(new Intent(getApplicationContext(), StoreActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.donationActivity:
                        startActivity(new Intent(getApplicationContext(), DonationActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                }
                return false;
            }
        });

    }



    /*private void getDonorLocation() {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {
                Location location = task.getResult();
                if (location != null) {

                    try {
                        Geocoder geocoder = new Geocoder(DonationActivity.this,
                                Locale.getDefault());
                        List<Address> address = geocoder.getFromLocation(location.getLatitude(),
                                location.getLongitude(), 1);
                        country = address.get(0).getCountryName();
                        locality = address.get(0).getLocality();

                        Toast.makeText(DonationActivity.this,country,Toast.LENGTH_LONG).show();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }*/

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        //Toast.makeText(this,adapterView.getSelectedItem().toString(), Toast.LENGTH_LONG).show();
        treeCount = adapterView.getSelectedItem().toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(this,"Select Tree Count", Toast.LENGTH_LONG).show();
    }
    private void insertDonationRequest() {
        if(donName.getText().toString().matches("")|| cnic.getText().toString().matches("")
                || locationTextfield.getText().toString().matches("")|| contactNum.getText().toString().matches("")){
            Toast.makeText(DonationActivity.this,"Empty Fields",Toast.LENGTH_LONG).show();
        }
        else {
            //treeCount = ;
            dUserName = donName.getText().toString();
            if (donName.getText().toString().matches("")){
                dUserName = MainActivity.sessionUserName;
            }
            donUserID = MainActivity.sessionUser;
            nic = cnic.getText().toString();
            address= locationTextfield.getText().toString();
            contact = contactNum.getText().toString();
            Log.d("donation",dUserName+"\n"+nic+"\n"+address+"\n"+contact+"\ntreecount"+treeCount);
        }



        String url = "http://hibabintetariq.stig.pk/insertDonation.php";
        final StringRequest sr = new StringRequest(1, url,
                new com.android.volley.Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(DonationActivity.this, response,
                                Toast.LENGTH_SHORT).show();

                        Intent in = new Intent(DonationActivity.this, OrderSuccess.class);
                        startActivity(in);
                    }

                }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(DonationActivity.this, error.getMessage(),Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("user_ID" , donUserID);
                map.put("nic_Number" , nic);
                map.put("user_Name" , dUserName);
                map.put("numOfTrees", treeCount);
                map.put("contact", contact);
                return map;
            }
        };

        RequestQueue rq = Volley.newRequestQueue(DonationActivity.this);
        rq.add(sr);


    }
}