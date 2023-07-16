import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

public class LineHandler implements Observer {

    public void calculate(){
        ArrayList<Dot> dots = DataSource.getDataSource().getDots();
        LinkedList<Point> lines = new LinkedList<>();

        for (Dot dot : dots){
            lines.add(new Point(dot.getX(), dot.getY()));
        }
        DataSource.getDataSource().setLines(lines);
    }



    @Override
    public void update(Observable o, Object arg) {
        calculate();
    }
}
