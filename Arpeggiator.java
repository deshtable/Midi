import java.util.ArrayList;
import java.util.Arrays;

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

    }

}
