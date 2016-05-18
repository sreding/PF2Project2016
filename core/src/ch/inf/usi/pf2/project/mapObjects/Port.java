package ch.inf.usi.pf2.project.mapObjects;

/**
 * Created by simonreding on 18/05/16.
 */
public class Port {
    private int x;
    private int y;
    private String name;

    public Port(String name, int x, int y){
        this.name = name;
        this.x = x;
        this.y = y;
    }//constructor

    public String getName() {
        return name;
    }
}
