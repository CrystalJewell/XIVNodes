package com.crystaljewell.xivnodes;

import android.app.Application;

/**
 * Created by crystaladkins on 5/7/17.
 */

public class XIVNodesApplication extends Application {

    private static XIVNodesApplication application;

    @Override
    public void onCreate() {
        super.onCreate();

        application = this;
    }
}
