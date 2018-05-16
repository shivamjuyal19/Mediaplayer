package com.example.pc77.mediaplayer;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mp;
    AudioManager am;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    Button play=findViewById(R.id.button);
    Button pause=findViewById(R.id.button2);
    Button stop=findViewById(R.id.button3);
    am=(AudioManager)getSystemService(Context.AUDIO_SERVICE);
     mp=MediaPlayer.create(this,R.raw.sj);
        SeekBar s=findViewById(R.id.seekBar3);
        s.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                am.setStreamVolume(AudioManager.STREAM_MUSIC,i,0);
              //  Toast.makeText(getApplicationContext(),Integer.toString(i),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    public void onButtonClick(View v){
        mp.start();
    }
    public void onButtonClick2(View v){
        mp.pause();
    }
    public void onButtonClick3(View v){
        mp.stop();
        mp=MediaPlayer.create(this,R.raw.sj);
        //mp.seekTo(0);
    }

}
