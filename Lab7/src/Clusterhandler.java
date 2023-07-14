import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Clusterhandler implements Observer {

    public void calculate(Dot dot){



    }

    @Override
    public void update(Observable o, Object arg) {
        ArrayList<Dot> dots =((DataSource)o).getDots();
        System.out.println("cluster: "+ dots);

    }
}
