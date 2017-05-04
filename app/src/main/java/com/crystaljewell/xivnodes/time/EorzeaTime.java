package com.crystaljewell.xivnodes.time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by crystaladkins on 5/2/17.
 */

public class EorzeaTime {


    public static String getEorzeaTime(){
        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a", Locale.US);
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));

        long time = calendar.getTimeInMillis();
        double ezTime = time * 20.57142852; //20.571428571428573 <--This one makes the clock fast, 20.57142852 make the time match ffxivclock

        return sdf.format(ezTime);

    }
}
