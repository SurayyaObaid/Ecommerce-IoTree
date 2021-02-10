package com.example.ecommerce_iotree.Maintenance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ecommerce_iotree.MainActivity;
import com.example.ecommerce_iotree.R;
import com.example.ecommerce_iotree.SetGoalsActivity;

public class WaterGoals extends AppCompatActivity {
    EditText wgLabel;
    Button setGoal,cancelWG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_goals);
        wgLabel = findViewById(R.id.WGLabel);
        cancelWG = findViewById(R.id.cancelWG);
        cancelWG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(WaterGoals.this, SetGoalsActivity.class);
                startActivity(in);
                finish();
            }
        });
        setGoal = findViewById(R.id.setWG);
        String wg = wgLabel.getText().toString();

        setGoal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
                    NotificationChannel channel = new NotificationChannel("WaterGoals", "WaterNotification", NotificationManager.IMPORTANCE_DEFAULT);
                    NotificationManager manager = getSystemService(NotificationManager.class);
                    manager.createNotificationChannel(channel);
                }
                NotificationCompat.Builder builder = new NotificationCompat.Builder(WaterGoals.this,"WaterGoals");
                builder.setContentTitle("Maintenance goal");
                builder.setContentText("It's time to water plant");
                builder.setSmallIcon(R.drawable.logo);
                builder.setAutoCancel(true);

                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(WaterGoals.this);
                managerCompat.notify(1, builder.build());
            }
        });

    }
}