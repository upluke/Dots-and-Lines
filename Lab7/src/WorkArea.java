import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class WorkArea extends JPanel implements MouseListener {
    private DataSource dataSource;
    private boolean clusterEnabled;
    private boolean lineEnabled;
    private ClusterHandler clusterHandler;
    private LineHandler lineHandler;

    private boolean isRunBtnClicked =false;

    public WorkArea() {
        setBackground(Color.DARK_GRAY);
        addMouseListener(this);
        dataSource = DataSource.getDataSource();
        clusterHandler = new ClusterHandler();
        lineHandler = new LineHandler();
        dataSource.addObserver(clusterHandler);
        dataSource.addObserver(lineHandler);

    }

    public void setClusterEnabled(boolean enabled) {
        clusterEnabled = enabled;
        repaint();
    }

    public void setLineEnabled(boolean enabled){
        lineEnabled = enabled;
        repaint();
    }

    public void run() {
        isRunBtnClicked =true;
        if(lineEnabled){
            lineHandler.setLineEnabled(true);
            lineHandler.calculate(getGraphics());


        }else{
            lineHandler.setLineEnabled(false);
            isRunBtnClicked=false;
            resetDotColors();
        }

        if(clusterEnabled) {
            clusterHandler.setClusterEnabled(true);
            clusterHandler.calculate();

        }else{
            clusterHandler.setClusterEnabled(false);
            resetDotColors();
        }
       repaint();
    }

    private void resetDotColors() {
        ArrayList<Dot> dots = dataSource.getDots();
        for (Dot dot : dots) {
            dot.setColor(Color.YELLOW);
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        ArrayList<Dot> curDots = dataSource.getDots();
        for (Dot dot : curDots) {
            int dotSize = 10;
            int dotOffset = dotSize / 2;
            g.setColor(dot.getColor());
            g.fillOval(dot.getX() - dotOffset, dot.getY() - dotOffset, dotSize, dotSize);
        }
        if(lineEnabled & isRunBtnClicked){
            lineHandler.calculate(g);
            isRunBtnClicked=false;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int dotX = e.getX();
        int dotY = e.getY();
        if( !clusterEnabled & !lineEnabled){
            Dot newDot = new Dot(dotX, dotY, Color.YELLOW);
            dataSource.add(newDot);
            repaint();
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {}
}
