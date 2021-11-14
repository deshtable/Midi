import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GraphicsUI extends JFrame implements MouseListener {

    String [] arpeggArr;
    String notePressed;
    private JButton btn;
    private int xcoor, ycoor, width, height;
    private int drawx, drawy, wSizex, wSizey, bSizey, bSizex;
    Arpeggiator Arpie;

    public GraphicsUI (){
        setSize(1280, 720);
        setVisible(true);
        addMouseListener(this);
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
        bSizex= (wSizex/3)*2;

        for(int i=1;i<=7;i++)
        {
            g.setColor(Color.WHITE);
            g.fillRect(drawx+i*wSizex, drawy, wSizex, wSizey);
            g.setColor(Color.BLACK);
            g.drawRect(drawx+i*wSizex, drawy, wSizex, wSizey);

        }



        g.setColor(Color.BLACK);

        g.fillRect(drawx+bSizex+wSizex, drawy, bSizex, bSizey);
        g.fillRect(drawx+bSizex+2*wSizex, drawy, bSizex, bSizey);
        g.fillRect(drawx+bSizex+4*wSizex, drawy, bSizex, bSizey);
        g.fillRect(drawx+bSizex+5*wSizex, drawy, bSizex, bSizey);
        g.fillRect(drawx+bSizex+6*wSizex, drawy, bSizex, bSizey);
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
        if(notePressed != ""){
        Arpie = new Arpeggiator(notePressed);
        Arpie.playArpegg(1);}
        System.out.println("mouse released");

        notePressed = "";
    }

    private String checkButtons(MouseEvent e) {


        System.out.println("getX: " + e.getX() + " drawx + wSizex : " + (drawx+wSizex*2) + " || getY: " + e.getY() + "drawy + wSizey" + (wSizey+drawy));
        if((e.getX()>drawx && e.getX()<drawx+wSizex*2 && e.getY() > drawy+bSizey && e.getY()<drawy+wSizey) ||
                (e.getX()>drawx && e.getX()<drawx+(wSizex*2 - bSizex/2) && e.getY() > drawy && e.getY()<drawy+wSizey) )
        {

            System.out.println("Click Button yuh");
            return "c";
        }

        return "";

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
