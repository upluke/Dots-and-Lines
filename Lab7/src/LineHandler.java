import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class LineHandler implements Observer {
    private boolean lineEnabled;
    private Dot prevDot;
//    private boolean isRepaint = false;
    public void calculate(Graphics g){

        if(!lineEnabled){
            return;
        }

        ArrayList<Dot> dots = DataSource.getDataSource().getDots();
//        int size = dots.size();


        for(Dot dot: dots){
            if(prevDot==null){
                prevDot = dot;
                continue;
            }
            System.out.println("prevDot: " + prevDot.getX() + " current Dot: " +dot.getX());
            if(prevDot.getX()!= dot.getX() & prevDot.getY()!=dot.getY()){
                prevDot.drawConnect(dot, g);
            }

            prevDot=dot;

        }

        prevDot=null;

    }

    public void setLineEnabled(boolean enabled){
        this.lineEnabled = enabled;
    }

    @Override
    public void update(Observable o, Object arg) {
//        calculate();
    }
}
