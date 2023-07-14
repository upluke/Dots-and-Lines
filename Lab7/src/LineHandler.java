import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class LineHandler implements Observer {
    private boolean lineEnabled;
    private Dot prevDot;
    public void calculate(){
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
            prevDot=dot;
        }


    }

    public void setLineEnabled(boolean enabled){
        this.lineEnabled = enabled;
    }

    @Override
    public void update(Observable o, Object arg) {
        calculate();
    }
}
