import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class ClusterHandler implements Observer {
//    private boolean clusterEnabled;
    public void calculate(){
//        if (!clusterEnabled) {
//            return;
//        }
        ArrayList<Dot> dots=DataSource.getDataSource().getDots();
        int size=DataSource.getDataSource().size();

        System.out.println("cluster: "+ dots+ " size:" + size);

        int totalX = 812;
        int middleX = totalX / 2;


        if(size==2) {
            dots.get(0).setColor(Color.red);
            dots.get(1).setColor(Color.blue);

        }else{
            for(Dot dot: dots){
                if((totalX-dot.getX())<middleX){
                    dot.setColor(Color.red);
                    System.out.println(dot.getX() + "***" + dot.getY());
                }else{
                    dot.setColor(Color. blue);
                    System.out.println(dot.getX() + "***" + dot.getY());
                }
            }
        }

    }





    @Override
    public void update(Observable o, Object arg) {
//        ArrayList<Dot> dots =((DataSource)o).getDots();
//        int size = ((DataSource)o).size();
          calculate();


    }
}
