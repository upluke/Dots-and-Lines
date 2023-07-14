import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class WorkArea extends JPanel implements MouseListener {
    private int dotX =-1;
    private int dotY =-1;
    public WorkArea(){
        setBackground(Color.DARK_GRAY);
        addMouseListener(this);
        DataSource dataSource = DataSource.getDataSource();
        Clusterhandler clusterhandler = new Clusterhandler();
        dataSource.addObserver(clusterhandler);
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        ArrayList<Dot> curDots = DataSource.getDataSource().getDots();
        System.out.println(curDots.size());
        for(Dot dot: curDots){
//            System.out.println("---" +dot);
            int dotSize = 10;
            int dotOffset = dotSize / 2;
            g.setColor(dot.getColor());
            g.fillOval(dot.getx() - dotOffset, dot.getY() - dotOffset, dotSize, dotSize);
        }
        // single dot testing:
//        if (dotX != -1 && dotY != -1) {
//            g.setColor(Color.white);
//            // adjust the alignment of the dot to fix if the dot is slightly off to the right of the mouse pointer
//            int dotSize = 10;
//            int dotOffset = dotSize / 2;
//            g.fillOval(dotX - dotOffset, dotY - dotOffset, dotSize, dotSize);
//        }
    }



    @Override
    public void mousePressed(MouseEvent e) {
        dotX =e.getX();
        dotY =e.getY();
//        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        dotX =e.getX();
        dotY =e.getY();
        Dot newDot = new Dot(dotX, dotY, Color.yellow);
        DataSource.getDataSource().add(newDot);
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseClicked(MouseEvent e) {}
}
