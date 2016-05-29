package ch.inf.usi.pf2.project.mapObjects;

/**
 * Created by simonreding on 29/05/16.
 */
public class Oceans extends Place{


    private final int x;
    private final int y;
    private final String name;
    private final int radius;
    public Oceans(int x, int y,int radius, String name){
        super(x,y,name);
        this.x = x;
        this.y = y;
        this.name = name;
        this.radius = radius;
    }




    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public String getName() {
        return name;
    }

    public int getRadius() {
        return radius;
    }
}
