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

    private boolean isRunBtnClicked;

    public WorkArea() {
        setBackground(Color.DARK_GRAY);
        addMouseListener(this);
        dataSource = DataSource.getDataSource();
        clusterHandler = new ClusterHandler();
        lineHandler = new LineHandler();
        dataSource.addObserver(clusterHandler);
        dataSource.addObserver(lineHandler);

    }

    public boolean getClusterEnabled(){
        return this.clusterEnabled;
    }

    public boolean getLineEnabled(){
        return this.lineEnabled;
    }
    public void setClusterEnabled(boolean enabled) {
        this.clusterEnabled = enabled;
//        repaint();
    }

    public void setLineEnabled(boolean enabled){
        this.lineEnabled = enabled;
//        repaint();
    }

    public void setRunBtnClicked(boolean clicked){
        this.isRunBtnClicked  =clicked;
//        repaint();
        if(isRunBtnClicked){
            repaint();
        }
    }

    public void run() {
//        isRunBtnClicked =true;
//        if(lineEnabled){
//            lineHandler.setLineEnabled(true);
//            lineHandler.calculate(getGraphics());
//
//
//        }else{
//            lineHandler.setLineEnabled(false);
//            isRunBtnClicked=false;
//            resetDotColors();
//        }
//
//        if(clusterEnabled) {
//            clusterHandler.setClusterEnabled(true);
//            clusterHandler.calculate();
//
//        }else{
//            clusterHandler.setClusterEnabled(false);
//            resetDotColors();
//        }
       repaint();
    }

//    private void resetDotColors(ArrayList<Dot> dots) {
//        for (Dot dot : dots) {
//            dot.setColor(Color.YELLOW);
//            System.out.println("reset");
//        }
//
//    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        ArrayList<Dot> curDots = dataSource.getDots();

        // if lineEnabled is true
        if(lineEnabled){
            //TODO iterate lines
        }

        System.out.println("run button: "+isRunBtnClicked);

        for (Dot dot : curDots) {
            int dotSize = 10;
            int dotOffset = dotSize / 2;

            if(!clusterEnabled ) {
                g.setColor(Color.yellow);
            }else{ // if clusterEnabled is true
                g.setColor(dot.getColor());
            }
            System.out.println(dot.getColor());
            g.fillOval(dot.getX() - dotOffset, dot.getY() - dotOffset, dotSize, dotSize);
        }
        if(isRunBtnClicked){
            repaint();
        }

        setRunBtnClicked(false);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int dotX = e.getX();
        int dotY = e.getY();
        if(!clusterEnabled && !lineEnabled) {
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
