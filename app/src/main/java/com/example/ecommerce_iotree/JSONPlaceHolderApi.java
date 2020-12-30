package com.example.ecommerce_iotree;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JSONPlaceHolderApi {

    public static String BASE_URL = "http://hibabintetariq.stig.pk/";
    @GET("getproduct.php")
    Call<List<Post>> getPosts();
    Call<List<Plant>> getAllPlants();

    @GET("fetchuser.php")
    Call<List<UserModel>> getUsers(@Query("Email") String Email, @Query("Password") String Password);

    @GET("fetchproduct.php")
    Call<List<Plant>> getPlants(@Query("Plant_ID") String Plant_ID );

    @GET("fetchcart.php")
    Call<List<CartModel>> getCart(@Query("User_ID") String User_ID );

}
