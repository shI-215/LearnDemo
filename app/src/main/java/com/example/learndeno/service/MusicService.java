package com.example.learndeno.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

import com.example.learndeno.R;

public class MusicService extends Service {
    private MediaPlayer mediaPlayer;
    private boolean isStop = true;
    final static String Lo = "MusicService";
    private int musicInt;

    public MusicService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        musicInt = intent.getIntExtra("musicInt", -1);
        Log.v(Lo, musicInt + "");
        switch (musicInt) {
            case 1:
                if (isStop) {
                    mediaPlayer.reset();
                    mediaPlayer = MediaPlayer.create(this, R.raw.shengpizi);
                    mediaPlayer.start();
                    mediaPlayer.setLooping(false);
                    isStop = false;
                } else if (!isStop && mediaPlayer != null) {
                    mediaPlayer.start();
                }
                break;
            case 2:
                if (!isStop && mediaPlayer.isPlaying() && mediaPlayer != null) {
                    mediaPlayer.pause();
                }
                break;
            case 3:
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    isStop = true;
                }
                break;
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (mediaPlayer == null) {
            mediaPlayer = new MediaPlayer();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
