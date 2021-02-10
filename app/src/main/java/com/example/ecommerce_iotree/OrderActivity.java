package com.example.ecommerce_iotree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class OrderActivity extends AppCompatActivity {
    String uid, iid, iname, iprice, iquantity, uname, addressText, numberText;
    EditText userName, address, phoneNumber;
    TextView orderDetails;
    Button ordersuccess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        orderDetails = findViewById(R.id.orderDetails);
        userName = findViewById(R.id.orUserName);
        address = findViewById(R.id.orAddress);
        phoneNumber = findViewById(R.id.orMobile);
        addressText = address.getText().toString();
        numberText = phoneNumber.getText().toString();
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        iid = bundle.getString("ItemID");
        iname = bundle.getString("ItemName");
        iprice = bundle.getString("ItemPrice");
        Integer iquantity = bundle.getInt("ItemQuantity");
        uid = bundle.getString("UserID");
        uname = bundle.getString("UserName");
        Log.d("final",uid +"\n"+ iid+"\n"+ iname+"\n"+ iprice+"\n"+ iquantity+"\n"+ uname);
        orderDetails.setText("Plant Name: " +iname + "\nPrice: "+ iprice +"\nQuantity: "+ iquantity + "\nItem ID: "+iid);
        ordersuccess = findViewById(R.id.orderSuccess);
        ordersuccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmOrder();
                Intent in = new Intent(OrderActivity.this,OrderSuccess.class);
                startActivity(in);
            }
        });

    }

    private void confirmOrder() {
        if(userName.getText().toString().matches("") || address.getText().toString().matches("") || numberText.matches("")  )
        {
            Toast.makeText(OrderActivity.this,"Empty Fields",Toast.LENGTH_LONG).show();
        }
        String url = "http://hibabintetariq.stig.pk/confirmOrder.php";
        StringRequest sr = new StringRequest(1, url,
                new com.android.volley.Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(OrderActivity.this, response,
                                Toast.LENGTH_SHORT).show();

                        Intent in = new Intent(OrderActivity.this, OrderSuccess.class);
                        startActivity(in);
                    }

                }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                    Toast.makeText(OrderActivity.this, error.getMessage(),Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                /*
                $itemid = $_POST["Item_ID"];
$pid = $_POST["Plant_ID"];
$uid = $_POST["User_ID"];
$item_name = $_POST["Item_name"];
$item_quantity = $POST_['Item_quantity'];
$usname = $_POST['User_name'];
$item_price = $_POST['Item_price'];
$address = mysqli_real_escape_string($db,$_POST['address']);
$mobile = mysqli_real_escape_string($db,$_POST['mobile']);
$otime = mysqli_real_escape_string($db,date("Y-m-d"));
$etime = mysqli_real_escape_string($db,date("Y-m-d", strtotime("+7 day")));
                 */
                Map<String, String> map = new HashMap<>();
                map.put("Item_ID" , iid);
                map.put("User_ID" , uid);
                map.put("Item_name" , iname);
                map.put("Item_price", iprice);
               // map.put("Item_quantity", "1");
                map.put("mobile", numberText);
                map.put("address", addressText);
                //Log.d("Values: ",pid + "\n" + user_ID + "\n" + proNameText +"\n" + proNameText +"\n" +iQuantity);
                return map;
            }
        };

        RequestQueue rq = Volley.newRequestQueue(OrderActivity.this);
        rq.add(sr);


    }
    }
