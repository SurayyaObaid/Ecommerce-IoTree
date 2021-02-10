package com.example.ecommerce_iotree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.ecommerce_iotree.JSONPlaceHolderApi.BASE_URL;

public class MainActivity extends AppCompatActivity {
    private TextView textViewResult;
    JSONPlaceHolderApi jsonPlaceHolderApi;
    EditText editEmail, editPassword;
    Button loginbtn, signup_link;
    String emailValue = "", passwordValue = "";
    public static String sessionUser = "", sessionUserName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewResult = findViewById(R.id.text_view_result);
        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);
        signup_link = findViewById(R.id.signup_Link);
        signup_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this, Registration.class);
                startActivity(in);
            }
        });
        loginbtn = findViewById(R.id.loginbtn);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emailValue = editEmail.getText().toString();
                passwordValue = editPassword.getText().toString();
                getUsers();

            }
        });

        //getPlants();

    }
   /* private void getPlants(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JSONPlaceHolderApi.class);
        Call<List<Post>> call = jsonPlaceHolderApi.getPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if(!response.isSuccessful()){
                    textViewResult.setText("Code:" +response.code());
                    return;
                }
                List<Post> posts = response.body();
                for (Post post:posts){
                    String content="";
                    content += "ID"+post.getId() + "\n";
                    content += "User ID"+post.getUserId() +"\n";
                    content += "Title"+post.getTitle() +"\n";
                    content += "Text"+post.getText() +"\n";

                    textViewResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });

    }*/
    private void getUsers(){
        if (editEmail.getText().toString().matches("") || editPassword.getText().toString().matches("")){
            Toast.makeText(MainActivity.this,"Empty field(s), please fill the form",
                    Toast.LENGTH_SHORT).show();
        }
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://hibabintetariq.stig.pk/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        jsonPlaceHolderApi = retrofit.create(JSONPlaceHolderApi.class);
        Call<List<UserModel>> call = jsonPlaceHolderApi.getUsers(emailValue,passwordValue);
        call.enqueue(new Callback<List<UserModel>>() {
            @Override
            public void onResponse(Call<List<UserModel>> call, Response<List<UserModel>> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText("Login Failed");
                    return;
                }
                List<UserModel> userModels = response.body();
                for (UserModel userModel :userModels) {
                    String content = "";
                    content += "ID" + userModel.getUser_ID() + "\n";
                    content += "User Name" + userModel.getUser_name() + "\n";
                    content += "Email" + userModel.getEmail() + "\n";
                    content += "Password" + userModel.getPassword() + "\n";

                    //textViewResult.append(content);
                    sessionUser = userModel.getUser_ID();
                    sessionUserName = userModel.getUser_name();
                    userModel.setUser_ID(sessionUser);
                    Intent in =new Intent(MainActivity.this,HomeActivity.class);
                    String userName = userModel.getUser_name();
                    Bundle bundle = new Bundle();
                    bundle.putString("UserName", userName);
                    in.putExtras(bundle);
                    //textViewResult.append(userName);
                    startActivity(in);
                }


            }

            @Override
            public void onFailure(Call<List<UserModel>> call, Throwable t) {
                textViewResult.setText("Login Failed");
            }
            });
    }

}