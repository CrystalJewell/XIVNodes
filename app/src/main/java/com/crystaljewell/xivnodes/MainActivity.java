package com.crystaljewell.xivnodes;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    @BindView(R.id.message)
    protected TextView message;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        initTime();
    }

    private void initTime() {
        Timer timer = new Timer(true);
        final Handler handler = new Handler();
        timer.schedule(
                new TimerTask() {
                    @Override
                    public void run() {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                Calendar calendar = Calendar.getInstance();
//                                Date date = new Date();
                                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a", Locale.US);
                                sdf.setTimeZone(TimeZone.getTimeZone("UTC"));

                                long time = calendar.getTimeInMillis();
                                double ezTime = time * 20.57142852; //20.571428571428573 <--This one makes the clock fast, 20.57142852 make the time match ffxivclock
                                String formattedTime = sdf.format(ezTime);

                                message.setText("ET " + formattedTime + "");
//                                );
                            }
                        });
                    }
                }
                , 0, (35/12)
        );
    }

}
