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
    private boolean isEditable =true;
    private boolean isRunBtnClicked;

    private Color dotColor = Color.BLACK;

    public WorkArea() {
        setBackground(Color.GRAY);
        addMouseListener(this);
        dataSource = DataSource.getDataSource();
        clusterHandler = new ClusterHandler();
        lineHandler = new LineHandler();
        dataSource.addObserver(clusterHandler);
        dataSource.addObserver(lineHandler);


    }


    public void setClusterEnabled(boolean enabled) {
        this.clusterEnabled = enabled;
    }

    public void setLineEnabled(boolean enabled){
        this.lineEnabled = enabled;
    }

    public void setIsEditable(boolean editable){
        this.isEditable = editable;
    }

    public void setRunBtnClicked(boolean clicked){
        this.isRunBtnClicked  =clicked;
        if(isRunBtnClicked){
            repaint();
        }
    }

    public void setDotColor (Color selectedColor){
        this.dotColor= selectedColor;
        repaint();
    }


    public void resetWorkArea(){

//        System.out.println("clusterEnabled: " + clusterEnabled+ " lineEnabled: " + lineEnabled + " isEdiable: " +isEditable);
        dataSource.getDots().clear();
        dataSource.getLines().clear();
        setClusterEnabled(false);
        setLineEnabled(false);
        setIsEditable(true);
        setDotColor(Color.black);
        repaint();
        revalidate();

    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        ArrayList<Dot> curDots = dataSource.getDots();
        LinkedList<Point> lines = DataSource.getDataSource().getLines();

        // if lineEnabled is true
        if(lineEnabled){
            for(int i =1;i<lines.size();i++){
                Double x1 = lines.get(i-1).getX();
                Double y1 = lines.get(i-1).getY();
                Double x2 = lines.get(i).getX();
                Double y2 = lines.get(i).getY();
                g.setColor(Color.ORANGE);
                g.drawLine(Integer.valueOf(x1.intValue()),
                        Integer.valueOf(y1.intValue()),
                        Integer.valueOf(x2.intValue()),
                        Integer.valueOf(y2.intValue()));
            }

        }


        for (Dot dot : curDots) {
            int dotSize = 15;
            int dotOffset = dotSize / 2;

            if(!clusterEnabled ) {
                g.setColor(this.dotColor);
            }else{ // if clusterEnabled is true

                int circleSize = dotSize + 10;
                int circleOffset = (circleSize - dotSize) / 2;
                int circleX = dot.getX() - circleOffset - 7;
                int circleY = dot.getY() - circleOffset - 7;
                g.setColor(this.dotColor);
                g.drawOval(circleX, circleY, circleSize, circleSize );
                g.setColor(dot.getColor());
            }



            g.fillOval(dot.getX() - dotOffset, dot.getY() - dotOffset, dotSize, dotSize);
        }

        setRunBtnClicked(false);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int dotX = e.getX();
        int dotY = e.getY();

        if(isEditable && !clusterEnabled && !lineEnabled){
            Dot newDot = new Dot(dotX, dotY, this.dotColor);
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
