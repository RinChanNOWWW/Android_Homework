package com.bytedance.videoplayer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;


public class ProActivity extends AppCompatActivity {

    private VideoView videoView;
    private int videoPosition = 0;
    private boolean isPlaying = false;


    @Override
    protected void onCreate(@Nullable Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("hh", "onCreate");
        videoView = findViewById(R.id.videoView);
        Intent intent = getIntent();
        Uri uri = intent.getData();
        Log.d("pro", uri.toString());
        videoView.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setMediaPlayer(videoView);
        videoView.start();
    }

    // 在这个时候保存进度
    @Override
    protected void onPause() {
        super.onPause();
        videoPosition = videoView.getCurrentPosition();
        isPlaying = videoView.isPlaying();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("hh", "onResume");
        videoView.seekTo(videoPosition);
        if (isPlaying)
            videoView.start();
    }

    // 此时 VideoView 已经清零
    @Override
    protected void onSaveInstanceState(@Nullable Bundle state) {

        if (state != null) {
            Log.d("hh", "onSave");
            int position = videoPosition;
            Log.d("hh", "Position: " + position);
            state.putInt("position", position);
            state.putBoolean("isPlaying", isPlaying);
        }
        super.onSaveInstanceState(state);
    }


    @Override
    protected void onRestoreInstanceState(@Nullable Bundle state) {
        super.onRestoreInstanceState(state);
        if (state != null) {
            Log.d("hh", "onRestore");
            int position = state.getInt("position");
            boolean isplaying = state.getBoolean("isPlaying");
            Log.d("hh", "Position: " + position);
            videoPosition = position;
            videoView.seekTo(position);
            isPlaying = isplaying;
            if (isPlaying)
                videoView.start();
        }

    }

    private String getVideoPath(int resId) {
        return "android.resource://" + this.getPackageName() + "/" + resId;
    }
}


