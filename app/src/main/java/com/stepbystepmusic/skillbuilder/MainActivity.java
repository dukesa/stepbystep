package com.stepbystepmusic.skillbuilder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;
import android.media.SoundPool;
import android.media.AudioAttributes;
import java.util.List;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final int stickClick;   //ID for stick click sound
        final int C1;
        final int D1;
        final int E2;
        final int F2;
        final int G2;
        final int A2;
        final int B2;
        final int C2;
        final List <Integer> scale = new ArrayList <>();

        final int bpm;          // Beats per minute
        final int wait_in_ms;   // Converted bpm to beat time in ms
        final int count_in;     // Number of beats for count in

        MusicPlayer MainMusicPlayer = new MusicPlayer;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AudioAttributes audioAttributes = new AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .setUsage(AudioAttributes.USAGE_GAME)
                .build();

        final SoundPool mSoundPool = new SoundPool.Builder()
                .setMaxStreams(2)
                .setAudioAttributes(audioAttributes)
                .build();

        stickClick = mSoundPool.load(this,R.raw.stick_click,1);
        A2 = mSoundPool.load(this, R.raw.a1_1,1);
        B2 = mSoundPool.load(this,R.raw.b1_1,1);
        C1 = mSoundPool.load(this,R.raw.c_1,1);
        C2 = mSoundPool.load(this,R.raw.c1_1,1);
        D1 = mSoundPool.load(this,R.raw.d_1,1);
        E2 = mSoundPool.load(this,R.raw.e1_1,1);
        F2 = mSoundPool.load(this,R.raw.f1_1,1);
        G2 = mSoundPool.load(this,R.raw.g1_1,1);


        bpm = 120;
        count_in = 4;
        wait_in_ms = 1000*60/bpm;

        // Build C major scale
        scale.add(C1);
        scale.add(D1);
        scale.add(E2);
        scale.add(F2);
        scale.add(G2);
        scale.add(A2);
        scale.add(B2);
        scale.add(C2);


        final Button button = (Button) findViewById(R.id.play_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int streamID = 0;

//             Code here executes on main thread after user presses button
                TextView myAwesomeTextView = (TextView)findViewById(R.id.main_text);
                myAwesomeTextView.setText("My Awesome Text");
                try {
                    // Play Count In
                    for (int i=0; i < count_in; i++) {
                        mSoundPool.play(stickClick, 1, 1, 1, 0, 1);
                        Thread.sleep(wait_in_ms);
                    }

                    // Play com.stepbystepmusic.skillbuilder.Scale
                    for (int i = 0; i < scale.size(); i++) {
                        if (i>0) {
                            mSoundPool.stop(streamID);
                        }
                        streamID = mSoundPool.play(scale.get(i),1,1,1,0,1);
                        Thread.sleep(wait_in_ms);
                    }

                    // hold for 3 more beats then stop
                    Thread.sleep(3*wait_in_ms);
                    mSoundPool.stop(streamID);

                } catch (InterruptedException exception){
                    exception.printStackTrace();
                }
            }
        });
    }



}
