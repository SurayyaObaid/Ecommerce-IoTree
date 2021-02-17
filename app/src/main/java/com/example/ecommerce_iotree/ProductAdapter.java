package com.example.ecommerce_iotree;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;
public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {

    private Context ctx;
    private List<Plant> plantList;

    public ProductAdapter(Context ctx, List<Plant> plantList) {
        this.ctx = ctx;
        this.plantList = plantList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater inflater = LayoutInflater.from(ctx);
        v = inflater.inflate(R.layout.productdata, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // Plant plantItem = plantList.get(position);

        holder.lnametxt.setText(plantList.get(position).getLocalName());
        holder.bnametxt.setText(plantList.get(position).getBotanicalName());
        holder.pricetxt.setText(plantList.get(position).getPricePKR());


        Glide.with(ctx)
                .load(plantList.get(position).getImage())
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return plantList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewPlant, lnametxt, bnametxt, pricetxt, quantitytxt;
        Button buyplant;
        ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            lnametxt = itemView.findViewById(R.id.lname);
            bnametxt = itemView.findViewById(R.id.bname);
            pricetxt = itemView.findViewById(R.id.price);
            quantitytxt = itemView.findViewById(R.id.quantity);
            buyplant = itemView.findViewById(R.id.buybtn);
            imageView = itemView.findViewById(R.id.plantimg);
        }
    }
}