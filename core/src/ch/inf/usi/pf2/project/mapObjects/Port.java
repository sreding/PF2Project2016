package ch.inf.usi.pf2.project.mapObjects;

import com.badlogic.gdx.math.Rectangle;
import java.util.Random;

/**
 * Created by simonreding on 18/05/16.
 */
public class Port {
    private int x;
    private int y;
    private String name;
    private Rectangle hitBox;
    private int incoming;
    private int outgoing;

    public Port(String name, Rectangle r){
        this.name = name;
        this.hitBox=r;
        this.x = (int) r.getX();
        this.y = (int)r.getY();
        Random rn = new Random();
        this.incoming = rn.nextInt(500);
        this.outgoing = rn.nextInt(500);
    }//constructor

    public String getName() {
        return name;
    }

    public Rectangle getHitBox() {
        return hitBox;
    }

    public int getIncoming() {
        return incoming;
    }

    public int getOutgoing() {
        return outgoing;
    }
}
