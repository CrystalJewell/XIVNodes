package com.crystaljewell.xivnodes.data.component;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by crystaladkins on 5/5/17.
 */

public class Utils {


    public static SimpleDateFormat getSdf() {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a", Locale.US);
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        return sdf;
    }


}
