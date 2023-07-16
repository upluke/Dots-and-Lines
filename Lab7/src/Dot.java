import java.awt.*;

public class Dot {
    private int x;
    private int y;
    private Color color;

    public Dot(int x, int y, Color color){
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public Color getColor(){
        return this.color;
    }

    public void setColor (Color color){
        this.color=color;
    }

}
