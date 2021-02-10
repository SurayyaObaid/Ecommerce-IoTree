package com.example.ecommerce_iotree;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
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

import static java.lang.Integer.valueOf;

public class GardenerAdapter extends RecyclerView.Adapter<GardenerAdapter.GardenerViewHolder> {
    private Context context;
    private List<GardenerModel> gardenerModels;

    public GardenerAdapter(Context context, List<GardenerModel> gardenerModels) {
        this.context = context;
        this.gardenerModels = gardenerModels;
    }

    @NonNull
    @Override
    public GardenerAdapter.GardenerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.gardener_row_item, parent, false);
        return new GardenerAdapter.GardenerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GardenerAdapter.GardenerViewHolder holder, int position) {
        GardenerModel gardenerModel = gardenerModels.get(position);
        final String num = gardenerModel.getGardenerNumber();
        holder.callGardener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Intent.ACTION_DIAL);
                Log.d("num",num);
                intent.setData(Uri.parse("tel:"+num));
                context.startActivity(intent);
            }
        });
        holder.gName.setText(gardenerModel.getGardenerName());
        holder.gService.setText(gardenerModel.getGardenerService());
        holder.gNumber.setText(gardenerModel.getGardenerNumber());
         String service=gardenerModel.getGardenerService();
         Log.d("service",service);
         String charges;
        //holder.gaddress.setText(gardenerModel.getGardenerAddress());
        switch(service){
            case "Clearance":
                charges = "5000";
                Log.d("charges",charges);
                break;
            case "Garden Designing":
                charges = "7000";
                Log.d("charges",charges);
                break;
            case "Overgrowth Prevention":
                charges = "3000";
                Log.d("charges",charges);
                break;
            case "Lawn Mowing":
                charges = "5000";
                Log.d("charges",charges);
                break;
            case "Jet Washing":
                charges = "1500";
                Log.d("charges",charges);
                break;
            default:
                charges = "1500";
                Log.d("charges",charges);
                break;

        }
        holder.gCharges.setText(charges);
    }

    @Override
    public int getItemCount() {
        return gardenerModels.size();
    }

    public class GardenerViewHolder extends RecyclerView.ViewHolder{
        TextView gName, gService, gNumber, gCharges, gaddress;
        Button callGardener;
        public GardenerViewHolder(@NonNull View itemView) {
            super(itemView);
            gName = itemView.findViewById(R.id.gardenerName);
            gService = itemView.findViewById(R.id.gardenerService);
            gNumber = itemView.findViewById(R.id.gardenerphone);
            gCharges = itemView.findViewById(R.id.gardenerCharges);
            //gaddress = itemView.findViewById(R.id.gardenerAddress);
            callGardener = itemView.findViewById(R.id.callGardener);

        }
    }
}
