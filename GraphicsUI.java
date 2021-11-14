import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GraphicsUI extends JFrame implements MouseListener {

    String [] arpeggArr;
    String notePressed;
    private JButton btn;
    private int xcoor, ycoor, width, height;
    private int drawx, drawy, wSizex, wSizey, bSizey;

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

        drawx = (int)(width * 0.20);
        drawy = (int) (height * 0.20);

        wSizex = (int)(width * 0.07);
        wSizey = (int)(height * 0.75);
        bSizey = (int)(wSizey * 0.6);


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
        notePressed = checkButtons(e);
    }

    private String checkButtons(MouseEvent e) {

        //if(e.getX())

        return "";
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
