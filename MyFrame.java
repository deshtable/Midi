import javax.swing.*;

public class MyFrame extends JFrame {

    GraphicsUI graphicsPanel = new GraphicsUI();

    public MyFrame(){
        this.setSize(1920, 1080);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(graphicsPanel);
        this.setVisible(true);
        this.setResizable(true);
    }


}
