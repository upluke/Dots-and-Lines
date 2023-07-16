import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class ClusterHandler implements Observer {
    public void calculate(){
        ArrayList<Dot> dots=DataSource.getDataSource().getDots();
        int size=DataSource.getDataSource().size();

        int totalX = 812;
        int middleX = totalX / 2;

        if(size==2) {
            dots.get(0).setColor(Color.red);
            dots.get(1).setColor(Color.blue);
        }else{
            for(Dot dot: dots){
                if((totalX-dot.getX())<middleX){
                    dot.setColor(Color.red);
                }else{
                    dot.setColor(Color. blue);
                }
            }
        }

    }





    @Override
    public void update(Observable o, Object arg) {
          calculate();
    }
}
