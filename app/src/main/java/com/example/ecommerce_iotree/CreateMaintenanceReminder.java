package com.example.ecommerce_iotree;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.badge.BadgeUtils;

import java.util.Calendar;

public class CreateMaintenanceReminder extends AppCompatActivity {
    EditText reminderTitle;
    String label, title;
    Button cancel, addReminder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_maintenance_reminder);
        reminderTitle =findViewById(R.id.remindertitle);
        cancel = findViewById(R.id.cancelReminder);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(CreateMaintenanceReminder.this, SetGoalsActivity.class);
                startActivity(in);
            }
        });

        addReminder = findViewById(R.id.setReminder);
        addReminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (reminderTitle.getText().toString().isEmpty()){
                    Toast.makeText(CreateMaintenanceReminder.this,"Please Add description",Toast.LENGTH_LONG).show();
                }else {
                    title = "Maintenance Task";
                    label = reminderTitle.getText().toString();
                    Intent intent = new Intent(Intent.ACTION_INSERT);
                    intent.setData(CalendarContract.Events.CONTENT_URI);
                    intent.putExtra(CalendarContract.Events.TITLE,title);
                    intent.putExtra(CalendarContract.Events.HAS_ALARM,true);
                    intent.putExtra(CalendarContract.Reminders.MINUTES,5);

                    if (intent.resolveActivity(getPackageManager())!=null){
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(CreateMaintenanceReminder.this,"Action Not Supported"
                                ,Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }
}