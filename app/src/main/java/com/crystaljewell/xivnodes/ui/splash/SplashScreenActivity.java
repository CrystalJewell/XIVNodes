package com.crystaljewell.xivnodes.ui.splash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.crystaljewell.xivnodes.R;
import com.crystaljewell.xivnodes.ui.node.NodeListActivity;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        startRunnable();
    }

    private void startRunnable() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    if (i == 49) {

                        Intent launchMain = new Intent(SplashScreenActivity.this, NodeListActivity.class);
                        startActivity(launchMain);
                    }
                    try {
                        Thread.sleep(60);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
