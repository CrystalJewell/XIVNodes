package com.crystaljewell.xivnodes.data.time;

import java.util.Calendar;

import static com.crystaljewell.xivnodes.data.component.Constants.EORZEA_TIME_DIFFERENCE;

/**
 * Created by crystaladkins on 5/2/17.
 */

public class EorzeaTime {


    public static long getEorzeaTime(){
        Calendar calendar = Calendar.getInstance();

        long time = calendar.getTimeInMillis();

        return (long)(time * EORZEA_TIME_DIFFERENCE);

    }
}
