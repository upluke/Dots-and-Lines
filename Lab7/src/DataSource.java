
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Observable;

public class DataSource extends Observable {
    private ArrayList<Dot> dots;
    private LinkedList<Point> lines;
    private static DataSource instance;


    private DataSource(){
        dots = new ArrayList<>();
        lines= new LinkedList<>();

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

    public LinkedList<Point> getLines(){
        return this.lines;
    }

    public void setLines(LinkedList<Point> lines){
        this.lines=lines;
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
