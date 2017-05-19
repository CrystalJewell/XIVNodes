package com.crystaljewell.xivnodes.data.notification;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.crystaljewell.xivnodes.data.time.EorzeaTime;

import java.util.Calendar;

/**
 * Created by crystaladkins on 5/2/17.
 */

public class ScheduleNotifications extends IntentService {

    private AlarmManager alarmManager;
    private PendingIntent alarmIntent;
    private Context context;


    public ScheduleNotifications(String name) {
        super(name);
    }

    private void displayNotification() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(EorzeaTime.getEorzeaTime());

        alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, alarmIntent);




//        NotificationCompat.Builder mBuilder =
//                new NotificationCompat.Builder(this)
//                        .setSmallIcon(R.drawable.ic_explore_black)
//                        .setContentTitle("Node is about to pop")
//                        .setContentText("The Node you are waiting for is about to pop");
//        Intent resultIntent = new Intent(this, NodeListActivity.class);
//        PendingIntent resultPendingIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), resultIntent, 0);
//        mBuilder.setContentIntent(resultPendingIntent);
//        NotificationManager mNotificationManager =
//                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//        mNotificationManager.notify(1, mBuilder.build());
    }


    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        displayNotification();

    }
}
