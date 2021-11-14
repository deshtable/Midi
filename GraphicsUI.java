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

        g.setColor(Color.RED);
        g.fillRect(0, 0 , width, height);

        drawKeys(g);


    }

    private void drawKeys(Graphics g) {

        int drawx = (int)(width * 0.20);
        int drawy = (int) (height * 0.20);
        int wSizex = (int)(width * 0.07);
        int wSizey = (int)(height * 0.75);
        int bSizey = (int)(wSizey * 0.6);


        for(int i=1;i<=7;i++)
        {
            g.setColor(Color.WHITE);
            g.fillRect(drawx+i*wSizex, drawy, wSizex, wSizey);
            g.setColor(Color.BLACK);
            g.drawRect(drawx+i*wSizex, drawy, wSizex, wSizey);

        }

        int keySize= (wSizex/3)*2;

        g.setColor(Color.BLACK);

        g.fillRect(drawx+keySize+wSizex, drawy, keySize, bSizey);
        g.fillRect(drawx+keySize+2*wSizex, drawy, keySize, bSizey);
        g.fillRect(drawx+keySize+4*wSizex, drawy, keySize, bSizey);
        g.fillRect(drawx+keySize+5*wSizex, drawy, keySize, bSizey);
        g.fillRect(drawx+keySize+6*wSizex, drawy, keySize, bSizey);
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
