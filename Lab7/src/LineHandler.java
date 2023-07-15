import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

public class LineHandler implements Observer {
//    private Dot prevDot;
//    private boolean isRepaint = false;
    public void calculate(){


        ArrayList<Dot> dots = DataSource.getDataSource().getDots();
        LinkedList<Point> lines = new LinkedList<>();

        for (Dot dot : dots){
            System.out.println("in line "+lines.size());
            lines.add(new Point(dot.getX(), dot.getY()));
            System.out.println("in line after"+lines.size());
            System.out.println(">>>>>>>");
        }

        DataSource.getDataSource().setLines(lines);

    }



    @Override
    public void update(Observable o, Object arg) {
        calculate();
    }
}
