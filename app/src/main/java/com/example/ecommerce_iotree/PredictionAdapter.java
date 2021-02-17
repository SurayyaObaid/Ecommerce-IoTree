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
public class PredictionAdapter extends RecyclerView.Adapter<PredictionAdapter.PredictionViewHolder> {

        private Context ctx;
        private List<PredictionResultModel> predictionResultModelList;
        int resId;

        public PredictionAdapter(Context ctx, List<PredictionResultModel> predictionResultModelList) {
            this.ctx = ctx;
            this.predictionResultModelList = predictionResultModelList;
        }

        @NonNull
        @Override
        public PredictionAdapter.PredictionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(ctx);
            View v = inflater.inflate(R.layout.prediction_row, parent, false);
            return new PredictionViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull final PredictionAdapter.PredictionViewHolder holder, int position) {
            final PredictionResultModel predictionResultModel = predictionResultModelList.get(position);
            holder.predLName.setText(predictionResultModel.getLocalName());
            holder.predBName.setText(predictionResultModel.getBotanicalName());
            holder.predTemperature.setText(predictionResultModel.getTemperature());
            holder.predFlowering.setText(predictionResultModel.getFlowering_time());
            holder.predHazards.setText(predictionResultModel.getKnown_hazards());
            final String plantId = predictionResultModel.getPlantID().toString();
            Log.d("predictionpid",plantId);
            //plantId = "3";
            switch (plantId) {
                case "1":
                    holder.predImage.setImageResource(R.drawable.p1);
                    resId = R.drawable.p1;
                    break;
                case "3":
                    holder.predImage.setImageResource(R.drawable.p3);
                    resId = R.drawable.p3;
                    break;
                case "4":
                    holder.predImage.setImageResource(R.drawable.p4);
                    resId = R.drawable.p4;
                    break;
                case "5":
                    holder.predImage.setImageResource(R.drawable.p5);
                    resId = R.drawable.p5;
                    break;
                case "6":
                    holder.predImage.setImageResource(R.drawable.p6);
                    resId = R.drawable.p6;
                    break;
                case "7":
                    holder.predImage.setImageResource(R.drawable.p7);
                    resId = R.drawable.p7;
                    break;
                case "8":
                    holder.predImage.setImageResource(R.drawable.p8);
                    resId = R.drawable.p8;
                    break;
                case "11":
                    holder.predImage.setImageResource(R.drawable.p11);
                    resId = R.drawable.p11;
                    break;
                case "13":
                    holder.predImage.setImageResource(R.drawable.p13);
                    resId = R.drawable.p13;
                    break;
                default:
                    holder.predImage.setImageResource(R.drawable.predict1);
                    break;
            }
            holder.predViewMore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent in = new Intent(ctx,ProductDescriptionActivity.class);
                    Bundle bundle = new Bundle();
                    in.putExtra("Plant_ID",plantId);
                    in.putExtra("image",resId);
                    ctx.startActivity(in);
                    /*Intent intent= new Intent(StoreActivity.this,ProductDescriptionActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("title",title7.getText().toString());
                bundle.putString("price",price7.getText().toString());
                bundle.putString("Plant_ID","11");
                intent.putExtras(bundle);
                intent.putExtra("image",R.drawable.graftedcactus);
                startActivity(intent);*/
                }
            });
        }

        @Override
        public int getItemCount() {
            return predictionResultModelList.size();
        }

        public class PredictionViewHolder extends RecyclerView.ViewHolder {
            TextView predLName, predBName, predTemperature, predFlowering, predHazards;
            Button predViewMore;
            ImageView predImage;

            public PredictionViewHolder(@NonNull View itemView) {
                super(itemView);
                predLName = itemView.findViewById(R.id.predictLName);
                predBName = itemView.findViewById(R.id.predictBName);
                predTemperature = itemView.findViewById(R.id.predictTemperature);
                predFlowering = itemView.findViewById(R.id.predflowering);
                predHazards = itemView.findViewById(R.id.predHazards);
                predImage = itemView.findViewById(R.id.predImage);
                predViewMore = itemView.findViewById(R.id.predViewMore);

            }
        }
    }


