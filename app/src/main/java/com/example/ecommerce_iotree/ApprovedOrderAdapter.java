package com.example.ecommerce_iotree;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ApprovedOrderAdapter extends RecyclerView.Adapter<ApprovedOrderAdapter.ApprovedOrderViewHolder> {
    String img, p, q;
    private Context context;
    private List<ApprovedOrderModel> approvedOrderModels;
    String jprice = "";

    public ApprovedOrderAdapter(Context context, List<ApprovedOrderModel> approvedOrderModels) {
        this.context = context;
        this.approvedOrderModels= approvedOrderModels;
    }

    @NonNull
    @Override
    public ApprovedOrderAdapter.ApprovedOrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.approved_order_row, parent, false);
        return new ApprovedOrderAdapter.ApprovedOrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ApprovedOrderAdapter.ApprovedOrderViewHolder holder, int position) {
        final ApprovedOrderModel approvedOrderModel = approvedOrderModels.get(position);
        String orderID = approvedOrderModel.getOrderID().toString();
        holder.orName.setText(approvedOrderModel.getItemName());
        holder.orPrice.setText(approvedOrderModel.getItemPrice());
        holder.orDate.setText(approvedOrderModel.getDateOrdered());
        holder.orArrival.setText(approvedOrderModel.getExpectedArrival());
        holder.orAddress.setText(approvedOrderModel.getAddress());
        holder.orMobile.setText(approvedOrderModel.getMobile());
        Log.d("plantID", orderID + " \n" );
        /*switch (orderID){
            case "1":
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
        }*/
    }

    @Override
    public int getItemCount() {
        return approvedOrderModels.size();
    }

    public class ApprovedOrderViewHolder extends RecyclerView.ViewHolder{
        TextView orName, orPrice, orDate, orArrival, orAddress, orMobile;
        public ApprovedOrderViewHolder(@NonNull View itemView) {
            super(itemView);
            orName = itemView.findViewById(R.id.aoName);
            orPrice = itemView.findViewById(R.id.aoPrice);
            orDate = itemView.findViewById(R.id.aoOrderedDate);
            orArrival = itemView.findViewById(R.id.aoExpectedArrival);
            orAddress = itemView.findViewById(R.id.aoAddress);
            orMobile = itemView.findViewById(R.id.aoMobile);

        }
    }
}
