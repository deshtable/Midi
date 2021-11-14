import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GraphicsUI extends JFrame implements MouseListener {

    String [] arpeggArr;

    private JButton btn;
    private int xcoor, ycoor, width, height;

    public GraphicsUI (){
        setSize(1280, 720);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void paint(Graphics g) {

        width = getSize().width;
        height = getSize().height;
        //setSize(getSize().width, getSize().height);

        drawKeys(g);


    }

    private void drawKeys(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);
        int drawx = width /3;
        int drawy = height /3;
        int sizex = width /25;
        int sizey = height /2;
        g.setColor(Color.BLACK);
        for(int i=1;i<=7;i++)
            g.drawRect(drawx+i*sizex, drawy, sizex, sizey);
        int tempsize= (sizex/3)*2;

        g.fillRect(drawx+tempsize+sizex, drawy, tempsize, sizey/2);
        g.fillRect(drawx+tempsize+2*sizex, drawy, tempsize, sizey/2);
        g.fillRect(drawx+tempsize+4*sizex, drawy, tempsize, sizey/2);
        g.fillRect(drawx+tempsize+5*sizex, drawy, tempsize, sizey/2);
        g.fillRect(drawx+tempsize+6*sizex, drawy, tempsize, sizey/2);
    }

    private void readFiles() {
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
