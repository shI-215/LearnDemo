package com.example.learndeno.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.learndeno.R;

import java.util.Timer;
import java.util.TimerTask;

public class HandleThreadActivity extends AppCompatActivity {

    private TextView tv_time;
    private int number = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handle_thread);
        initView();
    }

    private void initView() {
        tv_time = (TextView) findViewById(R.id.tv_time);
        new Thread(new Runnable() {
            @Override
            public void run() {
                timer.schedule(task, 0, 1000);
            }
        }).start();
    }

    private Timer timer = new Timer();
    private TimerTask task = new TimerTask() {
        @Override
        public void run() {
            if (number > 0) {
                Message message = Message.obtain();
                message.arg1 = number;
                message.what = 0;
                handler.sendMessage(message);
            } else {
                handler.sendEmptyMessage(1);
            }
            number--;
        }
    };

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    tv_time.setText(msg.arg1 + "");
                    break;
                case 1:
                    tv_time.setText("GO");
                    break;
            }
        }
    };

}
