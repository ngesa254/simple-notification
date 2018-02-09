package io.droidmarvin.simplenotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonNotificationShow, buttonNotificationClear;
    NotificationManager notificationManager;
    Notification mNotification;
    PendingIntent mPendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}
