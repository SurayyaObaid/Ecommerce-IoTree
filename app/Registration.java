package com.example.iotree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registration extends AppCompatActivity {
    EditText fname, lname, email, password;
    Button signup, login;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        fname =findViewById(R.id.fName);
        lname=findViewById(R.id.lName);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        signup=findViewById(R.id.MainActivityLink);
        textView = findViewById(R.id.textView);
        login = findViewById(R.id.login_Link);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Registration.this,LoginActivity.class);
                startActivity(in);
            }
        });


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                Pattern pattern;
                Matcher matcher;
                pattern = Pattern.compile(emailPattern);
                matcher = pattern.matcher(email.getText().toString());

                if (fname.getText().toString() == "" ||
                        lname.getText().toString() == "" ||
                        email.getText().toString() =="" ||
                        password.getText().toString() == ""){
                    Toast.makeText(Registration.this,"Empty field(s), please fill the form",
                            Toast.LENGTH_SHORT).show();}
                else if(password.getText().toString().length() <= 8){
                    Toast.makeText(Registration.this,"Weak password",
                            Toast.LENGTH_SHORT).show();
                }
                else if (!matcher.matches()){
                    Toast.makeText(Registration.this,"Invalid Email",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    String url = "http://hibabintetariq.stig.pk/register.php";
                    StringRequest sr = new StringRequest(1, url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    Toast.makeText(Registration.this, response,
                                            Toast.LENGTH_SHORT).show();
                                    fname.setText("");
                                    lname.setText("");
                                    email.setText("");
                                    password.setText("");
                                    Intent in = new Intent(Registration.this, MainActivity.class);
                                    Bundle bundle = new Bundle();
                                    bundle.putString("email",email.getText().toString());
                                    bundle.putString("password",password.getText().toString());
                                    in.putExtras(bundle);
                                    Log.d("emailc",email.getText().toString());
                                    Log.d("passwordc",password.getText().toString());
                                    startActivity(in);
                                }

                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    }){
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> map = new HashMap<>();
                            map.put("namekey" , fname.getText().toString());
                            map.put("emailkey" , email.getText().toString());
                            map.put("passwordkey" , password.getText().toString());
                            return map;
                        }
                    };

                    RequestQueue rq = Volley.newRequestQueue(Registration.this);
                    rq.add(sr);

                }
                }

        });
        /*final String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        final String emailText = email.getText().toString();
        email.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {


                if (emailText.matches(emailPattern) && s.length() > 0)
                {
                    Toast.makeText(getApplicationContext(),"valid email address",Toast.LENGTH_SHORT).show();
                    // or
                    textView.setText("valid email");
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Invalid email address",Toast.LENGTH_SHORT).show();
                    //or
                    textView.setText("invalid email");
                }
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // other stuffs
            }
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // other stuffs
            }
        });*/


    }
}