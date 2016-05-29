package ch.inf.usi.pf2.project.mapObjects;

/**
 * Created by simonreding on 29/05/16.
 */
public class Place {
    private final int x;
    private final int y;
    private final String name;
    public Place(int x, int y, String name){
        this.x = x;
        this.y = y;
        this.name = name;
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
}
