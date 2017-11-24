package com.stepbystepmusic.skillbuilder;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Scale {
    private int mNoteDuration_ms;   // Converted bpm to beat time in ms

    private ArrayList <Note> mNoteArray = new ArrayList<>();

    //Getters
    ArrayList getNoteArray(){
        return mNoteArray;
    }

    int getmNoteDuration_ms(){
        return mNoteDuration_ms;
    }

    //Builder method
    Scale build(int bpm, int clicks) {


        // Convert beats to time in ms
        mNoteDuration_ms = 1000*60/bpm;

        // Build clicks
        Note click = new Note();
        click.setmMusicFile(R.raw.stick_click);
        click.setmName("click");

        for(int n=0; n < clicks; n++){
            mNoteArray.add(click);
        }

        // Build C major scale

//        scale.add(C1);
//        scale.add(D1);
//        scale.add(E2);
//        scale.add(F2);
//        scale.add(G2);
//        scale.add(A2);
//        scale.add(B2);
//        scale.add(C2);
        return this;
    }

}
