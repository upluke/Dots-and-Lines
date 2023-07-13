import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class WorkArea extends JPanel implements MouseListener {
    public WorkArea(){
        setBackground(Color.DARK_GRAY);
        addMouseListener(this);
    }
    public void paintComponet(){

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getYOnScreen() + " " + e.getYOnScreen());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println(e.getYOnScreen() + " " + e.getYOnScreen());

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
