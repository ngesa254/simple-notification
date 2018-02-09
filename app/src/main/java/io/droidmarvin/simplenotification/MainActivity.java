package io.droidmarvin.simplenotification;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

        initialise();
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        buttonNotificationShow.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("io.droidmarvin.simplenotification");
                mPendingIntent = PendingIntent.getActivity(getApplicationContext(), 1, intent, 0);
                Notification.Builder mBuilder = new Notification.Builder(getApplicationContext());

                mBuilder.setAutoCancel(false);
                mBuilder.setContentTitle("xSimple Notification");
                mBuilder.setTicker("ticker text here");
                mBuilder.setContentText("Tech x Notification");
                mBuilder.setSmallIcon(R.drawable.techx);
                mBuilder.setContentIntent(mPendingIntent);
                mBuilder.setOngoing(true);

                //API level 16
                mBuilder.setSubText("We are holding an xMeeting this Monday. Purpose to attend!");
                mBuilder.setNumber(150);
                mBuilder.build();
                mNotification = mBuilder.getNotification();
                notificationManager.notify(11, mNotification);

            }
        });

        buttonNotificationClear.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                notificationManager.cancel(11);
            }
        });
    }

    private void initialise() {
        buttonNotificationShow = findViewById(R.id.notification_show_button);
        buttonNotificationClear = findViewById(R.id.notification_clear_button);
    }
}
