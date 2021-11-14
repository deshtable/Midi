public class Main {
    public static void main(String[] args) {
        // Creation of a GraphicsDemo Object
        GraphicsUI draw = new GraphicsUI();

        Arpeggiator arpie = new Arpeggiator("c");

        arpie.playArpegg(1);
    }
}
