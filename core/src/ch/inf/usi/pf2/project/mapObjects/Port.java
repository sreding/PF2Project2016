package ch.inf.usi.pf2.project.mapObjects;

import com.badlogic.gdx.math.Rectangle;

/**
 * Created by simonreding on 18/05/16.
 */
public class Port {
    private int x;
    private int y;
    private String name;
    private Rectangle hitBox;

    public Port(String name, Rectangle r){
        this.name = name;
        this.hitBox=r;
        this.x = (int) r.getX();
        this.y = (int)r.getY();
    }//constructor

    public String getName() {
        return name;
    }

    public Rectangle getHitBox() {
        return hitBox;
    }
}
