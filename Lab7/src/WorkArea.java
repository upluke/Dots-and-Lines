import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.LinkedList;

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
        LinkedList<Point> lines = DataSource.getDataSource().getLines();
        System.out.println("HEre is the size...."+lines.size());
        // if lineEnabled is true
        if(lineEnabled){

            for(int i =1;i<lines.size();i++){
                System.out.println(lines.get(i-1) + " ::: " +lines.get(i));
                Double x1 = lines.get(i-1).getX();
                Double y1 = lines.get(i-1).getY();
                Double x2 = lines.get(i).getX();
                Double y2 = lines.get(i).getY();
                g.drawLine(Integer.valueOf(x1.intValue()),
                        Integer.valueOf(y1.intValue()),
                        Integer.valueOf(x2.intValue()),
                        Integer.valueOf(y2.intValue()));

            }
            System.out.println("");
            System.out.println("");
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

//            repaint();
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
