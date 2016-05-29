package ch.inf.usi.pf2.project.mapObjects;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by simonreding on 29/05/16.
 */
public class Place {
    private int x;
    private int y;
    private String name;

    public Place(int x, int y, String name){
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


}

