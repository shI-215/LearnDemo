package com.example.learndeno.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.learndeno.R;
import com.example.learndeno.service.MusicService;

public class ServiceActivity extends AppCompatActivity implements View.OnClickListener {

    public int MUSIC_PLAY = 1;
    public int MUSIC_PAUSE = 2;
    public int MUSIC_STOP = 3;
    private Button tv_play;
    private Button tv_pause;
    private Button tv_stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        initView();
    }

    private void initView() {
        tv_play = (Button) findViewById(R.id.tv_play);
        tv_pause = (Button) findViewById(R.id.tv_pause);
        tv_stop = (Button) findViewById(R.id.tv_stop);

        tv_play.setOnClickListener(this);
        tv_pause.setOnClickListener(this);
        tv_stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_play:
                playMusic(MUSIC_PLAY);
                break;
            case R.id.tv_pause:
                playMusic(MUSIC_PAUSE);
                break;
            case R.id.tv_stop:
                playMusic(MUSIC_STOP);
                break;
        }
    }

    private void playMusic(int musicInt) {
        Intent intent = new Intent(ServiceActivity.this, MusicService.class);
        intent.putExtra("musicInt", musicInt);
        startService(intent);
    }
}
