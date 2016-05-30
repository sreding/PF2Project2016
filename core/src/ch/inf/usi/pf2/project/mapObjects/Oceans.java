package ch.inf.usi.pf2.project.mapObjects;
import java.util.Random;
/**
 * Created by simonreding on 29/05/16.
 * Remark: This class should in fact be called ocean since it only represent one but it is not.
 */
public class Oceans extends Place{


    private final int x;
    private final int y;
    private final String name;
    private final int radius;
    public Oceans(int x, int y,int radius, String name){
        super(x,y,name);
        Random rn = new Random();
        int displ = rn.nextInt(radius) - (radius/2) -1;
        this.x = x + displ;
        displ = rn.nextInt(radius) - (radius/2) -1;
        this.y = y + displ;
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
