package com.example.ecommerce_iotree;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import static com.example.ecommerce_iotree.JSONPlaceHolderApi.BASE_URL;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    private Context context;
    private List<CartModel> cartModels;

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
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        CartModel cartModel = cartModels.get(position);
        holder.itemName.setText(cartModel.getItem_name());
        holder.itemQuantity.setText(cartModel.getItem_quantity());
        holder.itemPrice.setText(cartModel.getItem_quantity());
        Glide.with(context)
                .load(cartModels.get(position).getImage())
                .into(holder.imageView);
        Log.d("img-url", BASE_URL+cartModel.getImage());
    }

    @Override
    public int getItemCount() {
        return cartModels.size();
    }

    public class CartViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView itemName, itemPrice, itemQuantity;
        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iimage);
            itemName = itemView.findViewById(R.id.iName);
            itemPrice = itemView.findViewById(R.id.iprice);
            itemQuantity = itemView.findViewById(R.id.iquantity);

        }
    }
}
