package com.stepbystepmusic.skillbuilder;

public class Note {
    private String mName;
    private int mMusicFile;
    private String mDisplayLetter;
    private int mSoundPoolID;

    // Getters
    int getmMusicFile(){
        return mMusicFile;
    }

    int getmSoundPoolID(){
        return mSoundPoolID;
    }

    // Setters
    void setmSoundPoolID(int ID){
        mSoundPoolID = ID;
    }

    void setmName(String name){
        mName = name;
    }

    void setmDisplayLetter(String letter){
        mDisplayLetter = letter;
    }

    void setmMusicFile(int fileID) {
        mMusicFile = fileID;
    }

    // Showers
    void showmDisplayLetter(){

    }

}
