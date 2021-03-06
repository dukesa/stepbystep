package com.stepbystepmusic.skillbuilder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;

import java.util.List;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final MusicPlayer MainMusicPlayer = new MusicPlayer();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize music player
        TextView myAwesomeTextView = (TextView)findViewById(R.id.main_text);
        myAwesomeTextView.setText("C Major");

        MainMusicPlayer.initialize(myAwesomeTextView);


        // Create Scale
        int bpm = 120;
        int clicks = 4;
        Scale CMajor = new Scale();
        CMajor.build(bpm, clicks);

        // Load scale into muisc player
        MainMusicPlayer.loadScale(CMajor);

        final Button button = (Button) findViewById(R.id.play_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // todo: move threading inside of MusicPlayer class
                Thread t1 = new Thread(new Runnable() {
                    public void run()
                    {
                        // code goes here.
                        MainMusicPlayer.play();
                    }});
                t1.start();

            }
        });
    }



}
