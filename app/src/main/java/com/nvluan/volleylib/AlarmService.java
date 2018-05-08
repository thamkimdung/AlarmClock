package com.nvluan.volleylib;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

/**
 * Created by systena on 2018/05/08.
 */

public class AlarmService extends IntentService {
    private NotificationManager alarmNotificationManager;

    public AlarmService() {
        super("");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        sendNotification("abc");
    }


    private void sendNotification(String msg) {
        alarmNotificationManager = (NotificationManager) this
                .getSystemService(Context.NOTIFICATION_SERVICE);

        PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
                new Intent(this, MainActivity.class), 0);

        NotificationCompat.Builder alamNotificationBuilder = new NotificationCompat.Builder(
                this).setContentTitle("Alarm").setSmallIcon(R.mipmap.ic_launcher)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(msg))
                .setContentText(msg);


        alamNotificationBuilder.setContentIntent(contentIntent);
        alarmNotificationManager.notify(1, alamNotificationBuilder.build());
    }
}
