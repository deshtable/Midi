import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GraphicsUI extends JFrame implements MouseListener {

    public GraphicsUI() {
        setSize(800, 480);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void paint(Graphics g) {
       drawpiano(g);
    }
    public void drawpiano(Graphics g){
        g.setColor(Color.WHITE);
        int
        g.fillRect(0, 0, 800, 480);
        g.setColor(Color.BLACK);
        for(int i=1;i<=7;i++)
            g.drawRect(50*i, 200, 50, 250);
        g.fillRect(85, 200, 30, 150);
        g.fillRect(135, 200, 30, 150);
        g.fillRect(235, 200, 30, 150);
        g.fillRect(285, 200, 30, 150);
        g.fillRect(335, 200, 30, 150);
    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
