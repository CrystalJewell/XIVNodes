package com.crystaljewell.xivnodes.data.time;

import java.util.Calendar;
import java.util.TimeZone;

import static com.crystaljewell.xivnodes.data.component.Constants.EORZEA_TIME_DIFFERENCE;

/**
 * Created by crystaladkins on 5/5/17.
 */

public class ConvertTime {



    public static long getNextRealWorldPopTime(String time) {

        if (time.length() > 5) {
            return -1;
        }
        long eorzeanTime = EorzeaTime.getEorzeaTime();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        calendar.setTimeInMillis(eorzeanTime);
        Calendar calendarCopy = Calendar.getInstance();
        calendarCopy.setTimeInMillis(eorzeanTime);
        calendarCopy.setTimeZone(TimeZone.getTimeZone("UTC"));

        calendarCopy.set(Calendar.HOUR_OF_DAY, Integer.valueOf(time.substring(0, 2)));
        calendarCopy.set(Calendar.MINUTE, 0);
        calendarCopy.set(Calendar.SECOND, 0);
        calendarCopy.set(Calendar.MILLISECOND, 0);

        if (calendar.getTimeInMillis() >= calendarCopy.getTimeInMillis()) {
            calendarCopy.add(Calendar.DATE, 1);
        }

        return (long)(calendarCopy.getTimeInMillis() / EORZEA_TIME_DIFFERENCE);
    }


}
