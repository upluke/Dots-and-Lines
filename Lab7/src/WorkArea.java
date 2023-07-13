import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class WorkArea extends JPanel implements MouseListener {
    private int dotX =-1;
    private int dotY =-1;
    public WorkArea(){
        setBackground(Color.DARK_GRAY);
        addMouseListener(this);
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        if (dotX != -1 && dotY != -1) {
            g.setColor(Color.white);
            // adjust the alignment of the dot to fix if the dot is slightly off to the right of the mouse pointer
            int dotSize = 10;
            int dotOffset = dotSize / 2;
            g.fillOval(dotX - dotOffset, dotY - dotOffset, dotSize, dotSize);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        dotX =e.getX();
        dotY =e.getY();
        System.out.println(e.getX() + " " + e.getY());

        System.out.println(e.getXOnScreen() + " " + e.getYOnScreen());
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
