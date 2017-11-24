package com.stepbystepmusic.skillbuilder;

import android.media.AudioAttributes;
import android.media.SoundPool;
import java.util.ArrayList;
import android.content.Context;
import android.widget.TextView;


public class MusicPlayer {
    com.stepbystepmusic.skillbuilder.Scale mScale;
    SoundPool mSoundPool;
    TextView mTextView;

    void initialize(TextView textView){

        AudioAttributes audioAttributes = new AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .setUsage(AudioAttributes.USAGE_GAME)
                .build();

        final SoundPool soundPool = new SoundPool.Builder()
                .setMaxStreams(2)
                .setAudioAttributes(audioAttributes)
                .build();

        mSoundPool = soundPool;
        mTextView = textView;
    }

    void play(){
        int streamID = 0;



        try {

            // Play com.stepbystepmusic.skillbuilder.Scale
            ArrayList <Note> note_array = mScale.getNoteArray();
            for (final Note note: note_array) {

//                for (int i = 0; i < mScale.getNoteArray().size(); i++) {
                if (streamID != 0) {
                    mSoundPool.stop(streamID);
                }
                mTextView.post(new Runnable() {
                                  public void run() {
                                      mTextView.setText(note.getmName());
                                  }
                              });
                streamID = mSoundPool.play(note.getmSoundPoolID(),1,1,1,0,1);
                Thread.sleep(mScale.getmNoteDuration_ms());
            }

            // hold for 3 more beats then stop
            Thread.sleep(3*mScale.getmNoteDuration_ms());
            mSoundPool.stop(streamID);

            // Reset scale name
            mTextView.post(new Runnable() {
                public void run() {
                    mTextView.setText("C Major");
                }
            });

        } catch (InterruptedException exception){
            exception.printStackTrace();
        }
    }

    void pause(){

    }

    void loadScale(Scale scale){
        // Set member scale
        mScale = scale;

        ArrayList <Note> note_array = mScale.getNoteArray();
        Context thisContext = myApplication.getAppContext();

        //todo: check for duplicates and only load once
        for (Note note: note_array) {
            int newID = mSoundPool.load(thisContext,note.getmMusicFile(),1);
            note.setmSoundPoolID(newID); //todo: make sure this sets the note object inside mScale....

//        stickClick = mSoundPool.load(this,R.raw.stick_click,1);
//        A2 = mSoundPool.load(this, R.raw.a1_1,1);
//        B2 = mSoundPool.load(this,R.raw.b1_1,1);
//        C1 = mSoundPool.load(this,R.raw.c_1,1);
//        C2 = mSoundPool.load(this,R.raw.c1_1,1);
//        D1 = mSoundPool.load(this,R.raw.d_1,1);
//        E2 = mSoundPool.load(this,R.raw.e1_1,1);
//        F2 = mSoundPool.load(this,R.raw.f1_1,1);
//        G2 = mSoundPool.load(this,R.raw.g1_1,1);
        }
    }


}

