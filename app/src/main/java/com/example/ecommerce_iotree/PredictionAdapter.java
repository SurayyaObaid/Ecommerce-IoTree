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

public class PredictionAdapter extends RecyclerView.Adapter<PredictionAdapter.PredictionViewHolder> {

        private Context ctx;
        private List<Plant> predList;

        public PredictionAdapter(Context ctx, List<Plant> predList) {
            this.ctx = ctx;
            this.predList = predList;
        }

        @NonNull
        @Override
        public PredictionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v;
            LayoutInflater inflater = LayoutInflater.from(ctx);
            v = inflater.inflate(R.layout.prediction_row, parent, false);
            return new PredictionViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull com.example.ecommerce_iotree.PredictionAdapter.PredictionViewHolder holder, int position) {
            // Plant plantItem = plantList.get(position);

            holder.predlnametxt.setText(predList.get(position).getLocalName());
            holder.predbnametxt.setText(predList.get(position).getBotanicalName());
            holder.predpricetxt.setText(predList.get(position).getPricePKR());
            holder.predtemptxt.setText(predList.get(position).getTemperature());


            Glide.with(ctx)
                    .load(predList.get(position).getImage())
                    .into(holder.imageView);

        }

        @Override
        public int getItemCount() {
            return predList.size();
        }

        public class PredictionViewHolder extends RecyclerView.ViewHolder {
            TextView textViewPlant, predlnametxt, predbnametxt, predpricetxt, predtemptxt;
            Button viewMore;
            ImageView imageView;

            public PredictionViewHolder(@NonNull View itemView) {
                super(itemView);
                predlnametxt = itemView.findViewById(R.id.predLName);
                predbnametxt = itemView.findViewById(R.id.predBname);
                predpricetxt = itemView.findViewById(R.id.predprice);
                predtemptxt = itemView.findViewById(R.id.predtemp);
                viewMore = itemView.findViewById(R.id.viewMore);
                imageView = itemView.findViewById(R.id.predimage);
            }
        }
    }

