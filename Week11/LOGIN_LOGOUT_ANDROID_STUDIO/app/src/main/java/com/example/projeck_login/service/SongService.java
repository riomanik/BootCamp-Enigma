package com.example.projeck_login.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class SongService extends Service {
    private MediaPlayer player;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {return null;}

    @Override
    public  int onStartCommand(Intent intent, int flags, int startId){

        player = MediaPlayer.create(this, Uri.parse("localhost:3007/stream"));
        player.start();

        return START_STICKY;
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        player.stop();
    }
}
