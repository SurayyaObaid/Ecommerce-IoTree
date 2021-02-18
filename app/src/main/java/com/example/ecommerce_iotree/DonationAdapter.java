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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DonationAdapter extends RecyclerView.Adapter<DonationAdapter.DonationViewHolder> {
   private Context context;
    private List<DonationModel> donationModels;

    public DonationAdapter(Context context, List<DonationModel> donationModels) {
        this.context = context;
        this.donationModels = donationModels;
    }

    @NonNull
    @Override
    public DonationAdapter.DonationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.donation_row_item, parent, false);
        return new DonationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final DonationViewHolder holder, int position) {
        final DonationModel donationModel = donationModels.get(position);
        holder.donorName.setText(donationModel.getUserName());
        holder.donorID.setText(donationModel.getUserID());
        holder.trees.setText(donationModel.getNumOfTrees());
        holder.amountDonated.setText(donationModel.getAmount());
        holder.donorContact.setText(donationModel.getContact());

    }

    @Override
    public int getItemCount() {
        return donationModels.size();
    }



    public class DonationViewHolder extends RecyclerView.ViewHolder{
       TextView donorName, donorID, trees, amountDonated, donorContact;
        public DonationViewHolder(@NonNull View itemView) {
            super(itemView);
            donorName = itemView.findViewById(R.id.donorName);
            donorID = itemView.findViewById(R.id.donorID);
            trees = itemView.findViewById(R.id.treeCountValue);
            amountDonated = itemView.findViewById(R.id.donationAmount);
            donorContact = itemView.findViewById(R.id.donorContact);

        }
    }
}

