package com.stepbystepmusic.skillbuilder;

import com.google.common.collect.HashBasedTable;

import javax.microedition.khronos.opengles.GL;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class NoteMap {

private static HashBasedTable noteMap;

//todo: should we use an immutable table instead of hashbasedtable?
public static synchronized HashBasedTable getNoteMap(){
//    if (noteMap == null){
//        noteMap = HashBasedTable.create();

//         Create a table with all of the image file names for every note in every view mode
//        todo: add all the notes!!!
//        List<String> keyNotes = new ArrayList<>(Arrays.asList("C1", "D1", "E1", "F1", "G1", "A2", "B2", "C2"));
//        ArrayList<> keyDisplayMode = new ArrayList<>(Arrays.asList(;
//
//        for (String thisNote: keyNotes) {
//            for (Object thisViewModeObj: keyDisplayMode){
//                String thisViewMode = thisViewModeObj.toString();
//                String thisImage = thisNote + "_" + thisViewMode + ".png";
//                noteMap.put(thisNote, thisViewMode,thisImage);
//            }
//        }
//
//    }
    return noteMap;
}

}
