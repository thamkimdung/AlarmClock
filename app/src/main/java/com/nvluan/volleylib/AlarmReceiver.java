package com.nvluan.volleylib;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.content.WakefulBroadcastReceiver;

/**
 * Created by systena on 2018/05/08.
 */

public class AlarmReceiver extends WakefulBroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        if (uri == null) {
            uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        }
        Ringtone ringtone = RingtoneManager.getRingtone(context, uri);
        ringtone.play();
        ComponentName componentName = new ComponentName(context.getPackageName(), AlarmService.class.getName());
        startWakefulService(context, intent.setComponent(componentName));
        setResultCode(Activity.RESULT_OK);

    }
}
