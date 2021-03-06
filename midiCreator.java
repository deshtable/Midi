import java.util.ArrayList; // import the ArrayList class

import java.io.*;
import java.util.*;
import javax.sound.midi.*; // package for all midi classes

public class midiCreator {
    public static void main(String argv[]) {
        System.out.println("midifile begin ");

        constructor("c", "c");


    }

    //****  Create a new MIDI sequence with 24 ticks per beat  ****
    public static void constructor(String note, String key) {

        try {

            Sequence s = new Sequence(javax.sound.midi.Sequence.PPQ, 24);

//****  Obtain a MIDI track from the sequence  ****
            Track t = s.createTrack();

//****  General MIDI sysex -- turn on General MIDI sound set  ****
            byte[] b = {(byte) 0xF0, 0x7E, 0x7F, 0x09, 0x01, (byte) 0xF7};
            SysexMessage sm = new SysexMessage();
            sm.setMessage(b, 6);
            MidiEvent me = new MidiEvent(sm, (long) 0);
            t.add(me);

//****  set tempo (meta event)  ****
            MetaMessage mt = new MetaMessage();
            byte[] bt = {0x02, (byte) 0x00, 0x00};
            mt.setMessage(0x51, bt, 3);
            me = new MidiEvent(mt, (long) 0);
            t.add(me);

//****  set track name (meta event)  ****
            mt = new MetaMessage();
            String TrackName = new String("midifile track");
            mt.setMessage(0x03, TrackName.getBytes(), TrackName.length());
            me = new MidiEvent(mt, (long) 0);
            t.add(me);

//****  set omni on  ****
            ShortMessage mm = new ShortMessage();
            mm.setMessage(0xB0, 0x7D, 0x00);
            me = new MidiEvent(mm, (long) 0);
            t.add(me);

//****  set poly on  ****
            mm = new ShortMessage();
            mm.setMessage(0xB0, 0x7F, 0x00);
            me = new MidiEvent(mm, (long) 0);
            t.add(me);

//****  set instrument to Piano  ****
            mm = new ShortMessage();
            mm.setMessage(0xC0, 0x00, 0x00);
            me = new MidiEvent(mm, (long) 0);
            t.add(me);

            String[] noteClassifier = {"c", "c#", "d", "d#", "e", "f", "f#", "g", "g#", "a", "a#", "b"};
            //byte noteByte;
            String noteByteString;
            ArrayList<String> noteList = new ArrayList<String>(Arrays.asList("c", "c#", "d", "d#", "e", "f", "f#", "g", "g#", "a", "a#", "b"));
            // Create an ArrayList object
            int noteByte;
            String[] arpeggArr = {"c", "e", "g"};
            int startCount = 1;
            int endCount = 120;
            for (int i = 0; i < arpeggArr.length; i++) {
                mm = new ShortMessage();
                //noteByteString = ()(noteList.indexOf(arpeggArr[i]) + 60));
                //System.out.println(noteByteString.getBytes());
                //noteByte = 0x42;
                noteByte = noteList.indexOf(arpeggArr[i]) + 60;
                mm.setMessage(0x90, noteByte, 0x60);
                me = new MidiEvent(mm, (long) startCount);
                t.add(me);

                //****  note off - middle C - 120 ticks later  ****
                mm = new ShortMessage();
                mm.setMessage(0x80, noteByte, 0x40);
                me = new MidiEvent(mm, (long) endCount);
                t.add(me);

                System.out.println(noteByte);
                System.out.println(arpeggArr[i]);
                startCount += 120;
                endCount += 120;
            }
            //****  set end of track (meta event) 19 ticks later  ****
            mt = new MetaMessage();
            byte[] bet = {}; // empty array
            mt.setMessage(0x2F, bet, 0);
            me = new MidiEvent(mt, (long) (endCount + 1));
            t.add(me);
            //****  write the MIDI sequence to a MIDI file  ****
            File f = new File("midifile.mid");
            MidiSystem.write(s, 1, f);

            System.out.println("midifile end "); //main

        } catch (Exception e) {
            System.out.println("Exception caught " + e.toString());
        }
    }
} //midifile
