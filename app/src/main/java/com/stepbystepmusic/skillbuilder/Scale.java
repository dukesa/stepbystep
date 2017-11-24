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
        Note click4 = new Note();
        click4.setmMusicFile(R.raw.stick_click);
        click4.setmName("4");
        mNoteArray.add(click4);

        Note click3 = new Note();
        click3.setmMusicFile(R.raw.stick_click);
        click3.setmName("3");
        mNoteArray.add(click3);

        Note click2 = new Note();
        click2.setmMusicFile(R.raw.stick_click);
        click2.setmName("2");
        mNoteArray.add(click2);

        Note click1 = new Note();
        click1.setmMusicFile(R.raw.stick_click);
        click1.setmName("1");
        mNoteArray.add(click1);

//        for(int n=0; n < clicks; n++){
//            mNoteArray.add(click);
//        }

        // Build C major scale
        Note C1 = new Note();
        C1.setmMusicFile(R.raw.c_1);
        C1.setmName("C");
        mNoteArray.add(C1);

        Note D1 = new Note();
        D1.setmMusicFile(R.raw.d_1);
        D1.setmName("D");
        mNoteArray.add(D1);

        Note E2 = new Note();
        E2.setmMusicFile(R.raw.e1_1);
        E2.setmName("E");
        mNoteArray.add(E2);

        Note F2 = new Note();
        F2.setmMusicFile(R.raw.f1_1);
        F2.setmName("F");
        mNoteArray.add(F2);

        Note G2 = new Note();
        G2.setmMusicFile(R.raw.g1_1);
        G2.setmName("G");
        mNoteArray.add(G2);

        Note A2 = new Note();
        A2.setmMusicFile(R.raw.a1_1);
        A2.setmName("A");
        mNoteArray.add(A2);

        Note B2 = new Note();
        B2.setmMusicFile(R.raw.b1_1);
        B2.setmName("B");
        mNoteArray.add(B2);

        Note C2 = new Note();
        C2.setmMusicFile(R.raw.c1_1);
        C2.setmName("C");
        mNoteArray.add(C2);

        return this;
    }

}
