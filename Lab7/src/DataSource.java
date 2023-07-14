
import java.util.ArrayList;
import java.util.Observable;

public class DataSource extends Observable {
    private ArrayList<Dot> dots;
    private static DataSource instance;
    private DataSource(){
        dots = new ArrayList<>();

    }

    public static DataSource getDataSource(){
        if(instance==null){
            instance=new DataSource();

        }
        return instance;
    }

    public ArrayList<Dot> getDots(){
        return this.dots;
    }

    public void add(Dot dot){
        dots.add(dot);
        setChanged();
        notifyObservers();

    }

    public int size(){
        return dots.size();
    }
}
