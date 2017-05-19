package com.crystaljewell.xivnodes.ui.node;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.crystaljewell.xivnodes.R;
import com.crystaljewell.xivnodes.data.component.Utils;
import com.crystaljewell.xivnodes.data.time.EorzeaTime;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NodeListActivity extends AppCompatActivity {

    @BindView(R.id.message)
    protected TextView message;
    @BindView(R.id.navigation)
    protected BottomNavigationView navigation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

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

                                message.setText("ET " + Utils.getSdf().format(EorzeaTime.getEorzeaTime()) + "");
                            }
                        });
                    }
                }
                , 0, 1000
        );
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    message.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    message.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    message.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }

    };

}
