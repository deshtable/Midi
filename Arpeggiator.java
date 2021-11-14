import java.util.ArrayList;
import java.util.Arrays;

import java.io.*;
import java.util.*;
import javax.sound.midi.*;
public class Arpeggiator {
    String firstNote;
    int firstNoteInd;
    ArrayList<String> noteList = new ArrayList<String>(
            Arrays.asList("c","c#","d","d#","e","f","f#","g","g#", "a", "a#", "b"));

    public Arpeggiator(String inNote){
        firstNote = inNote;
        firstNoteInd = noteList.indexOf(inNote);
    }

    public void runArpeggio(int typeArpeggio){

        if(typeArpeggio == 1)  // If the type of arpeggio is chosen to be a major chord
            majorArpeggio();

    }

    private String[] majorArpeggio() {

        String [] arpeggArr = new String[3];

        arpeggArr[0] = noteList.get(firstNoteInd);
        arpeggArr[1] = noteList.get(firstNoteInd + 4);
        arpeggArr[2] = noteList.get(firstNoteInd + 3);
        //
        return arpeggArr;
    }





    
    public void playArpegg(String[] arpeggArr){ // takes in the final arpeggArr from graphics and plays it through sequencer
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

          String[] noteClassifier = {"c", "cs", "d", "ds", "e", "f", "fs", "g", "gs", "a", "as", "b"};
          //byte noteByte;
          String noteByteString;
          ArrayList<String> noteList = new ArrayList<String>(Arrays.asList("c", "c#", "d", "d#", "e", "f", "f#", "g", "g#", "a", "a#", "b"));
          // Create an ArrayList object
          int noteByte;
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
          

          try{
            Sequencer sequencer;
            sequencer = MidiSystem.getSequencer(); 
            if (sequencer == null) {
                // Error -- sequencer device is not supported.
                // Inform user and return...
            } else {
                // Acquire resources and make operational.
                sequencer.open();
            }
            sequencer.setSequence(s);
            sequencer.start();
          }
          catch(Exception e){
            System.out.println(e.toString());
          }


          System.out.println("midifile end "); //main

      } catch (Exception e) {
          System.out.println("Exception caught " + e.toString());
      }

    }

}
