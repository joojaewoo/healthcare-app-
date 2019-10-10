package com.cookandroid.healthcare;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.util.Calendar;


public class sensor_receiver extends BroadcastReceiver {
    Context context;
    @Override
    public void onReceive(Context context, Intent intent){
        this.context =context;
        if(intent.getAction().equals("ACTION.RESTART.foreground")){
            Intent i=new Intent(context,sensor_foreground.class);
            context.startService(i);}
        else {
            sensor_foreground.setCnt(0);
            Intent my_intent = new Intent(context, sensor_receiver.class);
            int a=intent.getIntExtra("day",-1);
            AlarmManager alarmManager=(AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
            Calendar calendar = Calendar.getInstance();
            my_intent.putExtra("day",a+1);
            calendar.set(Calendar.DAY_OF_YEAR,a+1);
            calendar.set(Calendar.HOUR_OF_DAY, 23);
            calendar.set(Calendar.MINUTE, 59);
            calendar.set(Calendar.SECOND, 59);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 1, my_intent, PendingIntent.FLAG_UPDATE_CURRENT);
            alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
        }
    }
}
