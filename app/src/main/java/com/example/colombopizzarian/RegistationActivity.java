package com.example.colombopizzarian;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class RegistationActivity extends AppCompatActivity {
    private final String CHANNEL_ID="Notification Channel";
    private final int NOTIFICATION_ID=999;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registation);
    }

    public void displayNotification(View view) {
       if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
           CharSequence channel_name = "Notication Message";
           String description="You have sucessfully registered for Colombo Pizza shop";
           int importance = NotificationManager.IMPORTANCE_DEFAULT;

           NotificationChannel notificationChannel= new NotificationChannel (CHANNEL_ID,channel_name,importance);
           notificationChannel.setDescription(description);
           NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
           notificationManager.createNotificationChannel(notificationChannel);
       }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,CHANNEL_ID);
       builder.setContentTitle("Colombo Pizza Shop");
       builder.setContentText("You have sucessfully registered.");
       builder.setSmallIcon(R.drawable.ic_baseline_notifications_24);
       builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
       builder.setAutoCancel(true);

        NotificationManagerCompat notificationManagerCompat=NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(NOTIFICATION_ID,builder.build());
    }

    public void login(View view) {
        startActivity(new Intent(RegistationActivity.this, LoginActivity.class));
    }
}