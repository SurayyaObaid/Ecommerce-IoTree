package com.example.ecommerce_iotree;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.ecommerce_iotree.JSONPlaceHolderApi.BASE_URL;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    String img, p, q;
    private Context context;
    private List<CartModel> cartModels;
    String jprice = "";

    JSONPlaceHolderApi jsonPlaceHolderApi;
    public CartAdapter(Context context, List<CartModel> cartModels) {
        this.context = context;
        this.cartModels = cartModels;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View  view = layoutInflater.inflate(R.layout.cartitem, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CartViewHolder holder, int position) {
        final CartModel cartModel = cartModels.get(position);
        String plantID = cartModel.getPlant_ID();
        holder.itemid.setText(cartModel.getItem_ID());
        holder.itemName.setText(cartModel.getItem_name());
        holder.itemQuantity.setText(cartModel.getItem_quantity());
        holder.itemPrice.setText(cartModel.getItem_price());
        Log.d("plantID", plantID + " \n" );
        switch (plantID){
            case "1":
                holder.imageView.setImageResource(R.drawable.p1);
                Log.d("plantID1", plantID + " \n" );
                jprice = "1450";
                holder.itemPrice.setText(jprice);
                break;
            case "3":
                holder.imageView.setImageResource(R.drawable.p3);
                Log.d("plantID3", plantID + " \n" );
                jprice = "6000";
                holder.itemPrice.setText(jprice);
                break;
            case "4":
                holder.imageView.setImageResource(R.drawable.p4);
                Log.d("plantID4", plantID + " \n" );
                jprice = "1950";
                holder.itemPrice.setText(jprice);
                break;
            case "5":
                holder.imageView.setImageResource(R.drawable.p5);
                jprice = "1650";
                holder.itemPrice.setText(jprice);
                Log.d("plantID5", plantID + " \n" );
                break;
            case "6":
                holder.imageView.setImageResource(R.drawable.p6);
                jprice = "350";
                holder.itemPrice.setText(jprice);
                break;
            case "7":
                holder.imageView.setImageResource(R.drawable.p7);
                jprice = "1950";
                holder.itemPrice.setText(jprice);
                break;
            case "8":
                holder.imageView.setImageResource(R.drawable.p8);
                jprice = "1200";
                holder.itemPrice.setText(jprice);
                break;
            case "11":
                holder.imageView.setImageResource(R.drawable.p11);
                jprice = "875";
                holder.itemPrice.setText(jprice);
                break;
            case "13":
                holder.imageView.setImageResource(R.drawable.p13);
                jprice = "1450";
                holder.itemPrice.setText(jprice);
                break;
            default:
                holder.imageView.setImageResource(R.drawable.predict1);
                break;
        }
        holder.proceedToPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uid, iid, iname, iprice, iquantity, uname;
                uid = MainActivity.sessionUser;
                iid = cartModel.getItem_ID().toString();
                uname = MainActivity.sessionUserName;
                iname = cartModel.getItem_name().toString();
                iprice = jprice;
                if (holder.itemQuantity.toString()!=""){
                    iquantity = holder.itemQuantity.toString();
                }
                Integer  iquan = 1;
                Bundle bundle = new Bundle();
                bundle.putString("ItemID",iid);
                bundle.putString("ItemName",iname);
                bundle.putString("ItemPrice",iprice);
                bundle.putInt("ItemQuantity",iquan);
                bundle.putString("UserID",uid);
                bundle.putString("UserName",uname);
                Intent intent = new Intent(context, OrderActivity.class);
                intent.putExtras(bundle);
                context.startActivity(intent);
                Log.d("order",uid +"\n"+ iid+"\n"+ iname+"\n"+ iprice+"\n"+ iquan+"\n"+ uname);
            }
        });
        holder.deleteCartItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteCartItem();
            }
        });
    }

    @Override
    public int getItemCount() {
        return cartModels.size();
    }
    private void deleteCartItem(){
        CartModel cartModel = new CartModel();
        final String iid = cartModel.getItem_ID();
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://hibabintetariq.stig.pk/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        jsonPlaceHolderApi = retrofit.create(JSONPlaceHolderApi.class);
        final String uid= MainActivity.sessionUser;
        Call<List<CartModel>> call = jsonPlaceHolderApi.deleteCartItem(iid);
        call.enqueue(new Callback<List<CartModel>>() {
            @Override
            public void onResponse(Call<List<CartModel>> call, Response<List<CartModel>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(context,"Something went wrong",Toast.LENGTH_LONG).show();
                    Log.d("trouble deleting","truble deleting");
                    return;
                }
                List<CartModel> cartModels = response.body();
                for (CartModel cartModel :cartModels) {
                    String content = "";
                    Log.d("deleteitem",iid);


                }


            }

            @Override
            public void onFailure(Call<List<CartModel>> call, Throwable t) {
                Toast.makeText(context,"Failed to get response",Toast.LENGTH_LONG).show();
            }
        });

    }


    public class CartViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        Button proceedToPay;
        ImageButton deleteCartItem;
        TextView itemName, itemPrice, itemQuantity, itemid;
        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            proceedToPay = itemView.findViewById(R.id.proceedtopay);
            itemid = itemView.findViewById(R.id.iid);
            imageView = itemView.findViewById(R.id.iimage);
            itemName = itemView.findViewById(R.id.iName);
            itemPrice = itemView.findViewById(R.id.iprice);
            itemQuantity = itemView.findViewById(R.id.iquantity);
            deleteCartItem = itemView.findViewById(R.id.deleteCartItem);

        }
    }
}
